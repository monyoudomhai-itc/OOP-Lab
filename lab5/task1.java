import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Mydate {
    private static final SimpleDateFormat DATE_ONLY = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat DATE_TIME = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final SimpleDateFormat DAY_NAME = new SimpleDateFormat("EEEE");

    static {
        DATE_ONLY.setLenient(false);
    }

    static void getCurrentDate() {
        System.out.println("Current date and time: " + DATE_TIME.format(new Date()));
    }

    static void calculateDayBtwDates(String firstDate, String secondDate) {
        try {
            Date first = DATE_ONLY.parse(firstDate);
            Date second = DATE_ONLY.parse(secondDate);
            long diffMillis = Math.abs(second.getTime() - first.getTime());
            long days = diffMillis / (24L * 60L * 60L * 1000L);
            System.out.println("Total days between: " + days);
        } catch (ParseException e) {
            System.out.println("Invalid date(s). Please use dd/mm/yyyy.");
        }
    }

    static void findDay(String dateValue) {
        try {
            Date date = DATE_ONLY.parse(dateValue);
            System.out.println("That date is a: " + DAY_NAME.format(date));
        } catch (ParseException e) {
            System.out.println("Invalid date. Please use dd/mm/yyyy.");
        }
    }
}

public class task1{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("===== Menu =====");
            System.out.println("1. Current date and time");
            System.out.println("2. Calculate days btw two dates");
            System.out.println("3. Find the day of the week");
            System.out.println("4. Quit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Mydate.getCurrentDate();
                    break;
                case 2:
                    System.out.println("===== Calculate day btw two dates =====");
                    System.out.print("Fist Date(dd/mm/yyyy) : ");
                    String date1 = sc.nextLine();
                    System.out.print("Second Date(dd/mm/yyyy) : ");
                    String date2 = sc.nextLine();
                    Mydate.calculateDayBtwDates(date1, date2);

                    break;
                case 3:
                    System.out.println("===== Find the day of the week =====");
                    System.out.print("Input the date(dd/mm/yyyy) : ");
                    String date = sc.nextLine();
                    Mydate.findDay(date);
                    break;
                default:
                    break;
            }
            if(choice == 4){
                System.out.println("Exit program ....");
                break;
            }
        }
        sc.close();
    }
}