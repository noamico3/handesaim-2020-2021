
import java.util.Random;

/**
 *  Document   : Ex6
 *  Created on : 15/09/2020, 15:08:03
 *  Author     : נועם
 */
public class Ex6
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        int x = rnd.nextInt(9000)+ 1000;;
        int a = 0;
        for(int i = 2; i < x/2 ; i++){
            if(x % i == 0){
                a = 1;
                System.out.println(i);
            }
        }
        if(a == 1){
            System.out.println(x + " is not a prime number");
        }
        if(a == 0)
            System.out.println(x + " is a prime number");

    }
}
