package ver3_MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import static ver3_MVC.Main.checkTie;
//import static ver3_MVC.Main.checkWin;

/**
 * View - XO Game GUI 
 * 26/1/2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class View 
{
    // קבועים
    
    static final int BUTTON_SIZE = 120;  // ממדי הכפתור בלוח המשחק
    public static final String WIN_TITLE = "XO Game (ver3_MVC)";
    public static final Font FONT1 = new Font(null, Font.BOLD, 60);  // פונט לכפתורים
    public static final Font FONT2 = new Font(null, Font.BOLD, 16);  // פונט לכפתורים
    private static int ROWS;  // מספר השורות במטריצה
    private static int COLS;  // מספר העמודות במטריצה

    // משתנים 
    private JFrame win;
    private JButton btnNewGame, btnAIMove;
    private JLabel lblMsg;       // תוית להצגת תור מי לשחק
    private JButton[][] btnMat;  // מטריצת הכפתורים
    private Controller controller;
    
    
    
    public View(int boardSize, Controller controller)
    {
        // Load assets...
        ROWS = boardSize;
        COLS = boardSize;
        
        this.controller = controller;
        
        // Create GUI...
        createGUI();
    }
    
    private char getplayer(){
        return controller.getPlayer();
    }
    
    
     // בעת לחיצה על כפתור תזומן פעולה זו
    public void doHumanMove(JButton btn)
    {
        System.out.println(">> buttonClicked");

        // סימן השחקן על הכפתור
        btn.setText( this.getplayer() + "");

        // נעילת הכפתור
        btn.setEnabled(false);
        controller.boardButtonPressed(getBtnLoc(btn));

        // בדיקת מצב המשחק
        // האם המשחק ניגמר בניצחון או בתיקו או ממשיכים לשחק
        //checkGameStatus();
        //controller.
    }
    
    public Location getBtnLoc(JButton btn){
        // Tell to Controller that Board Button was pressed!
        String indexs = btn.getActionCommand(); // get indexes (row,col)
        System.out.println("button indexs = " + indexs);
        int row = Integer.parseInt(indexs.substring(0, indexs.indexOf(',')));
        int col = Integer.parseInt(indexs.substring(indexs.indexOf(',')+1));
        return new Location(row,col);
    }
    
    public void setup()
    {
        for (int row = 0; row < ROWS; row++)
        {
            // לולאה שעוברת על כל העמודות
            for (int col = 0; col < COLS; col++)
            {
                btnMat[row][col].setText(" ");
                btnMat[row][col].setEnabled(true);
                btnMat[row][col].setBackground(Color.WHITE);
            }
        }
        
        btnNewGame.setEnabled(false);
        btnAIMove.setEnabled(true);
        lblMsg.setText("X Turn");
    }
    
    // פעולה היוצרת את הממשק הגרפי של המשחק
    private void createGUI()
    {
        // יצירת החלון למחשבון
        win = new JFrame(WIN_TITLE);
        win.setSize(400, 400);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // יצירת פאנל עליון לכפתורי ניהול המשחק
        JPanel pnlTop = new JPanel();
        pnlTop.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        
        // כפתור להתחלת משחק חדש
        btnNewGame = new JButton("New Game");
        btnNewGame.setFocusable(false);
        btnNewGame.setForeground(Color.BLUE);
        btnNewGame.setFont(FONT2);
        btnNewGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                // TODO: tell to controller that newGame button, pressed!
                controller.newGameButtonPressed();
            }
        });
        pnlTop.add(btnNewGame);

        // כפתור לשחקן ממוחשב
        btnAIMove = new JButton("AI Move");
        btnAIMove.setFocusable(false);
        btnAIMove.setForeground(Color.BLUE);
        btnAIMove.setFont(FONT2);
        btnAIMove.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                // TODO: tell to controller that btnAI button, pressed!
                //controller.aiMoveButtonPressed();
                doAIMove();
            }
        });
        pnlTop.add(btnAIMove);

        // יצירת פאנל לכפתורים
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(ROWS, COLS));

        // מערך הכפתורים של המחשבון
        btnMat = new JButton[ROWS][COLS];

        // יצירת כל כפתורי המחשבון קביעת הפונט שלהם והוספתם לחלון על פי גריד שנקבע
        // לולאה שעוברת על כל השורות במטריצה
        for (int row = 0; row < ROWS; row++)
        {
            // לולאה שעוברת על כל העמודות
            for (int col = 0; col < COLS; col++)
            {
                // יצירת כפתור בלוח המשחק
                btnMat[row][col] = new JButton(" "); 
                btnMat[row][col].setFont(FONT1);
                btnMat[row][col].setFocusable(false);
                btnMat[row][col].setActionCommand(row + "," + col); // save indexs (row,col)
                
                // הוספת מאזין לאירוע לחיצה על הכפתור
                btnMat[row][col].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // Tell to Controller that Board Button was pressed!
                        JButton btn = (JButton) e.getSource();
                        controller.boardButtonPressed(getBtnLoc(btn));
                    }
                });

                // הוספת הכפתור לגריד שבפנאל
                pnlButtons.add(btnMat[row][col]);
            }
        }

        lblMsg = new JLabel("?");
        lblMsg.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2));
        lblMsg.setOpaque(true);
        lblMsg.setFont(FONT2);

        // הוספת כפתור לתחילת משחק חדש לצפון החלון
        win.add(pnlTop, BorderLayout.NORTH);

        // הוספת הפאנל למרכז החלון
        win.add(pnlButtons, BorderLayout.CENTER);

        // הוספת התוית לדרום החלון
        win.add(lblMsg, BorderLayout.SOUTH);

        // מרכז החלון
        win.setLocationRelativeTo(null);
        
        // מציג את החלון על המסך
        win.setVisible(true);
    }
   
    
    private void setBoardButtonsEnabled(boolean status)
    {
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                btnMat[row][col].setEnabled(status);
            }
        }
    }
    
    
    // פעולה שצובעת את מיקום הניצחון
    public void colorWinLoc(ArrayList<Location> winLocList)
    {
        for (int i = 0; i < winLocList.size(); i++)
        {
            Location loc = winLocList.get(i);
            btnMat[loc.getRow()][loc.getCol()].setBackground(Color.YELLOW);
        }
    }
    
    
    // הפעולה בודקת את מצב המשחק
    // האם המשחק ניגמר בניצחון או תיקו
    // אם המשחק לא ניגמר אז מבצעים החלפת תור שחקן
    private void checkGameStatus()
    {
        System.out.print(">> checkGameStatus: ");

        
        

        
        

        //3. אין ניצחון ואין תיקו מחליפים תור וממשיכים לשחק
        // ====================================================
        System.out.println("switch players & continue to play...");

        
        lblMsg.setText(this.getplayer() + " Turn");
    }
    
    
    public void tie(){
        System.out.println("Game Over - Tie!");
        lblMsg.setText("Game Over - Tie!");
        btnAIMove.setEnabled(false);
        btnNewGame.setEnabled(true);
        lblMsg.setBackground(Color.GREEN);
    }
    
    
    private void cleanBoard()
    {
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                btnMat[row][col].setText(" ");
                btnMat[row][col].setBackground(Color.WHITE);
            }
        }
    }
    
    private void newGame()
    {
        // 1. ניקוי הלוח
        cleanBoard();

        // 2. לפתוח נעילות כפתורים
        setBoardButtonsEnabled(true);
        btnNewGame.setEnabled(false);
        

        // 3. שחקן מתחיל והודעה
        controller.startNewGame();
        lblMsg.setText(getplayer() + " Turn");
        lblMsg.setBackground(null);
    }
    
    // ביצוע מהלך של שחקן ממוחשב
    public void doAIMove()
    {
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (btnMat[row][col].getText().equals(" "))
                {
                    // option 1
                    //checkGameStatus();
                    
                    // option 2
                   controller.boardButtonPressed(new Location(row, col));
                    return;
                }
            }
        }
    }
    
    
    public void updateBoardButton(Location loc, char player)
    {
        btnMat[loc.getRow()][loc.getCol()].setText(player+"");
        btnMat[loc.getRow()][loc.getCol()].setEnabled(false);
    }

    
    public void win(ArrayList<Location> winLoc, char currentPlayer)
    {
        System.out.println(currentPlayer + " WIN!");
        lblMsg.setText("Game Over - " + currentPlayer + " Win!");
        setBoardButtonsEnabled(false);    // נעילת כל הכפתורים
        btnAIMove.setEnabled(false);
        btnNewGame.setEnabled(true);
        lblMsg.setBackground(Color.GREEN);
        colorWinLoc(winLoc);
    }
}
