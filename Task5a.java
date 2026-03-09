import java.util.Scanner;

public class Task5a {
    Scanner sc = new Scanner(System.in);
    public void main (String[] args)
    {
        System.out.println("Calculate length of text");
        System.out.print("Please Input text : ");
        String text = sc.nextLine();
        int num = text.length();
        System.out.println("Text Lenght is "+num);
    }
}
