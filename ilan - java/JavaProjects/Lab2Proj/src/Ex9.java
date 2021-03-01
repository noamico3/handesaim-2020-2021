/**
 *  Document   : Ex9
 *  Created on : 15/09/2020, 19:07:04
 *  Author     : נועם
 */
public class Ex9
{
    public static void main(String[] args)
    {
        // סעיף א
        
        for(int i = 1; i <= 5; i++)        
        {
            System.out.println();
            for(int j = 1; j <= i; j++)            
            {
                System.out.print("*");
            }
        }
        System.out.println();
        
        
        System.out.println("-----------------------------");
        
        // סעיף ב
        
        for(int i = 5; i <= 5 && i != 0; i--)        
        {
            System.out.println();
            for(int j = 1; j <= i; j++)            
            {
                System.out.print("*");
            }
        }
        System.out.println();
        
        
        System.out.println("-----------------------------");
        
        // סעיף ג
        
        for(int i = -5; i <= 5 ; i++)        
        {
            if(i != 0 && i != 1){
                System.out.println(" ");
                for(int j = 0; j < Math.abs(i); j++)                
                {
                    System.out.print("*"); 
                }
            }
            
        }
        System.out.println(" ");
        
        System.out.println("-----------------------------");

        // סעיף ד
        
        for(int i = 1; i <= 5; i++)        
        {
            System.out.println();
            for(int j = 1; j <= i; j++)            
            {
                System.out.print(j);
            }
        }
        System.out.println();
        
        System.out.println("-----------------------------");
        
        // סעיף ה
        
        for(int i = 1; i <= 5; i++)        
        {
            System.out.println();
            for(int j = 1; j <= i; j++)            
            {
                System.out.print(i);
            }
        }
        System.out.println();
        
        System.out.println("-----------------------------");
        
        // סעיף ו
        
        for(int i = 5; i <= 5 && i != 0; i--)        
        {
            System.out.println();
            for(int j = 1; j <= i; j++)            
            {
                System.out.print(j);
            }
        }
        System.out.println();
        
        System.out.println("-----------------------------");
        
        // סעיף ז
        
        for(int i = 5; i <= 5 && i != 0; i--)        
        {
            System.out.println();
            for(int j = 1; j <= i; j++)            
            {
                System.out.print(i);
            }
        }
        System.out.println();
        
        System.out.println("-----------------------------");
        
        // סעיף ח
        
       for(int i = 1; i <= 5 ; i++)        
        {
            System.out.println();
            for(int j = 5; j >= i && j != 0 ; j--)            
            {
                System.out.print(i);
            }
        }
        System.out.println();
        
        

    }
}

