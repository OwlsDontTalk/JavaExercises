package lesson_5;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    //tunnel - semaphore?
    //start - countDown

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel());
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT + 1);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                cdl.countDown();

                try {
                    cdl.await();
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
        }).start();


    }
}

