public class Car {
    String brand ; 
    String type ; 
    String colour;
    int year;
    double maxSpeed;
    Car(String brand , String type , String colour , int year , double maxSpeed)
    {
        this.brand=brand;
        this.type = type;
        this.colour=colour;
        this.year=year;
        this.maxSpeed=maxSpeed;
    }
    public void printInfo()
    {
        System.out.println("\tInformation of Car");
        System.out.println("Brand : "+brand);
        System.out.println("Type : "+type);
        System.out.println("colour : "+colour);
        System.out.println("Year : "+ year);
        System.out.println("Max Speed : "+maxSpeed);
    }
}
