import java.util.Scanner;
import java.util.ArrayList;
class Student{
    private String name;
    private int id,age;
    Student(int id ,String name,int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    int getId()
    {
        return id;
    }
    static void listallStu(ArrayList<Student> students)
    {
        System.out.println("\tList all Student ");
        System.out.println("=".repeat(48));
        System.out.printf("| %-5s | %-5s | %-20s | %-5s |%n"
                            ,"No","ID","NAME","Age"
            );
        System.out.println("=".repeat(48));
        for (int i = 0 ; i <students.size() ;i++)
        {
            Student s = students.get(i);
            System.out.printf("| %-5d | %-5d | %-20s | %-5d |%n"
                            ,(i+1),s.id,s.name,s.age
            );
        }
        System.out.println("=".repeat(48));
    }
}
public class task2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int count= 1 ,countDelete = 1;
        int[] idDel = new int[100];
        while(true)
        {
            System.out.println("===== Menu ======");
            System.out.println("1. Add new student");
            System.out.println("2. Delete multiple student");
            System.out.println("3. Quit");
            int choice = sc.nextInt();
            if (choice == 1 )
            {
                while (true)
                {
                    System.out.println("Student #"+count+" : ");
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
                    System.out.print("Do you want to add more(y/n) ? : ");
                    String ch = sc.nextLine();
                    if(ch.toLowerCase().equals("n")){break;}
                    
                }
                Student.listallStu(students);
            }
            else if(choice == 2)
            {
                System.out.println("===== DELETION =====");
                while (true)
                {
                    System.out.print("Input Student #"+countDelete+" Id : ");
                    idDel[countDelete-1] = sc.nextInt();
                    sc.nextLine();
                    countDelete++;
                    System.out.print("Do you want to add more(y/n) ? : ");
                    String ch = sc.nextLine();   
                    if(ch.toLowerCase().equals("n")){break;}
                }
                for(int i = 0 ; i < countDelete;i++)
                {
                    if(students.removeIf(s -> s.getId()== idDel[0]))
                    {
                        System.out.println("Student with ID "+idDel[i]+" Deleted");
                    }
                    else {
                        System.out.println("Student with ID "+idDel[i]+" Not found!");
                    }
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
