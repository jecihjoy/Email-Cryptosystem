
package EmailSystem;

import static EmailSystem.Main.body;
import static EmailSystem.Main.icon;
import static EmailSystem.Main.right;
import static EmailSystem.Main.sender;
import static EmailSystem.Main.welcome;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author JoyGich
 */
public class CreateAccount extends javax.swing.JPanel {
    ImageIcon emailIcon = new ImageIcon(getClass().getResource("emailpic.png"));
    public Inbox myinbox;

    /**
     * Creates new form CreateAccount
     */
    
    public static String tableName="";
    public CreateAccount() {
        initComponents();
        
        ((AbstractDocument)tfname.getDocument()).setDocumentFilter(new Validate());
        ((AbstractDocument)tlname.getDocument()).setDocumentFilter(new Validate());
        ((AbstractDocument)tphone.getDocument()).setDocumentFilter(new ValidatePhone());
        ((AbstractDocument)tfname.getDocument()).setDocumentFilter(new Validate());
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        tlname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        tphone = new javax.swing.JTextField();
        tpass = new javax.swing.JPasswordField();
        tpass2 = new javax.swing.JPasswordField();
        back = new javax.swing.JButton();
        create = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Account");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("First Name");

        tfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameActionPerformed(evt);
            }
        });

        tlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlnameActionPerformed(evt);
            }
        });

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        tphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tphoneActionPerformed(evt);
            }
        });

        tpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpassActionPerformed(evt);
            }
        });

        tpass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpass2ActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        back.setForeground(new java.awt.Color(51, 255, 51));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        create.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        create.setForeground(new java.awt.Color(0, 255, 0));
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Confirm Password");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Telephone");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Last  Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfname, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(tlname)
                    .addComponent(tpass2)
                    .addComponent(tpass)
                    .addComponent(tphone)
                    .addComponent(txtemail))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(tphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(tpass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(back))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
        if(!tfname.getText().equals("")){
        tlname.requestFocusInWindow();
        }else{
            tfname.requestFocusInWindow();
        }
    }//GEN-LAST:event_tfnameActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
         Main.body.removeAll();
        Main.body.add(new PanelLogin(),BorderLayout.CENTER);
        Main.body.repaint();
        Main.body.updateUI();
        ImageIcon img = new ImageIcon("iconmail.png");
        sender.setVisible(false);
        welcome.setVisible(false);
       // setIconImage(img.getImage());
        icon.setIcon(emailIcon);
        icon.setSize(750, 500);
        
        //add login panell
        right.setVisible(false);
        body.removeAll();
        body.setLayout(new BorderLayout());
        body.add(new PanelLogin(),BorderLayout.CENTER); 
        body.repaint();
    }//GEN-LAST:event_backActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        
        
//         Main.body.removeAll();
//        Main.body.add(new PanelLogin(),BorderLayout.CENTER);
//        Main.body.repaint();
//        Main.body.updateUI();
//        ImageIcon img = new ImageIcon("iconmail.png");
//        sender.setVisible(false);
//        welcome.setVisible(false);
//       // setIconImage(img.getImage());
//        icon.setIcon(emailIcon);
//        icon.setSize(750, 500);
//        
insertReg();
       
        
       
    }//GEN-LAST:event_createActionPerformed

    
        public void insertReg(){
            tableName=txtemail.getText();
       // new CreateTable();
        
                String fname = tfname.getText();
                String lname = tlname.getText();
                String email = txtemail.getText();
                String tel = tphone.getText();
                String pass1 = tpass.getText();
                String pass2 = tpass2.getText();

                if (fname.equals("")&&lname.isEmpty()&& email.isEmpty()&& tel.isEmpty()&& pass1.isEmpty()&pass2.isEmpty()) {
                    
                    JOptionPane.showMessageDialog(null, "ERROR: ALL FIELD ARE REQUIRED", "ERROR", JOptionPane.ERROR_MESSAGE);
                    
                             
                } else {
                        if(!pass1.equals(pass2)){
                         JOptionPane.showMessageDialog(null,"Passwords do not match!!!");
                     }
                        else{
                            
                              
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem", "root", "");
                        Statement st = conn.createStatement();
                        String sql = "INSERT INTO account VALUES('" + fname + "','" + lname + "','" + email + "','" + tel + "',"
                                + "'" + pass1 + "')";
                        st.execute(sql);
                        //PreparedStatement ps = conn.prepareStatement(sql);
                        //ResultSet rs = ps.executeQuery(); 

                        JOptionPane.showMessageDialog(null, "Insert was successful", "Create Account", JOptionPane.INFORMATION_MESSAGE);
                   
                    
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "SERVER SAYS :" + e.getMessage(), "SERVR ERROR", JOptionPane.OK_OPTION);
                    }
                
                        }
            
                }
            
            
            
            
        }
    
    
    
    
    private void tlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlnameActionPerformed
       if(!tlname.getText().equals("")){
        txtemail.requestFocusInWindow();
        }else{
            tlname.requestFocusInWindow();
        }
    }//GEN-LAST:event_tlnameActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        if(!txtemail.getText().equals("")&&Pattern.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", txtemail.getText())){
                                
                                 tphone.requestFocusInWindow();
        }else{
            txtemail.requestFocusInWindow(); 
            JOptionPane.showMessageDialog(null,"Email format is wrong!!!");
}
    }//GEN-LAST:event_txtemailActionPerformed

    private void tphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tphoneActionPerformed
       if(!tphone.getText().equals("")){
        tpass.requestFocusInWindow();
        }else{
            tphone.requestFocusInWindow();
        }
    }//GEN-LAST:event_tphoneActionPerformed

    private void tpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpassActionPerformed
        if(!tpass.getText().equals("")){
        tpass2.requestFocusInWindow();
        }else{
            tpass.requestFocusInWindow();
        }
    }//GEN-LAST:event_tpassActionPerformed

    private void tpass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpass2ActionPerformed
        if(!tpass2.getText().equals("")){
        insertReg();
        }else{
            tpass2.requestFocusInWindow();
        }
        
    }//GEN-LAST:event_tpass2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField tfname;
    public static javax.swing.JTextField tlname;
    public static javax.swing.JPasswordField tpass;
    public static javax.swing.JPasswordField tpass2;
    public static javax.swing.JTextField tphone;
    public static javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
}
