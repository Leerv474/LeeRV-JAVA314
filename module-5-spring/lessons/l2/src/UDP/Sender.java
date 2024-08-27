package UDP;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) {
        DatagramSocket datagramSocket;
        Scanner input = new Scanner(System.in);
        try {
            datagramSocket = new DatagramSocket();
            while (true) {
                System.out.println("Enter a message for the server");
                String s = input.nextLine();
                byte[] b = s.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 4567);
                datagramSocket.send(datagramPacket);

                byte[] response = new byte[1024];
                DatagramPacket d = new DatagramPacket(response, response.length);
                datagramSocket.receive(d);

                byte[] data = d.getData();
                s = new String(data, 0, d.getLength());
                System.out.printf("Server %s port %s response: %s\n", d.getAddress().getHostAddress(), d.getPort(), s);
            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }
}