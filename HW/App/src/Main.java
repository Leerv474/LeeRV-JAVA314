import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Сервис передачи показаний счетчиков воды");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 20));

        LocalDate date = LocalDate.now();
        String helloInfo = "Вы вошли на страницу с правами администратора.";
        String userInfo = "Администратор Администратор";
        String currentDate = "Сегодня " + date;

        Font font = new Font("Arial", Font.PLAIN, 18);
        JLabel helloLabel = new JLabel(helloInfo);
        helloLabel.setFont(font);

        JLabel userLabel = new JLabel(userInfo);
        userLabel.setFont(font);

        JLabel dateLabel = new JLabel(currentDate);
        dateLabel.setFont(font);

        infoPanel.add(helloLabel);
        infoPanel.add(userLabel);
        infoPanel.add(dateLabel);

        Users.readData();

        JFrame tableFrame = new JFrame("User Data Table Example");
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = {"Username"};
        Object[][] userData = Users.getUsersList().stream().map(u -> new Object[]{u.getName()}).toArray(Object[][]::new);

        JTable userTable = new JTable(new DefaultTableModel(userData, columnNames));

        String[] dataColumnNames = {"Показания"};

        Object[][] userDataTable = Users.getUsersList().stream().map(u -> new Object[]{u.getData()}).toArray(Object[][]::new);
        JTable dataTable = new JTable(new DefaultTableModel(userDataTable, dataColumnNames));

        userTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = userTable.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
                model.setValueAt(Users.getUsersList().get(selectedRow).getData(), 0, 0);
            }
        });
        JScrollPane userScrollPane = new JScrollPane(userTable);
        JScrollPane dataScrollPane = new JScrollPane(dataTable);

        JTextField nameField = new JTextField(20);
        JTextField dataField = new JTextField(10);
        JButton addButton = new JButton("Add Data");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int data = Integer.parseInt(dataField.getText());

                Users.addData(name, data);

                DefaultTableModel userModel = (DefaultTableModel) userTable.getModel();
                userModel.addRow(new Object[]{name});

                nameField.setText("");
                dataField.setText("");
                Users.saveData();
            }
        });
        tableFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(userScrollPane);
        panel.add(dataScrollPane);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(dataField);
        inputPanel.add(addButton);
        tableFrame.add(panel, BorderLayout.CENTER);
        tableFrame.add(inputPanel, BorderLayout.SOUTH);


        tableFrame.getContentPane().add(infoPanel, BorderLayout.NORTH);
        tableFrame.setSize(500, 500);
        tableFrame.setVisible(true);
    }
}
