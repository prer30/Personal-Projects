import java.util.Scanner;
public class NumberToWords 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (less than 1000): ");
        int number = sc.nextInt();
        if (number < 0 || number >= 1000) 
        {
            System.out.println("Invalid input. Enter a number between 0 and 999.");
        } 
        else if (number == 0) 
        {
            System.out.println("Zero");
        }
        else 
        {
            System.out.println("In words: " + convertToWords(number));
        }
    }
    static final String[] units = 
    {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static final String[] tens = 
    {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String convertToWords(int num) 
    {
        StringBuilder result = new StringBuilder();
        if (num >= 100)
        {
            result.append(units[num / 100]).append(" Hundred");
            num = num % 100;
            if (num > 0) 
            {
                result.append(" and ");
            }
        }
        if (num < 20) 
        {
            result.append(units[num]);
        } 
        else 
        {
            result.append(tens[num / 10]);
            if (num % 10 != 0) 
            {
                result.append(" ").append(units[num % 10]);
            }
        }
        return result.toString().trim();
    }
}