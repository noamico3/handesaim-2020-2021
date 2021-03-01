
import java.util.Random;
import java.util.Scanner;

/**
 *  Document   : Ex3
 *  Created on : 02/10/2020, 01:00:55
 *  Author     : נועם
 */
public class Ex3
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int[] arr = new int [10];
        int [] arr2 = new int [10];
        int[] both = {0,0,0,0,0,0,0,0,0,0};
        int counter2 = 0;
        int counter = 0;
        int len = 0;//length of both
        System.out.print("arr: ");
        for(int i = 0; i < 10; i++)        
        {//מאתחל את המערך במספרים ומדפיס את המערך
            arr[i] = rnd.nextInt(10)+1;
            arr2[i] = rnd.nextInt(10)+1;
            if(i != 9)            
            {
                System.out.print(arr[i] + ",");
            }
            else
            {
                System.out.println(arr[i]);
            }
            
        }
        //----------------------------------------------------------------------
        System.out.print("arr2: ");
        for(int i = 0; i < 10; i++)        
        {//מדפיס את המערך השני
            if(i != 9)            
            {
                System.out.print(arr2[i] + ",");
            }
            else
            {
               System.out.println(arr2[i]); 
            }
        }
        //----------------------------------------------------------------------
        System.out.print("common for both arrays: ");
        for(int i = 0; i < 10; i++)        
        {
            counter = 0;
            for(int j = 0; j < 10; j++)            
            {//בודק איברים משותפים בין המערכים
                if(arr[i] == arr2[j])                
                {
                    counter++;
                }
                
            }
            counter2 = 0;
            for(int x = 0; x < 10; x++)            
            {//בודק האם האיבר נמצא במערך  both 
                if(arr[i] == both[x])                
                {
                     counter2++;                   
                }
            }
            if(counter > 0 && counter2 == 0){//אם האיבר משותף למערכים וגם לא נמצא כבר בתוך both 
                both[i] = arr[i];
                len++;
            }
        }
        int x = 0;
        for(int i = 0; i < 10; i++)        
        {//בהתחלה איפסנו את כל איברי המערך ולכן רק מה שלא יהיה שווה לאפס נדפיס כי מה שהוחלף באפס זה המספרים המשותפים
            if(both[i] != 0 && x <= len){
                
                if(x != len-1)            
                {
                    System.out.print(both[i] + ",");
                }
                else
                {
                    System.out.println(both[i]); 
                }
                x++;
            }
        }
        //-------------------------------------------------------------------------
        char[] str={ };  
        String s=new String(str);
        System.out.print("missing in arr: ");
        for(int i = 1; i <= 10; i++)        
        {
            counter = 0;
            for(int j = 0; j < 10; j++)            
            {
                if(i != arr[j])            
                {
                    counter++;
                    if(counter == 10)                    
                    {
                        System.out.print(i + ","); 
                    }
                }
            } 
        }
       
        //-------------------------------------------------------------------------
        System.out.println();
        System.out.print("missing in arr2: ");
        for(int i = 1; i <= 10; i++)        
        {
            counter = 0;
            for(int j = 0; j < 10; j++)            
            {
                if(i != arr2[j])            
                {
                    counter++;
                    if(counter == 10)                    
                    {
                        System.out.print(i + ",");
                    }
                }
            }
            
        }
        System.out.println();
    }
}
