class Student {
    int id;
    String name;
    String gender;
    int age;
    String major;
    Student next;

    public Student(int id, String name, String gender, int age, String major) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.next = null;
    }
}

class StudentList {
    private Student head;
    private int size;

    public StudentList() {
        head = null;
        size = 0;
    }

    public void add(Student student) {
        if (head == null) {
            head = student;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = student;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of range");
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Student current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Array is emply");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Student current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void display() {
        if (head == null) {
            System.out.println("Array is emply");
            return;
        }

        Student current = head;
        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" ,");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class task6 {
    public static void main(String[] args) {
        StudentList list = new StudentList();

        list.add(new Student(1, "Makara", "Male", 20, "CS"));
        list.add(new Student(2, "Kompheak", "Male", 21, "IT"));
        System.out.println("\tDisplay Student in array");
        list.display();

        list.removeLast();
        System.out.println("\tAfter remove");
        list.display();
        list.add(new Student(3, "Minea", "Female", 19, "CS"));
        list.add(new Student(4, "Mehsa", "Female", 20, "IT"));
        System.out.println("\tAdd new Student");
        list.display();

        list.remove(10);

        list.clear();
        System.out.println("\tAfter clear all element");
        list.display();
    }
}
