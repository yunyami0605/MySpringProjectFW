package mylab.notification.di.annot.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class,
loader=AnnotationConfigContextLoader.class)
public class NotificationConfigTest {
	@Autowired
	private NotificationManager notificationManager;
	
	@Test
	@DisplayName("NotificationManager not null test")
	public void testNotificationManagerNotNull() {
		Assertions.assertNotNull(notificationManager);
	}
	
	
	@Test
	@DisplayName("email service test")
	public void testEmailService(){
		EmailNotificationService es = notificationManager.getEmailService();
		
		Assertions.assertNotNull(es);
		
		Assertions.assertSame(es.getSmtpServer(), "smtp.gmail.com");

		Assertions.assertEquals(es.getPort(), 587); 
		
		EmailNotificationService es2 = new EmailNotificationService("test.com", 400);
		Assertions.assertEquals(es2.getPort(), 400); 
	}
	
	@Test
	@DisplayName("sms service test")
	public void testSMS() {
		SmsNotificationService sms = notificationManager.getSmsService();
		
		Assertions.assertNotNull(sms);
		Assertions.assertSame(sms.getProvider(), "SKT");
	}
	
	@Test
	@DisplayName("NotificationManager method test")
	public void testNotificationManagerMethodTest() {
		notificationManager.sendNotificationByEmail("테스트 이메일");
		notificationManager.sendNotificationBySms("테스트 SMS");
		
	}
	
	
	
	
}
