package ver3_MVC;

import java.util.ArrayList;

/**
 * Controller - XO Game Main Controller
 * 26/1/2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class Controller 
{
    // Constants - קבועים
    public static final int DEFAULT_BOARD_SIZE = 3;

    public void win(ArrayList<Location> a)
    {
        view.win(a,currentPlayer);
        
    }
    

    public void tie()
    {
        view.tie();
    }
    
    // Fields - תכונות
    private Model model;  // מודל
    private View view;    // תצוגה
    private char currentPlayer; // סימן השחקן הנוכחי זה שתורו לשחק כעת

    /**
     * יצירת המשחק פעם יחידה בלבד
     */
    public Controller()
    {
        // Load assets...
        
        // Create the game Model & View
        model = new Model(DEFAULT_BOARD_SIZE);
        view = new View(DEFAULT_BOARD_SIZE, this);
    }
    
    
     /**
     * New Game setup.
     * called every time new game started
     */
    public void startNewGame()
    {
        
        currentPlayer = 'X';
        model.setup();  // לוח משחק לוגי למצב התחלת משחק
        view.setup();   // לוח משחק תצוגה למצב התחלת משחק
    }
    
    public char getPlayer(){
            return currentPlayer;
    }
    
    // btnNewGame פעולה זו מזומנת על ידי התצוגה בעת לחיצה על כפתור
    // לצורך ביצוע התחלת משחק חדש
    public void newGameButtonPressed()
    {
        System.out.println("newGameButtonPressed");
        startNewGame();
    }
     
    // btnAIMoveפעולה זו מזומנת על ידי התצוגה בעת לחיצה על כפתור 
    // לצורך ביצוע מהלך של שחקן ממוחשב
    public void aiMoveButtonPressed()
    {
        System.out.println("aiMoveButtonPressed");
        // צריך לבקש מהמודל מהלך ממוחשב אקראי או ראשון פנוי או בינה מלאכותית
        view.doAIMove();
        
        
    }
    
    public void changePlayer(){
        if(currentPlayer == 'X')
            currentPlayer = 'O';
        else
            currentPlayer = 'X';
    }
    
    
    
    // פעולה זו מזומנת על ידי התצוגה בעת לחיצה על אחד מכפתורי לוח המשחק
    // לצורך ביצוע מהלך של שחקן אנושי
    public void boardButtonPressed(Location loc)
    {
        System.out.println("boardButtonPressed loc="+loc);
        // update model - שם את סימן השחקן הנוכחי במיקום שקיבלת
        
        model.updateBoardButton(loc, currentPlayer);
        
        // update view - שים בכפתור הלוח במיקום שהתקבל את סימן השחקן
        view.updateBoardButton(loc, currentPlayer);
        
        // check Game Over ?
        
        this.changePlayer();
    }
    
    // פעולה ראשית
    public static void main(String[] args)
    {
        Controller game = new Controller();
        game.startNewGame();
    }
}
