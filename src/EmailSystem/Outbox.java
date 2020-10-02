
package EmailSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JoyGich
 */
public class Outbox extends javax.swing.JPanel {

    /**
     * Creates new form Outbox
     */
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst   = null; 

    public Outbox() {
        initComponents();
        updateTable();
    }
    private void updateTable(){
         String attachto =Main.sender.getText();
        try{
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
            String sql1 = "select receiver,subject,message,date from emails where sender =?";// "+attachto+"";
            pst = conn.prepareStatement(sql1);
            pst.setString(1, attachto);
            rs = pst.executeQuery();
           
            OutboxTable.setModel(DbUtils.resultSetToTableModel(rs)); 
            if(rs.next()){
                
               OutboxTable.setModel(DbUtils.resultSetToTableModel(rs));  
            }
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        OutboxTable = new javax.swing.JTable();

        jScrollPane1.setViewportView(OutboxTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OutboxTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
