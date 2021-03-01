package ver3;

import java.util.ArrayList;
import javax.swing.JButton;
import static ver3.Main.checkWin;
import static ver3.Main.player;

/**
 *  Document   : model
 *  Created on : 24/11/2020, 17:46:45
 *  Author     : נועם
 */
public class model
{
    static JButton[][] btnMat;  // מטריצת הכפתורים
    static final int ROWS = 3;  // מספר השורות במטריצה
    static final int COLS = 3;  // מספר העמודות במטריצה

    public model()
    {
    }
    
    
    // בדיקת ניצחון
    public static ArrayList<Location> checkWin(char player)
    {
        // רשימת מיקומי 
        ArrayList<Location> winLocList = new ArrayList();

        // נבדוק האם יש ניצחון לשחקן הנוכחי באחת מהשורות
        for (int row = 0; row < ROWS; row++)
        {
            winLocList.clear();
            for (int col = 0; col < COLS; col++)
            {
                if (btnMat[row][col].getText().charAt(0) != player)
                    break;
                else
                    winLocList.add(new Location(row, col));
            }
            if (winLocList.size() == ROWS)
                return winLocList;
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באחת מהעמודות
        for (int col = 0; col < COLS; col++)
        {
            winLocList.clear();
            for (int row = 0; row < ROWS; row++)
            {
                if (btnMat[row][col].getText().charAt(0) != player)
                    break;
                else
                    winLocList.add(new Location(row, col));
            }
            if (winLocList.size() == COLS)
                return winLocList;
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באלכסון הראשי
        winLocList.clear();
        for (int i = 0; i < ROWS; i++)
        {
            if (btnMat[i][i].getText().charAt(0) != player)
                break;
            else
               winLocList.add(new Location(i, i));  
        }
        if (winLocList.size() == ROWS)
            return winLocList;

        // נבדוק האם יש ניצחון לשחקן הנוכחי באלכסון משני
        winLocList.clear();
        for (int i = 0; i < ROWS; i++)
        {
            if (btnMat[i][ROWS - i - 1].getText().charAt(0) != player)
                break;
            else
                winLocList.add(new Location(i, ROWS - i - 1));
        }
        if (winLocList.size() == ROWS)
            return winLocList;

        // אם הגענו לכאן לא נמצא ניצחון בלוח
        return null;
    }
    /**
     * הפעולה בודקת האם המשחק ניגמר
     * @return 'X' if x won, or 'O' if player o won, or 'T' if Tie, or ' ' game not over
     */
    public static char checkGameStatus()
    {
        System.out.print(">> checkGameStatus: ");
        
        //1. נבדוק האם יש ניצחון לשחקן הנוכחי זה ששיחק כעת
        // =============================================
        ArrayList<Location> winLocs = checkWin(player);
        if(winLocs != null)
        {
            System.out.println(player + " WIN! " + winLocs);
           // colorWinLoc(winLocs);
            return player;
        }

          
        //2. נבדוק האם יש תיקו כלומר נגמר המשחק ואף אחד לא ניצח
        // ====================================================
        boolean isTie = true;
        for(int row = 0; row < ROWS; row++)        
        {
            for(int col = 0; col < COLS; col++)            
            {
                if(btnMat[row][col].getText().equals(" "))
                    isTie = false;
            }
        }
        if(isTie == true)
        {
            System.out.println("TIE - No Winners!");
            return 'T';
        }
        
        //3. אין ניצחון ואין תיקו המשחק ממשיך
        // ====================================================
        System.out.println("continue to play...");
        return ' ';
    }
    
    
}
