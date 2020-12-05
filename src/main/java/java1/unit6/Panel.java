package java1.unit6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    private JButton actions[] = new JButton[5];
    private JTextField output = new JTextField();
    private JTextField numberOne = new JTextField();
    private JTextField numberTwo = new JTextField();

    public Panel(){
        setLayout(null);

        actions[0] = new JButton("+");
        actions[0].setBounds(10,200, 50, 50);
        ActionListener listenerPlus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput()){ output.setText(calculatePlus()); }
            }
        };
        actions[0].addActionListener(listenerPlus);

        actions[1] = new JButton("-");
        actions[1].setBounds(65,200, 50, 50);
        ActionListener listenerMinus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput()){ output.setText(calculateMinus()); }
            }
        };
        actions[1].addActionListener(listenerMinus);

        actions[2] = new JButton("*");
        actions[2].setBounds(120,200, 50, 50);
        ActionListener listenerMultiply = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput()){ output.setText(calculateMultiply()); }
            }
        };
        actions[2].addActionListener(listenerMultiply);

        actions[3] = new JButton("/");
        actions[3].setBounds(175,200, 50, 50);
        ActionListener listenerDivide = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput()){ output.setText(calculateDivide()); }
            }
        };
        actions[3].addActionListener(listenerDivide);

        actions[4] = new JButton("^");
        actions[4].setBounds(230,200, 50, 50);
        ActionListener listenerDegree = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput()){ output.setText(calculateDegree()); }
            }
        };
        actions[4].addActionListener(listenerDegree);


        for (JButton jb : actions){
            add(jb);
        }

        output.setBounds(10, 10, 270, 50 );
        output.setEditable(false);
        add(output);

        numberOne.setBounds(10, 70, 270, 50 );
        add(numberOne);

        numberTwo.setBounds(10, 130, 270, 50 );
        add(numberTwo);
    }

    private boolean checkInput(){
        System.out.println("Checking input");
        System.out.println("Number 1 = " + numberOne.getText());
        System.out.println("Number 2 = " + numberTwo.getText());
        if(numberOne.getText().isEmpty() || numberTwo.getText().isEmpty() ){
            output.setText("INCORRECT INPUT");
            return false;
        } else {
            output.setText("HURRAY");
            return true;
        }
    }

    private int[] parseInputFields(){
        int[] result = new int[2];
        result[0] = Integer.parseInt(numberOne.getText());
        result[1] = Integer.parseInt(numberTwo.getText());
        return result;
    }

    private String calculatePlus(){
        int[] input = parseInputFields();
        return  Integer.toString(input[0] + input[1]);
    }

    private String calculateMinus(){
        int[] input = parseInputFields();
        return  Integer.toString(input[0] - input[1]);
    }

    private String calculateMultiply(){
        int[] input = parseInputFields();
        return  Integer.toString(input[0] * input[1]);
    }

    private String calculateDivide(){
       int[] input = parseInputFields();
       return  Double.toString((double)input[0] / (double)input[1]);
    }

    private String calculateDegree(){
        int[] input = parseInputFields();
        double base = (double)input[0];
        int degree = input[1];
        double result = 0;
        if(degree == 0){
            if(base == 0 ){
                result = 0;
            } else {
                result = 1;
            }
        } else if (degree > 0) {
            result = 1;
            for(int i = 0; i < degree; i++){
                result *= base;
            }
        } else if (degree < 0){
            System.out.print("degree<0");
            result = 1;
            for(int i = 1; i < -degree; i++){
                result /= base;
              }
        }
        return Double.toString(result);
    }
}
