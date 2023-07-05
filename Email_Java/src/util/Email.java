package util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class Email {
	// Email :tranhoangvy200498@gmail.com
	// passwork:	ayfjefvwvtqrdpjh
	
	 public static void main(String[] args) {
		final String from ="tranhoangvy200498@gmail.com";
		final String passWord="ayfjefvwvtqrdpjh";
		
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		//create Authenticator; Dang nhap Gmail
		Authenticator auth=new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, passWord);
			}
		};
		//phiên làm việc
		Session session=Session.getInstance(props, auth);
		//gui Email
		final String to ="pkhailuong@gmail.com";
		// tao 1 tin nhawns
		MimeMessage msg=new MimeMessage(session);
		try {
			InternetAddress fromAddress = new InternetAddress(from, from);
			msg.addHeader("content-type", "text/Html; charset=UTF-8");
			//nguoi goi
			msg.setFrom(fromAddress);
			// nguoi nhan
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false)); 
			//tieu de imail
			msg.setSubject("gữi từ tranhoangvy20041998@gmail.com");
			//qui dinh ngay
			msg.setSentDate(new Date());
			//qui dinh email nhan phan hoi
//			msg.setReplyTo(InternetAddress.parse(from,false));
			
			//noi dung
			msg.setText("hai lc nhu cc ","UTF-8");
			// tạo đối tuongj chưa file
			// Tạo đối tượng MimeBodyPart chứa file đính kèm
//			MimeBodyPart attachmentPart = new MimeBodyPart();
			//gữi Email
			Transport.send(msg);
			System.out.println("gữi mail thành công");
		} catch (Exception e) {
			System.out.println("gặp lỗi trong quá trình gữi mail");
			e.printStackTrace();
			// TODO: handle exception
		}
		 
	}
	 
}
