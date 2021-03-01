package turtle;

import java.awt.Color;
import javax.swing.JOptionPane;


/**
 * TurtleDemo - This program do ...
 * 5/1/2021
 * By Ilan Peretz (ilanperets@gmail.com)
 */
public class TurtleDemo
{
    public static void main(String[] args)
    {
        MyTurtle t1 = new MyTurtle();
        t1.tailDown();
        t1.setTailColor(Color.BLUE);
        t1.tailUp();
        int n = 10;
        t1.setDelay(100);
        //t1.drawHouse(100, 50);
        t1.ElaboratePolygon(8, 50, Color.red);
        
        JOptionPane.showMessageDialog(null, "Well done!\nPress OK to close & exit ...");
        System.exit(0);
    }
}
