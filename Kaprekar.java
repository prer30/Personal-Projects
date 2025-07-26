public class Kaprekar
{
    public static void main(String[] args) 
    {
        int lower=1, upper=1000;
        System.out.println("Kaprekar numbers between 1 and 1000:");
        for (int num=lower; num<=upper; num++) 
        {
            if (isKaprekar(num)) 
            {
                System.out.print(num + " ");
            }
        }
    }
    public static int countDigits(long number)//Counts how many digits are in a number by dividing by 10 until it becomes 0.
    {
        int count = 0;
        while (number > 0) 
        {
            number /= 10;
            count++;
        }
        return count;
    }
    public static boolean isKaprekar(int num) 
    {
        if (num == 1) return true;
        long square = (long) num * num;
        int digits = countDigits(square);//counts no of digits in squared number
        for (int i=1; i<digits; i++) 
        {
            long divisor=(long) Math.pow(10, i);//Calculate divisor
            long right=square % divisor;//right part is remainder 
            long left=square / divisor;//left part is quotient
            if (right != 0 && (left + right == num)) 
            {
                return true;
            }
        }
        return false;
    }
}
