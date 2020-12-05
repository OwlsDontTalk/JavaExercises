package java1.unit5;

public abstract class Animal {
    protected String name;

    protected int runLimit = 0;
    protected double jumpLimit = 0;
    protected int swimLimit = 0;

    public Animal() { this.name = "Nameless"; }

    public Animal(String name){
        this.name = name;
    }

    public void swim(int distance){
        if(swimLimit > 0 && distance <= swimLimit){
            System.out.println(this.name + " swam " + distance + " m.");
        }else{
            System.out.println(this.name + " can not swim that far.");
        }
    }

    public void run(int distance){
        if(runLimit > 0 && distance <= runLimit){
            System.out.println(this.name + " ran " + distance + " m.");
        }else{
            System.out.println(this.name + " can not run that far.");
        }
    }

    public void jump(double height){
        if(jumpLimit > 0 && height <= jumpLimit){
            System.out.println(this.name + " jumped " + height + " m.");
        }else{
            System.out.println(this.name + " can not jump so high.");
        }
    }

}
