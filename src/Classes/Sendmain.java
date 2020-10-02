
package Classes;

import Classes.SendRunningApps;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.SwingUtilities;

/**
 *
 * @author JoyGich
 */
public class Sendmain extends JFrame {

    private JPanel main2,north, center, south;
    private JLabel sender,receive, subject,msg,lblloadcounter,message;
    private static JTextArea text;
    private JButton encrypt,send,attach,pic,drive,link,upload, delete;
    private JProgressBar upload2;
    private static int progressCounter;
    private JTextField text2,t1,t2,t3;
    private File file;
    private Font font;
    JScrollPane pane=new JScrollPane();
    String[] demo;
    
//    static ServerSocket ss;
//    static Socket s;
//    static DataOutputStream  dout;
    
    public Sendmain(){

        setBounds(0,0,540,540);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        //setBackground(Color.decode("#ff00ff"));
        
        msg = new JLabel("New Message");
        msg.setBounds(80,5,350,30);
        font = new Font("Serif", font.ITALIC, 20);
        msg.setFont(font);
        add(msg);
        
        sender = new JLabel("sender:");
        sender.setBounds(8,53,150,20);
        sender.setFont(font);
        add(sender);
        t1 = new JTextField(10);
        t1.setBounds(120,55,350,25);
        add(t1);
        
        //demo = [msg,sender];
        
        //t1.setVisible(false);
        t1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                t1.setVisible(true);
            }

            
    });
        
        receive = new JLabel("Recipient:");
        receive.setBounds(8,96,100,20);
        receive.setFont(font);
        add(receive);
        t2 = new JTextField(10);
        t2.setBounds(120,96,350,25);
        add(t2);
        //t2.setVisible(false);
        
        subject = new JLabel("Subject:");
        subject.setBounds(8,140,100,20);
        subject.setFont(font);
        add(subject);
        t3 = new JTextField(10);
        t3.setBounds(120,140,350,25);
        add(t3);
        //t3.setVisible(false);
        
        message = new JLabel("Message");
        message.setBounds(8,190,100,30);
        font = new Font("Serif", font.ITALIC, 20);
        message.setFont(font);
        add(message);
        
        text = new JTextArea("compose mail",5,20);
        //text.setBounds(130,160,350,195);
        text.setFont(new Font("Courier",Font.ITALIC,20));
        JScrollPane pane3  = new JScrollPane(text);
        pane3.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        pane3.setBounds(120,190,350,150);
       add(pane3);
        
        attach = new JButton("Attach");
        attach.setBounds(8,370,100,30);
        attach.setBackground(Color.GREEN);
        add(attach);
        
        text2 = new JTextField(50);
        text2.setBounds(130,380,300,20);
        add(text2);
        
        upload = new JButton("Upload");
        upload.setBounds(8,415,100,30);
        upload.setBackground(Color.GREEN);
        add(upload);
        
        upload2 = new JProgressBar();
        upload2.setBounds(130,420,300,20);
        upload2.setIndeterminate(false);
        upload2.setMaximum(99);
        upload2.setMinimum(0);
        //upload2.setVisible(false);
        add(upload2);
        
        lblloadcounter = new JLabel("text");
        //lblloadcounter.setFont(new Font("Arial", Font.PLAIN, 15));
        lblloadcounter.setBounds(435,420, 25, 20);
        //lblloadcounter.setVisible(false);
        add(lblloadcounter);
        
        encrypt = new JButton("Encrypt");
        encrypt.setBounds(8,475,100,30);
        encrypt.setBackground(Color.GREEN);
        add(encrypt);
       
         encrypt.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
//                 EncryptionPopup popup = new EncryptionPopup(SendMail.this);
//                 popup.setTitle("Encpt your email");
//                 popup.setLocation(300,300);
//                 popup.setSize(200,130);
//                 popup.setVisible(true);
//                 popup.setResizable(false);
//                 popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                 
             }
             
         });
         
                
        send = new JButton("Send");
        send.setBounds(130,475,100,30);
       send.setBackground(Color.GREEN);
        add(send);
        
        ImageIcon deleteicon3 =  new ImageIcon(getClass().getResource("delete.png"));
        delete = new JButton();//(deleteicon3);
        delete.setIcon(deleteicon3);
        delete.setBounds(480, 480,37,29);
        add(delete);
        
        attach.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
                 JFileChooser chooser = new JFileChooser();  
                 chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                 chooser.showOpenDialog(null);
                 file = chooser.getSelectedFile();
                 String filename = file.getAbsolutePath();
                 text2.setText(filename);
             }
                 });
        upload.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread scan = new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    while (progressCounter < 100) {

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                upload2.setValue(progressCounter++);
                                 upload2.setVisible(true);
                                //lbluploadstatus.setText("Uploading file..... "+ 
                                //file.getName()+"  "+progressCounter+" %");
                                lblloadcounter.setFont(new Font("Arial Black", Font.BOLD, 80));
                                lblloadcounter.setText(progressCounter+"%");
                                //Check c file directory
                                if (progressCounter == 100) {
                                   System.gc();
                                   //lbluploadstatus.setText("File Uploaded ");
                                   //lbluploadstatus.setVisible(true);
                                   //lbluploadedfile.setVisible(true);
                                   lblloadcounter.setVisible(false);
                                }
                                /*scanSystemFile();
                                if (progressCounter == 100) {
                                     endTimeLabel.setText("End Time: " + LocalTime.now().toString());
                                    JOptionPane.showMessageDialog(null, "Malware detected: True secure found some malware in your system, go to Scan logs to determine action", "True Secure", JOptionPane.ERROR_MESSAGE);
                                }*/
                            }
                        }
                        );
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }

                }
            }
            );
            scan.start();

            }});
        
        
        send.addActionListener(new ActionListener(){ 
        // TODO add your handling code here:
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("sdfghjkl;;");
 
            }
    } 
       ); 
        
     
        
    }
    public static void main(String[] args) {

        Sendmain gui=new Sendmain();
        gui.setSize(540, 540);
        gui.setTitle("Send Mail");
        gui.setResizable(false);
        gui.setLocation(150,100);//320,150
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
 
    }
}
