package java1.unit2;

public class Unit2Arrays {

    public static void main(String[] args){

        //Иницциализация массива из 0 и 1 и замена их значений на противоположные в цикле
        int[] intArr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1 ,1, 1 };

        for(int i = 0; i < intArr.length; i++){
            intArr[i] = (intArr[i] == 0 ? 1 : 0);
        }
        System.out.println("Массив после замены 0 и 1");
        printArr(intArr);


        // Инициализация пустого массива и заполнение его значениями в цикле.
        int[] emptyArr = new int[8];

        for(int i = 0; i < emptyArr.length; i++){
            emptyArr[i] = i * 3;
        }
        printArr(emptyArr);

        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        int[] presetArr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for(int i = 0; i < presetArr.length; i++){
            if(presetArr[i] < 6)
                presetArr[i] *= 2;
        }
        printArr(presetArr);

        //Создаем двумерный массив и заполняем его диагонали единицами
        int diagArr[][] = new int[10][10];
        for(int i = 0; i < diagArr.length; i++){
            System.out.print('\n');
            for(int j = 0; j < diagArr[i].length; j++){
                if(i == j){
                    diagArr[i][j] = 1;
                } else if((i + j) == (diagArr.length - 1 ) ) {
                    diagArr[i][j] = 1;
                }
                System.out.print(diagArr[i][j]);
            }
        }

        //Поиск минимума и максимума в массиве
        int min = presetArr[0];
        int max = presetArr[0];

        for(int i : presetArr){
            if(min > i)
                min = i;

            if(max < i)
                max = i;

        }


        printArr(presetArr);
        System.out.print("min: " + min + " max :" + max);

        int[] checkBallanceArray = {10,10};
        boolean result = checkBalance(checkBallanceArray);
        System.out.print("\n" + result);

        int[] testArray = {1,2,3,4,5};
        System.out.println();
        transpose(testArray,1);
        System.out.println();
        transpose(testArray, -2);
    }

    //Метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма
    // левой и правой части массива равны.
    public static boolean checkBalance(int[] arr){

        int sumBefore = 0;
        int sumAfter = 0;

        if(arr.length == 1)
            return false;

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                sumBefore+=arr[j];
            }
            for (int j=i; j < arr.length; j++){
                sumAfter+=arr[j];
            }
        }

        if(sumBefore == sumAfter)
            return true;

        return false;

    }

    //Метод, которому на вход подается одномерный массив и число n, при этом метод должен сместить все элементы массива
    // на n позиций
    public static void transpose(int[] arr, int n){
        int temp;

        if(n > 0){
            for(int i = 0; i < n; i++){
                temp = arr[ arr.length-1 ];
                System.out.print(i);

                for(int j = arr.length-1; j >= 1; j--){
                    arr[j] = arr[j-1];
                }
                arr[0] = temp;
            }
            System.out.println("Массив смещен на " + n);
            printArr(arr);
        } else if (n < 0){
            for(int i = n; i <= 0; i++){
                temp = arr[0];

                for(int j = 1; j < arr.length; j++){
                    arr[j-1] = arr[j];
                }
                arr[arr.length-1] = temp;
            }
            System.out.println("Массив смещен на " + n);
            printArr(arr);
        }

    }

    //метод выводит целочисленный массив
    public static void printArr(int[] arr){
        System.out.println("\nArray output: ");
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
