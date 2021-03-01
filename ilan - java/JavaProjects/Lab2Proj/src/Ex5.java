/**
 *  Document   : Ex5
 *  Created on : 15/09/2020, 14:57:03
 *  Author     : נועם
 */
public class Ex5
{
    public static void main(String[] args)
    {
        // for עדיף לדעתי
        //כיוון שאתה יודע את מספר הכוכביות המבוקש
        for(int i = 1; i <= 50; i++)        
        {
            System.out.print("*");
        }
        
        System.out.println();
        
        for(int i = 0; i < 50; i++)        
        {
            System.out.print("-");
        }
        
        System.out.println();
        int x = 0;
        while(x < 50){
            System.out.print("*");
            x++;
        }
        System.out.println(); 

    }
}
