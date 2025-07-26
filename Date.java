import java.time.LocalDate;
import java.util.Scanner;
public class Date 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year (4 digits): ");
        int year = sc.nextInt();
        System.out.print("Enter day number (1 to 366): ");
        int dayNumber = sc.nextInt();
        System.out.print("Enter N (days to add, 1 to 100): ");
        int N = sc.nextInt();

        LocalDate date = LocalDate.ofYearDay(year, dayNumber); //Convert day number to actual date
        String formattedOgDate = formatDateWithSuffix(date);
        LocalDate futureDate = date.plusDays(N);
        String formattedFutureDate = formatDateWithSuffix(futureDate);
        System.out.println("\nDate: " + formattedOgDate);
        System.out.println("Date after " + N + " days: " + formattedFutureDate);
    }
    public static String formatDateWithSuffix(LocalDate date) 
    {
        int day = date.getDayOfMonth();
        String suffix;
        if (day >= 11 && day <= 13) 
        {
            suffix = "th";
        } else 
        {
            switch (day % 10) 
            {
                case 1:  suffix = "st"; break;
                case 2:  suffix = "nd"; break;
                case 3:  suffix = "rd"; break;
                default: suffix = "th"; break;
            }
        }
        String month = date.getMonth().toString().substring(0, 1) + date.getMonth().toString().substring(1).toLowerCase();
        return day + suffix + " " + month + " " + date.getYear();
    }
}
