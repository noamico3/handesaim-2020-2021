/**
 * Cleaner -טיפוס חדש המייצג מנקה שהוא סוג של עובד 
 * 5.1.2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Cleaner extends Worker 
{
    private String area;    // איזור ניקוי

    public Cleaner(String name, int id, Date bornDate, char gender) {
        super(name, id, bornDate, gender, 6000);
        this.area = "Floor 10";
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Cleaner{" + super.toString() + ", area=" + area + '}';
    }
}
