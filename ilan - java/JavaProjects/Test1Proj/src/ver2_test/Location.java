package ver2_test;

/**
 *  Location - המחלקה מגדירה את הטיפוס מיקום בלוח
 *  17.11.2020
 */
public class Location
{
    // תכונות
    // ------------------------
    // תכונות הם משתנים שמגדירים איפה ישמרו הנתונים של הטיפוס
    private int row;    // נשמור את מספר השורה
    private int col;    // נשמור את מספר העמודה
    
    
    // פעולות
    // -------------------------
    public Location()
    {
        this.row = 0;
        this.col = 0;
    }

    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    @Override
    public String toString()
    {
        return "{row=" + row + ",col=" + col + "}";
    }
}
