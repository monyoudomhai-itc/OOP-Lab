import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class textEditor {
    
    public static void main(String[] args)throws Exception
    {
        ensureNoteFileExists();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("==== Menu ====");
            System.out.println("1. View my note");
            System.out.println("2. Edit");
            System.out.println("3. quit");
            System.out.print("opt: ");
            int opt = sc.nextInt();
            sc.nextLine();
            if(opt == 3 )
            {
                System.out.println("exit program ");
                break;
            }
            switch (opt) {
                case 1:
                    System.out.println("View my note ");
                    viewNote();
                    break;
                case 2: 
                    while(true){
                    System.out.println("Edit following note: ");
                    viewNote();
                    System.out.println("1.append new line");
                    System.out.println("2.update at line");
                    System.out.println("3. delete line");
                    System.out.print("opt: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if(choice == 4 ){break;}
                    else if(choice == 1){
                        System.out.println("Input String for line: ");
                        String line = sc.nextLine();
                        appendLine(line);
                    }
                    }
                    break;
                default:
                    break;
            }
        }


        sc.close();
    }
    static void ensureNoteFileExists() throws Exception {
        File noteFile = new File("text.txt");
        if (!noteFile.exists()) {
            noteFile.createNewFile();
        }
    }
    static void viewNote()throws Exception{
        File noteFile = new File("text.txt");
        if (!noteFile.exists()) {
            System.out.println("No note file found yet.");
            System.out.println("*".repeat(30));
            return;
        }

        Scanner scanner = new Scanner(noteFile);
        int count =1;
        boolean hasContent = false;
        while(scanner.hasNextLine())
        {
            hasContent = true;
            String text = scanner.nextLine();
            System.out.println(count+"| "+text);
            count++;
        }
        if (!hasContent) {
            System.out.println("(No notes yet)");
        }
        System.out.println("*".repeat(30));
        scanner.close();
    }
    static void appendLine(String line)throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter("text.txt",true));
        writer.println(line);
        writer.close();
    }
}