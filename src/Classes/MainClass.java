package Classes;

import Classes.OpenMail;
import Encryption.EncryptionFinal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author JoyGich
 */
public class MainClass extends JFrame {

    private JPanel main, north, right, left;
    private JButton home, send, open;
    private JLabel title, icon;
    //private BorderFactory border;

    public MainClass() {
        main = new JPanel();
        main.setBackground(Color.decode("#B0C4DE"));
        main.setLayout(null);
        main.setBounds(0, 0, getWidth(), 500);

        north = new JPanel();
        north.setBackground(Color.decode("#9400D3"));
        north.setLayout(null);
        north.setBounds(10, 3, 720, 67);
        //north.setBackground(Color.CYAN);

        main.add(north);
        title = new JLabel("Secure Email Transfer System");
        Font font = null;
        font = new Font("Serif", font.ITALIC, 24);
        Font font1 = null;
        font1 = new Font("Serif", font.ITALIC, 18);
        Font font2 = null;
        font2 = new Font("Serif", font.ITALIC, 14);
        title.setBounds(200, 10, 300, 30);
        title.setFont(font);
        title.setForeground(Color.RED);
        north.add(title);

        JPanel newpanel = new JPanel();
        newpanel.setLayout(null);
        newpanel.setBackground(Color.decode("#00FA9A"));
        //border = BorderFactory.createLineBorder(Color.GREEN,2,true);
        newpanel.setBorder(BorderFactory.createLineBorder(Color.decode("#9400D3"), 4, true));
        newpanel.setBounds(10, 60, 180, 550);

        main.add(newpanel);
        home = new JButton("Home");
        home.setForeground(Color.MAGENTA);
        home.setBounds(30, 20, 120, 40);
        home.setFont(font);
        newpanel.add(home);

        send = new JButton("Compose Mail");
        send.setForeground(Color.MAGENTA);
        send.setBounds(30, 90, 125, 40);
        send.setFont(font2);
        newpanel.add(send);

        open = new JButton("Open Mail");
        open.setForeground(Color.MAGENTA);
        open.setBounds(30, 160, 125, 40);
        open.setFont(font1);
        newpanel.add(open);

        ImageIcon email = new ImageIcon(getClass().getResource("emailpic.png"));
        icon = new JLabel();
        icon.setIcon(email);
        icon.setBounds(0, 0, 530, 530);
        right = new JPanel();
        //right.setBackground(Color.LIGHT_GRAY);
        //right.setBackground(Color.decode("#DDA0DD"));
        right.setLayout(null);
        right.setBounds(190, 70, 540, 540);
        right.add(icon);
        main.add(right);
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                right.removeAll();
                //right.repaint();
                // right.revalidate();
                right.add(new SendMail());
                right.repaint();
                right.revalidate();

            }
        }
        );

        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                right.removeAll();
                //right.repaint();
                // right.revalidate();
                right.add(new OpenMail());
                right.repaint();
                right.revalidate();

            }
        }
        );
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                right.removeAll();
                right.repaint();
                ImageIcon email = new ImageIcon(getClass().getResource("emailpic.png"));
                icon = new JLabel();
                icon.setIcon(email);
                icon.setBounds(0, 0, 530, 530);
                right.add(icon);
            }
        }
        );

        add(main);

    }

    public static String getLookAndFeelClassName(String nameSnippet) {
        LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
        for (LookAndFeelInfo info : plafs) {
            if (info.getName().contains(nameSnippet)) {
                return info.getClassName();
            }
        }
        return null;
    }

    public static void main(String[] args) {

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
        MainClass gui = new MainClass();
        gui.setSize(750, 650);
        // gui.getLookAndFeelClassName();
        gui.setResizable(false);
        gui.setLocation(80, 80);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

}
