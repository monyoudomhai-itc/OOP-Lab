public class Task4a {
    public static void main(String[] args) {
        System.out.print("   | ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d | ", i); 
        }
        System.out.println("\n-----------------------------------------------------");
        for (int row = 1; row <= 5; row++) {
            System.out.printf("%2d | ", row); 
            
            for (int col = 1; col <= 10; col++) {
                int result = row * col; 
                System.out.printf("%2d | ", result);
            }
            System.out.println();  
        }
    }
}
