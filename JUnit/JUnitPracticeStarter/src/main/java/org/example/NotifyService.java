package org.example;

public class NotifyService {
    private static final String SUBJECT = "メッセージ通知";
    private static final String SURVEY_SUBJECT = "確認依頼";
    private static final String ADMIN_E_MAIL_ADDRESS = "admin@hoge.com";
    private static final String SURVEY_KEYWORD = "機密";

    private final UserService userService;
    private final SendEMailService sendEMailService;

    /**
     * コンストラクタ
     * @param userService ユーザーサービス
     * @param sendEMailService Eメール送信サービス
     */
    public NotifyService(UserService userService, SendEMailService sendEMailService) {
        this.userService = userService;
        this.sendEMailService = sendEMailService;
    }

    public void notify(String toUserId, String message) throws UserNotFoundException, SendEMailFailureException {
        String eMailAddress = userService.getUserEMailAddress(toUserId);

        sendEMailService.send(eMailAddress, SUBJECT, message);

        if (message.contains(SURVEY_KEYWORD)) {
            sendEMailService.send(ADMIN_E_MAIL_ADDRESS, SURVEY_SUBJECT, message);
        }
    }
}
