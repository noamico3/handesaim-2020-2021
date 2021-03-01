package ver_Date;

/**
 *  Document   : TestDate
 *  Created on : 22/12/2020, 13:41:07
 *  Author     : Noam
 */


import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * TestDate - תוכנית בדיקה למחלקה תאריך
 * 22.12.20
 * By Ilan Peretz (ilanperets@gmail.com)
 */
public class TestDate
{
    public static void main(String[] args)
    {
        Date d1 = new Date(28, 12, 2020);
        Date d2 = new Date(28, 12, 2019);
        
        // פעולת השוואה בין תאריכים
        if(d1.compareTo(d2) < 0)
        {
            System.out.println("d1 -> " + d1);
            System.out.println("d2 -> " + d2);
        }
        else
        {
            System.out.println("d2 -> " + d2);
            System.out.println("d1 -> " + d1);
        }    
        
        // לקבל את תאריך של מחר
        Date d3 = d1.getTomorrow();
        System.out.println("d3 -> " + d3);
        
        
        /*--------------------4 שאלה ---------------------*/
        // קבלת התאריך שכעת שמור במחשב המקומי
        GregorianCalendar today = new GregorianCalendar();
        int day = today.get(GregorianCalendar.DAY_OF_MONTH);
        int month = today.get(GregorianCalendar.MONTH) + 1;
        int year = today.get(GregorianCalendar.YEAR);
        Date d4 = new Date(day, month, year);
       
        Scanner in = new Scanner(System.in);
        System.out.println("enter the days you want from today:");
        int x = in.nextInt();
        for(int i = 0; i < x; i++)        
        {
            d4 = d4.getTomorrow();
        }
        System.out.println("" + d4);
        
        
        /*---------------------5------------------------*/
        
        // סעיף ב
        // לא כי השינויים נעשו במחלקה תאריך כבר
        
        /*-------------------6---------------------------*/
        
        // סעיף א
        // כיוון שלא נרצה לתת למשתמש לגשת למחלקות שלי ולשנות כל דבר ישירות
        // סעיף ב
        // כן אפשר ונוכל למנוע זאת באמצעות תריי וקאץ ונתפוס אקספשן
        // הנה דוגמא לכך שאפשר להכניס תאריך לא תקין
        // Date temp = new Date(33,56,2020);
        
        /*--------------------7-------------------------*/
        
        
        
        /*----------------------8------------------------*/
        System.out.println("--------8--------");
        Date d5 = new Date();
        System.out.println("" + d5);
        
        
        /*----------------------9------------------------*/
        System.out.println("--------9--------");
        
        
        
        
        
    }
}
