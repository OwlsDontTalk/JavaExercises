package java2.unit2;

public class MyArraySizeException extends Exception {

    private int rows;
    private int columns;

    public int getRows() {return rows;}

    public int getColumns() {return columns;}

    public MyArraySizeException(String msg, int rows, int columns){
        super(msg);
        this.rows = rows;
        this.columns = columns;
    }
}
