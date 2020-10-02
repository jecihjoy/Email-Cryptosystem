
package Encryption;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Im jecihjoy
 */
public class decryptionPopup extends JDialog {
    JLabel l1;
    JTextField key;
    JButton encry;
    JPanel panel;
    public decryptionPopup(JFrame frame){
        super(frame, "popup window", true);
        setLayout(new GridLayout(3,1));
        
        l1 = new JLabel("Enter key");
        key =  new JTextField(45);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        encry = new JButton("Encrypt");
        panel.add(encry);
        
        encry.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                JOptionPane.showMessageDialog(null,"Your Email Has been Successfully decrypted", "Alert Box", JOptionPane.INFORMATION_MESSAGE);              
            }
        });
        add(l1);
        add(key);
        add(panel);
    }
    
}
