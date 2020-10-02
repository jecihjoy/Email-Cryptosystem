
package Classes;

import Classes.RecAppInfo;
import Encryption.decryptionPopup;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author JoyGich
 */
public class Open extends JFrame {
    private JPanel main;
    private static JTextArea textA;
    private JComboBox jcb,select;
    private JLabel title,choose,keylabel,selectfile, sender, subject, attachment,lblloadcounter,
            lbluploadstatus;
    private JButton decrypt,exit, download, open;
    private JTextField text, key, send, sub;
    private Font font, font2;
    private JProgressBar download2;
    private static int progressCounter;
    private File file;
    
    static Socket s;
    static DataInputStream din; //used to accept output from the server using getInputStream() method
    //static DataOutputStream  dout;//used to send data to the server using getOutputString()
    
    public Open(){
        //main = new JPanel();
        setLayout(null);
        //setBackground(Color.decode("#B0C4DE"));
        setBackground(Color.LIGHT_GRAY);
        setBounds(0,0,540,540);
        setBackground(Color.LIGHT_GRAY);
        //add(main);
        font = new Font("Serif", font.ITALIC, 18);
        
        title = new JLabel("Open Your Email");
        title.setBounds(180,10,300,20);
        title.setFont(font);
        add(title);
        
        choose = new JLabel("Choose Mail");
        choose.setBounds(10,65,130,30);
        choose.setFont(font);
        add(choose);
        
        select = new JComboBox();
        select.setBounds(170,65,280,30);
        add(select);
        
        decrypt = new JButton("Decrypt");
        decrypt.setFont(font);
        decrypt.setBounds(50,120,100,30);
        add(decrypt);
        
        open = new JButton("Open");
        open.setFont(font);
        open.setBounds(190,120,100,30);
        add(open);
        decrypt.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
                 decryptionPopup popup = new decryptionPopup(Open.this);
                 popup.setTitle("Encpt your email");
                 popup.setLocation(300,300);
                 popup.setSize(200,130);
                 popup.setVisible(true);
                 popup.setResizable(false);
                 popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
             }
             
         });
        font2 = new Font("Serif", font.ITALIC, 14);
        
        sender = new JLabel("Sender");
        sender.setBounds(10,165,130,30);
        sender.setFont(font);
        add(sender);
        
        send = new JTextField();
        send.setBounds(170,165,310,30);
        add(send);
        
        subject = new JLabel("Subject");
        subject.setBounds(10,210,130,30);
        subject.setFont(font);
        add(subject);
        
        sub = new JTextField();
        sub.setBounds(170,210,310,30);
        add(sub);
      
        
       textA = new JTextArea("received text",5,20);
       textA.setBounds(170,260,310,165);
       textA.setFont(new Font("Courier",Font.ITALIC,20));
        //pane=new JScrollPane(text);
        JScrollPane pane3  = new JScrollPane(textA);
        pane3.setBounds(170,260,310,165);
       add(pane3);
       
       jcb = new JComboBox(new Object[]
        {"--select file--", "file.zip", "file.png", "file.pdf"});
       jcb.setBounds(10,440,100,30);
       add(jcb);
       
       
       download = new JButton("Download");
       download.setFont(font2);      
       download.setBounds(130,440,100,30);   
       add(download);
       
        download2 = new JProgressBar();
        download2.setBounds(250,450,230,20);
        download2.setIndeterminate(false);
        download2.setMaximum(99);
        download2.setMinimum(0);
        //upload2.setVisible(false);
        add(download2);
        
        lblloadcounter = new JLabel("text");
        //lblloadcounter.setFont(new Font("Arial", Font.PLAIN, 15));
        lblloadcounter.setBounds(380,465, 25, 20);
        //lblloadcounter.setVisible(false);
        add(lblloadcounter);
        
        lbluploadstatus = new JLabel();
        lbluploadstatus.setFont(new Font("Arial", Font.PLAIN, 12));
        lbluploadstatus.setBounds(320,410, 600, 15);
        //lbluploadstatus.setVisible(false);
        add(lbluploadstatus);

        
        download.addActionListener(new ActionListener(){
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
                                download2.setValue(progressCounter++);
                                download2.setVisible(true);
                                lbluploadstatus.setText("Downloadind..... ");
                               // +file.getName()+"  "+progressCounter+" %");
                                lblloadcounter.setFont(new Font("Arial Black", Font.BOLD, 80));
                                lblloadcounter.setText(progressCounter+"%");
                                //Check c file directory
                                if (progressCounter == 100) {
                                   System.gc();
                                  lbluploadstatus.setText("Download Complete");
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
        
    }
     public static void main(String[] args) throws IOException {
        Open gui=new Open();
        gui.setSize(510, 540);
        gui.setTitle("Open Mail");
        gui.setResizable(false);
        gui.setLocation(150,100);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        new RecAppInfo();
         try{
            String message_in="";
            s=new Socket("127.0.0.1",1201);
            din=new DataInputStream(s.getInputStream());
            while(!message_in.equals("exit")){
            message_in=din.readUTF();
            textA.setText(textA.getText().trim()+message_in);
            
        }
        
        }
        catch(Exception eeee){
            System.out.print("error");
    }
    }
    
}

    

