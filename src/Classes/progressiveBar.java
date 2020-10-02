
package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import net.proteanit.sql.DbUtils;
//rs2xml

/**
 *
 * @author JoyGich
 */
public class progressiveBar extends JFrame{
    private JLabel title, fname,lname, admno,gender,dob,yos,term,date,tel,hide;
    private JTextField ttitle, tfname,tlname,tadm,tgen,tdob,tdate,ttel,tterm,tyos;
    private JPanel main,top,left, right;
    private JProgressBar bar;
    private JTextField text;
    private JButton button;
    private JTable table;
    private String[] columns;
    private Object[][] data;
    private JScrollPane tablescroll;
    private JComboBox box;
    
    
    public progressiveBar(){
         columns = new String[]{"fname","lname","adm","gender","dob","year","term","date","tel" };
         data = new Object[][]{
             {"jecih","joy",2524,"femae","1996/01/01",3,3,"2017/02/27",86 },
             {"jecih","joy",2524,"femae","1996/01/01",3,3,"2017/02/27",86 },
             {"jecih","joy",2524,"femae","1996/01/01",3,3,"2017/02/27",86 },
              {"jecih","joy",2524,"femae","1996/01/01",3,3,"2017/02/27",86 }
         };
         top = new JPanel(new FlowLayout());
        main = new JPanel(new BorderLayout());
        left = new JPanel(new GridLayout(11,2));
        left.setBackground(Color.BLUE);
        right = new JPanel();
        bar = new JProgressBar();
        text = new JTextField(30);
        button = new JButton("Progess Ok");
        table = new JTable();
        //table.setSize(300,150);
        tablescroll = new JScrollPane(table);
        box = new JComboBox();//new Object[]{"joy","jecih","demo"});
        box.setSize(10,10);
        fname = new JLabel("First Name");
        lname = new JLabel("Last Name");
        admno = new JLabel("Admission Number");
        gender = new JLabel("Gender");
        yos = new JLabel("Form:");
        dob = new JLabel("Date of Birth");
        term = new JLabel("Term");
        date = new JLabel("Date");
        tel = new JLabel("Tel");
        hide = new JLabel("Tel");
        hide.setVisible(false);
        
        tfname = new JTextField(15);
        tlname = new JTextField(15);
        tadm = new JTextField(15);
        tgen = new JTextField(15);
        tdob = new JTextField(15);
        tterm = new JTextField(15);
        tyos = new JTextField(15);
        ttel = new JTextField(15);
        tdate = new JTextField(15);
         
        button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            int value = Integer.parseInt(text.getText());
            bar.setValue(value);
        }    
        
        });
        //insert data to the textfields when a table row is clicked
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ev){
              try{
                  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/examsystem","root","");
                  int row = table.getSelectedRow();
                  String tableclick = (table.getModel().getValueAt(row,0).toString());
                  String sql = "select * from studetails where admno = '"+tableclick+"' ";
                  //Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/examsystem","root","");
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery(); 
                 if(rs.next()){
                     String add1 = rs.getString("fname");
                     fname.setText(add1);
                     String add2 = rs.getString("lname");
                     lname.setText(add2);
                     String add3 = rs.getString("admno");
                     tadm.setText(add3);
                     String add4 = rs.getString("gender");
                     tgen.setText(add4);
                     String add5 = rs.getString("dob");
                     tdob.setText(add5);
                     String add6 = rs.getString("yos");
                     tyos.setText(add6);
                     String add7 = rs.getString("term");
                     tterm.setText(add7);
                     String add8 = rs.getString("date");
                     tdate.setText(add8);
                     String add9 = rs.getString("tel");
                     ttel.setText(add9);
                                      }
              }  catch(Exception ex){
                  JOptionPane.showMessageDialog(null,"error"+ex);
              }
                
            }
            
        });
        
       
        

           
            
            //MailTable.setModel(DbUtils.resultSetToTableModel(rs));
           
//            if(rs.next()){
//                
//                String Send = rs.getString("sender");
//                String sub = rs.getString("subject");
//                String msg = rs.getString("message");
//                String date = rs.getString("date");
//                Object []data={Send,sub,msg,date};
//                
////                DefaultTableModel model=new DefaultTableModel();
////                String []col={"Sender","Subject","Message","Date"};
////                model.addColumn(col);
////                model.addRow(data);
////                MailTable.setModel(model);
               
//            }




