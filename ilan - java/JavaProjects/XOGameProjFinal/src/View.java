/**
 *  Document   : View
 *  Created on : 02/02/2021, 16:14:52
 *  Author     : Noam
 */
//package ver3_MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * View - XO Game GUI 
 * 26/1/2021
 * By Ilan Peretz (ilanperets@gmail.com).
 */
public class View 
{
    // קבועים
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
        startColors();
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
        lblMsg.setBackground(null);
        
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
                controller.aiMoveButtonPressed();
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
                        String indexs = btn.getActionCommand(); // get indexes (row,col)
                        int row = Integer.parseInt(indexs.substring(0, indexs.indexOf(',')));
                        int col = Integer.parseInt(indexs.substring(indexs.indexOf(',')+1));
                        
                        controller.boardButtonPressed(new Location(row,col));
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
   
    public void updateBoardButton(Location loc, char player)
    {
        btnMat[loc.getRow()][loc.getCol()].setText(player+"");
        btnMat[loc.getRow()][loc.getCol()].setEnabled(false);
    }

    public void gameOver(String msg, ArrayList<Location> winLocs)
    {
        // lock all board buttons
        setBoardButtonsEnabled(false);
        btnNewGame.setEnabled(true);
        btnAIMove.setEnabled(false);
        
        lblMsg.setText(msg);
        lblMsg.setBackground(Color.GREEN);
        
        if(winLocs != null)
            colorWinLoc(winLocs);
    }
    
    // פעולה לנעילה או פתיחה של כל כפתורי הלוח על פי הפרמטר שמתקבל
    // status=true - נעילה
    // status=false - פתיחה
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
    private void colorWinLoc(ArrayList<Location> winLocList)
    {
        for (int i = 0; i < winLocList.size(); i++)
        {
            Location loc = winLocList.get(i);
            btnMat[loc.getRow()][loc.getCol()].setBackground(Color.YELLOW);
        }
    }

    public void setLableMsg(String msg)
    {
        lblMsg.setText(msg);
    }
    
    public void startColors(){
        
        btnNewGame.setEnabled(false);
        
        //להפוך ללבן את רקע כל הכפתורים
        for(int row= 0; row < ROWS; row++)        
        {
            for(int col= 0; col < COLS; col++)            
            {
                btnMat[row][col].setBackground(Color.WHITE);
            }
        }
        
        Color arr[] = new Color[5];
        arr[0] = Color.CYAN;
        arr[1] = Color.BLUE;
        arr[2] = Color.RED;
        arr[4] = Color.ORANGE;
        arr[3] = Color.GREEN;
        
        //רץ על המערך של הצבעים
        for(int i = 0; i < 5; i++)        
        {
            //ירוץ על השורות
            for(int row= 0; row < ROWS; row++)        
            {
                //נעשה שורה שורה את הצבע במיקום של המערך של הצבעים
                for(int j= 0; j < COLS; j++)                
                {
                    btnMat[row][j].setBackground(arr[i]);
                    btnMat[row][j].setBackground(arr[i]);
                    btnMat[row][j].setBackground(arr[i]);
                }
                
                
                //כדי שלא יהיה יותר מדי מהיר נעשה לו סליפ
                try
                {
                    Thread.sleep(125);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                //נדאג להחזיר את הכל ללבן כמו שהיה ושלא ישאר הצבע האחרון שהוצג
                for(int j= 0; j < COLS; j++)                
                {
                    btnMat[row][j].setBackground(Color.WHITE);
                    btnMat[row][j].setBackground(Color.WHITE);
                    btnMat[row][j].setBackground(Color.WHITE);
                }
            }
            
    
        }
    }
    
}

