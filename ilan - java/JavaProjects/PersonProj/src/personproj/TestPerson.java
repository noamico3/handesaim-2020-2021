package personproj;

/**
 *  Document   : TestPerson
  Created on : 26/11/2020, 11:28:19
  Author     : נועם
 */
public class TestPerson
{
    public static void main(String[] args)
    {
        Person p1 = new Person("noam",1111,18.5,'m');
        Person p2 = new Person("amitay",2222,7,'f');

        System.out.println(p1);
        System.out.println(p2);
        
        p2.setAge(18);
        p2.setGender('x');
        
        System.out.println(p1);
        System.out.println(p2);
        
        System.out.println("----------------------------------------");
        //
        Person[] arr = new Person[5];
        arr[0] = new Person("loalinunono", 666, 12,'x');
        arr[1] = new Person("amitay", 555, 65,'f');
        arr[2] = new Person("noam", 444, 42,'m');
        arr[3] = new Person("liel", 333, 10,'m');
        arr[4] = new Person("bezalelllll", 21, 16,'f');
        
        printPersons(arr);
        
        System.out.println("----------------------------------------");
        checkAndPrint(arr);
        System.out.println("----------------------------------------");
        System.out.println(getNameOfBigestPerson(arr));
        System.out.println("----------------------------------------");
        System.out.println(getNumOfFemales(arr));
        System.out.println("----------------------------------------");
        System.out.println(getNumOfFemalesOver15(arr));
        System.out.println("----------------------------------------");
        sortByNames(arr);
        printPersons(arr);

    }
    
    //3.א
    public static void printPersons(Person[] arr)
    {
        for(int i= 0; i < arr.length; i++)        
        {
            System.out.println(arr[i]);
        }
    }
    
    
    public static void checkAndPrint(Person[] arr){
        for(int i= 0; i < arr.length; i++)        
        {
             int tempId = arr[i].getId();
             int lenOfName = arr[i].getName().length();
             if(tempId % 2 == 0 && lenOfName > 10)            
            {
                System.out.println(arr[i].getName());
            }
        }
    }
    
    public static String getNameOfBigestPerson(Person[] arr)
    {
        String name = arr[0].getName();
        int max = (int) arr[0].getAge();
        for(int i = 1; i < 5; i++)        
        {
            if(arr[i].getAge() > max)            
            {
                max = (int) arr[i].getAge();
                name = arr[i].getName();
            }
        }
        return name;
    }
    
    public static int getNumOfFemales(Person[] arr){
        int NumOfFemales = 0;
        for(int i = 0; i < 5; i++)        
        {
            if(arr[i].getGender() == 'f'){
                NumOfFemales++;
            }
        }
        return NumOfFemales;
    }
    
    
    public static String getNumOfFemalesOver15(Person[] arr){
        String femalesOver15 = "";
        for(int i = 0; i < 5; i++)        
        {
            if(arr[i].getGender() == 'f' && arr[i].getAge() > 15){
                femalesOver15 += arr[i].getName()+",";
            }
        }
        return femalesOver15.substring(0, femalesOver15.length()-1);
    }
    
    public static void sortByNames(Person[] arr){
        for(int i = arr.length-1; i > 0; i--)        
        {
            for(int j = 0; j < i; j++)            
            {
                if( arr[j].getName().compareTo(arr[j+1].getName()) > 0){
                    Person temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    
    
}
