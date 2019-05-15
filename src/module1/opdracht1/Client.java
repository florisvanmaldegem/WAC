package module1.opdracht1;

import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception{
        Socket s = new Socket("fluuurp.tk", 8081);
        OutputStream os = s.getOutputStream();
        os.write("Hello\n".getBytes());
        s.close();
    }

}
