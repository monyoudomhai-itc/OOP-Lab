import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
class User {
    String firstName;
    String lastName;
    String username;
    String email;
    String pass;
    int id ;
    User(int id,String firstName,String lastName,String username,String email,String pass)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.email=email;
        this.pass=pass;
        this.id = id;
    }
    String getName()
    {
        return firstName + " " +lastName;
    }
    String getPassword()
    {
        return pass;
    }
    int getId()
    {
        return id;
    }
    void addToFile(int id,String Name,String username,String email,String password)throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("user.txt", true));
        writer.println(id+","+Name + "," + username + "," + email + "," + password);
        writer.close();
    }
    
    boolean searchUser(String email , String pass)throws Exception
    {
        Scanner sc = new Scanner(new File("user.txt"));
        System.out.println("===== User Info =====");
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            String[] array =  new String[5];
            array = text.split(",");
            if(array[2].equals(email)||array[3].equals(email))
            {
                if(array[4].equals(pass)){
                System.out.println("HI ,"+array[1]);
                System.out.println("Your username is : "+array[2]);
                System.out.println("Your email is: "+array[3]);
                return true;
                }
            }
        }
        sc.close();
        return false;
    }
}
public class task6{
    public static void main(String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
        User users = new User(0, null, null, null, null, null);
        int id = 0;
        while(true)
        {
            System.out.println("===== Menu =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int chioce = sc.nextInt();
            sc.nextLine();
            switch (chioce) {
                case 2:
                    System.out.println("===== Register a new User =====");
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Password: ");
                    String pass = sc.nextLine();
                    String name = firstName + " "+lastName;
                    users.addToFile(id,name, username, email, pass);
                    id++;
                    System.out.println();
                    System.out.println("You are successfully register");                   break;
                case 1: 
                    System.out.println("==== Login ====");
                    System.out.print("Email or username : ");
                    username = sc.nextLine();
                    System.out.print("Password: ");
                    pass = sc.nextLine();
                    if(!users.searchUser(username, pass))
                    {
                        System.out.println("User Not found.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice .");
                    break;
            }
            if (chioce == 3 ){
                System.out.println("Exit program ... ");
                break;}
        }
    }
}