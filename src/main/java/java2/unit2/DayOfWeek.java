package java2.unit2;

public enum DayOfWeek{
    MONDAY("Пондельник", 40),
    TUESDAY("Вторник", 32),
    WEDNESDAY("Среда", 24),
    THURSHDAY("Четверг", 16),
    FRIDAY("Пятница", 8),
    SATURDAY("Суббота", 0),
    SUNDAY("Воскресенье", 0);

    private String title;
    private int hours;

    DayOfWeek(String title, int hours) {
        this.title = title;
        this.hours = hours;
    }

    public String getTitle() { return title; }

    public int getHours() { return hours;  }

}
