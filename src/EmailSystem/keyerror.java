/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSystem;

import java.awt.BorderLayout;
import javax.swing.JDialog;

/**
 *
 * @author jecihjoy
 */
public class keyerror extends JDialog {



    
    public keyerror(){
        setSize(330,140);
        setTitle("Sorry your decryption key doesnt match your encryption key");
        setLocationRelativeTo(new Main());
        setLayout(new BorderLayout());
        add(new DecryptionPanel(), BorderLayout.CENTER);
        setVisible(true);
    }
    
}
    

