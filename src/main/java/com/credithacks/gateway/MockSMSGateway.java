package com.credithacks.gateway;

import com.credithacks.exception.SendSMSException;
import com.sun.mail.smtp.SMTPTransport;

import javax.enterprise.inject.Alternative;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * Created by roman_b on 12/19/2014.
 */
@Alternative
public class MockSMSGateway implements SMSGateway{

    @Override
    public String send(String phone, String msg) throws SendSMSException {
        String senderEmail = "roman.burdeiniy@gmail.com";
        String senderPassword = "Gosha2283368";
        String recipientEmail = "roman.burdeiniy@gmail.com";
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set
        to true (the default), causes the transport to wait for the response to the QUIT command.
        */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage emailMsg = new MimeMessage(session);

        try{
            // -- Set the FROM and TO fields --
            emailMsg.setFrom(new InternetAddress(senderEmail));
            emailMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

            emailMsg.setSubject("Your SMS code");
            emailMsg.setText(msg, "utf-8");
            emailMsg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

            t.connect("smtp.gmail.com", senderEmail, senderPassword);
            t.sendMessage(emailMsg, emailMsg.getAllRecipients());
            t.close();
        }catch(MessagingException e){
            throw new SendSMSException("The email with SMS code can't be sent to " + recipientEmail);
        }

        return null;
    }

}
