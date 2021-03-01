package ver2_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Test1 - XO Game (ver2) - מבחן ראשון על המשחק איקס עיגול גירסה שנייה.
 * 3/12/2020
 */
public class Main
{
    // קבועים
    static final String STUDENT_NAME = "Noam Cohen jerusalem";
    static int already = 0;//נשתמש בשביל לחיצה על הכפתור פליי לצורך בדיקה
    static final String WIN_TITLE = "Test1 - XOGame(ver2) - " + STUDENT_NAME;
    static final int BUTTON_SIZE = 100;  // ממדי הכפתור בלוח המשחק
    static final Font FONT1 = new Font(null, Font.BOLD, 60); // פונט לכפתורי המשחק
    static final Font FONT2 = new Font(null, Font.BOLD, 20); // פונט לכפתורי המשחק
    static final int ROWS = 3;  // מספר השורות במטריצה
    static final int COLS = 3;  // מספר העמודות במטריצה

     //נגדיר עוד כפתור 
    static JButton btn_play = new JButton("play");
    
    static JButton btnNewGame;
    static JLabel lblMsg;       // תוית להצגת הודעות
    static JButton[][] btnMat;  // מטריצת הכפתורים
    static char player;         // סימן השחקן שתורו לשחק כעת

    public static void main(String[] args)
    {
        initGame();
        createGUI();
    }

    private static void initGame()
    {
        player = 'X';
    }

