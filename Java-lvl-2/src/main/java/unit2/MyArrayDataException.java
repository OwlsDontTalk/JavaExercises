package unit2;

public class MyArrayDataException extends Exception{

    int row;
    int column;
    public MyArrayDataException(String msg, int row, int column ){
        super(msg);
        this.row = row;
        this.column = column;
    }

    public int getRow() { return row; }
    public int getColumn() { return column; }
}


