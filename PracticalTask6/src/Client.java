import jdk.jfr.DataAmount;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final String SERVER_ADR = "localhost";
    private final int SERVER_PORT = 8199;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private volatile boolean connectionOpen;

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
            System.exit(0);
        }
    }

    public void openConnection() throws IOException {

        socket = new Socket(SERVER_ADR, SERVER_PORT);
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
                        String strFromServer = in.readUTF();
                        if (strFromServer.equals("/end")) {
                            connectionOpen = false;
                            System.out.println("Server has stopped the connection, press Enter to exit");
                            break;
                        }
                        System.out.println("Message from server: " + strFromServer);
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
                String strToServer = scanner.nextLine();
                if (strToServer.equals("/end"))
                    connectionOpen = false;
                synchronized (socket) {
                    out.writeUTF(strToServer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
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
    }

    public static void main(String[] args) {
        new Client();
    }

}
