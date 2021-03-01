/**
 *  Document   : Ex6
 *  Created on : 04/10/2020, 03:57:34
 *  Author     : נועם
 */
public class Ex6
{
    public static void main(String[] args)
    {
        double[] arr = {7.3,8.75,-3.11,0,17.2,1.80,0.5,3.1415,88,15.5};
        for(int i = 0; i < 10; i++)        
        {
            if(i != 9)            
            {
                System.out.print(arr[i] + ", ");
            }
            else
            {
                System.out.println(arr[i]);
            }
        }
        for(int i = 0; i < 9; i++)        
        {
            for(int j = i + 1; j > 0; j--)            
            {
                if(arr[j] < arr[j-1])            
                {
                    double x = 0;
                    x = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = x;           
                }
            }
            
        }
        for(int i = 0; i < 10; i++)        
        {
            if(i != 9)            
            {
                System.out.print(arr[i] + ", ");
            }
            else
            {
                System.out.println(arr[i]);
            }
        }
        
    }
}
