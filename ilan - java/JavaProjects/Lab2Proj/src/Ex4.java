
import java.util.Random;
import java.util.Scanner;

/**
 *  Document   : Ex4
 *  Created on : 15/09/2020, 14:42:47
 *  Author     : נועם
 */
public class Ex4
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        int cube1 = rnd.nextInt(6) + 1;
        int cube2 = rnd.nextInt(6) + 1;
        int counter = 0;
        while(cube1 + cube2 != 11){
            System.out.println(cube1 + " , " + cube2);
            counter++;
            cube1 = rnd.nextInt(6) + 1;
            cube2 = rnd.nextInt(6) + 1;
        }
        System.out.println("5 , 6");
        System.out.println("the number of tries until 5 and 6 is: " + counter);

    }
}
