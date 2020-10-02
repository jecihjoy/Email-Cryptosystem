
package Encryption;

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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author JoyGich
 */
public class EncryptionFinal extends javax.swing.JFrame {
public static final String ALGO = "AES";
    private  byte [] keyvalue;
    private static byte [] keyvalue2;
    private File file;
    public EncryptionFinal() {
        initComponents();
        setLocation(150,100);
        setTitle("Encryption Trials");
        keyspace.setText("Enter key");
        keyspace.setEditable(true);
        keyspace.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               keyspace.setText(null);
            }
            
        });
       
    attachfile.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ev){
             
             char ext[]=new char[4];
             
             JFileChooser chooser = new JFileChooser();  
             chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
             chooser.showOpenDialog(null);
             file = chooser.getSelectedFile();
             String filepath = file.getAbsolutePath();
             attach.setText(filepath);
             
             int x=filepath.length();
             //System.out.println(x);
             int ind=0;
             for(int k=x-1;k>0;k--){
                 char ch=filepath.charAt(k);
                 //System.out.println(ch);
                 
                 if(ch!='.'){
                     ext[ind]=ch;
                     ind++;
                     //System.out.println(ch);
                 }
                 else
                     break;
             }
             
             System.out.println(filepath);
             
             for(int t=3;t>=0;t--){
                 System.out.print(ext[t]);
             }
             
         }
             });
    attachImg.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ev){
             JFileChooser chooser = new JFileChooser();  
             chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
             chooser.showOpenDialog(null);
             file = chooser.getSelectedFile();
             String filepath = file.getAbsolutePath();
             attachImage.setText(filepath);
         }
             });
    attachvd.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ev){
             JFileChooser chooser = new JFileChooser();  
             chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
             chooser.showOpenDialog(null);
             file = chooser.getSelectedFile();
             String filepath = file.getAbsolutePath();
             attachvideo.setText(filepath);
         }
             });
    ///file encryption

    encrypt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){ 
            String demo,demo2;
        try{
            //TEXT
        demo = tmessage.getText();
                    tmessage.setText("");
                    demo2 = encryptText(demo);

                    tmessage.setText(demo2);
                    System.out.print(tmessage);
                    
                    //FILES/
           // String seed = null;
        FileInputStream file=new FileInputStream(attach.getText());
        
        
        System.out.println(attach.getText());
        
        
        FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\EncDec\\Encrypted.pdf");
//        String keyenter = "keyA123456Gatero";
        String keyenter=keyspace.getText();
        if(keyenter.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Encryption key is mandatory");
                                }
                    else{
        keyvalue=keyenter.getBytes();
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
	
        }
	}catch(Exception e){
	JOptionPane.showMessageDialog(null, e);
	}
        attach.setText(null);
        
      
    }
});



    decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String demo,demo2;
                try {
                    //text
                     
                    demo2 = tmessage.getText();
                    tmessage.setText("");
                    demo = decryptText(demo2);

                    tmessage.setText(demo);
                    System.out.print(tmessage);
                    
                    FileInputStream file1 = new FileInputStream(attach.getText());
                    FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\EncDec\\Decrypted.png");
                    String keyenter=keyspace.getText();
                    
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
                    attach.setText((""));
                    keyspace.setText("");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
    }
    
    
     
    private Key genarateKey() throws Exception{
        Key key = new SecretKeySpec(keyvalue, ALGO);
        return key;
    }
    
    //TEXT ENCRYPTION
    public static String encryptText(String Data) throws Exception {
       // Key key = genarateKeyText(); 
        String keyenter=keyspace.getText();
        keyvalue2=keyenter.getBytes();
        SecretKeySpec key=new SecretKeySpec(keyvalue2,"AES");
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encvalue = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encvalue);
        return encryptedValue;
        //encrypted then encoded.
    }

    public static String decryptText(String encryptedData) throws Exception {
        // Key key = genarateKeyText(); 
        String keyenter=keyspace.getText();
        keyvalue2=keyenter.getBytes();
        SecretKeySpec key=new SecretKeySpec(keyvalue2,"AES");
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decvalue = c.doFinal(decodedValue);
        String decrpytedValue = new String(decvalue);
        return decrpytedValue;
        //decoded then decrypted.

    }

    private static Key genarateKeyText() throws Exception {
        Key key = new SecretKeySpec(keyvalue2, ALGO);
        return key;
    }
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tmessage = new javax.swing.JTextArea();
        attachfile = new javax.swing.JButton();
        attach = new javax.swing.JTextField();
        encrypt = new javax.swing.JButton();
        decrypt = new javax.swing.JButton();
        keyspace = new javax.swing.JTextField();
        attachImg = new javax.swing.JButton();
        attachImage = new javax.swing.JTextField();
        attachvd = new javax.swing.JButton();
        attachvideo = new javax.swing.JTextField();
        attachSU = new javax.swing.JButton();
        attchsetup = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Message:");

        tmessage.setColumns(20);
        tmessage.setRows(5);
        jScrollPane1.setViewportView(tmessage);

        attachfile.setText("AttachFile");

        encrypt.setText("Encrypt");
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });

        decrypt.setText("Decrypt");
        decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptActionPerformed(evt);
            }
        });

        keyspace.setText("Enter Key");

        attachImg.setText("AttachImage");

        attachvd.setText("Video/Audio");

        attachSU.setText("AttachSetUp");

        javax.swing.GroupLayout messageLayout = new javax.swing.GroupLayout(message);
        message.setLayout(messageLayout);
        messageLayout.setHorizontalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messageLayout.createSequentialGroup()
                        .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(attachfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(attachImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(attachvd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(attachSU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(attach)
                            .addComponent(attachImage)
                            .addComponent(attachvideo)
                            .addComponent(attchsetup)))
                    .addGroup(messageLayout.createSequentialGroup()
                        .addComponent(keyspace, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        messageLayout.setVerticalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachfile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attachImg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachvideo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attachvd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attchsetup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attachSU, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyspace, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        keyspace.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decryptActionPerformed

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_encryptActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
        UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EncryptionFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptionFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptionFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptionFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptionFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attach;
    private javax.swing.JTextField attachImage;
    private javax.swing.JButton attachImg;
    private javax.swing.JButton attachSU;
    private javax.swing.JButton attachfile;
    private javax.swing.JButton attachvd;
    public static javax.swing.JTextField attachvideo;
    private javax.swing.JTextField attchsetup;
    private javax.swing.JButton decrypt;
    private javax.swing.JButton encrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField keyspace;
    private javax.swing.JPanel message;
    public static javax.swing.JTextArea tmessage;
    // End of variables declaration//GEN-END:variables
}
