package lesson_4;

public class Main {
    static Object obj = new Object();
    static volatile char letterToPrint = 'A';

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    synchronized (obj){
                        while (letterToPrint != 'A'){
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(" " + (i + 1) + " ");
                        System.out.print("A");
                        letterToPrint = 'B';
                        obj.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    synchronized (obj){
                        while (letterToPrint != 'B'){
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        letterToPrint = 'C';
                        obj.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    synchronized (obj){
                        while (letterToPrint != 'C'){
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("C");
                        letterToPrint = 'A';
                        obj.notifyAll();
                    }
                }
            }
        }).start();
    }

}

