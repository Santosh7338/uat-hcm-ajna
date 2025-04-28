/**
 * 
 */
package com.omfysgroup.ajanhcm.utility;

import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.omfysgroup.ajanhcm.model.Candidate_Information;
import com.omfysgroup.ajanhcm.model.LeaveDetails;
import com.omfysgroup.ajanhcm.model.RenewedMailCommunication;


/**
 * @author Omfys
 *
 */
@Component
public class MailService {
	
    final String user = "omfys.test@omfysgroup.com";// for UAT
	
     final String password = "Omfys@123";// change accordingly

	 //  final String user = "hrdesk@omfysgroup.com";// for production

	  // final String password = "Omfy$#987";// change accordingly for hrdesk
	
	public void sendMailForLeave(String employeeMailId, LeaveDetails leaveDetail, String mailBody, int empId)
			throws MessagingException {
	
		String to = employeeMailId; String cc = null; 
		
		String application_date = null, start_date = null, end_date = null;
		DateFormat cre12 = new SimpleDateFormat("dd-MM-yyyy");

		if (leaveDetail.getApplication_Date() != null) {
			application_date = cre12.format(leaveDetail.getApplication_Date());
		}

		if (leaveDetail.getStart_date() != null) {
			start_date = cre12.format(leaveDetail.getStart_date());
		}

		if (leaveDetail.getEnd_date() != null) {
			end_date = cre12.format(leaveDetail.getEnd_date());
		}

		RenewedMailCommunication mail = new RenewedMailCommunication();
		mail.setComm_type("Email");
		mail.setSub_type("Leave Application of " + leaveDetail.getEmpCode());

		mail.setFrom_mail(user);
		
		mail.setSubject("Leave Application " + leaveDetail.getApplicant_Name() + " " + "(" + leaveDetail.getEmpCode()
				+ ") on " + application_date);
		
		mail.setBody(mailBody);
		mail.setStatus("Completed");
		mail.setCreated_by(empId);
		mail.setLast_updated_by(empId);

		String host = "hosted-ex01.go4hosting.in";
		
		final String port = "587";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		MimeMessage message1 = new MimeMessage(session1);
		message1.setFrom(new InternetAddress(user));
		message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		if (cc != null) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		}

		message1.setSubject("Leave Application " + leaveDetail.getApplicant_Name() + " " + "("
				+ leaveDetail.getEmpCode() + ") on " + application_date);
		try {
			message1.setContent(mailBody,"text/html");
			Transport.send(message1);
//			System.out.println("Mail send to "+to);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void updatedSendMail(RenewedMailCommunication renewMailObj) throws MessagingException {
		
//		String to = renewMailObj.getTo_mail(); 
		String cc = null; 
	
		String to="santosh.kotgyale@omfysgroup.com";
		
		cc=renewMailObj.getCc_mail();

		String host = "hosted-ex01.go4hosting.in";//smtp
		final String port = "587";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		MimeMessage message1 = new MimeMessage(session1);
		message1.setFrom(new InternetAddress(user));
		message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		if (cc != null) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		}

		message1.setSubject(renewMailObj.getSubject());

