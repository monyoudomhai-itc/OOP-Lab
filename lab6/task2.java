import java.util.ArrayList;
import java.util.Scanner;

class Maths{
    int sum(int a, int b)
    {
        return a+b;
    }
    int sum(int a,int b,int c)
    {
        return a+b+c;
    }
    int sum(int[] values)
    {
        int sum = 0;
        for (int i = 0;i< values.length;i++)
        {
            sum += values[i];
        }
        return sum;
    }
    int multiply(int a,int b)
    {
        return a*b;
    }
    int multiply(int a,int b,int c)
    {
        return a*b*c;
    }
    int multiply(ArrayList<Integer> num)
    {
        int result= 1;
        for(int i = 0 ;i< num.size();i++)
        {
            result *= num.get(i);
        }
        return result;
    }
    int max(int a,int b, int c)
    {
        int max = a;
        if(b > max)
        {
            max = b;
        }
        if(c > max){
            max  = c;
        }
        return max;
    }
    int max(int a, int b)
    {
        if (a > b) {
            return a;
        }
        return b;
    }
    int max(ArrayList<Integer> num)
    {
        if (num.isEmpty()) {
            return 0;
        }

        int max = num.get(0);
        for (int i = 1; i < num.size(); i++) {
            if (num.get(i) > max) {
                max = num.get(i);
            }
        }
        return max;
    }
    int min(int a,int b,int c)
    {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }
    int min(int a, int b)
    {
        if (a < b) {
            return a;
        }
        return b;
    }
    int min(ArrayList<Integer> num)
    {
        if (num.isEmpty()) {
            return 0;
        }

        int min = num.get(0);
        for (int i = 1; i < num.size(); i++) {
            if (num.get(i) < min) {
                min = num.get(i);
            }
        }
        return min;
    }
    double average(int a, int b)
    {
        return (a + b) / 2.0;
    }
    double average(int a, int b, int c)
    {
        return (a + b + c) / 3.0;
    }
    double average(ArrayList<Integer> num)
    {
        if (num.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            sum += num.get(i);
        }
        return (double) sum / num.size();
    }
}
public class task2{
    static ArrayList<Integer> readList(Scanner sc)
    {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("How many numbers? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Input number #" + (i + 1) + ": ");
            int value = sc.nextInt();
            sc.nextLine();
            list.add(value);
        }
        return list;
    }

    public static void main(String[] args)
    {
        Maths math = new Maths();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Sum of two values");
            System.out.println("2. Sum of three values");
            System.out.println("3. Sum of many values");
            System.out.println("4. Multiply of two values");
            System.out.println("5. Multiply of three values");
            System.out.println("6. Multiply of many values");
            System.out.println("7. Max of two values");
            System.out.println("8. Max of three values");
            System.out.println("9. Max of many values");
            System.out.println("10. Min of two values");
            System.out.println("11. Min of three values");
            System.out.println("12. Min of many values");
            System.out.println("13. Average of two values");
            System.out.println("14. Average of three values");
            System.out.println("15. Average of many values");
            System.out.println("16. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 16) {
                System.out.println("Exit program...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Input a: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    int b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.sum(a, b));
                    break;
                case 2:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input c: ");
                    int c = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.sum(a, b, c));
                    break;
                case 3:
                    ArrayList<Integer> sumList = readList(sc);
                    int[] values = new int[sumList.size()];
                    for (int i = 0; i < sumList.size(); i++) {
                        values[i] = sumList.get(i);
                    }
                    System.out.println("Result: " + math.sum(values));
                    break;
                case 4:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.multiply(a, b));
                    break;
                case 5:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input c: ");
                    c = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.multiply(a, b, c));
                    break;
                case 6:
                    ArrayList<Integer> multiplyList = readList(sc);
                    System.out.println("Result: " + math.multiply(multiplyList));
                    break;
                case 7:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.max(a, b));
                    break;
                case 8:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input c: ");
                    c = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.max(a, b, c));
                    break;
                case 9:
                    ArrayList<Integer> maxList = readList(sc);
                    System.out.println("Result: " + math.max(maxList));
                    break;
                case 10:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.min(a, b));
                    break;
                case 11:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input c: ");
                    c = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.min(a, b, c));
                    break;
                case 12:
                    ArrayList<Integer> minList = readList(sc);
                    System.out.println("Result: " + math.min(minList));
                    break;
                case 13:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.average(a, b));
                    break;
                case 14:
                    System.out.print("Input a: ");
                    a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input b: ");
                    b = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input c: ");
                    c = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + math.average(a, b, c));
                    break;
                case 15:
                    ArrayList<Integer> averageList = readList(sc);
                    System.out.println("Result: " + math.average(averageList));
                    break;
                default:
                    System.out.println("Invalid menu option.");
                    break;
            }
        }
        sc.close();
    }
}