import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scanner.next();
        FileReader file = null;
        BufferedReader reader = null;
        try {
            file = new FileReader(path);
            reader = new BufferedReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}