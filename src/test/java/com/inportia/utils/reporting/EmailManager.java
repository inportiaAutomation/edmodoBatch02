package com.inportia.utils.reporting;


import java.util.Properties;

import javax.mail.BodyPart;

/* 
 *  Use gmail SMTP
 * */

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailManager {
    
	   public static void sendMail(String emailtext)
	   {
		    // create the properties
		    Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			// create the session
			Session session = Session.getDefaultInstance(props,null);
			Message message = new MimeMessage(session);
			
			try
			{
				
				message.setFrom( new InternetAddress("sohail.chd14@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sohail.choudhary@edmodo.com"));
				message.setSubject("email subject");
				message.setText(emailtext);
				
				Multipart multipart = new MimeMultipart("");
				BodyPart bodyPart = new MimeBodyPart();
				bodyPart.setText(emailtext);
				multipart.addBodyPart(bodyPart);
				
				message.setContent(multipart);
				
				Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com","sohail.chd14@gmail.com","Bsdlinux@123");
				System.out.println("Transport : "+transport.toString());
				transport.sendMessage(message, message.getAllRecipients());
				System.out.println("Email sent to the user.");
				
			}
			catch(AddressException ex)
			{
				ex.printStackTrace();
			}
			catch(MessagingException ex)
			{
				ex.printStackTrace();
			}
			
	   }
	   
	   public static void sendMail(String subject,String content,String[] attachementList)
	   {
		   
	   }
}
