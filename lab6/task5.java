import javax.swing.*;
import java.awt.*;

public class task5 {
	public static void main(String[] args) {
		JFrame f = new JFrame("First GUI");
		f.setLayout(new GridLayout(13, 1, 8, 6));

		JLabel title = new JLabel("Calculator");
		JLabel aLabel = new JLabel("A=");
		JLabel bLabel = new JLabel("B=");
		JTextField aField = new JTextField(16);
		JTextField bField = new JTextField(16);

		JButton addBtn = new JButton("A + B");
		JButton subBtn = new JButton("A - B");
		JButton mulBtn = new JButton("A * B");
		JButton divBtn = new JButton("A / B");

		JLabel addResult = new JLabel("=");
		JLabel subResult = new JLabel("=");
		JLabel mulResult = new JLabel("=");
		JLabel divResult = new JLabel("=");

		Font font = new Font("Arial", Font.PLAIN, 16);
		title.setFont(new Font("Arial", Font.BOLD, 16));
		aLabel.setFont(font);
		bLabel.setFont(font);
		aField.setFont(font);
		bField.setFont(font);
		addBtn.setFont(font);
		subBtn.setFont(font);
		mulBtn.setFont(font);
		divBtn.setFont(font);
		addResult.setFont(font);
		subResult.setFont(font);
		mulResult.setFont(font);
		divResult.setFont(font);

		addBtn.addActionListener(e -> compute(aField, bField, addResult, '+'));
		subBtn.addActionListener(e -> compute(aField, bField, subResult, '-'));
		mulBtn.addActionListener(e -> compute(aField, bField, mulResult, '*'));
		divBtn.addActionListener(e -> compute(aField, bField, divResult, '/'));

		JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row1.add(title);

		JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row2.add(aLabel);

		JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row3.add(aField);

		JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row4.add(bLabel);

		JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row5.add(bField);

		JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row6.add(addBtn);

		JPanel row7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row7.add(addResult);

		JPanel row8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row8.add(subBtn);

		JPanel row9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row9.add(subResult);

		JPanel row10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row10.add(mulBtn);

		JPanel row11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row11.add(mulResult);

		JPanel row12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row12.add(divBtn);

		JPanel row13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row13.add(divResult);

		f.add(row1);
		f.add(row2);
		f.add(row3);
		f.add(row4);
		f.add(row5);
		f.add(row6);
		f.add(row7);
		f.add(row8);
		f.add(row9);
		f.add(row10);
		f.add(row11);
		f.add(row12);
		f.add(row13);

		f.setSize(320, 520);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	private static void compute(JTextField aField, JTextField bField, JLabel out, char op) {
		try {
			double a = Double.parseDouble(aField.getText().trim());
			double b = Double.parseDouble(bField.getText().trim());
			double result;

			switch (op) {
				case '+':
					result = a + b;
					break;
				case '-':
					result = a - b;
					break;
				case '*':
					result = a * b;
					break;
				case '/':
					if (b == 0) {
						out.setText("= division by 0");
						return;
					}
					result = a / b;
					break;
				default:
					out.setText("= error");
					return;
			}

			out.setText("= " + result);
		} catch (NumberFormatException ex) {
			out.setText("= invalid input");
		}
	}
}
