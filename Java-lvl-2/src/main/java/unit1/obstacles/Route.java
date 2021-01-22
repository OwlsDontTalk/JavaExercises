package unit1.obstacles;

import java2.unit1.competitors.*;

import java.util.ArrayList;

public class Route {
    protected ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    public Route(Obstacle... obstacle){
        for(Obstacle o : obstacle){
            obstacles.add(o);
        }
    }

    public void introduceRoute(){
        System.out.println("Маршурт: ");
        for(Obstacle o : obstacles){
            o.obstacleName();
        }
    }

    public ArrayList<Obstacle> getRouteObstacles(){
        return this.obstacles;
    }

}
