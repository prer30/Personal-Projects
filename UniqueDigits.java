import java.util.Scanner;
public class UniqueDigits 
{
    public static boolean hasUniqueDigits(int num) 
    {
        boolean[] digits = new boolean[10];//array for each digit (0-9) to check which digit has already appeared
        while (num > 0) 
        {
            int d = num % 10;
            if (digits[d]) 
            {
                return false;
            }
            digits[d] = true;
            num /= 10;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of M: ");
        int M = sc.nextInt();
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        int count = 0;
        System.out.println("The Unique-digit numbers between " + M + " and " + N + " are:");
        for (int i = M; i <= N; i++)
        {
            if (hasUniqueDigits(i)) 
            {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nFrequency: " + count);
    }
}
