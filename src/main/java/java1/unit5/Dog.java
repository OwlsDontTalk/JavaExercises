package java1.unit5;

public class Dog extends Animal {
    public Dog(String name){
        super("Dog " + name);
        runLimit = 500;
        jumpLimit = 0.5;
        swimLimit = 10;
    }
}
