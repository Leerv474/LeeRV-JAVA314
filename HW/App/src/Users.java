import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Users {
    private String name;
    private int userId;
    private LocalDate date;
    private int data;

    public Users(String name, int userId, String date, int data) {
        this.name = name;
        this.userId = userId;
        this.date = LocalDate.parse(date);
        this.data = data;
    }

    public String getName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getDate() {
        return String.valueOf(this.date);
    }

    public int getData() {
        return this.data;
    }

    private static List<Users> usersList = new ArrayList<>();
    private static List<Integer> occupiedIds = new ArrayList<>();

    public static void readData () {
        Path path = Paths.get("data", "usersData.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s,]+");
                usersList.add(new Users(words[0], Integer.parseInt(words[1]), words[2], Integer.parseInt(words[3])));
                occupiedIds.add(Integer.parseInt(words[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Users> getUsersList() {
        return usersList;
    }

    public static void addData(String name, int data) {
        LocalDate date = LocalDate.now();
        Random random = new Random();
        int newId = 0;
        while (newId <= 0 || occupiedIds.contains(newId)) {
            newId = random.nextInt();
        }
        Users newUser = new Users(name, newId, String.valueOf(date), data);
        usersList.add(newUser);
        occupiedIds.add(newId);
    }

    static void saveData() {
        Path path = Paths.get("data", "usersData.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Users user : usersList) {
                writer.write(user.getName() + " " + user.getUserId() + " " + user.getDate() + " " + user.getData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}