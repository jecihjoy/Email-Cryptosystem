package EmailSystem;

import Classes.OpenMail;
import static EmailSystem.PanelLogin.txtuser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author JoyGich
 */
public class Main extends javax.swing.JFrame {

    ImageIcon emailIcon = new ImageIcon(getClass().getResource("emailpic.png"));
    public Inbox myinbox;
//new Inbox();
    
   //public static String logger=txtuser.getText();

    public Main() {
        setLocation(150,50);
        initComponents();
        //curdate();
        ImageIcon img = new ImageIcon("iconmail.png");
        sender.setVisible(false);
        welcome.setVisible(false);
        setIconImage(img.getImage());
        icon.setIcon(emailIcon);
        icon.setSize(750, 500);
        
        //add login panell
        right.setVisible(false);
        body.removeAll();
        body.setLocation(0,0);
        body.setLayout(new BorderLayout());
        body.add(new PanelLogin(),BorderLayout.CENTER); 
        body.repaint();
        

        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                body.removeAll();
                body.repaint();
                icon.setIcon(emailIcon);
                icon.setSize(750, 500);
                body.add(icon);
            }
        }
        );

        compose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                body.removeAll();
                //body.repaint();
               // body.revalidate();
               body.setLayout(new BorderLayout());
                body.add(new ComposeMail(),BorderLayout.CENTER);
                body.repaint();
                body.revalidate();

            }
        }
        );
        
        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                myinbox=new Inbox();
                body.removeAll();
               // body.repaint();
               // body.revalidate();
                body.setLayout(new BorderLayout());
                body.add(myinbox,BorderLayout.CENTER);
                body.repaint();
                body.revalidate();

            }
        }
        );
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                myinbox=new Inbox();
                body.removeAll();
               // body.repaint();
               // body.revalidate();
                body.setLayout(new BorderLayout());
                body.add(new Settings(),BorderLayout.CENTER);
                body.repaint();
                body.revalidate();

            }
        }
        );
        outbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                body.removeAll();
               // body.repaint();
               // body.revalidate();
                body.setLayout(new BorderLayout());
                body.add(new Outbox(),BorderLayout.CENTER);
                body.repaint();
                body.revalidate();

            }
        }
        );
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                body.removeAll();
               // body.repaint();
               // body.revalidate();
                body.setLayout(new BorderLayout());
                body.add(new Help(),BorderLayout.CENTER);
                body.repaint();
                body.revalidate();

            }
        }
        );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        inbox = new javax.swing.JButton();
        compose = new javax.swing.JButton();
        outbox = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        help = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        north = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sender = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        right.setBackground(new java.awt.Color(0, 255, 204));
        right.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(51, 51, 255)));

        home.setForeground(new java.awt.Color(0, 51, 255));
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        inbox.setForeground(new java.awt.Color(0, 0, 255));
        inbox.setText("Inbox");

        compose.setForeground(new java.awt.Color(51, 0, 255));
        compose.setText("Compose");
        compose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composeActionPerformed(evt);
            }
        });

        outbox.setForeground(new java.awt.Color(0, 0, 255));
        outbox.setText("Outbox");
        outbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outboxActionPerformed(evt);
            }
        });

        settings.setForeground(new java.awt.Color(51, 51, 255));
        settings.setText("Settings");

        help.setForeground(new java.awt.Color(51, 51, 255));
        help.setText("Help");

        logout.setBackground(new java.awt.Color(204, 204, 255));
        logout.setForeground(new java.awt.Color(153, 0, 153));
        logout.setText("Log out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inbox, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(compose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outbox, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(compose, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inbox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outbox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body.setBackground(new java.awt.Color(204, 204, 204));
        body.setPreferredSize(new java.awt.Dimension(633, 430));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon)
                .addContainerGap(471, Short.MAX_VALUE))
        );

        north.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("       Email Cryptosystem");

        sender.setFont(new java.awt.Font("Yu Gothic", 3, 14)); // NOI18N
        sender.setForeground(new java.awt.Color(0, 0, 204));

        welcome.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(102, 102, 102));
        welcome.setText("Welcome");

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sender, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        northLayout.setVerticalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(sender)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
            .addComponent(north, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(north, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void composeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composeActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
          home.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    home.setBackground(Color.decode("#00ff00"));

                } else {
                    home.setBackground(null);
                }
            }

        }
        );
    }//GEN-LAST:event_homeActionPerformed

    private void outboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outboxActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        ImageIcon img = new ImageIcon("iconmail.png");
        sender.setVisible(false);
        welcome.setVisible(false);
        setIconImage(img.getImage());
        icon.setIcon(emailIcon);
        icon.setSize(750, 500);
        
        //add login panell
        right.setVisible(false);
        body.removeAll();
        body.setLayout(new BorderLayout());
        body.add(new PanelLogin(),BorderLayout.CENTER); 
        body.repaint();
    }//GEN-LAST:event_logoutActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {Feel(info.getClassName());
//                    break;
//                }
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//                    javax.swing.UIManager.setLookAnd

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel body;
    private javax.swing.JButton compose;
    private javax.swing.JButton help;
    private javax.swing.JButton home;
    public static javax.swing.JLabel icon;
    private javax.swing.JButton inbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton logout;
    private javax.swing.JPanel north;
    private javax.swing.JButton outbox;
    public static javax.swing.JPanel right;
    public static javax.swing.JLabel sender;
    private javax.swing.JButton settings;
    public static javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
