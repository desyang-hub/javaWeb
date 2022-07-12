import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(App.PORT);
            System.out.println("服务器已启动，等待用户连接......");
            Socket socket = serverSocket.accept();
            System.out.println("用户IP:" + socket.getInetAddress().getHostAddress());

            new Thread(new ReceiveHelper(socket)).start();
            new Thread(new SendHelper(socket)).start();

        } catch (IOException e) {
            System.out.println("客户已断开");
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
