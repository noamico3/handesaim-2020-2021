/**
 * Main - Test program
 * 5.1.2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Main
{
    public static void main(String[] args)
    {
        Student s1 = new Student("ilan", 111, new Date(17,6,2000), 'M', 80.67);
        System.out.println("s1 -> " + s1);
        
        Teacher t1 = new Teacher("lavy", 222, new Date(1,1,1980), 'M');
        System.out.println("t1 -> " + t1);
        
        Teacher t2 = new Teacher("Rivka", 333, new Date(5,5,1955), 'F');
        t2.setSubjects(new String[] { "Gmara", "Toshba", "English" });
        t2.setSalary(9500);
        System.out.println("t2 -> " + t2);
    }
}
