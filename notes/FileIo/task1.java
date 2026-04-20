import java.io.PrintWriter;

public class task1{
    public static void main(String[] args)throws Exception{
        PrintWriter writer = new PrintWriter("shopping.txt");
        writer.println("Apple\nBread\nMilk\nEggs\nButter");
        writer.close();
    }
}