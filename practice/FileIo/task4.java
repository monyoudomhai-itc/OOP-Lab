import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    int age;
    String name;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Teacher {
    
}

public class task4 {

    public static ArrayList<Student> students = new ArrayList<>();
    public static File file = new File("student.txt");

    public static void main(String[] args) throws Exception {

        System.out.println("Write program store student info txt");

        students.add(new Student("Tolla", 20));
        students.add(new Student("Kompheak", 22));
        students.add(new Student("Srey", 21));

        addToFile(students);
        display();
    }

    static void addToFile(ArrayList<Student> students) throws Exception {
        PrintWriter writer = new PrintWriter(file);

        for (Student s : students) {
            writer.println(s.name + "," + s.age);
        }

        writer.close();
    }

    static void display() throws Exception {
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] array = line.split(",");

            System.out.println("Name: " + array[0] + " | Age: " + array[1]);
        }

        reader.close();
    }
}