
package Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JoyGich
 */
public class OpenMail extends JPanel {
    private JPanel main;
    private JLabel title,keylabel,selectfile;
    private JButton browse, decrypt,open,exit;
    private JTextField text, key;
    private Font font;
    private File file;
    public OpenMail(){
        //main = new JPanel();
        setLayout(null);
        //setBackground(Color.decode("#B0C4DE"));
        setBackground(Color.LIGHT_GRAY);
        setBounds(0,0,540,540);
        setBackground(Color.LIGHT_GRAY);
        //add(main);
        font = new Font("Serif", font.ITALIC, 18);
        
        title = new JLabel("Open Your Email");
        title.setBounds(50,10,300,20);
        title.setFont(font);
        add(title);
        
        browse = new JButton("Select File");
        browse.setBounds(10,65,130,30);
        browse.setFont(font);
        add(browse);
        
        text = new JTextField();
        text.setBounds(170,65,280,30);
        add(text);
        
        keylabel = new JLabel("Enter Key");
        keylabel.setBounds(10,130,130,30);
        keylabel.setFont(font);
        add(keylabel);
        
        key = new JTextField();
        key.setBounds(170,130,280,30);
        add(key);
        
        decrypt = new JButton("Decrypt");
        decrypt.setFont(font);
        decrypt.setBounds(10,240,100,30);
        add(decrypt);
        
        open = new JButton("Open");
        open.setFont(font);
        open.setBounds(135,240,90,30);
        add(open);
        
        exit = new JButton("Exit");
        exit.setFont(font);
        exit.setBounds(250,240,90,30);
        add(exit);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        browse.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
                 JFileChooser chooser = new JFileChooser();  
                 chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                 chooser.showOpenDialog(null);
                 file = chooser.getSelectedFile();
                 String filename = file.getAbsolutePath();
                 text.setText(filename);
             }
                 });
        
    }
//     public static void main(String[] args) {
//        OpenMail gui=new OpenMail();
//        gui.setSize(540, 540);
//        gui.setTitle("Send Mail");
//        gui.setResizable(false);
//        gui.setLocation(150,100);
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setVisible(true);
//    }
    
}
