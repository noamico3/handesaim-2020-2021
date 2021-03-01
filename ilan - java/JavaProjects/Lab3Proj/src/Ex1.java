
import java.util.Random;
import java.util.Scanner;

/**
 *  Document   : Ex1
 *  Created on : 29/09/2020, 23:08:58
 *  Author     : נועם
 */
public class Ex1
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        System.out.println("enter a number:\n");
        int num = in.nextInt();
        while(num < 0)        
        {
            System.out.println("the number is illegal, enter a number again:\n");
            num = in.nextInt();
        }
        int[] arr = new int[num];
        for(int i = 0; i < num; i++)        
        {//קליטת ציונים רנדומאליים לתוך מערך
            arr[i] = rnd.nextInt(61) + 40;
        }
        for(int i = 0; i < (num - 1); i++)        
        {//הדפסת המערך
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[num-1]);
        //------------------------------------------
        int counter = 0;
        for(int i = 0; i < (num); i++)        
        {
            if(arr[i] < 56)            
            {
                counter++;
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
        System.out.println( "(" + counter + ")");
        //---------------------------------------------
        counter = 0;
        for(int i = 0; i < (num); i++)        
        {
            if(arr[i] > 55)            
            {
                counter++;
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
        System.out.println( "(" + counter + ")");
        //---------------------------------------------
        int max = 0, min = 101;
        float sum = 0;
        for(int i = 0; i < num; i++)        
        {
            sum = sum + arr[i];
            if(arr[i] > max)            
            {
                max = arr[i];
            }
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        System.out.println("max = " + max + " min = " + min);
        //-----------------------------------------------
        float avg = sum / num;
        System.out.println("real avg = " + avg + " --> avg = " + Math.round(avg));
        for(int i = 0; i < num; i++)        
        {
            if(i != num - 1){
                if(arr[i] > avg)            
                {
                   System.out.print(arr[i] + ","); 
                }
            }
            else{
                if(arr[i] > avg)            
                {
                   System.out.println(arr[i]);
                }
            } 
                
        }
        
    }
}