//       //prints items in a JTable row
//        MailTable.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent ev){
//              try{
//                  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
//                  int row = MailTable.getSelectedRow();
//                  String tableclick = (MailTable.getModel().getValueAt(row,0).toString());
//                  String sql = "select sender,subject,date,message from emails where sender = '"+tableclick+"' ";
//                  PreparedStatement ps = conn.prepareStatement(sql);
//                  ResultSet rs = ps.executeQuery(); 
//                 if(rs.next()){
////                     String fromdemo = rs.getString("sender");
////                     System.out.println(fromdemo);
////                     String datedemo = rs.getString("date");
////                     System.out.println(datedemo);
////                     String subdemo = rs.getString("subject");
////                     //String Dsub = 
////                     System.out.println(subdemo);
////                     String messagedemo = rs.getString("message");
////                     System.out.println(messagedemo);
//                     
//                                      }
//              }  catch(Exception ex){
//                  JOptionPane.showMessageDialog(null,"error"+ex);
//              }
//                
//            }
//            
//        });
        



//sets textfields values on selecting an item from the combobox
        box.addPopupMenuListener(new PopupMenuListener(){
            PreparedStatement ps;
            ResultSet rs; 
             @Override
             public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }

             @Override
             public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                 String temp = (String)box.getSelectedItem();
                 String sql = "select * from studetails where admno = ?";
                 try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/examsystem","root","");
                 ps = conn.prepareStatement(sql);
                 ps.setString(1, temp);
                 rs = ps.executeQuery();
                 if(rs.next()){
                     String add1 = rs.getString("fname");
                     fname.setText(add1);
                     String add2 = rs.getString("lname");
                     lname.setText(add2);
                     String add3 = rs.getString("admno");
                     tadm.setText(add3);
                     String add4 = rs.getString("gender");
                     tgen.setText(add4);
                     String add5 = rs.getString("dob");
                     tdob.setText(add5);
                     String add6 = rs.getString("yos");
                     tyos.setText(add6);
                     String add7 = rs.getString("term");
                     tterm.setText(add7);
                     String add8 = rs.getString("date");
                     tdate.setText(add8);
                     String add9 = rs.getString("tel");
                     ttel.setText(add9);
                                      
                 }
                 }catch(Exception ex){
                     JOptionPane.showMessageDialog(null,"error"+ex);
                     
                 }
//                finally{
//		try{
//		rs.close();
//		ps.close();
//		}catch(Exception e){
//                    
//		}
//	}
             }

             @Override
             public void popupMenuCanceled(PopupMenuEvent e) {

             }
            
        }
        );
        
        bar.setStringPainted(true);
        bar.setMaximum(100);
        bar.setMinimum(0);
        //bar.setBorderPainted(Color.BLUE);
        
        left.add(hide);
        left.add(box);
      left.add(fname);left.add(tfname);left.add(lname);left.add(tlname);left.add(admno);
      left.add(tyos);left.add(term);left.add(tterm);left.add(date);left.add(tdate);left.add(tel);left.add(ttel);
        top.add(text);
        top.add(button);
        top.add(bar);
        right.add(tablescroll);
        main.add(top, BorderLayout.NORTH);
        main.add(left, BorderLayout.WEST);
        main.add(right);
        add(main);
    }
    //connects combobox and the database row
    private void comboDb(){
        PreparedStatement ps = null; 
        ResultSet rs = null;
        String sql = "select * from studetails";  

        try{
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/examsystem","root","");
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery(); 
                while(rs.next()){
                        String name = rs.getString("fname");
                        box.addItem(name);
        }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "An Error has occurred"+e.getMessage());
        }finally{
		try{
		rs.close();
		ps.close();
		}catch(Exception e){
		}
	}

        }
    
    
    //populates a jtable at runtime
    private void UpdateTable(){
      // private JTable table;
       ResultSet rs = null;
       PreparedStatement ps = null;
	String sql = "select * from studetails";

        try{
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/examsystem","root","");
	ps = conn.prepareStatement(sql);
	rs = ps.executeQuery();
	table.setModel(DbUtils.resultSetToTableModel(rs)); 

	}catch(Exception e){
	JOptionPane.showMessageDialog(null, "An Error has occurred"+e.getMessage());
	}
        finally{
		try{
		rs.close();
		ps.close();
		}catch(Exception e){
		}
	}

	}
    public static void main(String args[]){
        progressiveBar gui = new progressiveBar();
        gui.setTitle("Gui Components");
        gui.UpdateTable();
        gui.setVisible(true);
        gui.pack();
        gui.setLocation(0,0);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(800,500);
        gui.setResizable(false);
        gui.comboDb();
    }
}