    // פעולה היוצרת את הממשק הגרפי של המשחק
    private static void createGUI()
    {
        // יצירת החלון למחשבון
        JFrame win = new JFrame(WIN_TITLE);
        win.setSize(500, 500);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // יצירת פאנל עבור כפתורים לניהול המשחק
        JPanel pnlTop = new JPanel();

       
        //נבצע על הכפתור שינויים גרפיים
        btn_play.setFocusable(false);
        btn_play.setForeground(Color.red);
        btn_play.setFont(FONT2);
        //עדיין לא הצמדתי לו פה מאזין כי אני קודם רוצה שלתוך כל הכפתורים במשחק יוכנס התו רווח ואז אוכל לעשות את הבדיקה שלי
        
        
        // כפתור להתחלת משחק חדש
        btnNewGame = new JButton("New Game");
        btnNewGame.setFocusable(false);
        btnNewGame.setForeground(Color.BLUE);
        btnNewGame.setFont(FONT2);
        btnNewGame.setEnabled(false);//נעשה שלא יהיה ניתן ללחיצה בהתחלה
        btnNewGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                btnNewGame.setEnabled(false);//אם לחצנו עליו זאת אומרת שנגמר המשחק כי רק אז 
                newGame();
            }
        });
        pnlTop.add(btnNewGame);
        pnlTop.add(btn_play);//נוסיף אותו אחרי הכפתור של משחק חדש כיוון שנרצה אותו בימין לכפתור הזה 
       
        // יצירת פאנל לכפתורי לוח המשחק
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(ROWS, COLS));

        // מטריצה לשמירת כפתורי לוח המשחק
        btnMat = new JButton[ROWS][COLS];

        // יצירת כפתורי לוח המשחק והוספתם לחלון על פי הגריד שנקבע
        // לולאה שעוברת על כל השורות במטריצה
        for(int row = 0; row < ROWS; row++)
        {
            // לולאה שעוברת על כל העמודות
            for(int col = 0; col < COLS; col++)
            {
                //יצירת כפתור 
                btnMat[row][col] = new JButton(" ");
                btnMat[row][col].setFont(FONT1);
                btnMat[row][col].setFocusable(false);

                // הוספת מאזין לאירוע לחיצה על הכפתור
                btnMat[row][col].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // תן לי את הכפתור שנילחץ כעת
                        JButton btn = (JButton) e.getSource();
                        buttonClicked(btn);
                    }
                });

                // הוספת הכפתור לגריד שבפנאל
                pnlButtons.add(btnMat[row][col]);
            }
        }

        //הוספת מאזין לכפתור פליי
        btn_play.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                //לולאה שעוברת על השורות
                for(int row = 0; row < ROWS; row++)
                {
                    // לולאה שעוברת על כל העמודות
                    for(int col = 0; col < COLS; col++)
                    {
                        //אם לא עשינו בלחיצה הזו כבר תור של הכפתור ונפגשת בכפתור עם רווח
                        if(already == 0 && btnMat[row][col].getText().charAt(0) == ' ')                        
                        {
                            btnMat[row][col].setText(player + "");
                            btnMat[row][col].setEnabled(false);
                            already = 1;//נשנה על מנת שלא יחזור על עצמו
                            buttonClicked(btnMat[row][col]);//נגיד  לו כאילו אנחנו לחצנו על כפתור
                        }
                        
                    }
                }
                already = 0;// בסיום נרצה להחזיר את האפשרות ללחוץ שוב על הכפתור
            }
        });
        
        // יצירת תווית להצגת הודעות
        lblMsg = new JLabel(player + " Turn");
        lblMsg.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2)); // רווחים מסביב לתווית
        lblMsg.setOpaque(true);
        lblMsg.setFont(FONT2);

        // הוספת כפתור לתחילת משחק חדש לצפון החלון
        win.add(pnlTop, BorderLayout.NORTH);

        // הוספת הפאנל למרכז החלון
        win.add(pnlButtons, BorderLayout.CENTER);

        // הוספת התוית לדרום החלון
        win.add(lblMsg, BorderLayout.SOUTH);

        // מציג את החלון על המסך
        win.setVisible(true);
    }

       
    // בעת לחיצה על כפתור ריק שעל לוח המשחק תזומן פעולה זו
    public static void buttonClicked(JButton btn)
    {
        System.out.println(">> buttonClicked");

        // סימן השחקן על הכפתור
        btn.setText(player + "");

        // נעילת הכפתור
        btn.setEnabled(false);

        // בדיקת מצב המשחק
        // האם המשחק ניגמר בניצחון או בתיקו או ממשיכים לשחק
        checkGameStatus();
    }

    
    // הפעולה בודקת את מצב המשחק
    // האם המשחק ניגמר בניצחון או תיקו
    // אם המשחק לא ניגמר אז מבצעים החלפת תור שחקן
    public static void checkGameStatus()
    {
        System.out.print(">> checkGameStatus: ");

        //1. נבדוק האם יש ניצחון לשחקן הנוכחי זה ששיחק כעת
        // ====================================================
        Location[] winLocs = checkWin(player);
        if(winLocs != null)
        {
            System.out.println(player + " WIN!");
            lblMsg.setText("Game Over - " + player + " Win!");
            lblMsg.setBackground(Color.GREEN);
            btnNewGame.setEnabled(true);
            btn_play.setEnabled(false);
            setBoardButtonsEnabled(false);    // נעילת כל כפתורי הלוח
            colorWinLoc(winLocs);
            return;
        }

        //2. נבדוק האם יש תיקו כלומר נגמר המשחק ואף אחד לא ניצח
        // ====================================================
        if(checkTie() == true)
        {
            System.out.println("Game Over - Tie!");
            lblMsg.setText("Game Over - Tie!");
            lblMsg.setBackground(Color.GREEN);
            btnNewGame.setEnabled(true);
            btn_play.setEnabled(false);
            return;
        }

        //3. אין ניצחון ואין תיקו מחליפים תור וממשיכים לשחק
        // ====================================================
        System.out.println("switch players & continue to play...");
     
        // החלפת סימן שחקן תור מתחלף
        if(player == 'X')
        {
            player = 'O';
        }
        else
        {
            player = 'X';
        }
        
        lblMsg.setText(player + " Turn");
    }
    
    // פעולה שבודקת האם המשחק נגמר בתיקו
    // true אם כן הפעולה מחזירה
    // false אם לא הפעולה מחזירה
    public static boolean checkTie()
    {
        for(int row = 0; row < ROWS; row++)        
        {
            for(int col = 0; col < COLS; col++)            
            {
                // אם יש כפתור פנוי אז אין תיקו
                if(btnMat[row][col].getText().equals(" "))
                    return false;
            }
        }
            
        // אם היגענו לכאן זה אומר שיש תיקו
        return true;
    }

    // פעולה לבדיקת ניצחון עבור שחקן מסוים
    // הפעולה מקבלת סימן של שחקן ובודקת האם יש לו ניצחון
    // אם יש לשחקן ניצחון הפעולה מחזירה מערך של מיקומים
    // nullאם אין לשחקן ניצחון הפעולה מחזירה 
    public static Location[] checkWin(char player)
    {
        boolean isWin;

        // נבדוק האם יש ניצחון לשחקן הנוכחי באחת מהשורות
        for(int row = 0; row < ROWS; row++)
        {
            isWin = true;
            for(int col = 0; col < COLS; col++)
            {
                if(btnMat[row][col].getText().charAt(0) != player)
                {
                    isWin = false;
                    break;
                }
            }
            if(isWin == true)
            {
                Location[] winLocArr = new Location[ROWS];
                for(int i = 0; i < COLS; i++)
                {
                    winLocArr[i] = new Location(row, i);
                }
                return winLocArr;
            }
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באחת מהעמודות
        for(int col = 0; col < COLS; col++)
        {
            isWin = true;
            for(int row = 0; row < ROWS; row++)
            {
                if(btnMat[row][col].getText().charAt(0) != player)
                {
                    isWin = false;
                    break;
                }
            }
            if(isWin == true)
            {
                Location[] winLocArr = new Location[ROWS];
                for(int i = 0; i < ROWS; i++)
                {
                    winLocArr[i] = new Location(i, col);
                }
                return winLocArr;
            }
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באלכסון הראשי
        isWin = true;
        for(int i = 0; i < ROWS; i++)
        {
            if(btnMat[i][i].getText().charAt(0) != player)
            {
                isWin = false;
                break;
            }
        }
        if(isWin == true)
        {
            Location[] winLocArr = new Location[ROWS];
            for(int i = 0; i < ROWS; i++)
            {
                winLocArr[i] = new Location(i, i);
            }
            return winLocArr;
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באלכסון משני
        isWin = true;
        for(int i = 0; i < ROWS; i++)
        {
            if(btnMat[i][ROWS - i - 1].getText().charAt(0) != player)
            {
                isWin = false;
                break;
            }
        }
        if(isWin == true)
        {
            Location[] winLocArr = new Location[ROWS];
            for(int i = 0; i < ROWS; i++)
            {
                winLocArr[i] = new Location(i, ROWS - i - 1);
            }
            return winLocArr;
        }

        // אם הגענו לכאן לא נמצא ניצחון בלוח
        return null;
    }


    // פעולה לנעילה או פתיחה של כל כפתורי הלוח על פי הפרמטר שמתקבל
    // status=true - נעילה
    // status=false - פתיחה
    private static void setBoardButtonsEnabled(boolean status)
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                btnMat[row][col].setEnabled(status);
            }
        }
    }

    // פעולה שמנקה את כפתורי לוח המשחק
    private static void cleanBoard()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                btnMat[row][col].setText(" ");
                btnMat[row][col].setBackground(null);
            }
        }
    }

    // פעולה למשחק חדש
    private static void newGame()
    {
        // 1. ניקוי הלוח
        cleanBoard();
        lblMsg.setBackground(null);

        // 2. לפתוח נעילות כפתורים
        setBoardButtonsEnabled(true);
        //אם לחצנו על משחק חדש נרצה לאפשר שוב למחשב לעשות תור
        btn_play.setEnabled(true);
        
        player = 'X';
        // 3. שחקן מתחיל והודעה
        lblMsg.setText(player + " Turn");
    }

    
    // פעולה שצובעת את מיקום הניצחון
    private static void colorWinLoc(Location[] locArr)
    {
        for(int i = 0; i < locArr.length; i++)
        {
            Location loc = locArr[i];
            btnMat[loc.getRow()][loc.getCol()].setBackground(Color.YELLOW);
        }
    }
}
