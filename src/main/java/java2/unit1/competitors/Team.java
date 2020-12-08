package java2.unit1.competitors;

import java.util.ArrayList;

public class Team {
    private String name = new String();
    private ArrayList<Competitor> competitors = new ArrayList<Competitor>();

    public Team(String teamName, Competitor... competitor){
        this.name = teamName;

        for(Competitor c : competitor){
            competitors.add(c);
        }
    }

    public void introrudeTeam() {
        System.out.println("Команда " + this.name + " :");
        for (Competitor c : competitors) {
            c.introduceComperitor();
        }
    }

    public void teamName(){
        System.out.println(this.name);
    }

    public ArrayList<Competitor> getCompetitors(){
        return this.competitors;
    }

    public void showCompetitorsStatus(){
        for(Competitor competitor : competitors){
            competitor.info();
        }
    }

    public void showCompetitorsResult(){
        for(Competitor competitor : competitors){
            competitor.result();
        }
    }


}
