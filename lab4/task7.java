class Point{
    void printPoint()
    {
        System.out.println("draw a point. ");
    }
}
class Line extends Point{
    void printLine()
    {
        System.out.println("draw a line. ");
    }
}
class Triangle extends Line{
    void printTriangle()
    {
        System.out.println("draw a triangle");
    }
}
class Rectangle extends Triangle{
    void printRectangle()
    {
        System.out.println("draw rectangle");
    }
}

class ITStudent {
    String name;
    int studentId;
    String department;
    double gpa;

    ITStudent(String name, int studentId, String department, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.department = department;
        this.gpa = gpa;
    }

    void study() {
        System.out.println(name + " is studying IT fundamentals.");
    }

    void displayInfo() {
        System.out.println("--- IT Student Info ---");
        System.out.println("Name       : " + name);
        System.out.println("Student ID : " + studentId);
        System.out.println("Department : " + department);
        System.out.println("GPA        : " + gpa);
    }
}

class ProgrammingStudent extends ITStudent {
    String programmingLanguage;
    int projectsCompleted;

    ProgrammingStudent(String name, int studentId, double gpa,
                       String programmingLanguage, int projectsCompleted) {
        super(name, studentId, "Programming", gpa);
        this.programmingLanguage = programmingLanguage;
        this.projectsCompleted = projectsCompleted;
    }

    void code() {
        System.out.println(name + " is coding in " + programmingLanguage + ".");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Language   : " + programmingLanguage);
        System.out.println("Projects   : " + projectsCompleted);
    }
}

class TelecomStudent extends ITStudent {
    String networkSpecialization;
    boolean hasCertification;

    TelecomStudent(String name, int studentId, double gpa,
                   String networkSpecialization, boolean hasCertification) {
        super(name, studentId, "Telecom", gpa);
        this.networkSpecialization = networkSpecialization;
        this.hasCertification = hasCertification;
    }

    void configureNetwork() {
        System.out.println(name + " is configuring a " + networkSpecialization + " network.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization  : " + networkSpecialization);
        System.out.println("Certified       : " + (hasCertification ? "Yes" : "No"));
    }
}

public class task7 {
    public static void main(String[] args) {
        System.out.println("\tfrom point class");
        Point p = new Point();
        p.printPoint();
        
        System.out.println("\tFrom Line class");
        Line l = new Line();
        l.printPoint();
        l.printLine();

        System.out.println("\tFrom Triangle class");
        Triangle t = new Triangle();
        t.printPoint();
        t.printLine();
        t.printTriangle();

        System.out.println("\tFrom Rectangle class");
        Rectangle r = new Rectangle();
        r.printPoint();
        r.printLine();
        r.printTriangle();
        r.printRectangle();

        ProgrammingStudent ps = new ProgrammingStudent(
            "Alice", 1001, 3.8, "Java", 5
        );

        TelecomStudent ts = new TelecomStudent(
            "Bob", 1002, 3.5, "5G", true
        );

        ps.displayInfo();
        ps.study();       
        ps.code();        
        System.out.println();

        ts.displayInfo();
        ts.study();          
        ts.configureNetwork(); 
    }
}
