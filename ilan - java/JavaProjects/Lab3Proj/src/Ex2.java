
import java.util.Random;
import java.util.Scanner;

/**
 *  Document   : Ex2
 *  Created on : 30/09/2020, 22:56:29
 *  Author     : נועם
 */
public class Ex2
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int[] arr = new int [20];
        int ahadot = 0, asarot = 0, meot = 0;
        for(int i = 0; i < 20; i++)        
        {
            arr[i] = rnd.nextInt(201)-100;
        }
        for(int i = 0; i < 10; i++)        
        {
            int x = arr[i] % 10;
            int y = arr[i] / 10;
            y = y % 10;
            int z = arr[i] / 100;
                    
            if(y == 0 && z == 0 )            
            {
                ahadot++;
            }
            if(y != 0 && z == 0)
            {
                asarot++;
            }
            if(z != 0)            
            {
                meot++;
            }
        }
        for(int i = 0; i < 10; i++)        
        {
            if(i != 9)            
            {
               System.out.print(arr[i] + ","); 
            }
            else
            {
                System.out.println(arr[i]);
            } 
            
        }
        System.out.println("ahadot = " + ahadot + " asarot = " + asarot + " meot = " + meot );
    }
}
