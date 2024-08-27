package ClientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int serverPort = 5555;
    private static final String localHost = "127.0.0.1";

    public static void main(String[] args) {
        Socket socket = null;
        try {
            try {
                System.out.printf("Welcome to client side\nConnection to the server\n\t(IP address %s, port %s)", localHost, serverPort);
                InetAddress ipAddress = InetAddress.getByName(localHost);
                socket = new Socket(ipAddress, serverPort);
                System.out.println("Connection established");
                System.out.printf("\tHost address: %s. The buffer size: %d", socket.getInetAddress().getHostAddress(), socket.getReceiveBufferSize());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader keyboard = new BufferedReader(isr);

                String line;
                while (true) {
                    System.out.println("\nType something and press 'Enter'");
                    line = keyboard.readLine();
                    outputStream.writeUTF(line);
                    outputStream.flush();
                    line = inputStream.readUTF();

                    if(line.endsWith("quit")) {
                        break;
                    } else {
                        System.out.println("\nСервер отправил мне эту цитату:\n\t" + line);
                        System.out.println();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
