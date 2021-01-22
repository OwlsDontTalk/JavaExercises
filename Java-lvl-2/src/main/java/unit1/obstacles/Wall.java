package unit1.obstacles;

import java2.unit1.competitors.*;

public class Wall extends Obstacle {
    int height;
    private String name = "Стена";
    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }

    @Override
    public void obstacleName() {
        System.out.println(name);
    }
}