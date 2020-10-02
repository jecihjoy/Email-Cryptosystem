package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import java.io.OutputStream;

public class SendRunningApps {
    public SendRunningApps() throws IOException {
        Socket socket = null;
        String host = "127.0.0.1";

        socket = new Socket(host, 4453);

        File file = new File("C:\\Users\\JoyGich\\Desktop\\notepad\\save.txt");
        byte[] bytes = new byte[16 * 1024];
        FileInputStream in = new FileInputStream(file);
        OutputStream out =socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
    }
}