package java1.unit5;

public class Bowl {
    private int maxAmount;
    private int currentAmount;

    Bowl(int maxAmount){
        this.maxAmount = maxAmount;
        currentAmount = maxAmount;
    }

    public void setCurrentAmount(int amount){
        currentAmount = amount;
    }

    public int getCurrentAmount(){
        return currentAmount;
    }

    public void refill(){ currentAmount = maxAmount; }

}
