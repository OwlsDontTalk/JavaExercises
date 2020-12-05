package java1.unit6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
1. Разработать оконное приложение «Калькулятор»;
1.1. Калькулятор должен выполнять 4 простейшие арифметические операции.
1.2. Калькулятор должен иметь одно окно вывода результатов.
1.3. Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.
Подсказка 1: поля ввода в приложении дают читать только текстовые данные. Для преобразования
нужно использовать классы-оболочки: https://habrahabr.ru/post/49582/.

Подсказка 2: можно сделать код гораздо проще, изучив возможности ActionEvent:
https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener.

2. * Научить калькулятор операции возведения в степень.
 */

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