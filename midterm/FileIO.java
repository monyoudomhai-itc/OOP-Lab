import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

class User{
    private String username;
    private String email;
    private String password;
    User()
    {

    }
    User(String username,String email,String password)
    {
        this.username = username;
        this.email=email;
        this.password = password;
    }
    public String getUsername()
    {
        return username;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    static void registerToFile(User u)throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter("user.txt",true));
        writer.format("%s,%s,%s%n",u.getUsername(),u.getEmail(),u.getPassword());
        System.out.println("You are successfully registered");
        writer.close();
    }
    static void login(String usernameOrEmail,String passsword)throws Exception{
        Scanner scanner = new Scanner(new File("user.txt"));
        while(scanner.hasNextLine())
        {
            String text = scanner.nextLine();
            String[] array = text.split(",");
            if(array[0].equals(usernameOrEmail) || array[1].equals(usernameOrEmail))
            {
                if(array[2].equals(passsword))
                {
                    System.out.println();
                    System.out.println("Login Successful .");
                    System.out.println("Hello "+array[0]);
                }
                else
                {
                    System.out.println("password incorrect try again");
                }
            }
            else{
                System.out.println("user not found");
            }
        }
        scanner.close();
    }
}
public class FileIO {
    public static void main(String[] args)throws Exception
    {
        User users = new User();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            System.out.print("opt: ");
            int opt = sc.nextInt();
            sc.nextLine();
            if(opt == 3)
            {
                System.out.println("Exit program...");
                break;
            }
            switch (opt) {
                case 1:
                    System.out.println("=== Login ===");
                    System.out.print("Email or username : ");
                    String usernameOrEmail = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    User.login(usernameOrEmail, password);
                    break;
                case 2:
                    System.out.println("=== Registered a new user ===");
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Password: ");
                    password = sc.nextLine();
                    users = new User(username, email, password);
                    User.registerToFile(users);
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
