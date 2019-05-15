package module1.opdracht1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8081);
        Socket s = ss.accept();

        InputStream is = s.getInputStream();

        int c = is.read();
        while(c != -1){
            System.out.print((char) c);
            c = is.read();
        }

        s.close();
        ss.close();

    }
}
