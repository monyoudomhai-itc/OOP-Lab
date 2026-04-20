import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String firstName;
    String lastName;
    String email;
    String gender;

    Person(String firstName, String lastName, String gender, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
    }

    String fullName() {
        return firstName + " " + lastName;
    }
}

class Teacher extends Person {
    float sal;
    String subject;

    Teacher(String firstName, String lastName, String gender, String email, String subject, float sal) {
        super(firstName, lastName, gender, email);
        this.sal = sal;
        this.subject = subject;
    }

    String toFileString() {
        return firstName + "|" + lastName + "|" + gender + "|" + email + "|" + subject + "|" + sal;
    }

    static Teacher fromFileString(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length != 6) {
            return null;
        }
        try {
            float salary = Float.parseFloat(parts[5]);
            return new Teacher(parts[0], parts[1], parts[2], parts[3], parts[4], salary);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    String viewString() {
        return "[" + fullName() + "][" + gender + "][" + email + "][" + subject + "][" + formatMoney(sal) + "$]";
    }

    private String formatMoney(float value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}

class Student extends Person {
    int year;
    String major;

    Student(String firstName, String lastName, String gender, String email, int year, String major) {
        super(firstName, lastName, gender, email);
        this.year = year;
        this.major = major;
    }

    String toFileString() {
        return firstName + "|" + lastName + "|" + gender + "|" + email + "|" + year + "|" + major;
    }

    static Student fromFileString(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length != 6) {
            return null;
        }
        try {
            int studentYear = Integer.parseInt(parts[5 - 1]);
            return new Student(parts[0], parts[1], parts[2], parts[3], studentYear, parts[5]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    String viewString() {
        return "[" + fullName() + "][" + gender + "][" + email + "][" + year + "][" + major + "]";
    }
}

class SecurityGuard extends Person {
    String position;

    SecurityGuard(String firstName, String lastName, String gender, String email, String position) {
        super(firstName, lastName, gender, email);
        this.position = position;
    }

    String toFileString() {
        return firstName + "|" + lastName + "|" + gender + "|" + email + "|" + position;
    }

    static SecurityGuard fromFileString(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length != 5) {
            return null;
        }
        return new SecurityGuard(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }

    String viewString() {
        return "[" + fullName() + "][" + gender + "][" + email + "][" + position + "]";
    }
}

public class task5 {
    private static final String TEACHER_FILE = "teacher.txt";
    private static final String STUDENT_FILE = "student.txt";
    private static final String SECURITY_GUARD_FILE = "securityguard.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1. View all");
            System.out.println("2. Add new");
            System.out.println("3. Quit");
            int choice = readInt(sc, "Choose an option: ");

            if (choice == 1) {
                viewAll();
            } else if (choice == 2) {
                addNew(sc);
            } else if (choice == 3) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        sc.close();
    }

    private static void addNew(Scanner sc) {
        System.out.println("==== Add new resource ====");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Security guard");
        int type = readInt(sc, "Choose an option: ");

        if (type == 1) {
            Teacher teacher = readTeacher(sc);
            appendLine(TEACHER_FILE, teacher.toFileString());
            System.out.println("Teacher added.\n");
        } else if (type == 2) {
            Student student = readStudent(sc);
            appendLine(STUDENT_FILE, student.toFileString());
            System.out.println("Student added.\n");
        } else if (type == 3) {
            SecurityGuard guard = readSecurityGuard(sc);
            appendLine(SECURITY_GUARD_FILE, guard.toFileString());
            System.out.println("Security guard added.\n");
        } else {
            System.out.println("Unknown type!\n");
        }
    }

    private static Teacher readTeacher(Scanner sc) {
        String firstName = readLine(sc, "First Name: ");
        String lastName = readLine(sc, "Last Name: ");
        String sex = readLine(sc, "Sex: ");
        String email = readLine(sc, "Email: ");
        String subject = readLine(sc, "Subject: ");
        float salary = readFloat(sc, "Salary: ");
        return new Teacher(firstName, lastName, sex, email, subject, salary);
    }

    private static Student readStudent(Scanner sc) {
        String firstName = readLine(sc, "First Name: ");
        String lastName = readLine(sc, "Last Name: ");
        String sex = readLine(sc, "Sex: ");
        String email = readLine(sc, "Email: ");
        int year = readInt(sc, "Year: ");
        String major = readLine(sc, "Major: ");
        return new Student(firstName, lastName, sex, email, year, major);
    }

    private static SecurityGuard readSecurityGuard(Scanner sc) {
        String firstName = readLine(sc, "First Name: ");
        String lastName = readLine(sc, "Last Name: ");
        String sex = readLine(sc, "Sex: ");
        String email = readLine(sc, "Email: ");
        String position = readLine(sc, "Position: ");
        return new SecurityGuard(firstName, lastName, sex, email, position);
    }

    private static void viewAll() {
        ArrayList<Teacher> teachers = loadTeachers();
        ArrayList<Student> students = loadStudents();
        ArrayList<SecurityGuard> guards = loadSecurityGuards();

        System.out.println("==== Teacher ====");
        printTeacherList(teachers);
        System.out.println();

        System.out.println("==== Student ====");
        printStudentList(students);
        System.out.println();

        System.out.println("==== Security guard ====");
        printGuardList(guards);
        System.out.println();
    }

    private static ArrayList<Teacher> loadTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<String> lines = readAllLines(TEACHER_FILE);
        for (String line : lines) {
            Teacher t = Teacher.fromFileString(line);
            if (t != null) {
                teachers.add(t);
            }
        }
        return teachers;
    }

    private static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> lines = readAllLines(STUDENT_FILE);
        for (String line : lines) {
            Student s = Student.fromFileString(line);
            if (s != null) {
                students.add(s);
            }
        }
        return students;
    }

    private static ArrayList<SecurityGuard> loadSecurityGuards() {
        ArrayList<SecurityGuard> guards = new ArrayList<>();
        ArrayList<String> lines = readAllLines(SECURITY_GUARD_FILE);
        for (String line : lines) {
            SecurityGuard g = SecurityGuard.fromFileString(line);
            if (g != null) {
                guards.add(g);
            }
        }
        return guards;
    }

    private static void printTeacherList(ArrayList<Teacher> teachers) {
        if (teachers.isEmpty()) {
            System.out.println("No data");
            return;
        }
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).viewString());
        }
    }

    private static void printStudentList(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No data");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).viewString());
        }
    }

    private static void printGuardList(ArrayList<SecurityGuard> guards) {
        if (guards.isEmpty()) {
            System.out.println("No data");
            return;
        }
        for (int i = 0; i < guards.size(); i++) {
            System.out.println((i + 1) + ". " + guards.get(i).viewString());
        }
    }

    private static ArrayList<String> readAllLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            return lines;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading " + fileName);
        }

        return lines;
    }

    private static void appendLine(String fileName, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing " + fileName);
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number.");
            }
        }
    }

    private static float readFloat(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number.");
            }
        }
    }

    private static String readLine(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field is required.");
        }
    }
}