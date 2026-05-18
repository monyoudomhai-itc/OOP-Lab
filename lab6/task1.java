import java.util.Scanner;

class AbstractMath{
    int reverseNumber(int num)
    {
        return 0;
    }
    int roundedNumber(double num)
    {
        return 0;
    }
    int countDistinct(int[] values)
    {
        return 0;
    }
    int decimalToBinary(int decimal)
    {
        return 0;
    }
}
class Math extends AbstractMath{
    @Override
    int reverseNumber(int num)
    {
        int reverse = 0;
        while(num != 0)
        {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        
        return reverse;
    }
    @Override
    int roundedNumber(double num)
    {
        int integerPart = (int)num;
        double decimalPart = num - integerPart ;
        if(decimalPart >= 0.5)
        {
            return integerPart + 1;
        }
        else 
        {
            return integerPart;
        }
    }
    @Override
    int countDistinct(int[] values) {
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (values[i] == values[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                count++;
            }
        }

        return count-1;
    }
    @Override
    int decimalToBinary(int decimal) {
        int binary = 0;
        int place = 1;

        while (decimal != 0) {
            int remainder = decimal % 2;
            binary += remainder * place;
            place *= 10;
            decimal /= 2;
        }

        return binary;
    }
}

public class task1 {
    public static void main(String[] args)
    {
        AbstractMath math = new Math();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("==== Menu ====");
            System.out.println("1. Reverse a Number");
            System.out.println("2. Rounded number ");
            System.out.println("3. Count distinct number");
            System.out.println("4. Decimal to Binary");
            System.out.println("5. Quit");
            System.out.print("choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 5 ){
                System.out.println("Exit Porgram ...");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("==== Reverse a number ====");
                    System.out.print("Input number: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.println("output: "+math.reverseNumber(num));
                    break;
                case 2:
                    System.out.println("==== Rounded number ====");
                    System.out.print("Input number: ");
                    double number = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Output is: "+math.roundedNumber(number));
                    break;
                case 3:
                    System.out.println("==== Count distinct number ====");
                    int[] array = new int[100];
                    String ch = "y";
                    int count = 0;
                    while(!ch.equals("n")){
                        System.out.print("input number #"+(count+1)+": ");
                        array[count] = sc.nextInt();
                        sc.nextLine();
                        count++;
                        System.out.print("Do you want to continue?(y/n) : ");
                        ch = sc.nextLine();
                    }
                    System.out.println("Count distinct number: "+math.countDistinct(array));
                    break;
                case 4:
                    System.out.println("==== Decimal to Binary ====");
                    System.out.print("Input number: ");
                    num = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Output: "+math.decimalToBinary(num));
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        sc.close();
    } 
}
