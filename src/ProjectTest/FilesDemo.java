
package ProjectTest;

import java.io.File;

/**
 *
 * @author JoyGich
 */
public class FilesDemo {
    
    
    public static void main(String[] args){
        
    File test = null;
    Boolean bool = false;
    
    try{
        test = new File(System.getProperty("user.home"));
    
    bool = test.mkdir();
    System.out.print("Directory created?"+bool);
    
    }catch(Exception e){
        e.printStackTrace();
    }
    
    
        }
}
