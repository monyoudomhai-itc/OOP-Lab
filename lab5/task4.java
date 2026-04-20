import java.io.*;
import java.util.*;

public class task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String FILE_NAME = "data.txt";

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1. View my note");
            System.out.println("2. Edit");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                ArrayList<String> lines = new ArrayList<>();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                    br.close();
                } catch (Exception e) {}

                System.out.println("==== View note ====");
                System.out.println("******************************");

                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + "| " + lines.get(i));
                }

                System.out.println("******************************");
            }

            else if (choice == 2) {

                ArrayList<String> lines = new ArrayList<>();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                    br.close();
                } catch (Exception e) {}

                System.out.println("==== Edit following note ====");
                System.out.println("******************************");

                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + "| " + lines.get(i));
                }

                System.out.println("******************************");

                System.out.println("1. Append new line");
                System.out.println("2. Update at line");
                System.out.println("3. Delete line");
                System.out.print("Choose an option: ");

                int opt = sc.nextInt();
                sc.nextLine();

                if (opt == 1) {
                    System.out.print("Input a string: ");
                    String text = sc.nextLine();
                    lines.add(text);
                    System.out.println("Line added.");
                }

                else if (opt == 2) {
                    System.out.print("Enter line number: ");
                    int lineNum = sc.nextInt();
                    sc.nextLine();

                    if (lineNum > 0 && lineNum <= lines.size()) {
                        System.out.print("Enter new text: ");
                        String newText = sc.nextLine();
                        lines.set(lineNum - 1, newText);
                        System.out.println("Line updated.");
                    } else {
                        System.out.println("Invalid line!");
                    }
                }

                else if (opt == 3) {
                    System.out.print("Enter line number: ");
                    int lineNum = sc.nextInt();

                    if (lineNum > 0 && lineNum <= lines.size()) {
                        lines.remove(lineNum - 1);
                        System.out.println("Line deleted.");
                    } else {
                        System.out.println("Invalid line!");
                    }
                }

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
                    for (String l : lines) {
                        bw.write(l);
                        bw.newLine();
                    }
                    bw.close();
                } catch (Exception e) {
                    System.out.println("Error writing file!");
                }
            }

            else if (choice == 3) {
                System.out.println("Bye!");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}