import java.util.Scanner;

public class Task5e {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] text = new String[3];
        
        for (int i = 0 ; i < 3 ; i++)
        {
            System.out.print("Please input text"+(i+1)+" :");
            text[i] = input.nextLine();
        }
        System.out.println("Text1 is contain to Text2: " + text[0].contains(text[1]));
        System.out.println("Text1 is contain to Text3: " + text[0].contains(text[2]));
    }
}

