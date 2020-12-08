package lesson_1;

import lesson_1.Fruits.Apple;
import lesson_1.Fruits.Orange;

import java.util.ArrayList;

public class BoxTest {
    public static void main(String[] args) {
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Apple> secondAppleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();


        appleBox.putInBox(a1);
        appleBox.putInBox(a2);
        secondAppleBox.putInBox(a3);
        orangeBox.putInBox(o1);
        orangeBox.putInBox(o2);

        System.out.println("Apple boxes weight: ");
        System.out.println(appleBox.getWeight());
        System.out.println(secondAppleBox.getWeight());
        System.out.println("Orange box weight: ");
        System.out.println(orangeBox.getWeight());

        System.out.println("Comparing first and second apple boxes: ");
        appleBox.compare(orangeBox);

        
        secondAppleBox.sprinkle(appleBox);

       // itemSwap();
        arrayToArrayList();
    }

    private static void itemSwap(){
        int[] s = {1,2,3,4,5,6,7};

        int tmp = s[0];
        s[0] = s[1];
        s[1] = tmp;

        for (int digit : s) {
            System.out.println(digit);
        }
    }

    private static void arrayToArrayList(){
        int[] s = {1,2,3,4,5,6,7};
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (int i : s) {
            newList.add(i);
        }

        for (int i: newList) {
            System.out.println(i);
        }
    }

}
