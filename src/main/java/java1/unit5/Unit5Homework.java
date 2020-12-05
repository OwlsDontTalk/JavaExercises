package java1.unit5;

public class Unit5Homework {
    public static void main(String[] args){
        Cat[] arrayOfCats = new Cat[5];
        Bowl bowl = new Bowl(10);
        arrayOfCats[0] = new Cat("Barsik", 100, 2, 3);
        arrayOfCats[1] = new Cat("Tot", 200, 2, 5);
        arrayOfCats[2] = new Cat("Tat", 50, 0.5, 4);
        arrayOfCats[3] = new Cat("Tit", 50, 3, 3);
        arrayOfCats[4] = new Cat("Tet", 10, 0.5, 1);

        for(Cat cat : arrayOfCats){
            cat.eat(bowl);
        }
    }


}
