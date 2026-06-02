import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class insertStudent {

    public static void main(String[] args) {
        JTextField txtFirstName;
        JTextField txtLastName;
        JButton btnAdd;
        JTable table;
        DefaultTableModel model;

        JFrame frame = new JFrame("Insert Student");
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1000, 700);
        panel.setBackground(new Color(230, 230, 230));

        frame.add(panel);

        JLabel title = new JLabel("Insert a student");
        title.setBounds(120, 40, 400, 60);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        panel.add(title);

        JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(140, 150, 150, 30);
        lblFirstName.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(140, 200, 250, 70);
        txtFirstName.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(txtFirstName);

        JLabel lblLastName = new JLabel("Last name");
        lblLastName.setBounds(460, 150, 150, 30);
        lblLastName.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(460, 200, 250, 70);
        txtLastName.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(txtLastName);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(800, 200, 140, 70);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 28));
        btnAdd.setBackground(new Color(120, 160, 240));
        btnAdd.setForeground(Color.WHITE);
        panel.add(btnAdd);

        String[] columns = {"First name", "Last name"};

        model = new DefaultTableModel(columns,0);

        table = new JTable(model);
        table.setRowHeight(35);
        table.setFont(new Font("Arial", Font.PLAIN, 22));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 24));

        model.addRow(new Object[]{"John", "Smith"});
        model.addRow(new Object[]{"Mary", "Jones"});
        model.addRow(new Object[]{"David", "Brown"});
        model.addRow(new Object[]{"Anna", "Taylor"});
        model.addRow(new Object[]{"Peter", "Wilson"});

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(120, 340, 760, 250);

        panel.add(scrollPane);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                model.addRow(new Object[]{firstName, lastName});
                txtFirstName.setText("");
                txtLastName.setText("");
            }
        });

        frame.setVisible(true);
    }
}