import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task3 {
    public static void main(String[] args) {
        JFrame f = new JFrame("First GUI");
        f.setLayout(new GridLayout(4, 1, 10, 10)); // 4 rows, 1 col

        JLabel title = new JLabel("Count number of Vowels, Consonants, and Spaces");
        JLabel textLabel = new JLabel("Text:");
        JTextField tf = new JTextField(30);
        JButton b = new JButton("Find");
        JLabel l = new JLabel(" ");

        Font font = new Font("Arial", Font.PLAIN, 22);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        textLabel.setFont(font);
        tf.setFont(font);
        b.setFont(font);
        l.setFont(font);

        b.addActionListener(e -> {
            String text = tf.getText().toLowerCase();
            int vowels = 0, consonants = 0, spaces = 0;
            for (char c : text.toCharArray()) {
                if (c == ' ') spaces++;
                else if ("aeiou".indexOf(c) >= 0) vowels++;
                else if (Character.isLetter(c)) consonants++;
            }
            l.setText("<html>Count of vowel is: " + vowels +
                      "<br>Count of consonant is: " + consonants +
                      "<br>Count of space is: " + spaces + "</html>");
        });

        // Each row is its own panel
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(title);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.add(textLabel);
        row2.add(tf);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3.add(b);

        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row4.add(l);

        f.add(row1);
        f.add(row2);
        f.add(row3);
        f.add(row4);

        f.setSize(800, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}