public class Task6 {
    public void main (String[] args)
    {
        Employee e1 = new Employee("Ratana", 12, 300, 'F', "Intern", 15);
        Employee e2 = new Employee("Dom", 1, 10000, 'M', "Manager", 2000);

        e1.printInfo();
        e2.printInfo();

        Car car1 = new Car("Ferrari", "Super Sport", "Red", 2023, 200);
        Car car2 = new Car("Lexus", "SUV", "Black", 2010, 100);

        car1.printInfo();
        car2.printInfo();

        BankAccount b1 = new BankAccount("Dom", 102, "ewd", 200, null);
        b1.printInfo();

        Video v1 = new Video("Ratan", null, 0, null, null);
        v1.printInfo();
    }
}
