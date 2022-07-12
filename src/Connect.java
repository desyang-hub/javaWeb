import java.net.Socket;

public class Connect{

    public CloseListener closeListener;
    Socket client;
    public Connect(Socket socket) {
        client = socket;

        new Thread(new SendHelper(socket)).start();
        new Thread(new ReceiveHelper(socket)).start();
    }

    public void setCloseListener(CloseListener closeListener) {
        this.closeListener = closeListener;
    }
}
