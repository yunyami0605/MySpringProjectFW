package mylab.notification.di.annot;

/*
 * 이메일과 SMS 알림 서비스를 관리하는 중앙 클래스입니다.
 * 생성자를 통해 NotificationService 타입의 이메일 서비스와 SMS 서비스를 주입받습니다.
 * sendNotificationByEmail 및 sendNotificationBySms 메서드를 통해 각각의 서비스를 사용하여 알림을 전송합니다.

 * */
public class NotificationManager {
    private EmailNotificationService emailService;
    private SmsNotificationService smsService;
    
    public NotificationManager(EmailNotificationService emailService, SmsNotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }
    
    public EmailNotificationService getEmailService() { return emailService; }
    public SmsNotificationService getSmsService() { return smsService; }
    
    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }
    
    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}