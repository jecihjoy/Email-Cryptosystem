/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSystem;

import static EmailSystem.Inbox.datedemo;
import static EmailSystem.Inbox.fromdemo;
import static EmailSystem.Inbox.msgdemo;
import static EmailSystem.Inbox.subdemo;

/**
 *
 * @author jecihjoy
 */
public class tests {
  //System.out.println(attach1.getText());
                
//                 char newFp[];
//                 int len=pdfpath.length();
//                 char fp[]=new char[len];
//                 
//                
//                for(int k=0;k<pdfpath.length();k++){
//                   // System.out.print(pdfpath.indexOf('\\'));
//                    fp[k]=pdfpath.charAt(k);
//                    System.out.print(fp[k]);            
//                }
//                
//                int count=0;
//                for(int kk=0;kk<pdfpath.length();kk++){
//                   // System.out.print(pdfpath.indexOf('\\'));
//                    if(fp[kk]=='\\')
//                        count++;//System.out.print(fp[k]);
//                }
//                
//                                
//                int newLen =pdfpath.length()+count;
//                newFp  =new char[newLen];
//                
//                int w=0;
//                for(int kkk=0;kkk<pdfpath.length();kkk++){
//                   // System.out.print(pdfpath.indexOf('\\'));
//                   newfp[w]=fp[kkk];
//                   if(fp[kkk]=='\\'){
//                        w++;//System.out.print(fp[k]);
//                        newfp[w]='\\';
//                   }
//                   w++;
//                }
                
               // System.out.println("Count is "+count);
//               
//                //pdfpath = new String (newFp);   
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    // String sql2 = "INSERT INTO inboxattachments VALUES('"+to+"','"+pdfpath+"')";//,('"+to+"','"+imagepath+"')";
////                         String sql2 = "INSERT INTO inboxattachments (attachments )VALUES(?)";//,('"+to+"','"+imagepath+"')";
////                        PreparedStatement ps = conn.prepareStatement(sql2);
////                         
////
////                         //ps.setString(1,to);
////                         ps.setString(1,pdfpath);
////                        ps.execute();
//     //st.execute(sql2);
//                        //PreparedStatement ps = conn.prepareStatement(sql);
//                        //ResultSet rs = ps.executeQuery(); 
//                        //                       textTo.setText(null);
////                       txtSub.setText(null);
////                       txtCompose.setText(null);
//    
//    
//     // String extension=FilenameUtils.getExtension(filepath);
//            
////            int x=filepath.length();
////             //System.out.println(x);
////             int ind=0;
////             for(int k=x-1;k>0;k--){
////                 char ch=filepath.charAt(k);
////                 //System.out.println(ch); 
////                 if(ch!='.'){
////                     ext[ind]=ch;
////                     ind++;
////                     System.out.println(ch);
////                 }
////                 else
////                     break;
////             }
////             
////            // System.out.println(filepath);
////             //String cAt1=ext[0].toString();
////             for(int t=3;t>=1;t--){
////                 //System.out.print(ext[t]);
////                 Character extension = ext[t];
////             demo = extension.toString();
////                 System.out.println(demo);
////             }
////            
////             Path path=Paths.get(filepath);
////             Path moveTo=Paths.get("C:\\Users\\JoyGich\\Documents\\NetBeansProjects\\project\\Attachment\\"+fileName+"."+demo);
////                try {
////                    Files.move(path,moveTo,REPLACE_EXISTING);
////                } catch (IOException ex) {
////                    Logger.getLogger(ComposeMail.class.getName()).log(Level.SEVERE, null, ex);
////                }
//
//             if(attach1Status==0){
//             attach1.setText(filepath);
//             attach1Status=1;
//             filepath=null;
//             }
//            
//             else if(attach1Status==1){
//             attach2.setText(filepath);
//             attach2Status=1;
//             filepath=null;
//             }
//            
//             else if(attach4Status==0) {
//                 System.out.println("holy cow");
//             attach3.setText(filepath);
//             attach3Status=1;
//             filepath=null;
//             }
//             else if (attach3Status==1){
//             attach4.setText(filepath);
//             attach4Status=1;
//             }
//             if(filepath.contains("pdf")){
//                 attach1.setText(filepath);
//             }else if(filepath.contains("png")||(filepath.contains("jpg"))){
//                 
//                 attach2.setText(filepath);
//                     
//                     }
             
      
           //prints items in a JTable row
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
//                     fromdemo = rs.getString("sender");
//                     System.out.println(fromdemo);
//                      datedemo = rs.getString("date");
//                     System.out.println(datedemo);
//                      subdemo = rs.getString("subject"); 
//                     System.out.println(subdemo);
//                     msgdemo = rs.getString("message");
//                     System.out.println(msgdemo);
//                     
//                                      }
//              }  catch(Exception ex){
//                  JOptionPane.showMessageDialog(null,"error"+ex);
//              }
//                
//            }
//            
//        });
    
//     private void MailTableMouseClicked(java.awt.event.MouseEvent evt) {                                       
//        //JOptionPane.showMessageDialog(MailTable,new DecryptionPanel() ,"Decryption Key", JOptionPane.INFORMATION_MESSAGE);
//        int demo = MailTable.getSelectedRow();
//    //    fromdemo = MailTable.getValueAt(demo, 0);
//        //System.out.println(MailTable.getValueAt(demo, 0));
//        //fromdemo = new String(toString(MailTable.getValueAt(demo, 0)));
//        fromdemo = MailTable.getValueAt(demo, 0).toString();
//        //System.out.println(MailTable.getValueAt(demo, 1));
//        datedemo = MailTable.getValueAt(demo, 1).toString();
//        //System.out.println(MailTable.getValueAt(demo, 2));
//        subdemo = MailTable.getValueAt(demo, 2).toString();
//        //System.out.println(MailTable.getValueAt(demo, 3));
//        msgdemo = MailTable.getValueAt(demo, 3).toString();
//        new EnterKeyDialog();
//       // new DecryptionPanel();
//       
//       //print the files paths
//       OpenAttachments.OpenMail();
//
//    }                                      

}
