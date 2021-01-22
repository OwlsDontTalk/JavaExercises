package unit3;

public class Box {
    String color;
    int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }
}

class MainBox{
    public static void main(String[] args) {
        Box box1 = new Box("red", 1);
        Box box2 = new Box("red", 1);

        System.out.println("box 1 hash code: " + box1.hashCode());
        System.out.println("box 2 hash code: " + box2.hashCode());
        System.out.println("to object equal? " + box1.equals(box2));

    }
}