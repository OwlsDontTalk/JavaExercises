package unit2;

public class MainEx {

    public static void main(String[] args) {
        String[][] testArray = new String[3][4];

        //test values for 4x4 array. set testArray to [4][4] before uncommenting
//        testArray[0] = new String[] {"1","2","3","4"};
//        testArray[1] = new String[] {"5","6","7","8"};
//        testArray[2] = new String[] {"9","10","11","12"};
//        testArray[3] = new String[] {"13","14","asd","16"};

        try {
            arraySizeCheck(testArray,4,4);
        }catch (MyArraySizeException e){
            System.out.println(e.getMessage() + " " + e.getRows() + "x" + e.getColumns());
        }

        try {
            System.out.println(arrayFieldsCheck(testArray));
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage() + ": " + e.getRow() + "x" + e.getColumn());
        }


    }

    public static void arraySizeCheck(String[][] testArray, int rows, int cols) throws MyArraySizeException {
        //fix with checking every row of the array.
        if (!(testArray.length == rows && testArray[0].length == cols)) throw new MyArraySizeException("Wrong array size: ", testArray.length, testArray[0].length);
    }

    public static int arrayFieldsCheck(String[][] testArray) throws MyArrayDataException {
        int sum = 0;
        int temp = 0;

       for(int i = 0; i < testArray.length; i++){
            for(int j = 0; j < testArray[0].length; j++) {
                temp = 0;

                try {
                    temp = Integer.parseInt(testArray[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Cannot convert array item to int", i, j);
                }

                sum += temp;
            }
        }

        return sum;
    }
}
