import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ReactionTester extends JFrame implements MouseListener{

    JPanel panel; // the panel we put are buttons in
    JButton button1, button2, button3, button4; // the buttons

    JLabel label, time_label; // label to display text

    String current_color; // variable to hold current color

    String[] arr = {"Red", "Blue", "Green", "Yellow"}; // colors
    int score = 0;

    int FRAME_WIDTH = 500;
    int LABEL_WIDTH = 100;
    int LABEL_HEIGHT = 20;
    int FRAME_HEIGHT = 500;
    int PANEL_WIDTH = 300;
    int PANEL_HEIGHT = 300;

    int PANEL_X = 90;
    int PANEL_Y = 80;
    Font label_font = new Font("Arial", Font.BOLD, 20);
    Font button_font = new Font("Comic Man Sans", Font.BOLD, 20);

    Color label_color;
    public ReactionTester() {

        // normal frame stuff
        this.setTitle("Reaction tester game");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        // instantiating panel
        panel = new JPanel();
        panel.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
        panel.setLayout(new GridLayout(2, 2));

        // setting buttons
        button1 = new JButton("Red");
        button1.setOpaque(true);
        button1.setFont(button_font);
        button1.setBackground(Color.RED);

        button2 = new JButton("Blue");
        button2.setOpaque(true);
        button2.setFont(button_font);
        button2.setBackground(Color.BLUE);

        button3 = new JButton("Yellow");
        button3.setOpaque(true);
        button3.setFont(button_font);
        button3.setBackground(Color.YELLOW);

        button4 = new JButton("Green");
        button4.setOpaque(true);
        button4.setFont(button_font);
        button4.setBackground(Color.GREEN);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);

        current_color = arr[rand()];

        // setting label
        label = new JLabel(current_color);
        label.setBounds(PANEL_X + PANEL_WIDTH/2 - 20, PANEL_Y + PANEL_HEIGHT + 20 , LABEL_WIDTH, LABEL_HEIGHT);
        setLabelColor();
        label.setForeground(label_color);
        label.setFont(label_font);
        //label.setOpaque(true);

        // setting time label
        time_label = new JLabel();
        time_label.setBounds(PANEL_X + PANEL_WIDTH/2 - 10,PANEL_Y - 40, LABEL_WIDTH, LABEL_HEIGHT);
        time_label.setFont(label_font);
        time_label.setForeground(Color.WHITE);

        this.add(panel);
        this.add(label);
        this.setVisible(true);
        this.add(time_label);
        try {
            setTimer();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong");
        }

    }

    public int rand() {
        return (int) (Math.random() * 4);
    }
    public void setLabelColor () {
        switch (current_color) {
            case "Red": label_color = Color.RED; label.setForeground(label_color); break;
            case "Blue": label_color = Color.BLUE; label.setForeground(label_color); break;
            case "Green": label_color = Color.GREEN; label.setForeground(label_color); break;
            case "Yellow": label_color = Color.YELLOW; label.setForeground(label_color); break;
            default: label_color = Color.WHITE;

        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == button1) {
            if (current_color.equals("Red"))  {

                // generating random number that was different from the one before
                int r = rand();
                //while (arr[r].equals(current_color)) r = rand();

                // setting the current color to a random color
                current_color = arr[r];
                // setting the label to that color
                setLabelColor();
                // setting the label text
                label.setText(current_color);

                // incrementing score
                score++;
            }

        }
        if (e.getSource() == button2) {
            if (current_color.equals("Blue"))  {
                int r = rand();
                //while (arr[r].equals(current_color)) r = rand();
                current_color = arr[r];
                setLabelColor();
                label.setText(current_color);
                label.setForeground(label_color);
                score++;

            }

        }
        if (e.getSource() == button3) {
            if (current_color.equals("Yellow"))  {
                int r = rand();
                //while (arr[r].equals(current_color)) r = rand();
                current_color = arr[r];
                setLabelColor();
                label.setText(current_color);
                label.setForeground(label_color);
                score++;

            }

        }
        if (e.getSource() == button4) {
            if (current_color.equals("Green"))  {
                int r = rand();
                //while (arr[r].equals(current_color)) r = rand();
                current_color = arr[r];
                setLabelColor();
                label.setText(current_color);
                label.setForeground(label_color);
                score++;

            }

        }
    }

    // 10-second timer that stops the program after the time is up
    public void setTimer() throws InterruptedException{
        for (int i = 10; i >= 1; i --) {
            time_label.setText(i + "");
            Thread.sleep(1000);
        }
        this.setVisible(false);
        System.out.println("Times up!");
        System.out.println("Your score is: " + score);
        System.exit(0);
    }

    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new ReactionTester();
    }
}
