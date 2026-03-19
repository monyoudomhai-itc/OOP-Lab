import java.util.Scanner;

class Math{
    int a,b;
    static int add(int a,int b)
    {
        return a+b;
    }
    static int subtract(int a,int b)
    {
        return a-b;
    }
    static int multiply(int a,int b)
    {
        return a*b;
    }
    static int divide(int a,int b)
    {
        return a/b;
    }
    static int min(int a,int b)
    {
        if(a < b){return a;}
        else {return b;}
    }
    static int max(int a ,int b)
    {
        if(a > b){return a;}
        else {return b;}
    }
}
public class task5 {
        public static void main(String[] args) {
            System.out.println("Add : "+Math.add(5,7));
            System.out.println("Substract : "+Math.subtract(5, 7));
            System.out.println("Multiply : "+Math.multiply(5, 7));
            System.out.println("Divide : "+Math.divide(5, 7));
            System.out.println("Maximum : "+Math.max(5, 7));
            System.out.println("Minimum : "+Math.min(5, 7));
        }
}
