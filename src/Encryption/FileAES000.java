
package Encryption;

import static Encryption.AESExample.ALGO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.misc.BASE64Encoder;

/**
 *
 * @author JoyGich
 */
public class FileAES000 extends JFrame {
    private JTextField attach;
    private JButton attachfile, encrypt,decrypt;
    public static final String ALGO = "AES";
    private byte [] keyvalue;
    private File file;
    private JLabel mes;
    private JTextArea message;
    
    public FileAES000(){
        setLayout(new GridLayout (4,2));
//        keyvalue = key.getBytes();
        
        attach = new JTextField(50);
        attachfile = new JButton("Attach File");
        mes = new JLabel("message");
        message = new JTextArea("Compose",5,20);
        
        attachfile.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
                 JFileChooser chooser = new JFileChooser();  
                 chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                 chooser.showOpenDialog(null);
                 file = chooser.getSelectedFile();
                 String filename = file.getAbsolutePath();
                 attach.setText(filename);
             }
                 });
        message.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                message.setText(null);
            }
        });
        
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        
        attachfile.setVisible(true);
        add(mes);
        add(message);
        add(attachfile);
        add(attach);
        add(encrypt);
        add(decrypt);
    
    ///file encryption
    
    encrypt.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){                               
       //byte[] clearText = null;
        try{
           // String seed = null;
        FileInputStream file=new FileInputStream(attach.getText());
        FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\EncDec\\Encrypt.file");
	 keyvalue="keyA123456Gatero".getBytes();
        //String m = JOptionPane.showMessageDialog("Enter key");
	//String k=JOptionPane.showMessageDialog();
        SecretKeySpec key=new SecretKeySpec(keyvalue,"AES");
	Cipher enc=Cipher.getInstance("AES");
	enc.init(Cipher.ENCRYPT_MODE, key);
	CipherOutputStream cos=new CipherOutputStream(output,enc);
	byte[] buf=new byte[1024];
	int read;
	while((read=file.read(buf))!=-1){
	cos.write(buf,0,read);
	}
	file.close();
	output.flush();
	cos.close();
	JOptionPane.showMessageDialog(null, "Successfully Encrypted the Text file");
		
	}catch(Exception e){
	JOptionPane.showMessageDialog(null, e);
	}
        
    }
});



    decrypt.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){                                        
       try{
        FileInputStream file=new FileInputStream(attach.getText());
        FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\EncDec\\Decrypt.file");
	byte k[]="keyA123456Gatero".getBytes();
	SecretKeySpec key=new SecretKeySpec(k,"AES");
	Cipher enc=Cipher.getInstance("AES");
	enc.init(Cipher.DECRYPT_MODE, key);
	CipherOutputStream cos=new CipherOutputStream(output,enc);
	byte[] buf=new byte[1024];
	int read;
	while((read=file.read(buf))!=-1){
	cos.write(buf,0,read);
	}
	file.close();
	output.flush();
	cos.close();
	JOptionPane.showMessageDialog(null, "Successfully decrypted the Text file");
	}catch(Exception e){
	JOptionPane.showMessageDialog(null, e);
	}                            
        
        
    }});
    }
    //text Encryption
    public String encrypt(String Data) throws Exception{
        Key key = genarateKey();//call the genera  
        Cipher c = Cipher.getInstance(ALGO);//creates ciphertext oftype AES algorithm
        c.init(Cipher.ENCRYPT_MODE, key);//converts the cipher to encrypt mode using the key  
        byte[] encvalue = c.doFinal(Data.getBytes());//method using to encryp data. data is first converted into bytes.
        String encryptedValue = new BASE64Encoder().encode(encvalue);// encrypted data is then encoded and stored/returned as a string
        return encryptedValue;
        //encrypted then encoded.
    }
     
    private Key genarateKey() throws Exception{
        Key key = new SecretKeySpec(keyvalue, ALGO);
        return key;
    }
  public static void main(String[] args) {
        FileAES000 gui=new FileAES000();
        gui.setSize(400, 150);
        gui.setTitle("File Encryption");
        gui.setResizable(false);
        gui.setLocation(150,100);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
  }
}
