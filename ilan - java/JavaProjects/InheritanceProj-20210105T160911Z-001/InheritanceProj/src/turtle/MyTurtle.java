package turtle;

import java.awt.Color;
import unit4.turtleLib.Turtle;

/**
 * MyTurtle
 * 5/1/2021
 * By Ilan Peretz (ilanperets@gmail.com)
 */
public class MyTurtle extends Turtle
{
    public MyTurtle()
    {
        super();
    }
    
    
    public void drawCircle(double radius, Color color)
    {
        super.setTailColor(color);
        super.tailUp();
        
        int step = 1;
        for (int i= 1; i <= 360; i=i+step)        
        {
            super.moveForward(radius);
            super.tailDown();
            super.moveForward(1);
            super.tailUp();
            super.moveBackward(radius+1);
            super.turnRight(step);
        }
    }
    
    
    public void drawHouse(int a, int b)
    {
        super.tailDown();
        super.turnRight(90);
        super.moveForward(a);
        super.turnLeft(135);
        super.moveForward(Math.sqrt(2) * a);
        super.turnLeft(135);
        super.moveForward(a);
        super.turnLeft(135);
        super.moveForward(Math.sqrt(2) * a);
        super.turnLeft(135);
        super.moveForward(a);
        super.turnRight(135);
        super.moveForward(Math.sqrt(0.25 * Math.pow(a, 2) + Math.pow(b, 2)));
        super.turnRight(90);
        super.moveForward(Math.sqrt(0.25 * Math.pow(a, 2) + Math.pow(b, 2)));
        super.turnRight(45);
        super.moveForward(a);
    }
    
    
    public void ElaboratePolygon(int a, int b, Color color){
        double angle = 180-((a-2) * 180 / a);
        super.tailDown();
        super.setTailColor(color);
        for(int i= 0; i < a; i++)        
        {
            super.moveForward(b);
            super.turnRight(angle);
        }
    }
    
    
    
}
