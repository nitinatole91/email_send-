package com.email;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;



public class GEmailSender {

	public boolean sendEmail(String to,String from,String subject,String text)
	{
		boolean flag=false;
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		String username= "nitin.atole70";
		String password="";
		
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(username ,password);
			}
		});
		
		try {
			
			Message message= new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			
			try {
			MimeMultipart mimeMultipart = new MimeMultipart();
			
//			text
//			file
			
			MimeBodyPart textMime = new MimeBodyPart();
			MimeBodyPart fileMime = new MimeBodyPart();
//			text add
			textMime.setText(text);
//			path add		
			
			fileMime.attachFile("C:\\Users\\Ni3\\Downloads\\NitinAtoleCV.pdf");
			
			mimeMultipart.addBodyPart(textMime);
			mimeMultipart.addBodyPart(fileMime);
			
			message.setContent(mimeMultipart);
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			Transport.send(message);
			flag=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
}
