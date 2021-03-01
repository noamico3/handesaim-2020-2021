import java.util.Scanner;
/**
 *  Document   : Ex4
 *  Created on : 04/10/2020, 02:59:47
 *  Author     : נועם
 */

public class Ex4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("enter  a number:\n");;
        int num = in.nextInt();
        int[] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < num; i++)        
        {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        for(int i = 0; i < num; i++)        
        {
            if(i != num - 1)            
            {
                System.out.print(arr[i] + ",");
            }
            else
            {
                System.out.print(arr[i]);
            }
            
        }
    }
}
