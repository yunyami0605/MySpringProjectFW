package mylab.notification.di.annot;

/*
 * NotificationService 인터페이스를 구현합니다.
 * SMS 알림을 전송하는 기능을 제공합니다.
 * 생성자를 통해 SMS 제공업체(provider)를 주입 받습니다.
 * sendNotification 메서드는 메시지와 함께 제공업체 정보를 출력합니다.
 * */
public class SmsNotificationService implements NotificationService {
    private String provider;
    
    public SmsNotificationService(String provider) {
        this.provider = provider;
    }
    
    public String getProvider() { return provider; }
    
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS 알림 전송: " + message + " (제공업체: " + provider + ")");
    }
}