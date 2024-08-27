import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.io.*;
import java.sql.*;

public class Main3 {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/hotel";
        final String username = "study";
        final String password = "1234";
//        String imagePath = "src/village.jpg";
//        String query = "insert into image_table (image_data) values(?)";

//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            FileInputStream fileInputStream = new FileInputStream(imagePath);
//            byte[] imageData = new byte[fileInputStream.available()];
//            fileInputStream.read(imageData);
//
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setBytes(1, imageData);
//
//            int row = preparedStatement.executeUpdate();
//            if (row > 0) {
//                System.out.println("Изображение добавлено успешно.");
//            } else {
//                System.out.println("Не удалось добавить изображение.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        String folderPath = "src/";
        String query = "Select image_data from image_table where image_id = (?)";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                byte[] imageData = resultSet.getBytes("image_data");
                String imagePath = folderPath + "extractedImage.jpg";
                OutputStream outputStream = new FileOutputStream(imagePath);
                outputStream.write(imageData);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}