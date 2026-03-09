import java.util.Scanner;

public class Task5b {
    Scanner input = new Scanner(System.in);
    public void main (String[] args)
    {
        System.out.println("Cut the word 7 chacrater ");
        System.out.print("Please enter text: ");
        String text = input.nextLine();
        String result = text.substring(7);
        System.out.println("Result : "+result);
    }
}
