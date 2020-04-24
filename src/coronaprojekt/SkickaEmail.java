/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;


/*import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

/**
 *
 * @author Main
 */
public class SkickaEmail {
        /*public static void skicka(String mottagare, String amne, String msg) {
        System.out.println("Förbereder att skicka mail..");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String gmailAdress = "oru.no.reply@gmail.com";
        String gmailLosenord = "corona777";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(gmailAdress, gmailLosenord);
            }
        });
        Message message = forberedMeddelande(session, gmailAdress, mottagare, amne, msg);       
        try {
            Transport.send(message);
            System.out.println("Email skickat till: " + mottagare);
        } catch (MessagingException ex) {
            System.out.println("Error kunde inte skicka email: " + ex.getMessage());
        }       
    }
    
    private static Message forberedMeddelande(Session session, String gmailAdress, String mottagare, String amne, String msg){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(gmailAdress)); 
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mottagare));
            message.setSubject(amne);
            message.setText(msg);
            return message;
        }catch(MessagingException ex){
            System.out.println("Error kunde inte förbereda email: " + ex.getMessage());
        }
        return null;
    }*/
}
