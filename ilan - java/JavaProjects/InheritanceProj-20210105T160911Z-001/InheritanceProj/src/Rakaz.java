/**
 * Rakaz -טיפוס חדש המייצג רכז שכבה שהוא סוג של מורה 
 * 5.1.2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Rakaz extends Teacher 
{
    private int shichvaNum; // מספר השכבה שאותה הוא מרכז

    public Rakaz(String name, int id, Date bornDate, char gender)
    {
        super(name, id, bornDate, gender);
    }

    public int getShichvaNum()
    {
        return shichvaNum;
    }

    public void setShichvaNum(int shichvaNum)
    {
        this.shichvaNum = shichvaNum;
    }

    @Override
    public String toString()
    {
        return "Rakaz{" + super.toString() + ", shichvaNum=" + shichvaNum + '}';
    }
}
