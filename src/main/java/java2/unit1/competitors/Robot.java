package java2.unit1.competitors;

public class Robot implements Competitor{
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    @Override
    public boolean isOnDistance() {
        return active;
    }

    public Robot(String name) {
        this.name = name;
        this.maxRunDistance = 10000;
        this.maxJumpHeight = 200;
        this.maxSwimDistance = 0;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " хорошо справился с кроссом");
        } else {
            System.out.println(name + " не справился с кроссом");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " удачно перепрыгнул через стену");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену");
            active = false;
        }
    }

    @Override
    public void cardio(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " справился с беговой дорожкой");
        } else {
            System.out.println(name + " не справился с беговой дорожкой");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(name + " отлично проплыл");
        } else {
            System.out.println(name + " не смог проплыть");
            active = false;
        }
    }

    @Override
    public void info() {
        System.out.println(name + " - " + active);
    }

    @Override
    public void result() {
        if(active) {
            System.out.println(name + " успешно справился с дистанцией");
        } else {
            System.out.println(name + " сошел с дистанции");
        }
    }

    @Override
    public void introduceComperitor() {
        System.out.println(name);
    }
}
