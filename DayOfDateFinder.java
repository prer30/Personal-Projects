import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class DayOfDateFinder 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (dd/mm/yyyy): ");
        String dateInput = sc.nextLine();
        System.out.print("Enter day on 1st January of that year: ");
        String jan1Day = sc.nextLine().trim().toLowerCase();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate inputDate = LocalDate.parse(dateInput, formatter);
        LocalDate jan1 = LocalDate.of(inputDate.getYear(), 1, 1);

        long daysBetween = ChronoUnit.DAYS.between(jan1, inputDate);
        String[] daysOfWeek = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        int jan1Index = -1;
        for (int i = 0; i < daysOfWeek.length; i++) 
        {
            if (daysOfWeek[i].equals(jan1Day)) 
            {
                jan1Index = i;
                break;
            }
        }
        if (jan1Index == -1) 
        {
            System.out.println("Invalid day entered for 1st January.");
            return;
        }
        int finalDayIndex = (jan1Index + (int)daysBetween) % 7;
        if (finalDayIndex < 0) finalDayIndex += 7; // for dates before Jan 1
        String finalDay = daysOfWeek[finalDayIndex];
        String outputDay = finalDay.substring(0, 1).toUpperCase() + finalDay.substring(1);
        System.out.println("Day on " + dateInput + " : " + outputDay);
    }
}
