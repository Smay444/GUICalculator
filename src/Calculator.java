import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // 10 buttons for 10 numbers
    JButton[] functionButtons = new JButton[9]; // this will house all of my non-number characters
    JButton addButton,subButton,mulButton,divButton; // Name all of the function buttons
    JButton decButton, equButton, delButton, clrButton, negButton; //Name of the function Buttons

    JPanel panel; //to hold all of the separate buttons

    //one font for all buttons

    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0,result = 0;
    char operator; //will hold the operator chars


    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();//instantiate it
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //add buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        //add all buttons to function buttons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        //use for loop to iterate through the buttons to be able to update any fonts, add a listener, and do 'things' to the buttons
        for (int i=0; i <9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i=0; i < 10; i++){
            //need to finish instantiating the number buttons. Havent' done that yet.
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); // sometimes there is an outline around the button.
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430,100, 50);
        clrButton.setBounds(250, 430,100, 50);



        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10 ));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        //second Row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        //third row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        //number 0 button, which is:
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

        //del & clr will not be on jpanel with grid layout, so they will have to be set differently.

    }
    public static void main(String[] args) {

    Calculator calculator = new Calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e){
       //add functionality to the buttons

        //check to see if someone clicks on one of the number buttons

        for (int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //functionality for the decimal button
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            //assign operator
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            //assign operator
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            //assign operator
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            //assign operator
            operator = '/';
            textField.setText("");
        }
        //equal buttons
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator) {
                case '+':
                        result = num1+num2;
                        break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result; //so that we can continue in the case we wanted to use the same number.
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
                for (int i=0; i < string.length()-1; i++){
                    textField.setText(textField.getText()+string.charAt(i));
                }

        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            //take whatever value is in textfield and assign it the this variable temp
            //flip the sign
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }
}