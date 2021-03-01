package ver_Date;


/**
 *  Document   : Person
 *  Created on : 26/11/2020, 11:29:38
 *  Author     : נועם
 */
public class Person
{
    private String name;
    private int id;
    private double age;
    private char gender;
    private String birthday;

    /**
     * פעולה בונה עצם מסוג אדם על פי הפרמטרים הבאים
     * @param name שם האדם
     * @param id תעודת זהות תקינה
     * @param age גיל תקין
     * @param gender f - female m - man x - other
     */
    public Person(String name, int id, double age, char gender)//בשאלה הרביעית נוסיף פה את המשתנה תאריך לידה 
    {
        this.name = name;
        this.id = id;
        this.age = age;
        //this.birthday = birthday;
        this.gender = gender;
    }

    
    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public double getAge()
    {
        return age;
    }

    public char getGender()
    {
        return gender;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setAge(double age)
    {
        this.age = age;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + '}';//בשאלה הרביעית נוסיף פה גם תאריך לידה
    }

    //מכאן ומטה עבור השאלה הרביעית
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    
    
    
    
    
    
    
}
