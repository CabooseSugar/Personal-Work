package exercise2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Instance Data
    private JTextField textField;
    // used inside overriden method from ActionListener (can't be inside that method since the point is to preserve prevEntry
    // and queuedOperation between button presses, but they'd be reset to required default values every button press if inside)
    private Double prevEntry, temp;
    private char queuedOperation ='n'; // n used to represent no queued operation
    private boolean isRepeatOperation = false; // used to keep track of hitting something like = multiple times after one division so the operation repeats on the new result


    // Constructor
    public Calculator() throws HeadlessException {
        // Window
        setSize(800,600);
        setTitle("Calculator");
        setResizable(false); // makes window unable to be resized
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Window Layout - box layout divided into the screen, first (uniquely spaced) row of buttons, and the rest of the buttons
        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS); // need to use getContentPane() instead of this...
        setLayout(boxLayout);                                                    // ...adding layout to the contentPane, not the frame itself

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //JMenus on Menu Bar
        JMenu fileMenu = new JMenu();
        fileMenu.setText("File");
        menuBar.add(fileMenu);
        JMenu helpMenu = new JMenu();
        helpMenu.setText("Help");
        menuBar.add(helpMenu);

        // JMenus' Items
        JMenuItem closeCalc = new JMenuItem();
        closeCalc.setText("Close");
        closeCalc.addActionListener(this);
        fileMenu.add(closeCalc);

        // Calculator Screen
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 75));
        textField.setEditable(false); // makes it so user can't just type things directly into the textField
        textField.setFont(new Font("Dialog", Font.PLAIN, 25)); // making text in textField bigger
        add(textField);

        // Calculator Top Row of Buttons (separated because of unique spacing)
        JPanel calcTopButtons = new JPanel(); // creating a JPanel w/ Border Layout to arrange top row of buttons
        calcTopButtons.setBackground(Color.lightGray);
        BorderLayout borderLayout = new BorderLayout();
        calcTopButtons.setLayout(borderLayout);
        add(calcTopButtons);

        JButton backspaceButton = new JButton(); // declare button
        backspaceButton.addActionListener(this); // add an actionListener to it
        backspaceButton.setPreferredSize(new Dimension(300, 75)); // change size for cosmetic reasons
        backspaceButton.setBackground(Color.lightGray); // make button light gray
        backspaceButton.setForeground(Color.red); // ... with red text
        backspaceButton.setBorder(new LineBorder(Color.gray)); // ... and a gray border
        backspaceButton.setText("Backspace"); // set the text on the button
        calcTopButtons.add(backspaceButton, borderLayout.LINE_START); // add the button - all other buttons will be added this way

        JPanel calcTopRightButtons = new JPanel(); // making another new JPanel w/ flow layout inside the above Panel to squeeze both the CE and C buttons on the
        calcTopRightButtons.setBackground(Color.lightGray); // LINE.END portion of the Border Layout for the top row of buttons as a whole
        calcTopRightButtons.setMinimumSize(new Dimension(300, 75));
        FlowLayout flowLayout = new FlowLayout();
        calcTopRightButtons.setLayout(flowLayout);
        calcTopButtons.add(calcTopRightButtons, borderLayout.LINE_END);

        JButton ceButton = new JButton();
        ceButton.addActionListener(this);
        ceButton.setPreferredSize(new Dimension(150, 75));
        ceButton.setBackground(Color.lightGray);
        ceButton.setForeground(Color.red);
        ceButton.setBorder(new LineBorder(Color.gray));
        ceButton.setText("CE");
        calcTopRightButtons.add(ceButton);
        JButton cButton = new JButton();
        cButton.addActionListener(this);
        cButton.setPreferredSize(new Dimension(150, 75));
        cButton.setBackground(Color.lightGray);
        cButton.setForeground(Color.red);
        cButton.setBorder(new LineBorder(Color.gray));
        cButton.setText("C");
        calcTopRightButtons.add(cButton);

        // Calculator Numbers and Operations Buttons
        JPanel calcButtons = new JPanel(); // Rest of the buttons done in a JPanel with a Grid Layout
        calcButtons.setPreferredSize(new Dimension(800, 300));
        calcButtons.setBackground(Color.lightGray);
        GridLayout gridLayout = new GridLayout(4, 5, 3, 3);
        calcButtons.setLayout(gridLayout);
        add(calcButtons);

        JButton num7Button = new JButton(); // number 7 button
        num7Button.addActionListener(this);
        num7Button.setBackground(Color.lightGray);
        num7Button.setForeground(Color.blue);
        num7Button.setBorder(new LineBorder(Color.gray));
        num7Button.setText("7");
        calcButtons.add(num7Button);
        JButton num8Button = new JButton(); // number 8 button
        num8Button.addActionListener(this);
        num8Button.setText("8");
        num8Button.setBackground(Color.lightGray);
        num8Button.setForeground(Color.blue);
        num8Button.setBorder(new LineBorder(Color.gray));
        calcButtons.add(num8Button);
        JButton num9Button = new JButton(); // number 9 button
        num9Button.addActionListener(this);
        num9Button.setBackground(Color.lightGray);
        num9Button.setForeground(Color.blue);
        num9Button.setBorder(new LineBorder(Color.gray));
        num9Button.setText("9");
        calcButtons.add(num9Button);
        JButton divButton = new JButton(); // / button
        divButton.addActionListener(this);
        divButton.setBackground(Color.lightGray);
        divButton.setForeground(Color.red);
        divButton.setBorder(new LineBorder(Color.gray));
        divButton.setText("/");
        calcButtons.add(divButton);
        JButton sqrtButton = new JButton(); // sqrt button
        sqrtButton.addActionListener(this);
        sqrtButton.setBackground(Color.lightGray);
        sqrtButton.setForeground(Color.red);
        sqrtButton.setBorder(new LineBorder(Color.gray));
        sqrtButton.setText("sqrt");
        calcButtons.add(sqrtButton);
        JButton num4Button = new JButton(); // // number 4 button
        num4Button.addActionListener(this);
        num4Button.setBackground(Color.lightGray);
        num4Button.setForeground(Color.blue);
        num4Button.setBorder(new LineBorder(Color.gray));
        num4Button.setText("4");
        calcButtons.add(num4Button);
        JButton num5Button = new JButton(); // number 5 button
        num5Button.addActionListener(this);
        num5Button.setBackground(Color.lightGray);
        num5Button.setForeground(Color.blue);
        num5Button.setBorder(new LineBorder(Color.gray));
        num5Button.setText("5");
        calcButtons.add(num5Button);
        JButton num6Button = new JButton(); // number 6 button
        num6Button.addActionListener(this);
        num6Button.setBackground(Color.lightGray);
        num6Button.setForeground(Color.blue);
        num6Button.setBorder(new LineBorder(Color.gray));
        num6Button.setText("6");
        calcButtons.add(num6Button);
        JButton multButton = new JButton(); // * button
        multButton.addActionListener(this);
        multButton.setBackground(Color.lightGray);
        multButton.setForeground(Color.red);
        multButton.setBorder(new LineBorder(Color.gray));
        multButton.setText("*");
        calcButtons.add(multButton);
        JButton oneDivButton = new JButton(); // 1/x button
        oneDivButton.addActionListener(this);
        oneDivButton.setBackground(Color.lightGray);
        oneDivButton.setForeground(Color.red);
        oneDivButton.setBorder(new LineBorder(Color.gray));
        oneDivButton.setText("1/x");
        calcButtons.add(oneDivButton);
        JButton num1Button = new JButton(); // number 1 button
        num1Button.addActionListener(this);
        num1Button.setBackground(Color.lightGray);
        num1Button.setForeground(Color.blue);
        num1Button.setBorder(new LineBorder(Color.gray));
        num1Button.setText("1");
        calcButtons.add(num1Button);
        JButton num2Button = new JButton(); // number 2 button
        num2Button.addActionListener(this);
        num2Button.setBackground(Color.lightGray);
        num2Button.setForeground(Color.blue);
        num2Button.setBorder(new LineBorder(Color.gray));
        num2Button.setText("2");
        calcButtons.add(num2Button);
        JButton num3Button = new JButton(); // number 3 button
        num3Button.addActionListener(this);
        num3Button.setBackground(Color.lightGray);
        num3Button.setForeground(Color.blue);
        num3Button.setBorder(new LineBorder(Color.gray));
        num3Button.setText("3");
        calcButtons.add(num3Button);
        JButton subButton = new JButton(); // - button
        subButton.addActionListener(this);
        subButton.setBackground(Color.lightGray);
        subButton.setForeground(Color.red);
        subButton.setBorder(new LineBorder(Color.gray));
        subButton.setText("-");
        calcButtons.add(subButton);
        JButton percButton = new JButton(); // % button
        percButton.addActionListener(this);
        percButton.setBackground(Color.lightGray);
        percButton.setForeground(Color.red);
        percButton.setBorder(new LineBorder(Color.gray));
        percButton.setText("%");
        calcButtons.add(percButton);
        JButton num0Button = new JButton(); // number 0 button
        num0Button.addActionListener(this);
        num0Button.setBackground(Color.lightGray);
        num0Button.setForeground(Color.blue);
        num0Button.setBorder(new LineBorder(Color.gray));
        num0Button.setText("0");
        calcButtons.add(num0Button);
        JButton signChangeButton = new JButton(); // +/- button
        signChangeButton.addActionListener(this);
        signChangeButton.setBackground(Color.lightGray);
        signChangeButton.setForeground(Color.red);
        signChangeButton.setBorder(new LineBorder(Color.gray));
        signChangeButton.setText("+/-");
        calcButtons.add(signChangeButton);
        JButton decimalButton = new JButton(); // . button
        decimalButton.addActionListener(this);
        decimalButton.setBackground(Color.lightGray);
        decimalButton.setForeground(Color.red);
        decimalButton.setBorder(new LineBorder(Color.gray));
        decimalButton.setText(".");
        calcButtons.add(decimalButton);
        JButton addButton = new JButton(); // + button
        addButton.addActionListener(this);
        addButton.setBackground(Color.lightGray);
        addButton.setForeground(Color.red);
        addButton.setBorder(new LineBorder(Color.gray));
        addButton.setText("+");
        calcButtons.add(addButton);
        JButton equalButton = new JButton(); // = button
        equalButton.addActionListener(this);
        equalButton.setBackground(Color.lightGray);
        equalButton.setForeground(Color.red);
        equalButton.setBorder(new LineBorder(Color.gray));
        equalButton.setText("=");
        calcButtons.add(equalButton);

        pack(); // tries to get everything to its set preferredSize
        setVisible(true);
    }

    // Main Method
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    // Defining Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand().toUpperCase()) {
            case "0":
                if (isRepeatOperation) // so 0 starts on a fresh screen if entered after an equals operation
                    textField.setText("");
                if (!textField.getText().isEmpty()) // doesn't let you add 0 to empty field
                    textField.setText(textField.getText() + "0");
                break;
            case "1":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "1");
                break;
            case "2":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "2");
                break;
            case "3":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "3");
                break;
            case "4":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "4");
                break;
            case "5":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "5");
                break;
            case "6":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "6");
                break;
            case "7":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "7");
                break;
            case "8":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "8");
                break;
            case "9":
                if (isRepeatOperation)
                    textField.setText("");
                textField.setText(textField.getText() + "9");
                break;
            case "BACKSPACE":
                if (!textField.getText().isEmpty())
                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                break;
            case "CE": // resets just the immediate field
                textField.setText("");
                break;
            case "C": // resets entire calculator
                prevEntry = 0.0;
                textField.setText("");
                queuedOperation = 'n';
                isRepeatOperation = false;
                break;
            case "+/-":
                if (!textField.getText().equals("")) {
                    Double current = Double.parseDouble(textField.getText()) * -1;
                    textField.setText(current.toString());
                }
                break;
            case ".":
                if (textField.getText().equals(""))
                    textField.setText("0.");
                else if (textField.getText().contains(".")) {} // stops user from adding decimal point to numbers that already have them
                else
                    textField.setText(textField.getText() + ".");
                break;
            case "/":
                if (textField.getText().equals("")) {} // do nothing if trying to divide with nothing put into calculator
                else {
                    isRepeatOperation = false;
                    prevEntry = Double.parseDouble(textField.getText());
                    textField.setText("");
                    queuedOperation = '/';
                }
                break;
            case "*":
                if (textField.getText().equals("")) {}
                else {
                    isRepeatOperation = false;
                    prevEntry = Double.parseDouble(textField.getText());
                    textField.setText("");
                    queuedOperation = '*';
                }
                break;
            case "+":
                if (textField.getText().equals("")) {}
                else {
                    isRepeatOperation = false;
                    prevEntry = Double.parseDouble(textField.getText());
                    textField.setText("");
                    queuedOperation = '+';
                }
                break;
            case "-":
                if (textField.getText().equals("")) {}
                else {
                    isRepeatOperation = false;
                    prevEntry = Double.parseDouble(textField.getText());
                    textField.setText("");
                    queuedOperation = '-';
                }
                break;
            case "SQRT":
                if (textField.getText().equals("")) {}
                else {
                    Double current = Double.parseDouble(textField.getText());
                    current = Math.sqrt(current);
                    textField.setText(current.toString());
                }
                break;
            case "1/X":
                if (textField.getText().equals("")) {}
                else {
                    Double current = Double.parseDouble(textField.getText());
                    if (current == 0) { // can't divide by zero
                        textField.setText("Can't divide by zero");
                        break;
                    }
                    current = 1/current;
                    textField.setText(current.toString());
                }
                break;
            case "%":
                if (textField.getText().equals("")) {}
                else {
                    Double current = Double.parseDouble(textField.getText());
                    current = current / 100;
                    textField.setText(current.toString());
                }
                break;
            case "=":
                Double result;
                if (queuedOperation == 'n' || textField.getText().equals("")) {} // do nothing if try to perform an equals on nothing
                else if (queuedOperation == '/' || queuedOperation == '*' || queuedOperation == '+' || queuedOperation == '-') {
                    // separation of these two conditions is so hitting = multiples times in a row, the last operation is repeated on newest result
                    if (!isRepeatOperation) {
                        temp = Double.parseDouble(textField.getText());
                        if (queuedOperation == '/') {
                            result = prevEntry / Double.parseDouble(textField.getText());
                            textField.setText(result.toString());
                        }
                        if (queuedOperation == '*') {
                            result = prevEntry * Double.parseDouble(textField.getText());
                            textField.setText(result.toString());
                        }
                        if (queuedOperation == '+') {
                            result = prevEntry + Double.parseDouble(textField.getText());
                            textField.setText(result.toString());
                        }
                        if (queuedOperation == '-') {
                            result = prevEntry - Double.parseDouble(textField.getText());
                            textField.setText(result.toString());
                        }
                        isRepeatOperation = true;
                    }
                    else { // if this is a repeated operation (= being hit multiple times in a row), need to change what numbers are getting grabbed
                        if (queuedOperation == '/') {
                            result = Double.parseDouble(textField.getText()) / temp;
                            textField.setText(result.toString());
                        }
                        if (queuedOperation == '*') {
                            result = Double.parseDouble(textField.getText()) * temp;
                            textField.setText(result.toString());
                        }
                        if (queuedOperation == '+') {
                            result = Double.parseDouble(textField.getText()) + temp;
                            textField.setText(result.toString());
                        }
                        if (queuedOperation == '-') {
                            result = Double.parseDouble(textField.getText()) - temp;
                            textField.setText(result.toString());
                        }
                    }
                }
                break;
            case "CLOSE":
                dispose();
                break;
        }
    }
}