		try {
			message1.setContent(renewMailObj.getBody(), "text/html");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Transport.send(message1);
//			System.out.println("updatedSendMail Mail Send to ==> "+to+" Employee Mail Id ==> "+renewMailObj.getTo_mail());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void sendMailWithAttachment(RenewedMailCommunication renewMailObj,String filepath,String filename) throws AddressException, MessagingException
	{
		String to = renewMailObj.getTo_mail(); String cc = null;
		String host = "hosted-ex01.go4hosting.in";//smtp
		final String port = "587";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		MimeMessage message1 = new MimeMessage(session1);
		message1.setFrom(new InternetAddress(user));
		message1.setSubject(renewMailObj.getSubject());
		message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		if (cc != null) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		}
		
		//4) create new MimeBodyPart object and set DataHandler object to this object      
	    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
	  
	    DataSource source = new FileDataSource(filepath);  
	    messageBodyPart2.setDataHandler(new DataHandler(source));  
	    messageBodyPart2.setFileName(filename); 
	    
	  //5) create Multipart object and add MimeBodyPart objects to this object      
	    Multipart multipart = new MimeMultipart();  
	    multipart.addBodyPart(messageBodyPart2); 
	    
	  // Create the HTML Part
	    BodyPart htmlBodyPart = new MimeBodyPart();
	    htmlBodyPart.setContent(renewMailObj.getBody(),"text/html");
	    multipart.addBodyPart(htmlBodyPart);  
	     
	    //6) set the multiplart object to the message object  
	    message1.setContent(multipart); 
	    
	  //7) send message  
	    Transport.send(message1); 
//	    System.out.println("Mail send to "+to);
	 }

	
	//Send mail for certification management module
	public void updatedSendMailForCertificationMngt(RenewedMailCommunication renewMailObj,String[] cc) throws MessagingException {
		
		String to = renewMailObj.getTo_mail(); 

		String host = "hosted-ex01.go4hosting.in";//s
		final String port = "587";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		
		System.out.println("=====");
		
		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		MimeMessage message1 = new MimeMessage(session1);
		message1.setFrom(new InternetAddress(user));
		message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		if (cc != null) {
			for (int i = 0; i <= cc.length-1; i++) {
				message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
			}
		}

		message1.setSubject(renewMailObj.getSubject());

		try {
			message1.setContent(renewMailObj.getBody(), "text/html");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Transport.send(message1);
//			System.out.println("Mail send to "+to);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Send mail for certification management module
	
	//mail for h
public void updatedmailforhiring(RenewedMailCommunication renewMailObj) throws MessagingException {
		
		String to = renewMailObj.getTo_mail(); String cc = null; 
		
		final String hiringuser = "recruitment@omfysgroup.com";// for UAT
		
	   	final String hiringpassword = "Omfys@567";// change accordingly

		String host = "hosted-ex01.go4hosting.in";//smtp
		final String port = "587";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(hiringuser, hiringpassword);
			}
		});

		MimeMessage message1 = new MimeMessage(session1);
		message1.setFrom(new InternetAddress(hiringuser));
		message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		if (cc != null) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		}

		message1.setSubject(renewMailObj.getSubject());

		try {
			message1.setContent(renewMailObj.getBody(), "text/html");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Transport.send(message1);
//			System.out.println("updatedSendMail Mail Send to ==> "+to+" Employee Mail Id ==> "+renewMailObj.getTo_mail());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

public void sendmail(RenewedMailCommunication renewMailObj, byte[] attachmentData, String fileName, String fileType,
		String[] cc, String[] to, String interDate, String interTime, String meetinglink,
		Candidate_Information cand, String address) throws MessagingException {
//	String to = renewMailObj.getTo_mail(); 
	
	final String hiringuser = "recruitment@omfysgroup.com";// for UAT
	
   	final String hiringpassword = "Omfys@567";// change accordingly
	
	
	String host = "hosted-ex01.go4hosting.in";//smtp
	final String port = "587";

	Properties props = new Properties();
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", port);
	props.put("mail.smtp.auth", "true");

	Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(hiringuser, hiringpassword);
		}
	});
	
	MimeMessage message1 = new MimeMessage(session1);
	message1.setFrom(new InternetAddress(hiringuser));
	message1.setSubject(renewMailObj.getSubject());
	
	if (to != null) {
		for (int i = 0; i < to.length; i++) {
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
		}
		//message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
	}
	
	if (cc != null) {
		for (int i = 0; i <= cc.length-1; i++) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
		}
		//message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
	}
	
	//4) create new MimeBodyPart object and set DataHandler object to this object      
	MimeBodyPart attachmentBodyPart = new MimeBodyPart();
    attachmentBodyPart.setFileName(fileName); // Replace with the desired file name
    attachmentBodyPart.setContent(attachmentData, fileType);

    
  //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(attachmentBodyPart); 
    
  // Create the HTML Part
    BodyPart htmlBodyPart = new MimeBodyPart();
    htmlBodyPart.setContent(renewMailObj.getBody(),"text/html");
    multipart.addBodyPart(htmlBodyPart);  
     
    //6) set the multiplart object to the message object  
    message1.setContent(multipart); 
    
  //7) send message  
    Transport.send(message1); 
   System.out.println("Mail send to "+to);

}

