import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUIGuessingGame implements ActionListener{
    //Directions
    /*
    Extra Practice: Design a game using binary search. The player should also be
    able to choose the game's difficulty by inputting the number of values, n, they would like the
    computer to generate in an ArrayList (The smaller the set, the more difficult the game).
    The player should then choose a number between 1 and 12000.
    The computer will generate an ArrayList of n integers between 1 and 12000.
    The computer will then sort its list of randomly generated numbers and search for the player’s guess.
    If the player guesses correctly, the console will display the results
    and the player will earn 1 point and then be asked whether they would like to play again.
    The game should either end once the player makes an incorrect guess or chooses to end the game at the
    end of a correctly guessed round. In either ending scenario, the console will display the final score.
    */
    JFrame frame;
    JTextField field;
    private int userInput;
    private int points;
    JLabel label;
    JLabel pointLabel;

    JButton submitButton;
    JButton exitButton;
    int n = -1;
    boolean fieldVisibility = true;
    ArrayList<Integer> arr = new ArrayList<>();
    public GUIGuessingGame() {
        frame = new JFrame("Guessing Game");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(50,50,50));

        field = new JTextField();
        field.setSize(150,50);
        field.setLocation(225, 200);
        field.setText("List Size");
        field.setFont(new Font("Consolas",Font.BOLD, 15));
        field.setBackground(Color.GRAY);
        field.setForeground(Color.GREEN);
        field.setVisible(true);

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(new Font("Consolas",Font.BOLD, 30));
        label.setForeground(Color.BLACK);
        label.setText("Guessing Game");

        submitButton = new JButton("Submit");
        submitButton.setSize(100,50);
        submitButton.setLocation(125,200);
        submitButton.setVisible(true);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));

        exitButton = new JButton("Exit");
        exitButton.setSize(100,50);
        exitButton.setLocation(225,250);
        exitButton.setBorderPainted(false);
        exitButton.setOpaque(true);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.BLACK);
        exitButton.setVisible(true);
        exitButton.addActionListener(this);
        exitButton.setFont(new Font("Arial", Font.BOLD, 15));

        frame.add(field);
        frame.add(submitButton);
        frame.add(exitButton);
        frame.add(label);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                String text = field.getText();
                userInput = Integer.parseInt(text);
                field.setText("Enter your guess");
                label.setText("Guessing Game");
            }
            catch(Exception exception) {
                label.setText("Enter a valid number");
                return;
            }
            if (n == -1) {
                n = userInput;
                fillArrayList(n);
                insertionSort();
            }
            else {
                int guess = userInput;
                System.out.println(arr);
                if (binarySearch(arr,guess)) {
                    label.setForeground(Color.GREEN);
                    points++;
                    label.setText("Correct. Points: " + points);
                }
                else {
                    label.setText("Wrong");
                    label.setForeground(Color.RED);
                }
            }
        }
        if (e.getSource() == exitButton) System.exit(0);
    }
    public void fillArrayList(int n) {
        for (int i = 0; i < n; i ++) {
            int rand = (int) (Math.random() * 12000) + 1;
            arr.add(rand);
        }
    }
    public void insertionSort() {
        for (int i = 1; i < arr.size(); i ++) {
            int j = i;
            while (j > 0 && arr.get(j) < arr.get(j - 1)) {
                int temp = arr.get(j);
                arr.set(j, arr.get(j-1));
                arr.set(j-1,temp);
                j--;
            }
        }
    }
    public boolean binarySearch(ArrayList<Integer> arr,int target) {
        int l = 0;
        int r = arr.size() - 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (arr.get(mid) == target) return true;
            else if (arr.get(mid) < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        new GUIGuessingGame();
    }
}
