
package EmailSystem;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;
import java.awt.BorderLayout;
import javax.swing.JDialog;

/**
 *
 * @author JoyGich
 */
public class OpenMailDialog extends JDialog {
 
     public OpenMailDialog(){
        setSize(476, 600);
       // setTitle("Enter Decryption Key");
        setLocationRelativeTo(new OpenMail());
        setLayout(new BorderLayout());
        add(new OpenMail(), BorderLayout.CENTER);
        setVisible(true);
    }
     
    
}

