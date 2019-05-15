package module1.opdracht2;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception{
        Socket s = new Socket("fluuurp.tk", 8081);

        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("Hello World\nDat werkt");
        pw.flush();
        pw.close();
        s.close();
    }

}
