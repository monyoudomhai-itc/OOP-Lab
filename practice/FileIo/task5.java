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
        System.out.println("========== Teacher ==========");
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if(line.isEmpty()){
                continue;
            }
            else{
            String[] array = line.split(",");
            System.out.println(count+". ["+array[0]+"]["+array[1]+"]["+array[2]+"]["+array[3]+"]["+array[4]+"$]");
            count++;
            }
        }
        scanner.close();
    }
}

class Student extends User{
    int year;
    String major;
    Student(String firstName,String lastName,String gender,String email,int year,String major)
    {
        super(firstName, lastName, gender, email);
        this.year=year;
        this.major=major;
    }
    void add(Student s) throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("student.txt",true));
        writer.println(s.getName()+","+s.gender+","+s.email+","+s.year+","+s.major);
        writer.close();
    }
    static void addToFile(ArrayList<Student> students) throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("student.txt",true));
        for(int i = 0; i< students.size();i++)
        {
            Student s = students.get(i);
            writer.println(s.getName()+","+s.gender+","+s.email+","+s.year+","+s.major);
        }
        writer.close();
    }
    static void display()throws Exception
    {
        File f = new File("student.txt");
        Scanner scanner = new Scanner(f);
        int count = 1;
        System.out.println("========== Student ==========");
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if(line.isEmpty()){
                continue;
            }
            else{
            String[] array = line.split(",");
            System.out.println(count+". ["+array[0]+"]["+array[1]+"]["+array[2]+"]["+array[3]+"]["+array[4]+"]");
            count++;
            }
        }
        scanner.close();
    }
}

class SecurityGuard extends User{
    String position;
    SecurityGuard(String firstName,String lastName,String gender,String email,String position)
    {
        super(firstName, lastName, gender, email);
        this.position=position;
    }
    void add(SecurityGuard sg) throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("securityguard.txt",true));
        writer.println(sg.getName()+","+sg.gender+","+sg.email+","+sg.position);
        writer.close();
    }
    static void addToFile(ArrayList<SecurityGuard> guards) throws Exception
    {
        PrintWriter writer = new PrintWriter(new FileWriter("securityguard.txt",true));
        for(int i = 0; i< guards.size();i++)
        {
            SecurityGuard sg = guards.get(i);
            writer.println(sg.getName()+","+sg.gender+","+sg.email+","+sg.position);
        }
        writer.close();
    }
    static void display()throws Exception
    {
        File f = new File("securityguard.txt");
        Scanner scanner = new Scanner(f);
        int count = 1;
        System.out.println("========== Security guard ==========");
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if(line.isEmpty()){
                continue;
            }
            else{
            String[] array = line.split(",");
            System.out.println(count+". ["+array[0]+"]["+array[1]+"]["+array[2]+"]["+array[3]+"]");
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
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<SecurityGuard> guards = new ArrayList<>();

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1. View all");
            System.out.println("2. Add new");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1)
            {
                System.out.println("\n==== View all ====");
                System.out.println("1. Teacher");
                System.out.println("2. Student");
                System.out.println("3. Security Guard");
                System.out.print("Choose an option: ");
                int viewChoice = sc.nextInt();
                sc.nextLine();

                if(viewChoice == 1) {
                    Teacher.display();
                }
                else if(viewChoice == 2) {
                    Student.display();
                }
                else if(viewChoice == 3) {
                    SecurityGuard.display();
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                System.out.println("\n==== Add new resource ====");
                System.out.println("1. Teacher");
                System.out.println("2. Student");
                System.out.println("3. Security guard");
                System.out.print("Choose an opt: ");
                int addChoice = sc.nextInt();
                sc.nextLine();

                if(addChoice == 1) {
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
                    Teacher t = new Teacher(firstName, lastName, gender, email, subject, sal);
                    teachers.add(t);
                    t.add(t);
                    System.out.println();
                }
                else if(addChoice == 2) {
                    System.out.println("==== Add new student ====");
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Sex: ");
                    String gender = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Major: ");
                    String major = sc.nextLine();
                    Student s = new Student(firstName, lastName, gender, email, year, major);
                    students.add(s);
                    s.add(s);
                    System.out.println();
                }
                else if(addChoice == 3) {
                    System.out.println("==== Add new security guard ====");
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Sex: ");
                    String gender = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Position: ");
                    String position = sc.nextLine();
                    SecurityGuard sg = new SecurityGuard(firstName, lastName, gender, email, position);
                    guards.add(sg);
                    sg.add(sg);
                    System.out.println();
                }
            }
            else if(choice == 3)
            {
                System.out.println("Exit program...");
                break;
            }
        }
        sc.close();
    }
}