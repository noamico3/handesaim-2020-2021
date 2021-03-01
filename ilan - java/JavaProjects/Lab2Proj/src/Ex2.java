
import java.util.Random;

/**
 *  Document   : Ex2
  Created on : 15/09/2020, 14:17:48
  Author     : נועם
 */
public class Ex2
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        int sum = 0;
        int x;
        for(int i = 1; i <= 10; i++)        
        {
            x = rnd.nextInt(900) + 100;
            System.out.print(x + ",");
            if(x % 2 != 0){
                sum = sum + x;
            }
        }
        System.out.println();
        System.out.println("the sum of the odds numbers is: " + sum);
    } 
}
