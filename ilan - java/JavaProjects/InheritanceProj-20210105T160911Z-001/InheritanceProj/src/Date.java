import java.util.GregorianCalendar;

/**
 * Date -טיפוס חדש המייצג תאריך גרגוריאני 
 * 8.12.2020
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Date 
{
    private int day;    // יום
    private int month;  // חודש
    private int year;   // שנה
    
    //פעולה בונה ריקה 
    // שמאתחלת התכונות לתאריך שבמחשב
    public Date()
    {
        GregorianCalendar today = new GregorianCalendar();
        this.day = today.get(GregorianCalendar.DAY_OF_MONTH);
        this.month = today.get(GregorianCalendar.MONTH)+1;
        this.year = today.get(GregorianCalendar.YEAR);
    }
    
    /**
     * בונה תאריך מהפרמטרים המתקבלים
     * @param day 1-31
     * @param month 1-12
     * @param year 
     */
    public Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // פעולה בונה מעתיקה
    public Date(Date date)
    {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }
     
    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
//        String m = month+"";
//                
//        switch(month)
//        {
//            case 1: 
//                m="Jan";
//                break;
//            case 2: 
//                m="Feb";
//                break;
//        }
        
        return day+"."+month+"."+year;
    }

    /**
     * הפעולה משווה בין שני תאריכים
     * @param other
     * @return  0 if equals
     *         -1 < 0 if this date before other date
     *         +1 > 0 if this date after other date
     */
    public int compareTo(Date other)
    {
        if(this.year != other.year)
            return year-other.year;
        
        if(this.month != other.month)
            return this.month - other.month;
        
        return this.day - other.day;
    }
    
    /**
     * מחזירה את תאריך יום המחר מהתאריך הנוכחי
     * @return 
     */
    public Date getTomorrow()
    {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int d = day;
        int m = month;
        int y = year;

        // ? בדיקה האם זו שנה מעוברת
        // isLeapYear רצוי לכתוב את זה כפעולה
        if((y%4==0 && y%100!=0) || y%400==0)
            daysInMonth[1] = 29;    // עדכון מספר הימים בחודש פברואר
        
        if(d < daysInMonth[m-1])
            d++;
        else
        {
            // d=31
            if(m<12)
            {
                d=1;
                m++;
            }
            else
            {
                //m=12
                d=1;
                m=1;
                y++;
            }
        }
        
        return new Date(d, m, y);
    }
}
