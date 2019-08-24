// Janith Ganepola ©2018 170179U
package calc;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Calculator {
    private JPanel panelMain;
    private JTextField textField;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonDot;
    private JButton equals;
    private JButton division;
    private JButton multiplication;
    private JButton minus;
    private JButton plus;
    private JButton CE;
    private JButton buttonPi;
    private JButton buttonE;
    private JButton sin;
    private JButton cos;
    private JButton tan;
    private JButton fact;
    private JButton log10;
    private JButton sqrt;
    private JButton pow10;
    private JButton ln;
    private JButton exp;
    private JButton XPowY;
    private JLabel label;

    private UI ui = new UI();
    private Operation op = new Operation();

    private double num1 = 0, num2 = 0;   // Input Numbers
    private int operation = 0;          // Determines the operation
    private boolean state = true;       // Determines whether new operation must be performed

    private Calculator() {
        // Mouse Click Listeners for Numeric Inputs
        button0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button0, textField, state);
                state = false;
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button1, textField, state);
                state = false;
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button2, textField, state);
                state = false;
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button3, textField, state);
                state = false;
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button4, textField, state);
                state = false;
            }
        });
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button5, textField, state);
                state = false;
            }
        });
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button6, textField, state);
                state = false;
            }
        });
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button7, textField, state);
                state = false;
            }
        });
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button8, textField, state);
                state = false;
            }
        });
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.changeTextField(button9, textField, state);
                state = false;
            }
        });
        buttonDot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.placeDot(textField, state);
            }
        });

        // Mouse Click Listeners for Operational Inputs
        CE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.clearTextField(textField);
                ui.clearLabel(label);
                setDefaults();
            }
        });
        plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                operation = 1;
                state = true;
                ui.setLabelOp(label, num1, operation);
            }
        });
        minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                operation = 2;
                state = true;
                ui.setLabelOp(label, num1, operation);
            }
        });
        multiplication.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                operation = 3;
                state = true;
                ui.setLabelOp(label, num1, operation);
            }
        });
        division.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                operation = 4;
                state = true;
                ui.setLabelOp(label, num1, operation);
            }
        });
        XPowY.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                operation = 5;
                state = true;
                ui.setLabelOp(label, num1, operation);
            }
        });

        sin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 6);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 6);
                state = true;
            }
        });

        cos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 7);
                ui.setNumber(sum, textField);
                state = true;
                ui.setLabelOp(label, num1, sum, 7);
            }
        });

        tan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 8);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 8);
                state = true;
            }
        });

        fact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double fact = op.performOp(num1, 9);
                if (fact == 0 && num1 == Math.ceil(num1))
                    fact = Long.MAX_VALUE;
                ui.setNumber(fact, textField);
                ui.setLabelOp(label, num1, fact, 9);
                state = true;
            }
        });

        sqrt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 10);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 10);
                state = true;
            }
        });

        exp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 11);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 11);
                state = true;
            }
        });

        ln.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 12);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 12);
                state = true;
            }
        });

        pow10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 13);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 13);
                state = true;
            }
        });

        log10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                num1 = ui.getAndClearTextField(textField);
                double sum = op.performOp(num1, 14);
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, num1, sum, 14);
                state = true;
            }
        });

        // Mouse Click Listeners for Equal Sign
        equals.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!state && operation > 0 && operation <= 5) {
                    num2 = ui.getAndClearTextField(textField);
                    double x = op.performOp(num1, num2, operation);
                    ui.setLabelEq(label, num2, x);
                    num1 = num2;
                    num2 = x;
                    ui.setNumber(x, textField);
                }
                state = true;
            }
        });

        buttonPi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.clearTextField(textField);
                double sum = op.performOp("pi");
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, sum, "pi");
                state = true;
            }
        });

        buttonE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.clearTextField(textField);
                double sum = op.performOp("e");
                ui.setNumber(sum, textField);
                ui.setLabelOp(label, sum, "e");
                state = true;
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Windows or Mac Look and feel
        } catch (Exception ignored) {
        }

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void setDefaults() {
        num1 = num2 = operation = 0;
        state = true;
    }

}
