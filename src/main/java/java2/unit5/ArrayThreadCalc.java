package java2.unit5;

import java.util.concurrent.TimeUnit;

public class ArrayThreadCalc {

    private int size;
    private int numberOfThreads;
    private float arr[];
    private long threadCalcTime = 0;

    public ArrayThreadCalc(int size, int numberOfThreads){
        this.size = size;
        this.numberOfThreads = numberOfThreads;
        this.arr = new float[size];
    }

    private void fillArray(){
        for (int i = 0; i <this.size; i++) {
            arr[i] = 1;
        }
    }

    public void printTime(){
        System.out.println("2nd method array calculation time: " + threadCalcTime);
    }

    public void arrayCalcSimple(){

        fillArray();

        long a = System.currentTimeMillis();

        for (int i = 0; i < this.size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("1st method array calculation time: " + (System.currentTimeMillis() - a));
    }

    public void arrayCalcThread(){

        fillArray();

        int[][] arrayInstructions  = arraySizeCalc(this.numberOfThreads, this.size);


        for (int i = 0; i < arrayInstructions.length; i++) {

            int i0 = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    float[] arrPart = new float[arrayInstructions[i0][2]];

                    long a = System.currentTimeMillis();
                    System.arraycopy(arr, arrayInstructions[i0][0], arrPart, 0, arrayInstructions[i0][2]);

                    for (int j = 0; j < arrayInstructions[i0][2]; j++) {
                        arrPart[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                    }

                    System.arraycopy(arrPart, 0, arr, arrayInstructions[i0][0], arrayInstructions[i0][2]);
                    System.out.println("2nd method thread " + (i0+1) +  " calculation time: " + (System.currentTimeMillis() - a));
                    threadCalcTime += (System.currentTimeMillis() - a);
                }
            }).start();
        }
    }

    //return [startElement, endElement, subArraySize]
    private int[][] arraySizeCalc(int numberOfArrays, int mainArraySize){
        int[][] arr = new int[numberOfArrays][3];

        int size = mainArraySize / numberOfArrays;

        for (int i = 0; i < numberOfArrays; i++) {
            if( (i+1) == numberOfArrays ){
                arr[i][0] = i * size;
                arr[i][1] = mainArraySize - 1;
                arr[i][2] = mainArraySize - i * size;
            } else {
                arr[i][0] = i * size;
                arr[i][1] = (i + 1) * size - 1;
                arr[i][2] = size;
            }
        }

        return arr;
    }
}

class MainArrayCalc{
    public static void main(String[] args) throws InterruptedException {

        final int size = 10000000;
        final int numberOfThreads = 3;

        ArrayThreadCalc atc = new ArrayThreadCalc(size, numberOfThreads);

        atc.arrayCalcSimple();
        atc.arrayCalcThread();

        TimeUnit.SECONDS.sleep(10);
        atc.printTime();
    }
}

