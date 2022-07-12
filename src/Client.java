import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", App.PORT);


            new Thread(new ReceiveHelper(socket)).start();
            new Thread(new SendHelper(socket)).start();
        } catch (IOException e) {
            System.out.println("服务器已断开！");
        }

    }
}
