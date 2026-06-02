public class Employee{
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    public Employee(int id,String firstName,String lastName,int salary)
    {
        this.id=id;
        this.firstName=firstName;
        this.lastName = lastName;
        this.salary=salary;
    }
    public int getId(){return id;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getName(){ return firstName+" "+lastName;}
    public int getSalary(){return salary;}
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    public int getAnnualSalary(){
        return salary*12;
    }
    public int raiseSalary(int percent){
        salary = salary + (salary * percent) / 100;
        return salary;
    }
    public String toString(){
        return "Employee[id="+id+",name="+getName()+",salary="+salary+"]";
    }
    public static void main(String[] args){
        Employee e = new Employee(1, "John", "Doe", 1000);
        System.out.println("Before: " + e);
        System.out.println("Annual salary: " + e.getAnnualSalary());
        int newSalary = e.raiseSalary(10); 
        System.out.println("After 10% raise, salary = " + newSalary);
        System.out.println("After: " + e);
    }
}