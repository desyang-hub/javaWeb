import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveHelper implements Runnable{

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    public ReceiveHelper(Socket socket) {
        this.socket = socket;
        init();
    }

    public void init() {
        try{
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("服务器繁忙，稍后为您服务");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                String msg = in.readUTF();
                System.out.println(socket.getInetAddress().getHostName() + "：" + msg);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }

        }
    }
}
