import java.util.Scanner;
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

    static void listStudentNormal(Student[] students)
    {
        System.out.println("=".repeat(56));
        System.out.printf("| %-6s | %-6s | %-25s | %-6s |%n", "No", "ID", "Name", "Age");
        System.out.println("=".repeat(56));
        int displayCount = 0;
        for(int i = 0 ; i < students.length;i++)
        {
            Student s = students[i];
            if(s != null) {
                System.out.printf("| %-6s | %-6s | %-25s | %-6s |%n", (i+1), s.id, s.name, s.age);
                displayCount++;
            }
        }
        if(displayCount == 0) {
            System.out.println("No students to display.");
        }
        System.out.println("=".repeat(56));

    }
    static boolean deleteStudentById(Student[] stus, int id) {
    for (int i = 0; i < stus.length; i++) {

        if (stus[i] != null && stus[i].getId() == id) {

            // shift left
            for (int j = i; j < stus.length - 1; j++) {
                stus[j] = stus[j + 1];
            }

            stus[stus.length - 1] = null; // clear last
            return true;
        }
    }
    return false;
}

}
public class task2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Student[] students= new Student[100];
        int count = 0;

        while(true)
        {
        System.out.println("=== Menu===");
        System.out.printf("%-25s >%n","1. View all students");
        System.out.printf("%-25s >%n","2. Add a new student");
        System.out.printf("%-25s >%n","3. Delete a student");
        System.out.printf("%-25s >%n","4. Quit");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                Student.listStudentNormal(students);
                break;
            case 2:
                if(count < 100) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    students[count] = new Student(id, name, age);
                    count++;
                    System.out.println("Student added successfully!");
                } else {
                    System.out.println("Array is full!");
                }
                break;
            case 3:
                System.out.print("Enter ID to delete: ");
                int delId = sc.nextInt();
                sc.nextLine();
                if(Student.deleteStudentById(students, delId)) {
                    System.out.println("Student deleted successfully!");
                    count--;
                } else {
                    System.out.println("Student not found!");
                }
                break;
            case 4:
                System.out.println("Exit Program...");
                break;
                
            default:
                System.out.println("Invalid choice!");
                break;
        }
        if(choice == 4){break;}
        }
        sc.close();
    }   

}
