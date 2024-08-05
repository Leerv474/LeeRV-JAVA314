import java.net.InetAddress;
import java.net.UnknownHostException;
public class Main {

    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(address);
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostName());
        System.out.println();
        try {
            address = InetAddress.getByName("google.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(address);
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}