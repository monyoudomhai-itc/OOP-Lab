public class Task4b {
    public static void main(String[] args) {
        String c1 = "Germany", n1 = "Michael", p1 = "Computer Engineer"; int a1 = 19;
        String c2 = "England", n2 = "Robert",  p2 = "Artist";            int a2 = 34;
        String c3 = "United Kingdom", n3 = "Julia", p3 = "Designer";     int a3 = 42;
        String c4 = "United States",  n4 = "Jo",    p4 = "Actor";        int a4 = 21;

        String line = "+----------------+---------+-------------------+-----+";

        System.out.println(line);
        System.out.printf("| %-14s | %-7s | %-17s | %-3s |\n", "Country", "Name", "Profession", "Age");
        System.out.println(line);

        System.out.printf("| %-14s | %-7s | %-17s | %-3d |\n", c1, n1, p1, a1);
        System.out.println(line);
        System.out.printf("| %-14s | %-7s | %-17s | %-3d |\n", c2, n2, p2, a2);
        System.out.println(line);
        System.out.printf("| %-14s | %-7s | %-17s | %-3d |\n", c3, n3, p3, a3);
        System.out.println(line);
        System.out.printf("| %-14s | %-7s | %-17s | %-3d |\n", c4, n4, p4, a4);
        System.out.println(line);
    }
}

