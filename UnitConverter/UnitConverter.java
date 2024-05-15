import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UnitConverter implements ActionListener{
    JFrame frame;
    String[] metricUnits = {"millimeters","kilograms","watt","meters per second"};
    String[] statesUnits = {"inches","pounds","horse power","feet per second"};

    double[] metricToStates = {(1/25.4),2.2,(1/746.0),3.28};
    double[] statesToMetric = {25.4, (1/2.2), 746.0,(1/3.28)};

    //Font answerFont = new Font("Fantasy", Font.BOLD, 20);
    Font titleFont = new Font("Times New Roman", Font.ITALIC, 25);
    //Font boxFont = new Font("Times new Roman", Font.BOLD, 20);
    JLabel header;
    boolean isString;
    JComboBox metricBox;
    JTextField metricTextField;
    JLabel metricLabel;
    JLabel metricTitle;

    JComboBox  statesBox;
    JTextField statesTextField;
    JLabel statesLabel;
    JLabel stateTitle;
    int METRIC_X = 100;
    int METRIC_Y = 50;
    int METRIC_WIDTH = 200;
    int METRIC_HEIGHT = METRIC_WIDTH/2;

    int STATES_X = METRIC_X;
    int STATES_Y = METRIC_Y + 500;
    int STATES_WIDTH = METRIC_WIDTH;
    int STATES_HEIGHT = STATES_WIDTH/2;
    public UnitConverter() {
        // normal frame stuff
        frame = new JFrame("Unit converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        header = new JLabel();
        header.setBounds(90,0,500,50);
        header.setFont(new Font("Times New Roman",Font.BOLD,50));
        header.setText("Unit Converter");

        // setting values of all the components
        metricBox = new JComboBox(metricUnits);
        statesBox = new JComboBox(statesUnits);

        //metricBox.setBorder(new BorderLayout());
        //statesBox.setFont(boxFont);

        metricBox.addActionListener(this);
        statesBox.addActionListener(this);

        metricBox.setBounds(METRIC_X  * 2,METRIC_Y + 100,METRIC_WIDTH,METRIC_HEIGHT);
        statesBox.setBounds(STATES_X* 2,STATES_Y,STATES_WIDTH,STATES_HEIGHT);

        metricLabel = new JLabel();
        metricLabel.setBounds(METRIC_X,METRIC_Y+175,1000,100);
        //metricLabel.setFont(answerFont);
        metricLabel.setText("answer: ");


        metricTitle = new JLabel();
        metricTitle.setBounds(METRIC_X, METRIC_Y + 20, 1000,100);
        metricTitle.setFont(titleFont);
        metricTitle.setText("Metric to state equivalent");

        stateTitle = new JLabel();
        stateTitle.setBounds(STATES_X, STATES_Y- 75 , 1000,100);
        stateTitle.setFont(titleFont);
        stateTitle.setText("State to metric equivalent");

        statesLabel = new JLabel();
        statesLabel.setBounds(STATES_X,STATES_Y+75,1000,100);
        //statesLabel.setFont(answerFont);
        statesLabel.setText("answer: ");

        metricTextField = new JTextField();
        metricTextField.setBounds(METRIC_X, METRIC_Y + 100, METRIC_WIDTH,METRIC_HEIGHT);

        statesTextField = new JTextField();
        statesTextField.setBounds(STATES_X , STATES_Y, STATES_WIDTH,STATES_HEIGHT);




        // adding components to frame
        frame.add(metricBox);
        frame.add(statesBox);
        frame.add(metricLabel);
        frame.add(statesLabel);
        frame.add(metricTextField);
        frame.add(statesTextField);
        frame.add(metricTitle);
        frame.add(stateTitle);
        frame.add(header);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == metricBox) {
            String text = metricTextField.getText();
            if (text.length() > 0) {
                double num = 0;
                try {
                    num = Double.parseDouble(text);
                    isString = false;
                } catch (Exception type) {
                    num = 0;
                    isString = true;
                }
                if (num < 0) {
                    metricLabel.setText("answer: No negatives allowed!");
                }
                else if (isString){
                    metricLabel.setText("Stop entering characters other than numbers");
                }
                else {
                    metricLabel.setText("answer: " + Math.round(num * metricToStates[metricBox.getSelectedIndex()]) + " " + statesUnits[metricBox.getSelectedIndex()]);
                }
            }
        }

        if (e.getSource() == statesBox) {
            String text = statesTextField.getText();
            if (text.length() > 0) {
                double num = 0;
                try {
                    num = Double.parseDouble(text);
                    isString = false;
                } catch (Exception type) {
                    num = 0;
                    isString = true;
                }
                if (num < 0) {
                    statesLabel.setText("answer: No negatives allowed!");
                }
                else if (isString) {
                    statesLabel.setText("Stop entering characters other than numbers");
                }
                else {
                    statesLabel.setText("answer: " + Math.round(num * statesToMetric[statesBox.getSelectedIndex()]) + " " + metricUnits[statesBox.getSelectedIndex()]);
                }
            }
        }
    }

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter();
    }



}
