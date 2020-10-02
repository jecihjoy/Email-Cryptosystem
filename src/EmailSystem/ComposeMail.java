
package EmailSystem;

import static EmailSystem.CreateAccount.tpass;
import static EmailSystem.CreateAccount.tphone;
import static Encryption.EncryptionFinal.decryptText;
import static Encryption.EncryptionFinal.keyspace;
import static Encryption.EncryptionFinal.tmessage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.security.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author JoyGich
 */
public class ComposeMail extends javax.swing.JPanel {
    
    private static byte [] keyvalue;
    public static final String ALGO = "AES";
    public String Esub, Emsg;
    public char newfp[]; 
    
    String demo;
             public int attach1Status=0;
             public int attach2Status=0;
             public int attach3Status=0;
             public int attach4Status=0;
             public String filepath ;
             public   String keyenter;

    
    public ComposeMail()   {
        initComponents();
        curDate();
        getTo();
        keyspace.setText("Enter key");
        keyspace.setEditable(true);
        keyspace.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               keyspace.setText(null);
            }
            
        });
       
        
        //email text encryption
    encrypt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){ 
            String sub,msg;
        try{

        Esub = encryptText(txtSub.getText());
        Emsg = encryptText(txtCompose.getText());
        //System.out.print(tmessage);
        txtSub.setText(Esub);
        txtCompose.setText(Emsg);
        
                    
        String keyenter=keyspace.getText();
        if(keyenter.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Encryption key is mandatory");
                                }
        else {
            //TIMER
            JOptionPane.showMessageDialog(null, "Email Encrypted Successfully");
        
        }
	}catch(Exception e){
	JOptionPane.showMessageDialog(null, e);
	}
        
      
    }
});
      decrypt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){ 
            String sub,msg;
            
        try{

        sub = decryptText(txtSub.getText());
        msg = decryptText(txtCompose.getText());
        //System.out.print(tmessage);
        txtSub.setText(sub);
        txtCompose.setText(msg);
        
        String keyenter=keyspace.getText();
        if(keyenter.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Encryption key is mandatory");
                                }
                    else{
        
            
            
        }
	}catch(Exception e){
	JOptionPane.showMessageDialog(null, e);
	}                                                                                                     
        
      
    }
});

      //SAVES A NEW EMAIL TO THE DATABASE
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ve) {
                SaveAttachments.saveattachments();
                String from = Main.sender.getText();
                String to=textTo.getText();
                String sub = txtSub.getText();
                String message = txtCompose.getText();
                String date = datelabel.getText();
                String pdfpath = attach1.getText();
                System.out.println(pdfpath);
                String imagepath =  attach2.getText();
                
               
               
                if(to.isEmpty() || sub.isEmpty() || message.isEmpty() ||  date.isEmpty()) 
                {
                   JOptionPane.showMessageDialog(null, "ERROR: ALL FIELD ARE REQUIRED","ERROR",JOptionPane.ERROR_MESSAGE);
                   
                }else
                 
                try{
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
                        Statement st = conn.createStatement();
                        String sql="INSERT INTO emails VALUES('"+from+"','"+to+"','"+sub+"','"+message+"',"
                                + "'"+LocalDate.now()+"')";
                       
                       st.execute(sql);
                       
                       JOptionPane.showMessageDialog(null, "Email send","Mail Box",JOptionPane.OK_OPTION);

                }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, "SERVER SAYS :"+ e.getMessage(),"SERVR ERROR",JOptionPane.OK_OPTION);
                    }
                        
                    }
        });
        
        attach.addActionListener(new ActionListener(){
            
            //AttachEncryption.encryption().
         private File file;
         public void actionPerformed(ActionEvent ev){
             char ext[]=new char[4];
              
             
             
             JFileChooser chooser = new JFileChooser();  
             chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
             chooser.showOpenDialog(null);
             file = chooser.getSelectedFile();
             String fileName=chooser.getSelectedFile().getName().toString();
             
             filepath = file.getAbsolutePath();
           
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
        keyvalue=keyenter.getBytes();
        SecretKeySpec key=new SecretKeySpec(keyvalue,"AES");
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encvalue = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encvalue);
        return encryptedValue;
        //encrypted then encoded
    
    }

    public static String decryptText(String encryptedData) throws Exception {
        // Key key = genarateKeyText(); 
        String keyenter=keyspace.getText();
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
    public static String getTo(){
        return textTo.getText();
    }
//     
    public void curDate(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        datelabel.setText(year+"/"+(month+1)+"/"+day);
        System.out.print(LocalDate.now());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTo = new javax.swing.JTextField();
        txtSub = new javax.swing.JTextField();
        datelabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCompose = new javax.swing.JTextArea();
        attach = new javax.swing.JButton();
        attach3 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        attach1 = new javax.swing.JLabel();
        attach2 = new javax.swing.JLabel();
        keyspace = new javax.swing.JTextField();
        encrypt = new javax.swing.JButton();
        decrypt = new javax.swing.JButton();
        attach4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(625, 420));

        textTo.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        textTo.setText("Email@gmail.com");
        textTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textToMouseClicked(evt);
            }
        });
        textTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textToActionPerformed(evt);
            }
        });

        txtSub.setText("Subject");
        txtSub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSubMouseClicked(evt);
            }
        });
        txtSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubActionPerformed(evt);
            }
        });

        datelabel.setFont(new java.awt.Font("Bradley Hand ITC", 3, 14)); // NOI18N
        datelabel.setForeground(new java.awt.Color(0, 0, 204));
        datelabel.setText("Date");

        txtCompose.setColumns(20);
        txtCompose.setRows(5);
        txtCompose.setText("compose mail\n");
        txtCompose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtComposeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtComposeMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(txtCompose);

        attach.setText("Attach");
        attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachActionPerformed(evt);
            }
        });

        attach3.setText("Attachment3");

        send.setText("SEND");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jLabel1.setText("To:");

        jLabel2.setText("Subject:");

        jLabel3.setText("Compose:");

        attach1.setText("Attachment1");

        attach2.setText("Attachment2");

        keyspace.setToolTipText("Key length must be 16 bits");
        keyspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyspaceActionPerformed(evt);
            }
        });

        encrypt.setText("Encrypt");
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });

        decrypt.setText("reverse");

        attach4.setText("Attachment4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(keyspace, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(attach, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(attach1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(attach2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(attach3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)))
                                .addComponent(attach4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSub, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                                    .addComponent(textTo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1))))
                        .addGap(20, 20, 20)))
                .addComponent(decrypt))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datelabel)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attach2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attach1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attach, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attach3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attach4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(send)
                            .addComponent(keyspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(encrypt)
                            .addComponent(decrypt)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubActionPerformed
        if(!txtSub.getText().equals("")){
        txtCompose.requestFocusInWindow();
        txtCompose.setText(null);
        }else{
            txtSub.requestFocusInWindow();
        }
        
    }//GEN-LAST:event_txtSubActionPerformed

    private void attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachActionPerformed
       
    }//GEN-LAST:event_attachActionPerformed

    private void textToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textToActionPerformed
        if(!textTo.getText().equals("")){
        txtSub.requestFocusInWindow();
        txtSub.setText(null);
        }else{
            textTo.requestFocusInWindow();        }
    }//GEN-LAST:event_textToActionPerformed

    private void txtComposeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComposeMouseEntered
       
    }//GEN-LAST:event_txtComposeMouseEntered

    private void textToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textToMouseClicked
        textTo.setText(null);
    }//GEN-LAST:event_textToMouseClicked

    private void txtComposeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComposeMouseClicked
         txtCompose.setText(null);
    }//GEN-LAST:event_txtComposeMouseClicked

    private void txtSubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSubMouseClicked
        txtSub.setText(null);
    }//GEN-LAST:event_txtSubMouseClicked

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
       try{
           //image
           FileInputStream file=new FileInputStream(attach2.getText());
        
             FileOutputStream output=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\Project\\EncDecImg\\Encrypted.png");
//        String keyenter = "keyA123456Gatero";
             keyenter=keyspace.getText();
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
            //cos.close();
            JOptionPane.showMessageDialog(null, "Successfully Encrypted the Image");
            }
        
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
           try{
            //pdf
            FileInputStream file1=new FileInputStream(attach1.getText());
        
             FileOutputStream output1=new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\Project\\EncDecPdf\\Encrypted.pdf");
            String keyenter1=keyspace.getText();
            if(keyenter.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Encryption key is mandatory");
                                    }
                        else{
            keyvalue=keyenter.getBytes();
            SecretKeySpec key1=new SecretKeySpec(keyvalue,"AES");
            Cipher enc1=Cipher.getInstance("AES");
            enc1.init(Cipher.ENCRYPT_MODE, key1);
            CipherOutputStream cos1=new CipherOutputStream(output1,enc1);
            byte[] bufread=new byte[1024];
            //cos1.getBytes();
            int read1;
            while((read1=file1.read(bufread))!=-1){
            cos1.write(bufread,0,read1);
            }
            file1.close();
            output1.flush();
            cos1.close();
            JOptionPane.showMessageDialog(null, "Successfully Encrypted the file");
            
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
            attach.setText(null);


        

        
    }//GEN-LAST:event_encryptActionPerformed

    private void keyspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyspaceActionPerformed
        keyspace.setToolTipText("Key Length must be 16 bits");
    }//GEN-LAST:event_keyspaceActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        
    }//GEN-LAST:event_sendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attach;
    public static javax.swing.JLabel attach1;
    public static javax.swing.JLabel attach2;
    private javax.swing.JLabel attach3;
    private javax.swing.JLabel attach4;
    private javax.swing.JLabel datelabel;
    private javax.swing.JButton decrypt;
    private javax.swing.JButton encrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField keyspace;
    private javax.swing.JButton send;
    public static javax.swing.JTextField textTo;
    private javax.swing.JTextArea txtCompose;
    private javax.swing.JTextField txtSub;
    // End of variables declaration//GEN-END:variables
}
