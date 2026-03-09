import java.util.Scanner;

public class Task5c {
    Scanner input = new Scanner(System.in);
    public void main (String[] args)
    {
        System.out.println("Find the index position of vowel ");
        System.out.print("Please input text : ");
        String text = input.nextLine();
        int num = text.length();
        String textLower = text.toLowerCase();
        char[] characters = textLower.toCharArray();
        for (int i = 0; i < num ; i++)
        {
            if (characters[i] == 'a'|| characters[i]=='e'|| characters[i] == 'o'||characters[i]=='i'|| characters[i]=='u')
            {
                System.out.println("\""+characters[i]+"\" is at index: "+ i);
            }
        }
    }
}
