import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UnitConverter implements ActionListener{
    JFrame frame;
    String[] metricUnits = {"millimeters","kilograms","watt","meters per second"};
    String[] statesUnits = {"inches","pounds","horse power","feet per second"};

    double[] metricToStates = {(1/25.4),2.2,(1/746.0),3.28};
    double[] statesToMetric = {25.4, (1/2.2), 746.0,(1/3.28)};
    JComboBox metricBox;
    JTextField metricTextField;
    JLabel metricLabel;
    JComboBox  statesBox;
    JTextField statesTextField;
    JLabel statesLabel;

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

        // setting values of all the components
        metricBox = new JComboBox(metricUnits);
        statesBox = new JComboBox(statesUnits);

        metricBox.setBounds(METRIC_X,METRIC_Y,METRIC_WIDTH,METRIC_HEIGHT);
        statesBox.setBounds(STATES_X,STATES_Y,STATES_WIDTH,STATES_HEIGHT);

        metricLabel = new JLabel();
        metricLabel.setBounds(METRIC_X,METRIC_Y+75,100,100);
        metricLabel.setText("answer: ");

        statesLabel = new JLabel();
        statesLabel.setBounds(STATES_X,STATES_Y+75,100,100);
        statesLabel.setText("answer: ");

        metricTextField = new JTextField();
        metricTextField.setBounds(METRIC_X  * 3 + 20 , METRIC_Y + METRIC_Y/2 , 150,50);

        statesTextField = new JTextField();
        statesTextField.setBounds(STATES_X  * 3 + 20, STATES_Y + 20 , 150,50);




        // adding components to frame
        frame.add(metricBox);
        frame.add(statesBox);
        frame.add(metricLabel);
        frame.add(statesLabel);
        frame.add(metricTextField);
        frame.add(statesTextField);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == metricUnits && !metricTextField.getText().equals("")) {

        }
    }

    public static void main(String[] args) {
        UnitConverter converter = new UnitConverter();
    }



}
