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
                System.out.println("Добро пожаловать на клиентскую сторону\n>> Подключение к серверу");
                InetAddress ipAddress = InetAddress.getByName(localHost);
                socket = new Socket(ipAddress, serverPort);
                System.out.println(">> Подключение установлено");
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader keyboard = new BufferedReader(isr);

                String line;
                while (true) {
                    System.out.print("\nХотите получить цитату дня? (Yes/No) ");
                    line = keyboard.readLine();
                    if (line.endsWith("Yes")) {
                        outputStream.writeUTF(line);
                        outputStream.flush();
                        line = inputStream.readUTF();
                    } else if (line.endsWith("No")) {
                        break;
                    } else {
                        System.out.println("\nНеправильная команда");
                        continue;
                    }

                    System.out.println(line);
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
