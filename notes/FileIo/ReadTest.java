import java.io.File;
import java.util.Scanner;

public class ReadTest {
   public static void main(String[] args)throws Exception
   {
    File file = new File("file.txt");
    Scanner scanner = new Scanner(file);
    while(scanner.hasNextLine())
    {
        String line = scanner.nextLine();
        System.out.println(line);
    }
    scanner.close();
   }
}