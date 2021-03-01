/**
 * Student -טיפוס חדש המייצג סטודנט שהוא סוג של אדם 
 * 5.1.2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Student extends Person
{
    private double avg; // ממוצע הציונים

    // פעולה בונה
    public Student(String name, int id, Date bornDate, char gender, double avg)
    {
        super(name, id, bornDate, gender);  // זימון פעולה בונה של אדם
        this.avg = avg;
    }

    public double getAvg()
    {
        return avg;
    }

    public void setAvg(double avg)
    {
        this.avg = avg;
    }

    @Override
    public String toString()
    {
        return "Student{" + super.toString() + ", avg=" + avg + '}';
    }
}
