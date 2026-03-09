import java.util.Scanner;

public class Task5d {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] text = new String[3];
        
        for (int i = 0 ; i < 3 ; i++)
        {
            System.out.print("Please input text"+(i+1)+" :");
            text[i] = input.nextLine();
        }
        System.out.println("Text1 is equal to Text2: " + text[0].equals(text[1]));
        System.out.println("Text1 is equal to Text3: " + text[0].equals(text[2]));
    }
}

