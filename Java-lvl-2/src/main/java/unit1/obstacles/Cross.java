package unit1.obstacles;

import java2.unit1.competitors.*;
public class Cross extends Obstacle {
    int length;
    private String name = "Кросс";
    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }

    @Override
    public void obstacleName() {
        System.out.println(name);
    }
}