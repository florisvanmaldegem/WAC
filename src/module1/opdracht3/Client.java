package module1.opdracht3;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{
        Socket s = new Socket("fluuurp.tk", 8081);

        OutputStream outputStream = s.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        while(!s.isClosed()){
            Scanner scanner = new Scanner(System.in);
            String text = "";
            if(scanner.hasNextLine()){
                text += scanner.nextLine() + "\n";
                if(text.equals("stop\n")){
                    printWriter.write(text);
                    printWriter.flush();
                    s.close();
                    scanner.close();
                    System.out.println("Socket is stopped");
                }else{
                    printWriter.write(text);
                    printWriter.flush();
                }
            }
        }
    }

}
