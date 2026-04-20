import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

class User{
    String firstName;
    String lastName;
    String gender;
    String email;
    User(String firstName,String lastName,String gender,String email)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.email=email;
    }
    String getName()
    {
        return firstName + " "+lastName;
    }
}
class Teacher extends User{
    String subject;
    float sal;
    Teacher(String firstName,String lastName,String gender,String email,String subject,float sal)
    {
        super(firstName, lastName, gender, email);
        this.subject=subject;
        this.sal= sal;
    }
    void add(Teacher t) throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("teacher.txt",true));
        writer.println(t.getName()+","+t.gender+","+t.email+","+t.subject+","+t.sal);
        writer.close();
    }
    static void addToFile(ArrayList<Teacher> teachers) throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("teacher.txt",true));
        for(int i = 0; i< teachers.size();i++)
        {
            Teacher t = teachers.get(i);
            writer.println(t.getName()+","+t.gender+","+t.email+","+t.subject+","+t.sal);
        }
        writer.close();
    }
    static void display()throws Exception
    {
        File f = new File("teacher.txt");
        Scanner scanner = new Scanner(f);
        int count = 1;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if(line.isEmpty()){
                System.out.println("No teacher yet");
            }
            else{
            String[] array = new String[10];
            array = line.split(",");
            System.out.println(count+". ["+array[0]+"]["+array[1]+"]["+array[2]+"]["+array[3]+"]["+array[4]+"$]");
            count++;
            }
        }
        scanner.close();
    }
}
public class task5{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Teacher> teachers =  new ArrayList<>();
        Teacher t= new Teacher(null, null, null, null, null, 0);
        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1. View all teacher");
            System.out.println("2. Add new Teacher");
            System.out.println("3. Quit");
            System.out.print("choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1)
            {
                Teacher.display();
            }
            else if(choice == 2)
            {
                System.out.println("==== Add new teacher ====");
                System.out.print("First Name: ");
                String firstName = sc.nextLine();
                System.out.print("Last Name: ");
                String lastName = sc.nextLine();
                System.out.print("Sex: ");
                String gender = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Subject: ");
                String subject = sc.nextLine();
                System.out.print("Salary: ");
                float sal = sc.nextFloat();
                sc.nextLine();
                t = new Teacher(firstName, lastName, gender, email, subject, sal);
                teachers.add(new Teacher(firstName, lastName, gender, email, subject, sal));
                t.add(t);
            }
            else if(choice == 3 )
            {
                System.out.println("Exit program...");
                break;
            }

        }
    }
}