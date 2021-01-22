package unit1;

import java2.unit1.competitors.*;
import java2.unit1.obstacles.*;

import java.util.ArrayList;

public class Marathon {

    private ArrayList<Team> teamList = new ArrayList<Team>();
    private Route route;

    public Marathon(Route route, Team... team){
        this.route = route;

        for(Team t: team){
            teamList.add(t);
            t.introrudeTeam();
        }

        route.introduceRoute();
    }

    public void init(){
    }

    public void race(){
        System.out.println("\nНачинаем гонку! ");
        ArrayList<Obstacle> obstacles =  route.getRouteObstacles();

        for(Team team: teamList){
            team.teamName();
            ArrayList<Competitor> competitors = team.getCompetitors();

            for (Competitor competitor : competitors){
                for(Obstacle obstacle : obstacles){
                    obstacle.doIt(competitor);
                }
            }

        }
    }

    public void result(){
        System.out.println("\nРезультат марафона: ");
        for(Team team : teamList){
            team.teamName();
            team.showCompetitorsResult();
        }
    }

}
