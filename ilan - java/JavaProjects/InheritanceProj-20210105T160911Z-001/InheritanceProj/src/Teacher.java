import java.util.Arrays;

/**
 * Teacher -טיפוס חדש המייצג מורה שהוא סוג של עובד 
 * 5.1.2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Teacher extends Worker 
{
    private String[] subjects;  // מקצועות הלימוד שהמורה מלמד

    public Teacher(String name, int id, Date bornDate, char gender) 
    {
        super(name, id, bornDate, gender, 8000);
        this.subjects = new String[] { "Math", "CS" };
    }

    public String[] getSubjects() 
    {
        return subjects;
    }

    public void setSubjects(String[] subjects) 
    {
        this.subjects = subjects;
    }

    @Override
    public String toString() 
    {
        return "Teacher{" + super.toString() + ", subjects=" + Arrays.toString(subjects) + '}';
    }
}
