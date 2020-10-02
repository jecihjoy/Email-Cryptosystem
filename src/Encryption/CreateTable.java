
//
//package EmailSystem;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author JoyGich
// */
//public class CreateTable {
//    
//  Connection con;
//  Statement st;
//  
//  String tab=CreateAccount.tableName.replace(".", "");
//  String tableFinalString=tab.replace("@", "");
//  String tableout=tableFinalString.concat("outbox");
//  String tablein=tableFinalString.concat("Inbox");
//  String attachin=tableFinalString.concat("inboxAttachments");
//  String attachout=tableFinalString.concat("ouboxattachment");
//   
//    public CreateTable()  {
//        getconn();
//        createTableOutbox();
//        createTableInbox();
//        AttachmentOutbox();
//        AttachmentInbox();
//        
//        
//       
//    }
//    public Connection getconn() {
//        try{
//       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsystem","root","");
//       
//        }catch(SQLException ex){
//            System.out.println(ex);
//        }
//        return con;
//    }
////    public static void main(String[] jecy){
////    new CreateTable();    
////    }
//    private void createTableOutbox() {
//        System.out.println(tableout);
//        String myTableName = "create table"+" "+tableout+" "+"(" 
//            + "mailID INT(20) NOT NULL  AUTO_INCREMENT," 
//            + "sender VARCHAR(30) NOT NULL unique,"  
//            + "subject VARCHAR(40) NOT NULL," 
//            + "message VARCHAR(200),"  
//            + "date varchar(30),"  
//            + "primary key(mailID))";
//        try {
//           
//            st = con.createStatement();
//            //The next line has the issue
//            st.executeUpdate(myTableName);
//            System.out.println("Table Created");
//        }
//        catch (SQLException e ) {
//            System.out.println("An error has occurred on Table   "+tableout+" Creation"+e.getMessage());
//        }
//        
//    }
//    private void createTableInbox() {
//        //String tableN=tableFinalString.concat("Inbox");
//        System.out.println(tablein);
//        String myTableName = "create table"+" "+tablein+" "+"(" 
//            + "mailID INT(20) NOT NULL  AUTO_INCREMENT," 
//            + "sender VARCHAR(30) NOT NULL unique,"  
//            + "subject VARCHAR(40) NOT NULL," 
//            + "message VARCHAR(200),"  
//            + "date DATE,"  
//            + "primary key(mailID))";  
//        try {
//           
//            st = con.createStatement();
//            //The next line has the issue
//            st.executeUpdate(myTableName);
//            System.out.println("Table Created");
//        }
//        catch (SQLException e ) {
//            System.out.println("An error has occurred on Table   "+tablein+" Creation"+e.getMessage());
//        }
//        
//    }
//    private void AttachmentOutbox() {
//        //String tableN=tableFinalString.concat("outbox");
//        System.out.println(attachout);
//        String myTableName = "create table"+" "+attachout+" "+"("   
//            + "mailId int(20)," 
//            + "attachments TEXT(60))";    
//        try {
//           
//            st = con.createStatement();
//            //The next line has the issue
//            st.executeUpdate(myTableName);
//            System.out.println("Table Created");
//        }
//        catch (SQLException e ) {
//            System.out.println("An error has occurred on Table   "+attachout+" Creation"+e.getMessage());
//        }
//        
//    }
//    private void AttachmentInbox() {
//        //String tableN=tableFinalString.concat("outbox");
//        System.out.println(attachin);
//        String myTableName = "create table"+" "+attachin+" "+"(" 
//            + "mailId int(20)," 
//            + "attachments TEXT(60))"; 
//        try {
//           
//            st = con.createStatement();
//            //The next line has the issue
//            st.executeUpdate(myTableName);
//            System.out.println("Table Created");
//        }
//        catch (SQLException e ) {
//            System.out.println("An error has occurred on Table   "+attachin+" Creation"+e.getMessage());
//        }
//        
//    }
//    }
//
