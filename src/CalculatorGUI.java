import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField resultTextField;
    private String operator = "";
    private double num1 = 0, num2 = 0;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);

        // Create and configure the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create and configure the result panel
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result:"));

        resultTextField = new JTextField();
        resultTextField.setEditable(false);
        resultTextField.setHorizontalAlignment(JTextField.RIGHT);
        resultPanel.add(resultTextField, BorderLayout.CENTER);

        // Create and configure the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        JButton button1 = new JButton("1");
        button1.addActionListener(new NumberButtonListener());
        buttonPanel.add(button1);

        JButton button2 = new JButton("2");
        button2.addActionListener(new NumberButtonListener());
        buttonPanel.add(button2);

        JButton button3 = new JButton("3");
        button3.addActionListener(new NumberButtonListener());
        buttonPanel.add(button3);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new OperatorButtonListener());
        buttonPanel.add(addButton);

        JButton button4 = new JButton("4");
        button4.addActionListener(new NumberButtonListener());
        buttonPanel.add(button4);

        JButton button5 = new JButton("5");
        button5.addActionListener(new NumberButtonListener());
        buttonPanel.add(button5);

        JButton button6 = new JButton("6");
        button6.addActionListener(new NumberButtonListener());
        buttonPanel.add(button6);

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new OperatorButtonListener());
        buttonPanel.add(subtractButton);

        JButton button7 = new JButton("7");
        button7.addActionListener(new NumberButtonListener());
        buttonPanel.add(button7);

        JButton button8 = new JButton("8");
        button8.addActionListener(new NumberButtonListener());
        buttonPanel.add(button8);

        JButton button9 = new JButton("9");
        button9.addActionListener(new NumberButtonListener());
        buttonPanel.add(button9);

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new OperatorButtonListener());
        buttonPanel.add(multiplyButton);

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ClearButtonListener());
        buttonPanel.add(clearButton);

        JButton button0 = new JButton("0");
        button0.addActionListener(new NumberButtonListener());
        buttonPanel.add(button0);

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new EqualsButtonListener());
        buttonPanel.add(equalsButton);

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new OperatorButtonListener());
        buttonPanel.add(divideButton);

        // Add the panels to the main panel
        mainPanel.add(resultPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Set the main panel as the content pane of the JFrame
        setContentPane(mainPanel);
    }

    private class NumberButtonListener implements ActionListener {
        public void
        actionPerformed(ActionEvent e) {
            String buttonText = ((JButton) e.getSource()).getText();
            resultTextField.setText(resultTextField.getText() + buttonText);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = ((JButton) e.getSource()).getText();
            num1 = Double.parseDouble(resultTextField.getText());
            resultTextField.setText("");
        }
    }

    private class EqualsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num2 = Double.parseDouble(resultTextField.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            resultTextField.setText(String.valueOf(result));
        }
    }

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = "";
            num1 = 0;
            num2 = 0;
            resultTextField.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Add your implementation for the actionPerformed method here
    }

    public static void main(String[] args) {
        CalculatorGUI calculator = new CalculatorGUI();
        calculator.setVisible(true);
    }
}