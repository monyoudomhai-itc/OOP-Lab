import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

class User{
    String name;
    int id;
    User()
    {

    }
    User(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
    static void addToFile(User users)throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter("user.txt", true));
        writer.format("%d,%s%n",users.id,users.name);
        writer.close();
    }
    static void display()throws Exception{
        Scanner scanner = new Scanner(new File("user.txt"));
        System.out.printf("%-5s | %-20s%n","ID","Name");
        while(scanner.hasNextLine())
        {
            String text = scanner.nextLine();
            String[] array = text.split(",");
            System.out.printf("%-5s | %-20s%n",array[0],array[1]);
        }
        scanner.close();
    }
}
public class oop55{
    public static void main(String[] args)throws Exception
    {
        User u = new User(2, "dom");
        User.addToFile(u);
        
        User.display();
    }
}