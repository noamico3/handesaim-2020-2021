
import java.util.Random;
import java.util.Scanner;

/**
 *  Document   : Ex5
 *  Created on : 04/10/2020, 03:14:38
 *  Author     : נועם
 */
public class Ex5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int k = rnd.nextInt(11)+5;
        int[] arr = new int[k];
        for(int i = 0; i < k; i++)        
        {
            arr[i] = rnd.nextInt(9999)+1;
        }
        for(int i = 0; i < k; i++)        
        {
            if(i != k - 1)            
            {
                System.out.print(arr[i] + ",");
            }
            else
            {
                System.out.println(arr[i]);
            }
            
        }
        for(int i = 0; i < k; i++)        
        {
            int ahadot = arr[i] % 10;
            int asarot = arr[i] /10 %10;
            int meot = arr[i]/100 % 10;
            int alaphim = arr[i] / 1000;
            if(alaphim == 0)            
            {
                if(meot == 0 && alaphim == 0){
                    if(meot == 0 && alaphim == 0 && asarot == 0)            
                        System.out.println(arr[i] + "(" + ahadot + "=" + ahadot + ")");
                    else
                        System.out.println(arr[i] + "(" + asarot + "+" + ahadot + "=" + (asarot + ahadot) + ")");
                }
                else
                    System.out.println(arr[i] + "(" + meot + "+" + asarot + "+" + ahadot + "=" + (meot + asarot + ahadot) + ")");
            }
            else
                System.out.println(arr[i] + "(" + alaphim + "+" + meot + "+" + asarot + "+" + ahadot + "=" + (alaphim + meot + asarot + meot) + ")");
        }
        
    }
}
