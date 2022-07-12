import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendHelper implements Runnable{

    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    public SendHelper(Socket socket) {
        this.socket = socket;
        init();
    }

    public void init() {
        try{
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                String msg = sc.nextLine();
                out.writeUTF(msg);
//                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
