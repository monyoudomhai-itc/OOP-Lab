import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task4 {
    public static void main(String[] args) {
        JFrame f = new JFrame("First GUI");
        f.setLayout(new GridLayout(6, 1, 10, 6));

        JLabel title = new JLabel("Find roots of quadratic equation ax^2 + bx + c = 0");
        JLabel text1Label = new JLabel("a=");
        JLabel text2Label = new JLabel("b=");
        JLabel text3Label = new JLabel("c=");
        JTextField tf1 = new JTextField(20);
        JTextField tf2 = new JTextField(20);
        JTextField tf3 = new JTextField(20);
        JButton b = new JButton("Find");
        JLabel l = new JLabel(" ");

        Font font = new Font("Arial", Font.PLAIN, 18);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        text1Label.setFont(font);
        text2Label.setFont(font);
        text3Label.setFont(font);
        tf1.setFont(font);
        tf2.setFont(font);
        tf3.setFont(font);
        b.setFont(font);
        l.setFont(font);

        b.addActionListener(e -> {
            try {
                double a = Double.parseDouble(tf1.getText().trim());
                double bVal = Double.parseDouble(tf2.getText().trim());
                double c = Double.parseDouble(tf3.getText().trim());

                if (a == 0) {
                    l.setText("a must not be 0");
                    return;
                }

                double d = (bVal * bVal) - (4 * a * c);
                if (d >= 0) {
                    double sqrtD = java.lang.Math.sqrt(d);
                    double x1 = (-bVal + sqrtD) / (2 * a);
                    double x2 = (-bVal - sqrtD) / (2 * a);
                    l.setText("x1 = " + x1 + ",  x2 = " + x2);
                } else {
                    l.setText("No real roots");
                }
            } catch (NumberFormatException ex) {
                l.setText("Enter valid numbers");
            }
        });

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(title);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.add(text1Label);
        row2.add(tf1);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3.add(text2Label);
        row3.add(tf2);

        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row4.add(text3Label);
        row4.add(tf3);

        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row5.add(b);

        JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row6.add(l);

        f.add(row1);
        f.add(row2);
        f.add(row3);
        f.add(row4);
        f.add(row5);
        f.add(row6);

        f.setSize(600, 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}