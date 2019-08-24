package calc;

import javax.swing.*;

// This class contains methods required to interact with UI
class UI {

    private final int NUM_OF_DIGITS = 15;
    private final String[] OPERATIONS = {" + ", " - ", " * ", " / ", " ^ ", "sin", "cos", "tan", "!", "sqrt", "exp", "ln", "10^", "log"};

    // Changes the number in the JTextField
    void changeTextField(JButton jButton, JTextField jTextField, boolean state) {
        String number = jButton.getText();
        String current = jTextField.getText();
        if (state)
            jTextField.setText(number);
        else if (current.length() < NUM_OF_DIGITS)
            jTextField.setText(current + number);
    }

    // Places the decimal point
    void placeDot(JTextField jTextField, boolean state) {
        String current = jTextField.getText();
        if (state)
            jTextField.setText("0.");
        if ((!current.contains(".")) && (current.length() < NUM_OF_DIGITS - 2))
            jTextField.setText(current + ".");
    }

    // Gets the number ins the JTextField
    private double getNumber(JTextField jTextField) {
        return (Double.parseDouble(jTextField.getText()));
    }

    // Sets the number in the JTextField
    void setNumber(double value, JTextField jTextField) {
        if (value == Math.ceil(value))
            if ((long) value == Long.MAX_VALUE)
                jTextField.setText("#RANGE");
            else
                jTextField.setText(String.valueOf((long) value));
        else
            jTextField.setText(String.valueOf(value));
    }

    // Clears the JTextField
    void clearTextField(JTextField jTextField) {
        jTextField.setText("0");
    }

    // Clears and returns the number in the JTextField
    double getAndClearTextField(JTextField jTextField) {
        double value = getNumber(jTextField);
        clearTextField(jTextField);
        return value;
    }

    // Clears the JLabel
    void clearLabel(JLabel jLabel) {
        jLabel.setText("");
    }

    // Adds new numeric value to JLabel
    private void setLabelNumber(JLabel jLabel, double value) {
        if (value == Math.ceil(value))
            if ((long) value == Long.MAX_VALUE)
                jLabel.setText("#RANGE");
            else
                jLabel.setText(String.format("%s%s", jLabel.getText(), String.valueOf((long) value)));
        else
            jLabel.setText(String.format("%s%s", jLabel.getText(), String.valueOf(value)));
    }

    // Changes JLabel text for one input operations
    void setLabelOp(JLabel jLabel, double num, int operation) {
        clearLabel(jLabel);
        setLabelNumber(jLabel, num);
        jLabel.setText(String.format("%s %s ", jLabel.getText(), OPERATIONS[operation - 1]));
    }

    // Changes JLabel text for two input operations
    void setLabelOp(JLabel jLabel, double num1, double num2, int operation) {
        jLabel.setText(String.format("%s (%s) = ", OPERATIONS[operation - 1], String.valueOf(num1)));
        setLabelNumber(jLabel, num2);
    }

    // Changes JLabel text for no input operations
    void setLabelOp(JLabel jLabel, double num, String operation) {
        clearLabel(jLabel);
        if (operation.equals("pi"))
            jLabel.setText("π = ");
        else if (operation.equals("e"))
            jLabel.setText("e = ");
        setLabelNumber(jLabel, num);
    }

    // Changes JLabel text after performing the sum
    void setLabelEq(JLabel jLabel, double num1, double num2) {
        setLabelNumber(jLabel, num1);
        jLabel.setText(jLabel.getText() + " = ");
        setLabelNumber(jLabel, num2);
    }
}
