import java.util.*;
public class SmithNumber
{
    // Check if number is prime
    public static boolean isPrime(int n) 
    {
        if (n <= 1) 
            return false;
        for (int i = 2; i<n; i++) 
        {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
    public static int sumOfDigits(int n) 
    {
        int sum = 0;
        while (n > 0) 
        {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static List<Integer> getPrimeFactors(int n) 
    {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) 
        {
            while (n % i == 0 && isPrime(i)) 
            {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (isPrime(num)) 
        {
            System.out.println(num + " is a Prime Number, so not a Smith Number.");
        } 
        else 
        {
            int sumDigits = sumOfDigits(num);
            List<Integer> primeFactors = getPrimeFactors(num);
            int sumFactorsDigits = 0;
            System.out.print("Prime factors: ");
            for (int factor : primeFactors) 
            {
                System.out.print(factor + " ");
                sumFactorsDigits += sumOfDigits(factor);
            }
            System.out.println("\nSum of digits: " + sumDigits);
            System.out.println("Sum of digits of the factors: " + sumFactorsDigits);
            if (sumDigits == sumFactorsDigits) 
            {
                System.out.println(num + " is a Smith Number.");
            } 
            else 
            {
                System.out.println(num + " is NOT a Smith Number.");
            }
        }
    }
}