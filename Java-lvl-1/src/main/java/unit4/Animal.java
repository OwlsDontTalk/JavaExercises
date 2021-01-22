package unit4;

public class Animal {
    private int runLimit;
    private int swimLimit;
    private double jumpOverLimit;

    public void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public void setJumpOverLimit(double jumpOverLimit) {
        this.jumpOverLimit = jumpOverLimit;
    }

    public void Run(int length){
        boolean result;

        if(length > runLimit){
            result  = false;
        } else {
            result = true;
        }
        System.out.println("result: " + result);
    }

    public void Swim(int length){
        boolean result;

        if(length > swimLimit){
            result  = false;
        } else {
            result = true;
        }
        System.out.println("result: " + result);

    }

    public void JumpOver(double height){
        boolean result;

        if(height > jumpOverLimit){
            result  = false;
        } else {
            result = true;
        }
        System.out.println("result: " + result);
    }
}
