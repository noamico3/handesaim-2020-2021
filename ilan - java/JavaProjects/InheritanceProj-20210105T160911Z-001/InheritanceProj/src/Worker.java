/**
 * Worker -טיפוס חדש המייצג עובד שהוא סוג של אדם 
 * 5.1.2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Worker extends Person 
{
    private double salary;  // שכר בשקלים

    public Worker(String name, int id, Date bornDate, char gender, double sal) 
    {
        super(name, id, bornDate, gender);
        this.salary = sal;
    }

    public double getSalary() 
    {
        return salary;
    }

    public void setSalary(double salary) 
    {
        this.salary = salary;
    }

    @Override
    public String toString() 
    {
        return "Worker{" + super.toString() + ", salary=" + salary + '}';
    }
}
