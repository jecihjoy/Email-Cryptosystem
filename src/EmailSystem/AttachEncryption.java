
package EmailSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author JoyGich
 */
public class AttachEncryption {
    
    
    
public static void encryption(){
    //String path = pdf.getText(); 
    
    try{
        FileInputStream file=new FileInputStream(ComposeMail.attach1.getText());
        FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\EncDec\\Encrypted.png");
	byte k[]="amos123456Gatero".getBytes();
        SecretKeySpec key=new SecretKeySpec(k,"AES");
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



    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       try{
        FileInputStream file=new FileInputStream(ComposeMail.attach1.getText());
        FileOutputStream output=new FileOutputStream("C:\\Users\\AmosGait\\Desktop\\EncDec\\Decrypt.file");
	byte k[]="amos123456Gatero".getBytes();
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
        
        
    }                                        

    
}
