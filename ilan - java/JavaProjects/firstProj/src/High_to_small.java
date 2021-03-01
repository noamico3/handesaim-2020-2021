/**
 *  Document   : High_to_small
  Created on : 10/09/2020, 11:32:54
  Author     : נועם
 */
public class High_to_small
{
    public static void main(String[] args)
    {
        int x1 = -4;
        int x2 = 0;
        int x3 = -5;
        int max = 0;
        
        //  x2 = max
        if(x1 < x2 && x2 > x3){
            max = x2;
            if(x1 < x3){
                System.out.println(x1);
                System.out.println(x3);
                System.out.println(max);

            }
            if(x1 >= x3){
                System.out.println(x3);
                System.out.println(x1);
                System.out.println(max);  
            }
            
        }
        //x3 = max
        if(x1 < x3 && x3 > x2){
            max = x3;
            if(x1 < x2){
                System.out.println(x1);
                System.out.println(x2);
                System.out.println(max);

            }
            if(x1 >= x2){
                System.out.println(x2);
                System.out.println(x1);
                System.out.println(max);   
            }
        }
        //x1 = max
        if(x1 > x2 && x1 > x3){
            max = x1;
            if(x2 < x3){
                System.out.println(x2);
                System.out.println(x3);
                System.out.println(max);

            }
            if(x2 >= x3){
                System.out.println(x3);
                System.out.println(x2);
                System.out.println(max);   
            }
        }
        //אם כל האיברים שווים
        if(x1 == x2 && x2 == x3){
            System.out.println(x1);
            System.out.println(x1);
            System.out.println(x1);
        }
        
        if(x1 == x2){
            if(x3 < x1){
                System.out.println(x3);
                System.out.println(x2);
                System.out.println(x1);
            }
        }
        if(x1 == x3){
            if(x2 < x1){
                System.out.println(x2);
                System.out.println(x3);
                System.out.println(x1);
            }
        }
        if(x2 == x3){
            if(x1 < x2){
                System.out.println(x1);
                System.out.println(x3);
                System.out.println(x2);
            }
        }
    }    
}   

