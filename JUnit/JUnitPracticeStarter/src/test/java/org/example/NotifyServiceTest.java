package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// (1-1) JUnitのMockito拡張を設定
public class NotifyServiceTest {
    // (1-2) UserServiceのモックの定義
    private UserService userService;

    // (1-3) SendEMailServiceのモックの定義
    private SendEMailService sendEMailService;

    // (1-4) toEmailAddress用のArgumentCaptorを定義

    // (1-4) subject用のArgumentCaptorを定義

    // (1-4) body用のArgumentCaptorを定義

    // (1-5) テスト対象にMockを差し込む
    private NotifyService notifyService;

    @Test
    @DisplayName("正常にメール送信できるかのテスト")
    public void test1() throws Exception{
        // (2-1) UserServiceのgetUserEMailAddressのスタブを設定

        // テスト対象の実行
        notifyService.notify("1", "こんにちは");

        // (2-2) SendEMailServiceのsendメソッドの実行回数の検査と渡された各引数を検査

    }

    @Test
    @DisplayName("ユーザーが存在しない場合のテスト")
    public void test2() throws Exception{
        // (3-1) UserServiceのgetUserEMailAddressのスタブを設定

        // テスト対象の実行
        assertThrows(
                UserNotFoundException.class,
                () -> notifyService.notify("2", "こんにちは"));
    }

    @Test
    @DisplayName("メッセージに「機密」が含まれていた場合のテスト")
    public void test3() throws Exception{
        // (4-1) UserServiceのgetUserEMailAddressのスタブを設定

        // テスト対象の実行
        notifyService.notify("1", "このメッセージには機密情報が含まれています");

        // (4-2) SendEMailServiceのsendメソッドの実行回数の検査と渡された各引数を検査
    }

    @Test
    @DisplayName("メールの送信失敗時のテスト")
    public void test4() throws Exception{
        // (5-1) SendEMailServiceのsendのスタブを設定(例外をスロー)

        // テスト対象の実行
        assertThrows(
                SendEMailFailureException.class,
                () -> notifyService.notify("1", "こんにちは"));
    }
}
