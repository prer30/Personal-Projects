import java.util.Scanner;
public class Money
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        // Accept amount from user
        System.out.println("Enter the amount: ");
        int amount = sc.nextInt();
        int originalAmount = amount;
        
        int[] denominations = {100, 50, 20, 10, 5, 2};
        System.out.println("Currency breakdown for Rs. " + originalAmount + ":");
        for (int denom : denominations) 
        {
            int count = amount / denom;
            if (count > 0) {
                System.out.println("Rs. " + denom + " notes = " + count);
                amount = amount % denom;
            }
        }
        // If there's any leftover amount that can't be broken down
        if (amount > 0) 
        {
            System.out.println("Remaining amount Rs. " + amount + " cannot be broken down using available denominations.");
        }
    }
}
