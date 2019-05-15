package module1.opdracht5;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8081);
        while(serverSocket.isBound()){
            Thread t = new Thread(new Servlet(serverSocket.accept()));
            t.start();
        }
    }
}
