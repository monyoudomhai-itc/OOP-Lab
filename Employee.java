public class Employee {
    String name; 
    int employeeID;
    double salary;
    char gender;
    String position;
    double bonus;
    Employee(String name,int employeeID,double salary,char gender,String position,double bonus)
    {
        this.name=name;
        this.employeeID=employeeID;
        this.salary=salary;
        this.gender = gender;
        this.position=position;
        this.bonus=bonus;
    }
    public void printInfo()
    {
        System.out.println("\tInformation of Employee");
        System.out.println("Name : "+name);
        System.out.println("EmployeeID : "+employeeID);
        System.out.println("Gender : "+gender);
        System.out.println("Position : "+position);
        System.out.println("Salary : $"+salary);
        System.out.println("Bonus : $"+bonus);
        System.out.println("Total Salary : $"+(salary+bonus));
        System.out.println("-".repeat(40));
    }
}
