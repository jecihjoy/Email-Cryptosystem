
package EmailSystem;

import java.awt.BorderLayout;
import javax.swing.JDialog;

/**
 *
 * @author JoyGich
 */
public class EnterKeyDialog extends JDialog {
    
    public EnterKeyDialog(){
        setSize(330,140);
        setTitle("Enter Decryption Key");
        setLocationRelativeTo(new Main());
        setLayout(new BorderLayout());
        add(new DecryptionPanel(), BorderLayout.CENTER);
        setVisible(true);
    }
    
}
