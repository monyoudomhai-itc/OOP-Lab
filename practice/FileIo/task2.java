import java.util.Scanner;
import java.io.File;
public class task2
{
    public static void main(String[] args)throws Exception{
        File files = new File("shopping.txt");
        Scanner scanner = new Scanner(files);
        int count = 1;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(count+". "+line);
            count++;
        }
        scanner.close();
    }
}