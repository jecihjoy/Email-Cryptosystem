
package EmailSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoyGich
 */
public class SaveAttachments {
    public static String attch1, attch2;
     public static FileOutputStream fop = null;
    public static File file;
    
    public static void saveattachments(){
        attch1 = ComposeMail.attach1.getText();
        attch2 = ComposeMail.attach2.getText();
        
         //write message content


        //write mail header content into file
        try {

            file = new File("Myfiles/MailAttachments.txt");
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] username = attch1.getBytes();
            byte[] osname = attch2.getBytes();

            fop.write(username);
            fop.write(System.getProperty("line.separator").getBytes());
            fop.write(osname);
            fop.flush();
            fop.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
      

    }

