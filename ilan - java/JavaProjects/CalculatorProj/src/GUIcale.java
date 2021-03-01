import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * GUIcalc4 - מחשבון פשוט עם ממשק משתמש גרפי.
 * 27/10/2020
 * By Ilan Peretz (ilanperets@gmail.com)
 */
public class GUIcale
{
    // הגדרת משתנים גלובליים
    static String exp="",s1,s2;
    static double num1 = 0;
    static double num2 = 0;
    static int minus = 0;
    static char op; // ישמור את האופרטור החשבוני
    
    public static void main(String[] args)
    {
        // יצירת החלון למחשבון
        JFrame win = new JFrame("Basic Calculator");  
        win.setSize(400, 400);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setLayout(new GridLayout(4,4));  // Grid 4x4
        
        // סוג הפונט לטקסט שיופיע על הכפתורים
        Font font = new Font("Arial", Font.BOLD, 30);
        
        // מערך הכפתורים של המחשבון
        JButton[] btnArr = new JButton[16];
        
        // מערך מחרוזות של הטקסט שיופיע על כל כפתור
        String[] btnTexts = {
            "7","8","9","+",
            "4","5","6","-",
            "1","2","3","*",
            "0",".","=","/",
        };
        
        // יצירת כל כפתורי המחשבון קביעת הפונט שלהם והוספתם לחלון על פי גריד שנקבע
        for(int i= 0; i < btnArr.length; i++)        
        {
            btnArr[i] = new JButton(btnTexts[i]);
            btnArr[i].setFont(font);
            
            // הוספת מאזין לאירוע לחיצה על הכפתור
            btnArr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // תן לי את הכפתור שנילחץ כעת
                    JButton btn = (JButton)e.getSource();
                    
                    // שמירת הטקסט שעל הכפתור כתו
                    char ch = btn.getText().charAt(0);
                    
                    // חלק זה יתבצע לאחר לחיצה על כפתור
                    System.out.print(ch);
                    
                    // שמירת כל התווים בתוך מחרוזת על ידי שירשור לסוף המחרוזת 
                    exp = exp + ch;
                    
                    // לבצע חישוב ולהדפיס התוצאה
                    if(ch == '=')
                    {
                        // בידוד המספר הראשון בביטוי החשבוני
                        // ---------------------------------
                        s1 = "";
                        int i = 0;
                        while(exp.charAt(i) != '+' && exp.charAt(i) != '-' && exp.charAt(i) != '*' && exp.charAt(i) != '/')
                        {
                            s1 = s1 + exp.charAt(i);
                            i++;
                        }
                        
                        // בידוד אופרטור הפעולה החשבונית
                        // ---------------------------------
                        op = exp.charAt(i);
                        
                        // בידוד המספר השני בביטוי החשבוני
                        // ---------------------------------
                        s2 = "";
                        i++;
                        while(exp.charAt(i) != '=')
                        {
                            s2 = s2 + exp.charAt(i);
                            i++;
                        }
                        
                        // מנגנון לבדיקת חריגת המרה בזמן הריצה
                        try
                        {
                            num1 = Double.parseDouble(s1);
                            num2 = Double.parseDouble(s2);
                            
                             // הצגת התוצאה
                            switch(op)
                            {
                                case '+':
                                    System.out.println(num1+num2);
                                    break;

                                case '-':
                                    System.out.println(num1-num2);
                                    break;

                                case '*':
                                    System.out.println(num1*num2);
                                    break;

                                case '/':
                                    System.out.println(num1/num2);
                                    break;
                            }
                        }
                        catch(Exception ex)
                        {
                            // אם הגענו לכאן סימן שהייתה חריגה בזמן הריצה
                            // ולא היה ניתן להמיר אחת מהמחרוזות למספר ממשי תקין
                            System.out.println("Error");
                        }

                        // איפוס הביטוי כדי לאפשר הכנסת ביטוי חשבוני חדש
                        exp = "";
                    }
                }
            });
            
            // הוספת הכפתור לגריד שבחלון
            win.add(btnArr[i]);
        }

        // צביעת טקסט כפתורי פעולות החשבון בכחול
        for(int i = 3; i < 16; i=i+4)        
        {
            btnArr[i].setForeground(Color.BLUE);  // + button BLUE
        }

        // צביעת טקסט הכפתור שווה באדום
        btnArr[14].setForeground(Color.RED);  // = button RED
       
        // מציג את החלון על המסך
        win.setVisible(true);  
    }
}