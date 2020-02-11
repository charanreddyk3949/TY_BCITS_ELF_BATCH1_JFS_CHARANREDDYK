package com.bcits.discomusecase.mail;


import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bcits.discomusecase.beans.CurrentBill;
 

public class EmailGenerator {
	public boolean sendMail(CurrentBill currentBill) {

		System.out.println("sending...");

		final String username = "charanreddyk439@gmail.com";
		final String password = "9676262682";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(currentBill.getDueDate());
		String date = dateFormat.format(currentBill.getDueDate());

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("charanreddy2185@gmail.com"));
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Consumer," + "\n\n This  Month you have Consumed  " + currentBill.getConsumption()
					+ " units" + "\n\n Total Bill will be rupees  " + currentBill.getBillAmount()
					+ "\n\n The Due Date will be " + dueDate + "\n\n" + "\n\n" + " Statmented On " + date
					+ "\n\n Thank You " +"\n"+ " Regards, " + "\n" + " DISCOM PVT LTD" );

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
        return false;
	}

}