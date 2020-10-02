
package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JoyGich
 */
public class MainClass2 extends JFrame {
     
    private JPanel main, north, right,left;
    private JButton send, open;
    private JLabel title;
    
    public MainClass2(){
        main = new JPanel( new BorderLayout()); 
        main.setBackground(Color.decode("#B0C4DE"));
        add(main);
        
        north = new JPanel();
        main.add(north, BorderLayout.NORTH);
        Font font = null;
        font = new Font("Serif", font.ITALIC, 20);
        title  = new JLabel("Secure Email Transfer System");
        //title.setBounds(50,10,300,20);
        title.setFont(font);
        title.setForeground(Color.BLUE);
        north.add(title);
        
        left = new JPanel(new GridLayout(2,1,50,20));
        left.setSize(300,150);
        //left.setLayout(null);
        left.setBackground(Color.decode("#B0C4DE"));
        //left.setBounds(0,0,200,100);
        send = new JButton("Send Mail");
        send.setSize(50,30);
        send.setForeground(Color.YELLOW);
        //send.setBounds(20,100,100, 30);
        left.add(send);
        
        open = new JButton("Open Email");
        left.add(open);
        
        main.add(left, BorderLayout.WEST);
        
        
         
        /*
        //main.setLayout(null);
        //main.setBounds(0,0,600,500);
        font = new Font("Serif", font.ITALIC, 20);
        title  = new JLabel("Secure Email Transfer System");
        title.setBounds(50,10,300,20);
        title.setFont(font);
        title.setForeground(Color.BLUE);
        main.add(title);
        //title.setBackground(Color.red);
        
        send = new JButton("Send Mail");
        send.setForeground(Color.YELLOW);
        send.setBounds(20,100,100, 30);
        main.add(send);
        open = new JButton("Open Mail");*/
    }
  public static void main(String[] args) {
        MainClass2 gui=new MainClass2();
        gui.setSize(600, 500);
        gui.setResizable(false);
        gui.setLocation(150,100);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
      
}
