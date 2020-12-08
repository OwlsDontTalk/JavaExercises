package java2.unit1.obstacles;

import java2.unit1.competitors.*;

public class Water extends Obstacle {
    int length;
    private  String name = "Вода";
    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }

    @Override
    public void obstacleName() {
        System.out.println(name);
    }
}