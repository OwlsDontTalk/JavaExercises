package lesson_1;

import lesson_1.Fruits.Fruit;

import java.util.ArrayList;

//TODO fix classes names and make them work
public class Box <T extends Fruit> {
    public ArrayList<T> box = new ArrayList<T>();

    public void putInBox(T obj){
        box.add(obj);
    }

    public double getWeight(){
        double weight = 0.0f;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void compare(Box boxy){
        if(this.getWeight() == boxy.getWeight()){
            System.out.println("equal");
        }
        if(this.getWeight() > boxy.getWeight() ){
            System.out.println("current box is heavier");
        }
        if(this.getWeight() < boxy.getWeight()){
            System.out.println("second box is heavier");
        }
    }

    public void sprinkle(Box<T> boxToEmpty){
        for (T item : boxToEmpty.box) {
            this.box.add(item);
        }
        boxToEmpty.box.removeAll(boxToEmpty.box);
    }
}
