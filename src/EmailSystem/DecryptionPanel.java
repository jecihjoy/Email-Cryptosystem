
package EmailSystem;

import static EmailSystem.ComposeMail.ALGO;
import static EmailSystem.ComposeMail.attach1;
import static EmailSystem.ComposeMail.attach2;
import static EmailSystem.ComposeMail.decryptText;
import static EmailSystem.ComposeMail.keyspace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;

/**
 *
 * @author JoyGich
 */
public class DecryptionPanel extends javax.swing.JPanel {
private static byte [] keyvalue;
    public static final String ALGO = "AES";
    public static String fromdemo1,datedemo2, Dsub, Dmsg;
    public static String keyenter;
    public DecryptionPanel() {
        initComponents();
         decryptionkey.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               decryptionkey.setText(null);
            }
            
        });
         
        Decrypt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){ 
            //new OpenMailDialog();
       
                    //decryption code.
                    fromdemo1 = Inbox.fromdemo;
                    datedemo2 = Inbox.datedemo;
                    System.out.println(Inbox.fromdemo);
                    System.out.println(Inbox.datedemo);
                    System.out.println(Inbox.subdemo);
                    System.out.println(Inbox.msgdemo);
            String sub,msg;
            keyenter=decryptionkey.getText();
        try{

        if(keyenter.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Encryption key is mandatory");
                                }
                    else{
        
        sub = decryptText(Inbox.subdemo);
        msg = decryptText(Inbox.msgdemo);
        System.out.println(sub);
        System.out.print(msg);

        
        }
	}catch(Exception e){
	JOptionPane.showMessageDialog(null, e);
	}                                                                                                     
        
      
    }
});
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decryptionkey = new javax.swing.JTextField();
        Decrypt = new javax.swing.JButton();

        decryptionkey.setText("Enter Key To decrypt");
        decryptionkey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionkeyActionPerformed(evt);
            }
        });

        Decrypt.setText("Decrypt");
        Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decryptionkey, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(decryptionkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Decrypt)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed
        JOptionPane.showMessageDialog(null,"Sorry your decryption key doesnt match your encryption key", "key error", JOptionPane.ERROR_MESSAGE);
        try {
                        //image
                    FileInputStream file1 = new FileInputStream("C:\\Users\\JoyGich\\Desktop\\Project\\EncDecImg\\Encrypted.png");
                    FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\Project\\EncDecImg\\Decrypted.png");
                    String keyenter=decryptionkey.getText();
                    
                    byte k[]=keyenter.getBytes();
                    SecretKeySpec key=new SecretKeySpec(k,"AES");
                    Cipher enc=Cipher.getInstance("AES");
                    enc.init(Cipher.DECRYPT_MODE, key);
                    CipherOutputStream cos=new CipherOutputStream(output,enc);
                    byte[] buf=new byte[1024];
                    int read;
                    while ((read = file1.read(buf)) != -1) {
                        cos.write(buf,0,read);
                    }
                    file1.close();
                    output.flush();
                    cos.close();
                    JOptionPane.showMessageDialog(null, "Successfully decrypted the Text file");
                    
                    //pdf
                    FileInputStream file2 = new FileInputStream("C:\\Users\\JoyGich\\Desktop\\Project\\EncDecPdf\\Encrypted.pdf");
                    FileOutputStream output1=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\Project\\EncDecPdf\\Decrypted.pdf");
                    String keyenter1=decryptionkey.getText();
                    
                    byte k1[]=keyenter1.getBytes();
                    SecretKeySpec key1=new SecretKeySpec(k1,"AES");
                    Cipher enc1=Cipher.getInstance("AES");
                    enc.init(Cipher.DECRYPT_MODE, key);
                    CipherOutputStream cos1=new CipherOutputStream(output,enc);
                    byte[] buf1=new byte[1024];
                    int read1;
                    while ((read1 = file2.read(buf)) != -1) {
                        cos.write(buf,0,read);
                    }
                    file1.close();
                    output.flush();
                    cos.close();
                    JOptionPane.showMessageDialog(null, "Successfully decrypted the Text file");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            
    
       
    }//GEN-LAST:event_DecryptActionPerformed

    private void decryptionkeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionkeyActionPerformed
       
    }//GEN-LAST:event_decryptionkeyActionPerformed
    private Key genarateKey() throws Exception{
        Key key = new SecretKeySpec(keyvalue, ALGO);
        return key;
    }
    public static String decryptText(String encryptedData) throws Exception {
        // Key key = genarateKeyText(); 
        //String keyenter=decryptionkey.getText();
        keyvalue=keyenter.getBytes();
        SecretKeySpec key=new SecretKeySpec(keyvalue,"AES");
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decvalue = c.doFinal(decodedValue);
        String decrpytedValue = new String(decvalue);
        return decrpytedValue;
        //decoded then decrypted.

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Decrypt;
    public static javax.swing.JTextField decryptionkey;
    // End of variables declaration//GEN-END:variables
}
