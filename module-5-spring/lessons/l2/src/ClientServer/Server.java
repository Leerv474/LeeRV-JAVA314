package ClientServer;

import javax.management.MBeanServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread {
    private static final int PORT = 5555;
    private String MSG = "Клиент '%d' отправил мне сообщение:\n\t";
    private String CONN = "Клиент '%d' закрыл соединение";
    private Socket socket;
    private int num;

    public void setSocket(int num, Socket socket) {
        this.num = num;
        this.socket = socket;

        start();
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String line;
            while (true) {
                line = dis.readUTF();
                System.out.printf(MSG, num);
                System.out.println(line);
                System.out.println("Sending back...");
                dos.writeUTF("Server is receiving text: " + line);
                dos.flush();
                System.out.println();
                if (line.equalsIgnoreCase("quit")) {
                    socket.close();
                    System.out.printf(CONN, num);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ServerSocket srvSocket = null;
        try {
            try {
                int i = 0;
                InetAddress ia = InetAddress.getByName("localhost");
                srvSocket = new ServerSocket(PORT, 0, ia);
                System.out.println("Server is running");

                while(true) {
                    Socket socket = srvSocket.accept();
                    System.err.println("\n\nClient accepted");
                    new Server().setSocket(i++, socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (srvSocket != null) {
                    srvSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
