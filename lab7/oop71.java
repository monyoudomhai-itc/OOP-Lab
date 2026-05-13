import java.util.Scanner;

abstract class ShapeArea{
    abstract double calculateRectangleArea(double w , double h);
    abstract double calculateCircleArea(double r);
    abstract double calculateTriangleArea(double a,double b,double c);
    abstract double calculateTriangleArea(double base,double height);
    abstract double calculateSemiCircle(double r);
    abstract double calculateSectorArea(double r , double angle);
}
class GeometryArea extends ShapeArea{
    @Override
    double calculateRectangleArea(double w,double h)
    {
        return w*h;
    }
    @Override
    double calculateCircleArea(double r)
    {
        return Math.PI*r*r;
    }
    @Override
    double calculateTriangleArea(double a,double b,double c)
    {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    double calculateTriangleArea(double base,double height)
    {
        return (base * height) / 2;
    }
    @Override
    double calculateSemiCircle(double r)
    {
        return (Math.PI * r * r) / 2;
    }
    @Override
    double calculateSectorArea(double r, double angle)
    {
        return (Math.PI * r * r * angle) / 360;
    }
}
public class oop71{
    public static void main(String[] args)
    {
        Scanner sc =  new Scanner(System.in);
        GeometryArea geo = new GeometryArea();
        
        while(true)
        {
            System.out.println("=== Shape Area Calculation ===");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Triangle (three sides)");
            System.out.println("4. Triangle (based and height)");
            System.out.println("5. Semi circle");
            System.out.println("6. Sector");
            System.out.println("7. Quit");
            System.out.print("Choose an opt: ");
            int opt = sc.nextInt();
            sc.nextLine();
            
            if(opt == 7) break;
            
            switch(opt) {
                case 1:
                    System.out.print("Enter width: ");
                    double w = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double h = sc.nextDouble();
                    System.out.println("Area of Rectangle: " + geo.calculateRectangleArea(w, h));
                    break;
                case 2:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    System.out.println("Area of Circle: " + geo.calculateCircleArea(r));
                    break;
                case 3:
                    System.out.print("Enter side a: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter side b: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter side c: ");
                    double c = sc.nextDouble();
                    System.out.println("Area of Triangle: " + geo.calculateTriangleArea(a, b, c));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();
                    System.out.println("Area of Triangle: " + geo.calculateTriangleArea(base, height));
                    break;
                case 5:
                    System.out.print("Enter radius: ");
                    double r5 = sc.nextDouble();
                    System.out.println("Area of Semi Circle: " + geo.calculateSemiCircle(r5));
                    break;
                case 6:
                    System.out.print("Enter radius: ");
                    double r6 = sc.nextDouble();
                    System.out.print("Enter angle (in degrees): ");
                    double angle = sc.nextDouble();
                    System.out.println("Area of Sector: " + geo.calculateSectorArea(r6, angle));
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println();
        }
        sc.close();
    }
}