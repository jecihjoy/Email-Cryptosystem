
package NewProject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author JoyGich
 */
public class TextEncryption extends JFrame {

    
    public static final String ALGO = "AES";
    private byte[] keyvalue;
    public byte[] enterText;
    private JTextArea text;
    private JButton encry;
    
//    public TextEncryption(){
//        
//    }
    public TextEncryption(String key){   
        keyvalue = key.getBytes();  
        setLayout(new FlowLayout());
        setSize(400,400);
        setLocation(100,100);
        setTitle("Text Encryption");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        text = new JTextArea("text area", 5,20);
        text.setBackground(Color.red);
        text.setVisible(true);
        add(text);
        
        encry = new JButton("Encrypt");
        add(encry);
        //enterText = text.getBytes();
    }
   
    public String encrypt(String Data) throws Exception{
    Key key = genarateKey();//call the genera  
    Cipher c = Cipher.getInstance(ALGO);//creates ciphertext oftype AES algorithm
    c.init(Cipher.ENCRYPT_MODE, key);//converts the cipher to encrypt mode using the key  
    byte[] encvalue = c.doFinal(Data.getBytes());//method using to encryp data. data is first converted into bytes.
    String encryptedValue = new BASE64Encoder().encode(encvalue);// encrypted data is then encoded and stored/returned as a string
    return encryptedValue;
    //encrypted then encoded.
    }
     
    public String decrypt(String encryptedData) throws Exception{
        Key key = genarateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decvalue =c.doFinal(decodedValue);
        String decrpytedValue = new String(decvalue);
        return decrpytedValue;
        //decoded then decrypted.
    
        
    }
    
    private Key genarateKey() throws Exception{
        Key key = new SecretKeySpec(keyvalue, ALGO);
        return key;
    }
    public static void main(String[] args){
        try{
            TextEncryption gui = new TextEncryption("qwertyuizxcvbnmm" );//key passed to the constructor.
            String encdata = gui.encrypt("Hey Demo");
            //JOptionPane.showMessageDialog(null, "Encrypted text " +encdata);
            String decdata = gui.decrypt(encdata);
            //JOptionPane.showMessageDialog(null, "decrypted text " +decdata);
            
        }catch(Exception ex){
            //Logger.getLogger(AESExample.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
}

