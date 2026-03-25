import java.util.Scanner;
import java.util.ArrayList;
 class Student{
    int id ,age;
    String name;
    Student()
    {

    }
    Student(int id,String name,int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public int getId()
    {
        return id;
    }
    static void listStudent(ArrayList<Student> students)
    {
        System.out.println("=".repeat(56));
        System.out.printf("| %-6s | %-6s | %-25s | %-6s |%n", "No", "ID", "Name", "Age");
        System.out.println("=".repeat(56));
        for(int i= 0;i<students.size();i++)
        {
            Student s = students.get(i);
            //we use s = students.get(i) to avoid repeating call ex: students.get(i).id 
            System.out.printf("| %-6s | %-6s | %-25s | %-6s |%n", (i+1), s.id, s.name, s.age);
        }
        System.out.println("=".repeat(56));
    }
}

public class task1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        ArrayList<Student> students = new ArrayList<>();
    
        while(true)
        {
            System.out.println("Student #"+count+":");
            System.out.print("ID : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("Age : ");
            int age = sc.nextInt();
            sc.nextLine();

            students.add(new Student(id, name, age));
            count++;
            System.out.print("Do you want to add more (y/n)? :");
            String ans = sc.nextLine();
            if (ans.equals("n")){break;}
        }
        Student.listStudent(students);
        sc.close();
    }
}
