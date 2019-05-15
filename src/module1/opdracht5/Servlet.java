package module1.opdracht5;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Servlet extends Thread{
    private Socket socket;

    public Servlet(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            OutputStream outputStream = this.socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            String response = "HTTP/1.1 200 OK\r\n";
            response += "\r\n";
            response += "<h1>It works!</h1>\r\n";
            printWriter.write(response);
            printWriter.flush();
            this.socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
