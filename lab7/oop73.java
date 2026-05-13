import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Scanner;

abstract class TextRandomizer {
    abstract char randomizeACharacter();
    abstract String randomizeAString(int length);
    abstract String[] randomizeUniqueStrings(int lenght ,int amount);
}

class StringRandomizer extends TextRandomizer {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    @Override
    char randomizeACharacter() {
        int randomIndex = (int)(Math.random() * ALPHABET.length());
        return ALPHABET.charAt(randomIndex);
    }
    
    @Override
    String randomizeAString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            sb.append(randomizeACharacter());
        }
        return sb.toString();
    }
    
    @Override
    String[] randomizeUniqueStrings(int lenght, int amount) {
        Set<String> uniqueStrings = new HashSet<>();
        while(uniqueStrings.size() < amount) {
            uniqueStrings.add(randomizeAString(lenght));
        }
        
        String[] result = new String[amount];
        int i = 0;
        for(String str : uniqueStrings) {
            result[i++] = str;
        }
        return result;
    }
}

public class oop73 {
    public static void main(String[] args) {
        StringRandomizer randomizer = new StringRandomizer();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n==== Text Randomizer ====");
            System.out.println("1. A Character");
            System.out.println("2. A String");
            System.out.println("3. Unique Strings");
            System.out.println("4. Quit");
            System.out.print("Choose an opt: ");
            int opt = sc.nextInt();
            sc.nextLine();
            
            if(opt == 4) break;
            
            switch(opt) {
                case 1:
                    System.out.println("Randomized Character: " + randomizer.randomizeACharacter());
                    break;
                case 2:
                    System.out.print("Enter string length: ");
                    int length = sc.nextInt();
                    System.out.println("Randomized String: " + randomizer.randomizeAString(length));
                    break;
                case 3:
                    System.out.print("Enter string length: ");
                    int len = sc.nextInt();
                    System.out.print("Enter amount of unique strings: ");
                    int amount = sc.nextInt();
                    String[] uniqueStrings = randomizer.randomizeUniqueStrings(len, amount);
                    System.out.println("Unique Randomized Strings: " + Arrays.toString(uniqueStrings));
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        sc.close();
    }
}
