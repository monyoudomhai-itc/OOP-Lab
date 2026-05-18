import java.util.Scanner;
import java.util.ArrayList;

class Student{
    private String name;
    private int age;
    private int id;
    public int getID()
    {
        return id;
    }
    Student()
    {

    }
    Student(String name,int age,int id)
    {
        this.id= id;
        this.name=name;
        this.age = age;
    }
    static void display(ArrayList<Student> students)
    {
        if(students.isEmpty())
        {
            System.out.println("No student register yet.");
            return;
        }
        System.out.println("==== View all student ====");
        System.out.printf("| %-5s | %-5s | %-15s | %-5s |%n"
                                ,"No","ID","Name","Age");
        for(int i = 0;i< students.size();i++)
        {
            Student s = students.get(i);
            System.out.printf("| %-5d | %-5d | %-15s | %-5d |%n"
                                ,(i+1),s.id,s.name,s.age);
        }
    }
    static void deleteByID(ArrayList<Student> students){
        System.out.println("==== Delete student ====");
        System.out.print("Input id:");
        
    }

}
public class oop42{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while(true)
        {
        System.out.println("==== Menu ====");
        System.out.println("1. View All students");
        System.out.println("2. Add a new student");
        System.out.println("3. Delete a student");
        System.out.println("4. Update student ");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 5){
            System.out.println("exit program....");
            break;
        }
        switch (choice) {
            case 1:
                Student.display(students);
                break;
            case 2:
                System.out.println("==== Add a new student ====");
                System.out.print("ID:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                students.add(new Student(name, age, id));
                System.out.println("Student added successfullly.");
                break;
            case 3:
                System.out.println("==== Delete student ====");
                System.out.print("input id: ");
                id = sc.nextInt();
                sc.nextLine();
                boolean found = true;
                for (int i = 0 ; i< students.size();i++)
                {
                    Student s = students.get(i);
                    if(s.getID() == id)
                    {
                        students.remove(s);
                        found = false;
                    }
                }
                if(!found)
                {
                    System.out.println("Student "+id+" have been deleted.");
                }
                else{
                    System.out.println("student not found");
                }
                break;
            case 4:
                System.out.println("==== Update student ====");
                System.out.print("input id: ");
                id = sc.nextInt();
                sc.nextLine();
                found = true;
                for (int i = 0 ; i< students.size();i++)
                {
                    Student s = students.get(i);
                    if(s.getID() == id)
                    {
                        System.out.print("ID:");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        name = sc.nextLine();
                        System.out.print("Age: ");
                        age = sc.nextInt();
                        sc.nextLine();
                        students.set(i, new Student(name, age, id));
                        found = false;
                    }
                }
                if(!found)
                {
                    System.out.println("Student "+id+" have been update.");
                }
                else{
                    System.out.println("student not found");
                }
                break;
            default:
                break;
        }
        
        }
        sc.close();
    }
}