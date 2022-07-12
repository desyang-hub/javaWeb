import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveHelper implements Runnable{

    Socket socket;
    DataInputStream in;
    public ReceiveHelper(Socket socket) {
        this.socket = socket;
        init();
    }

    public void init() {
        try{
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                String msg = in.readUTF();
                System.out.println("发送方：" + msg);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }

        }
    }
}
