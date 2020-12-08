package java2.unit1.obstacles;

import java2.unit1.competitors.*;

public class Treadmill extends Obstacle {

    int length;
    private String name = "Беговая дорожка";

    public Treadmill(int length){this.length=length;}

    @Override
    public void doIt(Competitor competitor) {
        competitor.cardio(length);
    }

    @Override
    public void obstacleName() {
         System.out.println(name);
    }
}
