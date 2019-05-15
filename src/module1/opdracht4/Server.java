package module1.opdracht4;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8081);

        while(ss.isBound()){
            Socket s = ss.accept();

            while(!s.isClosed()){
                InputStream is = s.getInputStream();
                OutputStream outputStream = s.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                Scanner input = new Scanner(is);
                String output = "";

                while(input.hasNextLine()){
                    output = input.nextLine();
                    System.out.println(output);
                    if(output.isBlank()){
                        String response = "HTTP/1.1 200 OK\r\n";
                        response += "\r\n";
                        response += "<h1>It works!</h1>\r\n";
                        printWriter.write(response);
                        printWriter.flush();
                        s.close();
                    }

                }
            }

        }
    }
}