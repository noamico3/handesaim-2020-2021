

import java.util.Random;
import java.util.Scanner;

/**
 *  Document   : Ex7
 *  Created on : 15/09/2020, 18:40:07
 *  Author     : נועם
 */
public class Ex7
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int x = rnd.nextInt(100)+ 1;;
        int counter = 0;
        System.out.println("guess  a number:");
        int y = in.nextInt();
        while(y != x){
            counter++;
            if(counter == 10){
                if(x % 2 == 0){
                    System.out.println("---------------------------------");
                    System.out.println("the number is an even number");
                    System.out.println("---------------------------------");
                }
                else{
                    System.out.println("---------------------------------");
                    System.out.println("the number is an odd number");
                    System.out.println("---------------------------------");
                }
            }
            if(counter == 15){
                if(x < 50){
                    System.out.println("---------------------------------");
                    System.out.println("the number is under 50");
                    System.out.println("---------------------------------");
                }
                else{
                    System.out.println("---------------------------------");
                    System.out.println("the number is above 50");
                    System.out.println("---------------------------------");
                }
    
            }
            System.out.println("guess a number");
            y = in.nextInt();
        }
        System.out.println("that's right!!! well done, the number is: 56" + x);
    }
}
