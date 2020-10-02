
package EmailSystem;

import static Classes.Login.usert;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author JoyGich
 */
public class PanelLogin extends javax.swing.JPanel {
public static String oldpassword;

    public PanelLogin() {
        initComponents();
        //Map attributes = font.
        creataccount = new JLabel("<HTML><U>CLICK HERE </U></HTML>");
        creataccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }
    
    

   public void Validate(){               
            String userdb,passdb;
            userdb=txtuser.getText();
            passdb=txtpass.getText();
            if(userdb.isEmpty() || passdb.isEmpty())
            {
             JOptionPane.showMessageDialog(null, "All login details are required","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
             try{
             //1. create a connection
             Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
             
             //2. create a statement
             Statement mySt = myCon.createStatement();
             String selectInfo="select email, pass  from account where email=? AND pass= ?";
             PreparedStatement pst= myCon.prepareStatement(selectInfo);  
             pst.setString(1, userdb);
             pst.setString(2, passdb);

             ResultSet myRs = pst.executeQuery();
             
             if(!myRs.next()){
                 System.out.println("No record found matching your credentials!");
                 JOptionPane.showMessageDialog(null, "INCORECT SIGN IN DETAILS","REJECTED LOGIN",JOptionPane.ERROR_MESSAGE);
             }
             
            else{
                 oldpassword = passdb;
                //while(myRs.next()){

//                 String dbuser = myRs.getString("email");
//                 String dbpass = myRs.getString("pass");
//
//
//                 if(dbuser.equals(userdb) || dbpass.equals(passdb)){ 
                        Main.right.setVisible(true);
                        Main.sender.setVisible(true);
                        Main.welcome.setVisible(true);
                        Main.body.removeAll();
                        Main.body.add(Main.icon,BorderLayout.CENTER);
                        Main.body.repaint();
                        Main.body.updateUI();
                        Main.sender.setText(txtuser.getText());

                 }
             }
             catch (Exception exc){
                 JOptionPane.showMessageDialog(null, "Database Error  " +exc.getMessage());
                // JOptionPane.showMessageDialog(null, "INCORECT SIGN IN DETAILS","REJECTED LOGIN",JOptionPane.ERROR_MESSAGE);
                }
             }  }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        creataccount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 153, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Email");

        jLabel3.setText("Password :");

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });

        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        creataccount.setForeground(new java.awt.Color(255, 0, 0));
        creataccount.setText("Clich here");
        creataccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creataccountMouseClicked(evt);
            }
        });

        jLabel4.setText("to create an account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(creataccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creataccount)
                    .addComponent(jLabel4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
      Validate();
      //remove
       Main.right.setVisible(true);
       Main.sender.setVisible(true);
       Main.welcome.setVisible(true);
                Main.body.removeAll();
                Main.body.add(Main.icon,BorderLayout.CENTER);
                Main.body.repaint();
                Main.body.updateUI();
                Main.sender.setText(txtuser.getText());
    }//GEN-LAST:event_loginActionPerformed
   
    private void creataccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creataccountMouseClicked
        Main.body.removeAll();
        Main.body.add(new CreateAccount(),BorderLayout.CENTER);
        Main.body.repaint();
        Main.body.updateUI();
    }//GEN-LAST:event_creataccountMouseClicked

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
                                     
        if(!txtuser.getText().equals("")){
        txtpass.requestFocusInWindow();
        //txtCompose.setText(null);
        }else{
            txtuser.requestFocusInWindow();
        }    }//GEN-LAST:event_txtuserActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        if(! txtpass.getText().equals("")){
        Validate();
        //txtCompose.setText(null);
        }else{
            txtpass.requestFocusInWindow();
            } 
    }//GEN-LAST:event_txtpassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creataccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JButton login;
    public static javax.swing.JPasswordField txtpass;
    public static javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
