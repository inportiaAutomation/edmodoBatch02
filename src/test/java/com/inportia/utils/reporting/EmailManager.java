package com.inportia.utils.reporting;


import java.util.Properties;



/* 
 *  Use gmail SMTP
 * */

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailManager {
    
	
	   static Properties mail_properties;
       static Session getMailSession;
	   static MimeMessage generateMailMessage;
	 
	   public static void sendMail(String emailtext)
	   {
		 
			try
			{
			     email_sending_logic();	
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
	   
	   static void email_sending_logic() throws MessagingException
	   {
		   System.out.println("setting up mail properties....");
			 mail_properties = System.getProperties();
			 mail_properties.put("mail.smtp.port", "587");
			 mail_properties.put("mail.smtp.auth", "true");
			 mail_properties.put("mail.smtp.starttls.enable", "true");
			 mail_properties.put("mail.debug","true");
			 System.out.println("Mail Server Properties have been setup successfully..");
			 
			 System.out.println("setting up mail session....");
			 getMailSession = Session.getDefaultInstance(mail_properties, null);
			 generateMailMessage = new MimeMessage(getMailSession);
			 generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("sohail.choudhary@edmodo.com"));
//			 generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
			 generateMailMessage.setSubject("Inportia reports");
			 String emailBody = " Sample email from the inportia automation team. <br> Thanks";
			 generateMailMessage.setContent(emailBody, "text/html");
			 System.out.println("Mail Session has been created successfully..");
			 
			 Transport transport = getMailSession.getTransport("smtp");
			 
				// Enter your correct gmail UserID and Password
				// if you have 2FA enabled then provide App Specific Password
				transport.connect("smtp.gmail.com", "sohail.chd14@gmail.com", "Bsdlinux2123");
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
				transport.close();
	   }
}
