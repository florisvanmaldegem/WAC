package module1.opdracht3;

import java.io.InputStream;
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
                Scanner input = new Scanner(is);
                String output = "";

                if(input.hasNextLine()){
                    output += input.nextLine();
                    System.out.println(output);
                }
            }

        }
    }
}