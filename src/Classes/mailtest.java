
package Classes;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author JoyGich
 */
public class mailtest {

 
    public static void main(String[] args) {
    final String username="rigallitoh@gmail.com";
    final String password="Jevanjee40";
        Properties prop=new Properties();
        prop.put("mail.smtp.starttsl.enable", "true");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        Session session=Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
              return new PasswordAuthentication(username,password);  
            }
});
        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress("rigallitoh@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("journalreagan@gmail.com"));
            message.setSubject("test");
            message.setText("sjAJKJKAJKASJKAJKASJKA");
            
            Transport.send(message);
            System.out.println("success");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
    