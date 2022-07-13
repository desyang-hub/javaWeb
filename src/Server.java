import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Vector<Connect> clients;

        try {
            serverSocket = new ServerSocket(App.PORT);
            System.out.println("服务器已启动，等待用户连接......");
            clients = new Vector<>();
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("用户IP: " + socket.getInetAddress().getHostAddress());
                clients.add(new Connect(socket));

            }
        } catch (IOException e) {
            System.out.println("客户已断开");
            System.exit(0);
        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