public void SendMailForJobPosting(RenewedMailCommunication renewMailObj , String cc[] , String to[]) throws MessagingException {
	
	//String to = renewMailObj.getTo_mail(); 
    final String hiringuser = "recruitment@omfysgroup.com";// for UAT
	
   	final String hiringpassword = "Omfys@567";// change accordingly
	
	
	String host = "hosted-ex01.go4hosting.in";//s
	final String port = "587";
	
	Properties props = new Properties();
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", port);
	props.put("mail.smtp.auth", "true");

	
	System.out.println("=====");
	
	Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(hiringuser, hiringpassword);
		}
	});

	MimeMessage message1 = new MimeMessage(session1);
	message1.setFrom(new InternetAddress(hiringuser));
	
	
	if (to != null) {
		for (int i = 0; i <= to.length-1; i++) {
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
		}
	}
	
	
	if (cc != null) {
		for (int i = 0; i <= cc.length-1; i++) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
		}
	}

	
	message1.setSubject(renewMailObj.getSubject());

	try {
		message1.setContent(renewMailObj.getBody(), "text/html");
	} catch (MessagingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Transport.send(message1);
//		System.out.println("Mail send to "+to);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public void SendMailForInterviewRejection(RenewedMailCommunication renewMailObj) throws MessagingException {
	
	String to = renewMailObj.getTo_mail();
	
     final String hiringuser = "recruitment@omfysgroup.com";// for UAT
	
   	final String hiringpassword = "Omfys@567";// change accordingly

	String host = "hosted-ex01.go4hosting.in";//s
	final String port = "587";
	
	Properties props = new Properties();
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", port);
	props.put("mail.smtp.auth", "true");

	
	System.out.println("=====");
	
	Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(hiringuser, hiringpassword);
		}
	});

	MimeMessage message1 = new MimeMessage(session1);
	message1.setFrom(new InternetAddress(hiringuser));
	//message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
		   message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	       message1.setSubject(renewMailObj.getSubject());

	try {
		message1.setContent(renewMailObj.getBody(), "text/html");
	} catch (MessagingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Transport.send(message1);
//		System.out.println("Mail send to "+to);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public void sendmailForWarningManagementSystem(RenewedMailCommunication renewMailObj, byte[] attachmentData, String fileName, String fileType,
		String[] cc, String to) throws MessagingException {
//	String to = renewMailObj.getTo_mail(); 
	String host = "hosted-ex01.go4hosting.in";//smtp
	final String port = "587";

	Properties props = new Properties();
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", port);
	props.put("mail.smtp.auth", "true");

	Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, password);
		}
	});
	
	MimeMessage message1 = new MimeMessage(session1);
	message1.setFrom(new InternetAddress(user));
	message1.setSubject(renewMailObj.getSubject());
	
	if (to != null) {
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
	}
	
	if (cc != null) {
		for (int i = 0; i <= cc.length-1; i++) {
			message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
		}
		//message1.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
	}
	
	//4) create new MimeBodyPart object and set DataHandler object to this object      
	MimeBodyPart attachmentBodyPart = new MimeBodyPart();
    attachmentBodyPart.setFileName(fileName); // Replace with the desired file name
    attachmentBodyPart.setContent(attachmentData, fileType);

    
  //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(attachmentBodyPart); 
    
  // Create the HTML Part
    BodyPart htmlBodyPart = new MimeBodyPart();
    htmlBodyPart.setContent(renewMailObj.getBody(),"text/html");
    multipart.addBodyPart(htmlBodyPart);  
     
    //6) set the multiplart object to the message object  
    message1.setContent(multipart); 
    
  //7) send message  
    Transport.send(message1); 
   System.out.println("Mail send to "+to);

}

	
	
	
}
