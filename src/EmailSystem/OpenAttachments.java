
package EmailSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoyGich
 */
public class OpenAttachments {
    public static String mailA1,mailA2;
    
    public  static void OpenMail(){
        try {
            mailA1=Files.readAllLines(Paths.get("Myfiles/MailAttachments.txt")).get(0);
            mailA2=Files.readAllLines(Paths.get("Myfiles/MailAttachments.txt")).get(1);
            System.out.println(mailA1);
            System.out.println(mailA2);
        } catch (IOException ex) {
            Logger.getLogger(OpenMail.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
