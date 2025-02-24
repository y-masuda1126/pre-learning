package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// (1-1) JUnitのMockito拡張を設定
@ExtendWith(MockitoExtension.class)
public class NotifyServiceTest {
    // (1-2) UserServiceのモックの定義
	@Mock
    private UserService userService;

    // (1-3) SendEMailServiceのモックの定義
	@Mock
    private SendEMailService sendEMailService;

    // (1-4) toEmailAddress用のArgumentCaptorを定義
	@Captor
	private ArgumentCaptor<String> toEmailAddressCaptor;

    // (1-4) subject用のArgumentCaptorを定義
	@Captor
	private ArgumentCaptor<String> subjectCaptor;

    // (1-4) body用のArgumentCaptorを定義
	@Captor
	private ArgumentCaptor<String> bodyCaptor;

    // (1-5) テスト対象にMockを差し込む
	@InjectMocks
    private NotifyService notifyService;

    @Test
    @DisplayName("正常にメール送信できるかのテスト")
    public void test1() throws Exception{
        // (2-1) UserServiceのgetUserEMailAddressのスタブを設定
    	when(userService.getUserEMailAddress("1")).thenReturn("to1@fuga.com");

        // テスト対象の実行
        notifyService.notify("1", "こんにちは");

        // (2-2) SendEMailServiceのsendメソッドの実行回数の検査と渡された各引数を検査
        verify(sendEMailService, times(1))
        		.send(toEmailAddressCaptor.capture(), subjectCaptor.capture(), bodyCaptor.capture());

        var toEmailAddress = toEmailAddressCaptor.getValue();
        var subject = subjectCaptor.getValue();
        var body = bodyCaptor.getValue();

        assertEquals("to1@fuga.com", toEmailAddress);
        assertEquals("メッセージ通知", subject);
        assertEquals("こんにちは", body);

    }

    @Test
    @DisplayName("ユーザーが存在しない場合のテスト")
    public void test2() throws Exception{
        // (3-1) UserServiceのgetUserEMailAddressのスタブを設定
    	when(userService.getUserEMailAddress("2")).thenThrow(new UserNotFoundException());

        // テスト対象の実行
        assertThrows(
                UserNotFoundException.class,
                () -> notifyService.notify("2", "こんにちは"));
    }

    @Test
    @DisplayName("メッセージに「機密」が含まれていた場合のテスト")
    public void test3() throws Exception{
        // (4-1) UserServiceのgetUserEMailAddressのスタブを設定
    	when(userService.getUserEMailAddress("1")).thenReturn("to1@fuga.com");

        // テスト対象の実行
        notifyService.notify("1", "このメッセージには機密情報が含まれています");

        // (4-2) SendEMailServiceのsendメソッドの実行回数の検査と渡された各引数を検査
        verify(sendEMailService, times(2))
        		.send(toEmailAddressCaptor.capture(), subjectCaptor.capture(), bodyCaptor.capture());

        var toEmailAddress = toEmailAddressCaptor.getAllValues();
        var subject = subjectCaptor.getAllValues();
        var body = bodyCaptor.getAllValues();

        assertEquals("to1@fuga.com", toEmailAddress.get(0));
        assertEquals("メッセージ通知", subject.get(0));
        assertEquals("このメッセージには機密情報が含まれています", body.get(0));

        assertEquals("admin@hoge.com", toEmailAddress.get(1));
        assertEquals("確認依頼", subject.get(1));
        assertEquals("このメッセージには機密情報が含まれています", body.get(1));

    }

    @Test
    @DisplayName("メールの送信失敗時のテスト")
    public void test4() throws Exception{
        // (5-1) SendEMailServiceのsendのスタブを設定(例外をスロー)
//    	when(sendEMailService.send(any(), any(), any())).thenThrow(new SendEMailFailureException()); // 誤りのためコメントアウト
    	doThrow(new SendEMailFailureException()).when(sendEMailService).send(any(), any(), any());

        // テスト対象の実行
        assertThrows(
                SendEMailFailureException.class,
                () -> notifyService.notify("1", "こんにちは"));
    }
}
