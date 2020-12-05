package java1.unit5;

public class Cat extends Animal {
    int consumedFood;
    boolean bellyful = false;

    public Cat(String name, int runLimit, double jumpLimit, int consumedFood){
        super("Cat " + name);
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
        this.consumedFood = consumedFood;
    }

    public void swim(int distance){
        System.out.println(name + " can not swim.");
    }

    public void eat(Bowl bowl){
        if(bowl.getCurrentAmount() - consumedFood >= 0){
            bowl.setCurrentAmount(bowl.getCurrentAmount() - consumedFood);
            bellyful = true;
            System.out.println(name + " ate " + consumedFood);
            System.out.println("Bawl contains " + bowl.getCurrentAmount() + " of food");
        }else{
            System.out.println("There is not enough food in the bowl for " + name + ". Refilling bowl.");
            bowl.refill();
        }
    }

}
