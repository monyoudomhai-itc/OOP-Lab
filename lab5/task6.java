import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class User {
	String firstName;
	String lastName;
	String username;
	String email;
	String password;

	User(String firstName, String lastName, String username, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	String toFileString() {
		return firstName + "|" + lastName + "|" + username + "|" + email + "|" + password;
	}

	static User fromFileString(String line) {
		String[] parts = line.split("\\|", -1);
		if (parts.length != 5) {
			return null;
		}
		return new User(parts[0], parts[1], parts[2], parts[3], parts[4]);
	}

	boolean matchLogin(String emailOrUsername, String password) {
		boolean idMatch = username.equals(emailOrUsername) || email.equals(emailOrUsername);
		return idMatch && this.password.equals(password);
	}
}

public class task6 {
	private static final String FILE_NAME = "user.txt";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("==== Menu ====");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Quit");
			int choice = readInt(sc, "Choose an option: ");

			if (choice == 1) {
				login(sc);
			} else if (choice == 2) {
				register(sc);
			} else if (choice == 3) {
				System.out.println("Bye!");
				break;
			} else {
				System.out.println("Invalid choice!\n");
			}
		}

		sc.close();
	}

	private static void register(Scanner sc) {
		System.out.println("\n==== Register a new user ====");

		String firstName = readLine(sc, "First Name: ");
		String lastName = readLine(sc, "Last Name: ");
		String username = readLine(sc, "Username: ");
		String email = readLine(sc, "Email: ");
		String password = readLine(sc, "Password: ");

		ArrayList<User> users = loadUsers();
		for (User user : users) {
			if (user.username.equals(username) || user.email.equals(email)) {
				System.out.println("Username or email already exists.\n");
				return;
			}
		}

		User newUser = new User(firstName, lastName, username, email, password);
		appendLine(FILE_NAME, newUser.toFileString());
		System.out.println("\nYou are successfully registered~\n");
	}

	private static void login(Scanner sc) {
		System.out.println("\n==== Login ====");

		while (true) {
			String emailOrUsername = readLine(sc, "Email or Username: ");
			String password = readLine(sc, "Password: ");

			ArrayList<User> users = loadUsers();
			User found = null;

			for (User user : users) {
				if (user.matchLogin(emailOrUsername, password)) {
					found = user;
					break;
				}
			}

			if (found != null) {
				System.out.println("=========== User Info ===========");
				System.out.println("Hi " + found.firstName + " " + found.lastName + ",");
				System.out.println("Your username is: " + found.username);
				System.out.println("Your email is: " + found.email + "\n");
				return;
			}

			System.out.println("User not found. Please try again\n");
		}
	}

	private static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<>();
		File file = new File(FILE_NAME);

		if (!file.exists()) {
			return users;
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					User user = User.fromFileString(line);
					if (user != null) {
						users.add(user);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error reading " + FILE_NAME);
		}

		return users;
	}

	private static void appendLine(String fileName, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(content);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.out.println("Error writing " + fileName);
		}
	}

	private static int readInt(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please input a valid number.");
			}
		}
	}

	private static String readLine(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			}
			System.out.println("This field is required.");
		}
	}
}
