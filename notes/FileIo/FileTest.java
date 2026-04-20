import java.io.PrintWriter;

public class FileTest {
    public static void main(String[] args)throws Exception{
        PrintWriter writer = new PrintWriter("file.txt");
        writer.println("Hello world");
        writer.println("More text");
        writer.close();
    }
}