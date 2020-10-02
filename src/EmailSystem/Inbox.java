
package EmailSystem;

import static Classes.Login.usert;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JoyGich
 */
public class Inbox extends javax.swing.JPanel {
private Main mainClass;
public static String fromdemo,datedemo, subdemo,msgdemo;
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst   = null; 



    public Inbox() {
        initComponents();
       updateTable();

        //openMail();
    }
    
    private void updateTable(){
         String attachto =Main.sender.getText();
        try{
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
            String sql1 = "select sender,subject,message,date from emails where receiver =?";// "+attachto+"";
            pst = conn.prepareStatement(sql1);
            pst.setString(1, attachto);
            rs = pst.executeQuery();
           
            MailTable.setModel(DbUtils.resultSetToTableModel(rs)); 
            if(rs.next()){
                
               MailTable.setModel(DbUtils.resultSetToTableModel(rs));  
            }
 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MailTable = new javax.swing.JTable();
        refresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 102));

        jPanel1.setPreferredSize(new java.awt.Dimension(607, 421));

        MailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MailTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MailTable);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(refresh)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailTableMouseClicked

        int demo = MailTable.getSelectedRow();
          fromdemo = MailTable.getValueAt(demo, 0).toString();
             datedemo = MailTable.getValueAt(demo, 1).toString();
               subdemo = MailTable.getValueAt(demo, 2).toString();
               msgdemo = MailTable.getValueAt(demo, 3).toString();
        new EnterKeyDialog();
       
       //OpenAttachments.OpenMail();

    }//GEN-LAST:event_MailTableMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable MailTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
