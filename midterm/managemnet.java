import java.util.Scanner;
import java.util.ArrayList;

class Student {
    String name;
    int id;
    Student()
    {

    }
    Student(int id,String name)
    {
        this.id= id;
        this.name= name;
    }
    static void display(ArrayList<Student> students)
    {
        for (int i =0;i<students.size();i++)
        {
            Student s = students.get(i);
            System.out.printf("%-5d | %-20s%n",s.id,s.name);
        }
    }
    static void delete(ArrayList<Student> students,int id){
        boolean found = true;
        for (int i =0;i< students.size();i++)
        {
            Student s = students.get(i);
            if(s.id == id)
            {
                found = false;
                students.remove(s);
            }
        }
        if(!found){
            System.out.println("student "+id+"have been delete");
        }
        else{
            System.out.println("student not found.");
        }
    }
    static void update(ArrayList<Student> students ,int id ,Student newStu)
    {
        boolean found = true;
        for (int i =0;i< students.size();i++)
        {
            Student s = students.get(i);
            if(s.id == id)
            {
                found = false;
                students.set(i,newStu);
            }
        }
        if(!found){
            System.out.println("student "+id+"have been update");
        }
        else{
            System.out.println("student not found.");
        }
    }
} 
public class managemnet{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> listStudents = new ArrayList<>();
        while(true)
        {
            System.out.println("==== Menu ====");
            System.out.println("1. view student");
            System.out.println("2. add a new student");
            System.out.println("3. Delete student");
            System.out.println("4. Update student");
            System.out.println("5. exit ");
            System.out.print("opt : ");
            int opt = sc.nextInt();
            sc.nextLine();
            if(opt == 5 )
            {
                System.out.println("Exit program....");
                break;
            }
            switch (opt) {
                case 1:
                    System.out.println("View");
                    Student.display(listStudents);
                    break;
                case 2: 
                    System.out.println("add new student");
                    System.out.print("ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    Student stu = new Student(id, name);
                    listStudents.add(stu);
                    break;
                case 3: 
                    System.out.println("delete student");
                    System.out.print("ID: ");
                    id= sc.nextInt();
                    sc.nextLine();
                    Student.delete(listStudents, id);
                    break;
                case 4:
                    System.out.println("update student");
                    System.out.print("ID: ");
                    id= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Input new ID: ");
                    int newID = sc.nextInt();
                    sc.nextLine();
                    String newName = sc.nextLine();
                    
                    Student.update(listStudents, id, new Student(newID, newName));
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}