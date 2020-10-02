package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class RecAppInfo extends Thread {
	public String ip;
    public RecAppInfo() throws IOException {

    }
    public void run()
    {
        while(true)
        {
            try
            {
                ServerSocket serverSocket = null;

                try {
                    serverSocket = new ServerSocket(4453);
                } catch (IOException ex) {
                    
                }

                Socket socket = null;
                InputStream in = null;
                FileOutputStream out = null;

                try {
                    socket = serverSocket.accept();
//                    ip=socket.getRemoteSocketAddress().toString().replace("/","").split(":")[0];
//            		File containingFolder = new File("ClientInfo");
//            		File dir = new File(containingFolder, ip);
//            		dir.mkdir();
                } catch (IOException ex) {
                  
                }

                try {
                    in =socket.getInputStream();
                } catch (IOException ex) {
                    
                }

                try {
                    out = new FileOutputStream("C:\\Users\\JoyGich\\Desktop\\notepad\\received.txt");
                } catch (FileNotFoundException ex) {
                   
                }

                byte[] bytes = new byte[16*1024];

                int count;
                while ((count = in.read(bytes)) > 0) {
                    out.write(bytes, 0, count);
                }

                out.close();
                in.close();
                socket.close();
                serverSocket.close();
            }
           
            
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
    }
}