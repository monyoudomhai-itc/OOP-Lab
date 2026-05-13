import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Scanner;

public class oop72
{
    abstract class NumberRandomizer{
        abstract int randomizeInBetween(int min,int max);
        abstract int[] randomizeUniqueInBetween(int min,int max,int amount);
    }
    class Random extends NumberRandomizer{
        @Override 
        int randomizeInBetween(int min,int max)
        {
            return min + (int)(Math.random() * (max - min + 1));
        }
        @Override
        int[] randomizeUniqueInBetween(int min,int max,int amount)
        {
            int range = max - min + 1;
            if(amount > range) {
                System.out.println("Error: amount cannot exceed the range");
                return new int[0];
            }
            
            Set<Integer> uniqueNumbers = new HashSet<>();
            while(uniqueNumbers.size() < amount) {
                uniqueNumbers.add(randomizeInBetween(min, max));
            }
            
            int[] result = new int[amount];
            int i = 0;
            for(int num : uniqueNumbers) {
                result[i++] = num;
            }
            return result;
        }
    }
    
    public static void main(String[] args)
    {
        oop72 outer = new oop72();
        Random rand = outer.new Random();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n=== Random Number Generator ===");
            System.out.println("1. In Between");
            System.out.println("2. Unique In Between");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int opt = sc.nextInt();
            sc.nextLine();
            
            if(opt == 3) break;
            
            switch(opt) {
                case 1:
                    System.out.print("Enter min value: ");
                    int min1 = sc.nextInt();
                    System.out.print("Enter max value: ");
                    int max1 = sc.nextInt();
                    System.out.println("Random number: " + rand.randomizeInBetween(min1, max1));
                    break;
                case 2:
                    System.out.print("Enter min value: ");
                    int min2 = sc.nextInt();
                    System.out.print("Enter max value: ");
                    int max2 = sc.nextInt();
                    System.out.print("Enter amount of unique numbers: ");
                    int amount = sc.nextInt();
                    int[] uniqueNumbers = rand.randomizeUniqueInBetween(min2, max2, amount);
                    System.out.println("Unique random numbers: " + Arrays.toString(uniqueNumbers));
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        sc.close();
    }
}