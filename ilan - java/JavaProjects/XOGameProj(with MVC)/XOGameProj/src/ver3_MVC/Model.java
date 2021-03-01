package ver3_MVC;


import java.util.ArrayList;


/**
 * Model - XO Game Logic
 * 26/1/2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Model 
{
    // תכונות
    private char[][] logicBoard; // לוח משחק לוגי
    private int logicBoardSize;
    
    private Controller controller = new Controller();
    /**
     * 
     * @param boardSize 
     */
    public Model(int boardSize)
    {
        // יצירת לוח לוגי לצורך בדיקות וקבלת החלטות במשחק
        logicBoard = new char[boardSize][boardSize];
        logicBoardSize = boardSize;
    }
    
    
    
    public ArrayList<Location> checkWin(char player)
    {
        // רשימת מיקומי 
        ArrayList<Location> winLocList = new ArrayList();

        // נבדוק האם יש ניצחון לשחקן הנוכחי באחת מהשורות
        for (int row = 0; row < logicBoardSize; row++)
        {
            winLocList.clear();
            for (int col = 0; col < logicBoardSize; col++)
            {
                if (logicBoard[row][col]/*.getText().charAt(0)*/ != player)
                {
                    break;
                } else
                {
                    winLocList.add(new Location(row, col));
                }
            }
            if (winLocList.size() == logicBoardSize)
            {
                return winLocList;
            }
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באחת מהעמודות
        for (int col = 0; col < logicBoardSize; col++)
        {
            winLocList.clear();
            for (int row = 0; row < logicBoardSize; row++)
            {
                if (logicBoard[row][col]/*.getText().charAt(0)*/ != player)
                {
                    break;
                } else
                {
                    winLocList.add(new Location(row, col));
                }
            }
            if (winLocList.size() == logicBoardSize)
            {
                return winLocList;
            }
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באלכסון הראשי
        winLocList.clear();
        for (int i = 0; i < logicBoardSize; i++)
        {
            if (logicBoard[i][i]/*.getText().charAt(0)*/ != player)
            {
                break;
            } else
            {
                winLocList.add(new Location(i, i));
            }
        }
        if (winLocList.size() == logicBoardSize)
        {
            return winLocList;
        }

        // נבדוק האם יש ניצחון לשחקן הנוכחי באלכסון משני
        winLocList.clear();
        for (int i = 0; i < logicBoardSize; i++)
        {
            if (logicBoard[i][logicBoardSize - i - 1]/*.getText().charAt(0)*/ != player)
            {
                break;
            } else
            {
                winLocList.add(new Location(i, logicBoardSize - i - 1));
            }
        }
        if (winLocList.size() == logicBoardSize)
        {
            return winLocList;
        }

        // אם הגענו לכאן לא נמצא ניצחון בלוח
        return null;
    }
    
    // פעולה שבודקת האם המשחק נגמר בתיקו
    // true אם כן הפעולה מחזירה
    // false אם לא הפעולה מחזירה
    public boolean checkTie()
    {
        for (int row = 0; row < logicBoardSize; row++)
        {
            for (int col = 0; col < logicBoardSize; col++)
            {
                // אם יש כפתור פנוי אז אין תיקו
                if (logicBoard[row][col]/*.getText().equals(" ")*/ == ' ')
                {
                    return false;
                }
            }
        }

        // אם היגענו לכאן זה אומר שיש תיקו
        return true;
    }
    
    public Location firstLocEmpty(){
        Location l = new Location();
       for(int row = 0; row < logicBoardSize; row++)        
        {
            for(int col = 0; col < logicBoardSize; col++)            
            {
                if(logicBoard[row][col] == ' ')                
                {
                    l = new Location(row,col);
                }
            }
        }
        return l;
    }
    
    // פעולה לאתחול לוגי של משחק חדש
    public void setup()
    {
        for(int i = 0; i < logicBoardSize; i++)        
        {
            for(int j = 0; j < logicBoardSize; j++)            
            {
                logicBoard[i][j] = ' ';
            }
        }
    }

    void updateBoardButton(Location loc, char currentPlayer)
    {
        logicBoard[loc.getRow()][loc.getCol()] = currentPlayer;
        ArrayList<Location> a =  checkWin(currentPlayer);
        if(a != null) {       
            controller.win(a);
            return;
        }
        if(checkTie()){
            controller.tie();
        }
                    
        
    }
}
