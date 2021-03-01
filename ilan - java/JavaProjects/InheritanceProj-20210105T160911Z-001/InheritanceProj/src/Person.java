/**
 * Person -טיפוס חדש המייצג אדם 
 * 26.11.2020
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Person 
{
    private String name;    // שם מלא
    private int id;         // מספר זהות
    private Date bornDate;  // תאריך לידה
    private char gender;    // מיגדר

    /**
     * פעולה בונה עצם מסוג אדם על פי הפרמטרים הבאים
     * @param name שם האדם
     * @param id מספר זהות תקין
     * @param gender 'f' - female, 'm' - male, 'x' - other
     */
    public Person(String name, int id, Date bornDate, char gender)
    {
        this.name = name;
        this.id = id;
        this.bornDate = bornDate;
        this.gender = gender;
    }

    public Date getBornDate()
    {
        return bornDate;
    }

    public void setBornDate(Date bornDate)
    {
        this.bornDate = bornDate;
    }

   
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public char getGender()
    {
        return gender;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name=" + name + ", id=" + id + ", bornDate="+bornDate+", gender=" + gender + '}';
    }
    
    
}
