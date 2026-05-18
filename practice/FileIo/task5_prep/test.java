import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class test {

    public static void main(String[] args)throws Exception {
        // PrintWriter writer = new PrintWriter(new FileWriter("text.txt",true));
        // writer.println("hello world. ");
        // writer.close();
        File f = new File("text.txt");
        if(!f.exists())
        {
            f.createNewFile();
        }
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}
