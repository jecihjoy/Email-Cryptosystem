
package ProjectTest;
 import java.io.File;
/**
 *
 * @author JoyGich
 */
public class File2 {

  public static void main(String[] args)
  {
    File dir = new File("/Users/JoyGich/Desktop");
    
    // attempt to create the directory here
    boolean successful = dir.mkdir();
    if (successful)
    {
      // creating the directory succeeded
      System.out.println("directory was created successfully");
    }
    else
    {
      // creating the directory failed
      System.out.println("failed trying to create the directory");
    }
  }
}  
    
    

