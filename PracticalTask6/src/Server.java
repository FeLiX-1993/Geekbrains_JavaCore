import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private final int SERVER_PORT = 8199;

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private volatile boolean connectionOpen;

    public Server() {
        try {
            createServer();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServer();
        }
    }

    public void createServer() throws IOException {

        serverSocket = new ServerSocket(SERVER_PORT);
        socket = serverSocket.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        connectionOpen = true;

        Scanner scanner = new Scanner(System.in);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (!connectionOpen)
                            break;
                        String strFromClient = in.readUTF();
                        if (strFromClient.equals("/end")) {
                            connectionOpen = false;
                            System.out.println("Client has stopped the connection, press Enter to exit");
                            break;
                        }
                        System.out.println("Message from client: " + strFromClient);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            while (true) {
                if (!connectionOpen)
                    break;
                String strToClient = scanner.nextLine();
                if (strToClient.equals("/end"))
                    connectionOpen = false;
                out.writeUTF(strToClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeServer() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}
