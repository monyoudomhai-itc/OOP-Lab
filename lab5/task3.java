import java.util.Scanner;
import java.util.ArrayList;

class Line{
    protected int length;
    Line(int length)
    {
        this.length=length;
    }
    int getLength()
    {
        return length;
    }
    static void listLine(ArrayList<Line> lines)
    {
        System.out.println("=== List all lines ===");
        for(int i = 0;i<lines.size();i++)
        {
        System.out.println("length : "+lines.get(i).getLength());
        System.out.println("_".repeat(lines.get(i).getLength()));   
        }
    }
}
class Rectangle extends Line{
    protected int h,w;
    Rectangle(int w , int h)
    {
        super(h);
        this.w=w;
        this.h=h;
    }
    static void listRec(ArrayList<Rectangle> rectangles)
    {
        System.out.println("==== List all Rectangle ====");
        if(rectangles.isEmpty())
        {
            System.out.println("No rectangles to show.\n");
            return;
        }
        for(int i = 0; i < rectangles.size(); i++)
        {
            Rectangle r = rectangles.get(i);
            System.out.println("Rectangle #" + (i + 1) + " (w=" + r.w + ", h=" + r.h + ")");
            for(int row = 0; row < r.h; row++)
            {
                if(row == 0 || row == r.h - 1 || r.h == 1)
                {
                    System.out.println("*".repeat(Math.max(0, r.w)));
                }
                else if(r.w <= 1)
                {
                    System.out.println("*");
                }
                else
                {
                    System.out.println("*" + " ".repeat(r.w - 2) + "*");
                }
            }
            System.out.println();
        }
    }
}
class Triangle extends Rectangle {
    Triangle(int w, int h)
    {
        super(w, h);
    }
    static void listTri(ArrayList<Triangle> triangles)
    {
        System.out.println("==== List all Triangle ====");
        if(triangles.isEmpty())
        {
            System.out.println("No triangles to show.\n");
            return;
        }
        for(int i = 0; i < triangles.size(); i++)
        {
            Triangle t = triangles.get(i);
            System.out.println("Triangle #" + (i + 1) + " (base=" + t.w + ", height=" + t.h + ")");
            for(int row = 1; row <= t.h; row++)
            {
                int stars = Math.max(1, (int)Math.round((double)t.w * row / t.h));
                if(row == 1 || row == t.h || stars <= 2)
                {
                    System.out.println("*".repeat(stars));
                }
                else
                {
                    System.out.println("*" + " ".repeat(stars - 2) + "*");
                }
            }
            System.out.println();
        }
    }
}
public class task3 {
    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<>();
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        ArrayList<Triangle> triangles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("==== Menu =====");
            System.out.println("1. view all lines");
            System.out.println("2. view all rectanlge");
            System.out.println("3. view all triangle");
            System.out.println("4. add a new Shape");
            System.out.println("5. Quit");
            System.out.print("Choioce : ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    if(lines.isEmpty())
                    {
                        System.out.println("No lines to show.\n");
                    }
                    else
                    {
                        Line.listLine(lines);
                    }
                    break;
                case 2:
                    Rectangle.listRec(rectangles);
                    break;
                case 3:
                    Triangle.listTri(triangles);
                    break;
                case 4:
                    System.out.println("==== Add Shape ====");
                    System.out.println("1. Line");
                    System.out.println("2. Rectangle");
                    System.out.println("3. Triangle");
                    System.out.print("Shape type: ");
                    int shapeChoice = sc.nextInt();
                    if(shapeChoice == 1)
                    {
                        System.out.print("Input line length: ");
                        int length = sc.nextInt();
                        if(length > 0)
                        {
                            lines.add(new Line(length));
                        }
                        else
                        {
                            System.out.println("Length must be positive.");
                        }
                    }
                    else if(shapeChoice == 2)
                    {
                        System.out.print("Input rectangle width: ");
                        int width = sc.nextInt();
                        System.out.print("Input rectangle height: ");
                        int height = sc.nextInt();
                        if(width > 0 && height > 0)
                        {
                            rectangles.add(new Rectangle(width, height));
                        }
                        else
                        {
                            System.out.println("Width and height must be positive.");
                        }
                    }
                    else if(shapeChoice == 3)
                    {
                        System.out.print("Input triangle base width: ");
                        int width = sc.nextInt();
                        System.out.print("Input triangle height: ");
                        int height = sc.nextInt();
                        if(width > 0 && height > 0)
                        {
                            triangles.add(new Triangle(width, height));
                        }
                        else
                        {
                            System.out.println("Width and height must be positive.");
                        }
                    }
                    else
                    {
                        System.out.println("Unknown shape type.");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice, try again.\n");
            }
            if(choice == 5)
            {
                break;
            }
        }
        sc.close();
    }
}
