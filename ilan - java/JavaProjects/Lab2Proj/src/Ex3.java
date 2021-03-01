
import java.util.Scanner;

/**
 *  Document   : Ex3
 *  Created on : 15/09/2020, 14:34:15
 *  Author     : נועם
 */
public class Ex3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter a number:");
        int num = in.nextInt();
        int sum = 1;
        for(int i = 1; i <= num; i++)        
        {
            sum = sum * i;
        }
        System.out.println("the factorial of " + num + " is: " + sum);
    }
} 
