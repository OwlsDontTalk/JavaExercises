package unit6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    public Calculator(){
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(305, 295);
        add(new Panel());
        setResizable(false);
        setVisible(true);
    }


    public static void main(String[] args){
        new Calculator();
    }


}
