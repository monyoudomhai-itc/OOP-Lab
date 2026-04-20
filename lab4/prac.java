/*Write Student manangemnt system  allow to list delete and add*/
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    String name, birthDate;
    int id;
    Student (int id ,String name,String birthDate)
    {
        this.id=id;
        this.name=name;
        this.birthDate=birthDate;
    }
    static void listStudent(ArrayList<Student> students)
    {
        System.out.println("===== LIST ALL STUDENTS =====");
        System.out.println("=".repeat(53));
        System.out.printf("| %-5s | %-5s | %-20s | %-10s |%n"
                        ,"No","ID","Name","Birth date");
        System.out.println("=".repeat(53));
        if(students != null){
        for (int i = 0 ; i < students.size();i++)
        {
            Student s = students.get(i);
            System.out.printf("| %-5d | %-5d | %-20s | %-10s |%n"
                        ,(i+1),s.id,s.name,s.birthDate);
        }

        }
        else{
            System.out.println("No Students registered yet...");
        }
        System.out.println("=".repeat(53));
    }
    int getId(){
        return id;
    }
    static boolean deleteStudent(ArrayList<Student> students, int id) {
    return students.removeIf(s -> s.getId() == id);
}
}
public class prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true)
        {
            System.out.println("===== Menu =====");
            System.out.println("1. List all students");
            System.out.println("2. add new student ");
            System.out.println("3. Delete student ");
            System.out.println("4. Quit ");
            System.out.print("Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Student.listStudent(students);
                    break;
                case 2:
                    System.out.println("===== Add new Student =====");
                    System.out.print("ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Birth Date : ");
                    String date = sc.nextLine();
                    students.add(new Student(id, name, date));
                    System.out.println("Student "+id+" added successful");
                    break;
                case 3:
                    System.out.println("===== Delete Student ======");
                    System.out.print("Please input id of student you want to delete : ");
                    id  = sc.nextInt();
                    sc.nextLine();
                    // if (Student.deleteStudent(students, id)) {
                    //     System.out.println("Deleted!");
                    // } else {
                    //     System.out.println("Not found!");
                    // }
                   if(students.removeIf(s -> s.getId() == id))
                   {
                    System.out.println("deleted .");
                   }
                   else {
                    System.out.println("not found");
                   }
                    break;
                default:
                    break;
            }
            if(choice == 4)
                {
                    System.out.println("Exit program ...");
                    break;
                }
        }
        sc.close();
    }
}
