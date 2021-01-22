package unit2;

public class DaysOfWeekMain {

        public static void main(String[] args) {

        DayOfWeek[] days = DayOfWeek.class.getEnumConstants();

            for(DayOfWeek d : days){
                getWorkingHours(d);
            }
    }

    private static void getWorkingHours(DayOfWeek day) {

        if(day.getHours() == 0){
            System.out.println("Сегодня выходной");
        }
        if(day.getHours() != 0){
            System.out.println("До конца рабочей недели осталось: " + day.getHours() + " часов.");
        }
    }
}

