/**
 *  Document   : Location
 *  Created on : 02/02/2021, 16:15:45
 *  Author     : Noam
 */
//package ver3_MVC;

public class Location
{
    // תכונות הם משתנים שמגדירים איפה ישמרו הנתונים של הטיפוס
    private int row;    // נשמור את מספר השורה
    private int col;    // נשמור את מספר העמודה
    
    
    // פעולות
    
    // constructor פעולה בונה
    public Location(int r, int c)
    {
        row = r;
        col = c;
    }
    
    // default constractor פעולה בונה ריקה
    public Location()
    {
        row = 0;
        col = 0;
    }

    // פעולה מאחזרת את ערך השורה
    public int getRow()
    {
        return row;
    }
    
    // פעולה מאחזרת את ערך העמודה של המיקום
    public int getCol()
    {
        return col;
    }

    // הפעולה מחזירה מחרוזת המתארת את מצב העצם
    @Override
    public String toString()
    {
        //return "row="+row+",col="+col;
        return "("+row+","+col+")";
    }
    
    
}

