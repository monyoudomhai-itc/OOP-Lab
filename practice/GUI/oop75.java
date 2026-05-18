import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class oop75 {

    public static void main(String[] args) {

        // ── Create the Window ──────────────────────────────────────────
        JFrame frame = new JFrame("Student Management");
        frame.setSize(1200, 800);                          // ← bigger window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ==============================================================
        // NORTH : Title
        // ==============================================================
        JLabel title = new JLabel("Student Management");
        title.setFont(new Font("Arial", Font.BOLD, 28));   // ← bigger font
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        frame.add(title, BorderLayout.NORTH);

        // ==============================================================
        // CENTER : Input fields + Add button
        // ==============================================================
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblFirst = new JLabel("First name");
        lblFirst.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField txtFirst = new JTextField(12);
        txtFirst.setFont(new Font("Arial", Font.PLAIN, 16));
        txtFirst.setPreferredSize(new Dimension(150, 40)); // ← bigger field

        JLabel lblLast = new JLabel("Last name");
        lblLast.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField txtLast = new JTextField(12);
        txtLast.setFont(new Font("Arial", Font.PLAIN, 16));
        txtLast.setPreferredSize(new Dimension(150, 40));

        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField txtAge = new JTextField(5);
        txtAge.setFont(new Font("Arial", Font.PLAIN, 16));
        txtAge.setPreferredSize(new Dimension(80, 40));

        JLabel lblMajor = new JLabel("Major");
        lblMajor.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField txtMajor = new JTextField(12);
        txtMajor.setFont(new Font("Arial", Font.PLAIN, 16));
        txtMajor.setPreferredSize(new Dimension(150, 40));

        JButton btnAdd = new JButton("Add new");
        btnAdd.setBackground(new Color(70, 130, 180));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
        btnAdd.setPreferredSize(new Dimension(130, 40));   // ← bigger button
        btnAdd.setFocusPainted(false);

        inputPanel.add(lblFirst);
        inputPanel.add(txtFirst);
        inputPanel.add(lblLast);
        inputPanel.add(txtLast);
        inputPanel.add(lblAge);
        inputPanel.add(txtAge);
        inputPanel.add(lblMajor);
        inputPanel.add(txtMajor);
        inputPanel.add(btnAdd);

        frame.add(inputPanel, BorderLayout.CENTER);

        // ==============================================================
        // SOUTH : Table
        // ==============================================================
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("First name");
        model.addColumn("Last name");
        model.addColumn("Age");
        model.addColumn("Major");

        model.addRow(new Object[]{"AA", "Tola",   "21", "IT"});
        model.addRow(new Object[]{"AA", "Makara", "19", "IT"});
        model.addRow(new Object[]{"AA", "Tola",   "21", "IT"});
        model.addRow(new Object[]{"AA", "Makara", "19", "IT"});

        JTable table = new JTable(model);
        table.setRowHeight(35);                            // ← bigger rows
        table.setFont(new Font("Arial", Font.PLAIN, 16)); // ← bigger text
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // ← bigger header

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200, 550)); // ← taller table
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        frame.add(scrollPane, BorderLayout.SOUTH);

        // ==============================================================
        // BUTTON ACTION
        // ==============================================================
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String firstName = txtFirst.getText();
                String lastName  = txtLast.getText();
                String age       = txtAge.getText();
                String major     = txtMajor.getText();

                if (firstName.isEmpty() || lastName.isEmpty() || age.isEmpty() || major.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!");
                    return;
                }

                model.addRow(new Object[]{firstName, lastName, age, major});

                txtFirst.setText("");
                txtLast.setText("");
                txtAge.setText("");
                txtMajor.setText("");
            }
        });

        // ==============================================================
        frame.setVisible(true);
    }
}