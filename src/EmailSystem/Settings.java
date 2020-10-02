
package EmailSystem;

import static EmailSystem.CreateAccount.tfname;
import static EmailSystem.CreateAccount.tlname;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author JoyGich
 */
public class Settings extends javax.swing.JPanel {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst   = null; 
String passold = "";
    public Settings() {
        //getOldPassword();
        initComponents();
        
        
        
        changepass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 String email =Main.sender.getText();
                 System.out.println("GGGGGG");
        //System.out.print(email);
        String pass0 = oldpass.getText();
        String pass00  = PanelLogin.oldpassword;
                
        String pass1 = newpass1.getText();
        String pass2 = newpass2.getText();
        if(pass0.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter Old Password","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        else if(!pass0.equals(pass00)){
            JOptionPane.showMessageDialog(null, "Old Password is wrong","ERROR",JOptionPane.ERROR_MESSAGE);
        }
       else if(pass1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter New Password","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
       if(pass2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Passwords do not match","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
         
        else if(newpass1.getText().equals(newpass2.getText())){
            try{
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
                String sql1 = "update account set pass1 = ? where email = ? ";
                pst = conn.prepareStatement(sql1);
                pst.setString(1,pass1 );
                pst.setString(2,email );
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password changed to" +" "+pass1);
                
            }catch(Exception ex){
                
            }
            
        }
                else{
            JOptionPane.showMessageDialog(null, "Passwords dont match","ERROR",JOptionPane.ERROR_MESSAGE);
        }
            }
            
        });    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        oldpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        newpass1 = new javax.swing.JPasswordField();
        newpass2 = new javax.swing.JPasswordField();
        changepass = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        oldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpassActionPerformed(evt);
            }
        });

        jLabel2.setText("Old Password");

        jLabel3.setText("New Password");

        jLabel4.setText("Confirm");

        newpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpass1ActionPerformed(evt);
            }
        });

        changepass.setBackground(new java.awt.Color(51, 51, 255));
        changepass.setText("ChangePassword");
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
        });
        changepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(changepass, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(oldpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newpass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(changepass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 14)); // NOI18N
        jLabel1.setText("Change Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
       
//    public String getOldPassword(){
//        
//        String email =Main.sender.getText();
//        try{
//            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
//                        Statement st = conn.createStatement();
//                        String sql="select pass from account where sender = "+email+"";
//                        PreparedStatement ps = conn.prepareStatement(sql);
//                        rs = ps.executeQuery(); 
//                       if(rs.next()){
//                           passold = rs.getString("pass");
//                           System.out.println(passold);
//                       }
//
//        }catch(Exception ex){
//            
//        }
//        return passold;
//    }
    private void oldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpassActionPerformed
        
        
        if(!oldpass.getText().equals("")||oldpass.getText().equals(passold) ){
        newpass1.requestFocusInWindow();
        }else{
            oldpass.requestFocusInWindow();
            JOptionPane.showMessageDialog(null, "Old password is wrong");
        }
    }//GEN-LAST:event_oldpassActionPerformed

    private void newpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpass1ActionPerformed
        // TODO add your handling code here:
        
        if(!newpass1.getText().equals("")){
        newpass2.requestFocusInWindow();
        }else{
            newpass1.requestFocusInWindow();
        }
    }//GEN-LAST:event_newpass1ActionPerformed

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
       
    }//GEN-LAST:event_changepassMouseClicked

    private void changepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepassActionPerformed

    }//GEN-LAST:event_changepassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField newpass1;
    private javax.swing.JPasswordField newpass2;
    private javax.swing.JPasswordField oldpass;
    // End of variables declaration//GEN-END:variables
}
