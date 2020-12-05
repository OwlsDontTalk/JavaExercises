package java1.unit1;

public class Unit1Homework {
    public static void main(String[] args){
        int varInt = -1;
        byte varByte = -128;
        short varShort = 32767;
        char varChar = 'a';
        long varLong = 10000L;
        float varFloat = 3.4f;
        double varDouble = 6.8;
        boolean varBoolean = true;
        String varString = "Ivan";


        varFloat = calculate(1,2,3,4);
        System.out.println(varFloat);

        varBoolean = compare(5,7);
        System.out.println(varBoolean);

        positiveOrNegative(-5);

        varBoolean = isNegative(100);
        System.out.println(varBoolean);

        sayHello(varString);

        isThereA29th(2015);
        isThereA29th(2016);
        isThereA29th(2000);
    }

    public static float calculate(int a, int b, int c, int d){
        float result = a * (b + (c / d));
        return result;
    }

    public static boolean compare(int a, int b){
        if( ((a+b) >= 10 ) && (((a+b) <= 20 ) )){
            return true;
        } else {
            return false;
        }
    }

     public static void positiveOrNegative(int a){
        if(a>=0){
            System.out.println("number is positive");
        }
        if(a < 0){
            System.out.println("number is negative");
        }
    }

    public static boolean isNegative(int a){return (a < 0);}

    public  static void sayHello(String name){
        String speech = String.format("Hello, %s!", name);
        System.out.println(speech);
    }

    public static void isThereA29th(int year){
        if(year%400 == 0){
            System.out.println(year +  " - весокосный");
        } else if ( (year % 100 != 0) && (year % 4 == 0) ){
            System.out.println(year +  " - весокосный");
        } else {
            System.out.println(year +  " - невесокосный");
        }
    }
}
