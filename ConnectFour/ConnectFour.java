import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.Timer;
public class ConnectFour extends JPanel implements KeyListener {
    int[][] board = new int[6][7];
    boolean gameOver;
    Timer timer = new Timer();
    int turn = 1;
    boolean[][] filled = new boolean[6][7];
    JFrame frame;
    public ConnectFour() {
        frame = new JFrame("Connect Four");
        frame.setSize(1500,1500);
        frame.add(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 =  (Graphics2D)g;
        g2.setColor(Color.BLUE);
        g2.fillRect(0,0,frame.getWidth(),frame.getHeight());
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(6));

        if (turn == 1) {
            g2.setColor(Color.RED);
        }
        else {
            g2.setColor(Color.ORANGE);
        }
        g2.fillOval(frame.getWidth()/2-50,50,75,75);
        g2.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans",Font.BOLD,60));
        g.drawString("Turn", frame.getWidth()/2+50,115);
        /*for (int i = 0; i < board.length+2; i ++) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.PLAIN,50));
            if (i == 1) {
                g.drawString("A",200,i*100+70);
            }
            if (i == 2) {
                g.drawString("B",200,i*100+70);
            }
            if (i == 3) {
                g.drawString("C",200,i*100+70);
            }
            if (i == 4) {
                g.drawString("D",200,i*100+70);
            }
            if (i == 5) {
                g.drawString("E",200,i*100+70);
            }
            if (i == 6) {
                g.drawString("F",200,i*100+70);
            }
            if (i == 7) {
                g.drawString("G",200,i*100+70);
            }
        }*/
        g.setColor(Color.WHITE);
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                g2.drawRect(i*100+450,j*100+140,100,100);
            }
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    g2.setColor(Color.RED);
                    g2.fillOval(i * 100 + 460, j * 100 + 150, 75, 75);
                } else if (board[i][j] == 2) {
                    g2.setColor(Color.ORANGE);
                    g2.fillOval(i * 100 + 460, j * 100 + 150, 75, 75);
                }
            }
        }
        if (gameOver) {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,frame.getWidth(),frame.getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans",Font.BOLD,60));
            g.drawString("Thanks for playing!", frame.getWidth()/2 - 275,frame.getHeight()/2);

        }
    }
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if(e.getKeyCode() == 49) {
            int counter = 0;
            while(counter < 7) {
                if (filled[0][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[0][6-counter] = true;
                    if (turn == 1) {
                        board[0][6-counter] = 1;
                        turn = 2;
                        break;
                    }
                    else {
                        board[0][6-counter] = 2;
                        turn = 1;
                        break;
                    }
                }
            }
            counter = 0;
        }
        if(e.getKeyCode() == 50) {
            int counter = 0;
            while(counter < 7) {
                if (filled[1][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[1][6-counter] = true;
                    if (turn == 1) {
                        board[1][6-counter] = 1;
                        turn = 2;
                        break;
                    }
                    else {
                        board[1][6-counter] = 2;
                        turn = 1;
                        break;
                    }
                }
            }
            counter = 0;
        }
        if(e.getKeyCode() == 51) {
            int counter = 0;
            while(counter < 7) {
                if (filled[2][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[2][6-counter] = true;

                    if (turn == 1) {
                        board[2][6-counter] = 1;
                        turn = 2;

                        break;
                    }
                    else {
                        board[2][6-counter] = 2;
                        turn = 1;

                        break;
                    }
                }
            }
            counter = 0;
        }
        if(e.getKeyCode() == 52) {
            int counter = 0;
            while(counter < 7) {
                if (filled[3][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[3][6-counter] = true;

                    if (turn == 1) {
                        board[3][6-counter] = 1;
                        turn = 2;

                        break;
                    }
                    else {
                        board[3][6-counter] = 2;
                        turn = 1;

                        break;
                    }
                }
            }
            counter = 0;
        }
        if(e.getKeyCode() == 53) {
            int counter = 0;
            while(counter < 7) {
                if (filled[4][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[4][6-counter] = true;

                    if (turn == 1) {
                        board[4][6-counter] = 1;
                        turn = 2;

                        break;
                    }
                    else {
                        board[4][6-counter] = 2;
                        turn = 1;

                        break;
                    }
                }
            }
            counter = 0;
        }
        if(e.getKeyCode() == 54) {
            int counter = 0;
            while(counter < 7) {
                if (filled[5][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[5][6-counter] = true;

                    if (turn == 1) {
                        board[5][6-counter] = 1;
                        turn = 2;

                        break;
                    }
                    else {
                        board[5][6-counter] = 2;
                        turn = 1;

                        break;
                    }
                }
            }
            counter = 0;
        }
        if(e.getKeyCode() == 55) {
            int counter = 0;
            while(counter < 7) {
                if (filled[6][6-counter]) {
                    counter++;
                    continue;
                }
                else {
                    filled[6][6-counter] = true;

                    if (turn == 1) {
                        board[6][6-counter] = 1;
                        turn = 2;

                        break;
                    }
                    else {
                        board[6][6-counter] = 2;
                        turn = 1;

                        break;
                    }
                }
            }
            counter = 0;
        }
        if (gameOver()) {
            gameOver = true;
            //System.out.println("Game over");
            repaint();
            //System.exit(0);
        }
        repaint();

    }
    public boolean gameOver() {
        
        
       for (int i = 0; i < board.length; i ++) {
           for (int j = 0; j < board[0].length - 3; j ++) {
               if (board[i][j] != 0 && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3]) {
                   return true;
               }
           }
       }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length - 4; j ++) {
                if (board[j][i] != 0 && board[j][i] == board[j+1][i] && board[j][i] == board[j+2][i] && board[j][i] == board[j+3][i]) {
                    return true;
                }
            }
        }

        for (int row = 0; row < board.length - 2; row++) {
            for (int col = 0; col < board.length - 2; col ++) {
                if(board[row][col] != 0 && board[row][col] == board[row+1][col+1] && board[row][col] == board[row+2][col+2] && board[row][col] == board[row+3][col+3]) {
                    return true;
                }
            }
        }
        for (int row = board.length - 1; row >= 2; row--) {
            for (int col = 0; col < board.length - 2; col ++) {
                if(board[row][col] != 0 && board[row][col] == board[row-1][col+1] && board[row][col] == board[row-2][col+2] && board[row][col] == board[row-3][col+3]) {
                    return true;
                }
            }
        }
        for (int row = 0; row < board.length - 2; row++) {
            for (int col = board.length - 1; col >= 2; col --) {
                if(board[row][col] != 0 && board[row][col] == board[row+1][col-1] && board[row][col] == board[row+2][col-2] && board[row][col] == board[row+3][col-3]) {
                    return true;
                }
            }
        }
        for (int row = board.length - 1; row >= 2; row--) {
            for (int col = board.length - 1; col >= 2; col --) {
                if(board[row][col] != 0 && board[row][col] == board[row-1][col-1] && board[row][col] == board[row-2][col-2] && board[row][col] == board[row-3][col-3]) {
                    return true;
                }
            }
        }

        return false;

    }

    public void keyTyped(KeyEvent e)
    {

    }
    public void keyReleased(KeyEvent e)
    {

    }
    public static void main(String[] args) {
        ConnectFour app = new ConnectFour();
    }
}
