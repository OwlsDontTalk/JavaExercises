package unit1;

import java2.unit1.competitors.*;
import java2.unit1.obstacles.*;

public class Main {
    public static void main(String[] args) {


        Team teamHumans = new Team("Люди", new Human("Человек Боб"),
                new Human("Нелюдь Егор"));
        Team teamAnimals = new Team ("Звери", new Cat("Борис"),
                new Dog("Анатолий"));
        Team teamRobots = new Team( "Роботы", new Robot("Робот Валли"),
                new Robot("Робот Ева"));

        Route route = new Route( new Wall(2), new Water(50), new Cross(120),
                new Treadmill(1000));

        Marathon marathon = new Marathon(route, teamAnimals, teamHumans, teamRobots);

        marathon.init();
        marathon.race();
        marathon.result();
    }
}

