package unit3;

import java.util.Scanner;
import java.util.Random;


public class Unit3TickTackToe {

    private static char[][] map;
    private static int[][] computerMap;
    private static Random random = new Random();

    private static final int SIZE = 3;
    private static final boolean SILLY_MODE = false;
    private static final char DOT_EMPTY = '●';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static boolean FIRST_TURN = true;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        initializeMap();
        printMap();

        while(true){
            humanTurn();

            if(isEndGame(DOT_X)){
                break;
            }

            //В первый ход клетка выбирается случайно. Дальше включается клеток и простановка оценок каждый клетке
            computerTurn();
            if(FIRST_TURN) FIRST_TURN = false;

            if(isEndGame(DOT_O)){
                break;
            }
        }

    }

    //инициализируем карты и заполняем их нуляеми
    public static void initializeMap(){
        map = new char[SIZE][SIZE];
        computerMap = new int[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
                computerMap[i][j] = 0;
            }
        }
    }

    //карту с оценками клеток для хода компьютера заполняем нулями
    public static void initializeComputerMap(){

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                computerMap[i][j] = 0;
            }
        }
    }

    public static void printMap(){
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < SIZE; i++){
            System.out.print((i+1) + " ");

            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    //метод для отображения массивая с оценками будущих ходов для компьютера
    public static void printComputerMap(){
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < SIZE; i++){
            System.out.print((i+1) + " ");

            for(int j = 0; j < SIZE; j++){
                System.out.print(computerMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static boolean isCellValid(int x, int y){

        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            return false;
        }

        if(map[x][y] != DOT_EMPTY){
            return false;
        }

        return true;
    }

    public static boolean isMapFull(){

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char playerSymbol) {

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            return true;
        }

        return false;
    }

    private static boolean isEndGame(char playerSymbol){

        printMap();

        if(checkWin(playerSymbol)){
            System.out.println("Win: " + playerSymbol);
            return true;
        }

        if(isMapFull()){
            System.out.println("Game ended in a draw.");
            return true;
        }

        return false;
    }

    public static void humanTurn(){
        int x, y;

        do{
            System.out.println("Input coordinates (X Y)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }while(!isCellValid(x, y));

        map[x][y] = DOT_X;

    }

    public static void computerTurn(){
        int x = -1;
        int y = -1;
        int[] turn = new int[2];

        if(SILLY_MODE){
            do{
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }while(!isCellValid(x,y));
        } else {
            if(FIRST_TURN){
                System.out.println("Random pc initialised");
                do{
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                }while(!isCellValid(x,y));
            }else{
                System.out.println("Smart pc initialised");
                turn = chooseCell();
                x = turn[0];
                y = turn[1];
            }
        }
        System.out.println("Computer turn:" + (y + 1) + " " + (x + 1));
        map[x][y] = DOT_O;

    }

    public static int[] chooseCell(){
        int[] turn = new int[2];
        int bestCell = 0;
        turn[0] = 0;
        turn[1] = 0;

        System.out.println("cells choosing begins");
        rateCells();

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(computerMap[i][j]>bestCell){
                    bestCell = computerMap[i][j];
                    turn[0] = i;
                    turn[1] = j;
                }
            }
        }
        System.out.println(turn[0] + " " + turn[1]);
        return turn;
    }

    public static void rateCells(){
        System.out.println("cell rating begins");
        int sup = 0;
        //переинициализируем массив c оценкой клеток
        initializeComputerMap();

        //алгоритм проходит карту 4 раза из углов в центр. если рядом с текущей клеткой есть 0 - увеличивается значение в текущей клетке
        //проверка из левого верхнего угла до центра
        for(int i = 0; i < SIZE-1; i++){
            for(int j = 0; j < SIZE-1; j++){
                //здесь нам надо пройтись по каждой клетке и если рядом с ней есть 0 - приплюсовать
                if(map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i+1][j+1] == DOT_O) computerMap[i][j] +=1;
            }
        }

        //проверка из правого верхнего угла до центра
        for(int i = 0; i < SIZE-1 ; i++){
            for(int j = SIZE-1; j >=1; j--){

                if(map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i+1][j-1] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O) computerMap[i][j] +=1;
            }
        }

        //проверка из левого нижнего угла до центра
        for(int i = SIZE-1; i>=1; i-- ){
            for(int j = 0; j < SIZE-1; j++){

                if(map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i-1][j+1] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O) computerMap[i][j] += 1;
            }
        }

        //проверка из правого нижнего угла до центра
        for(int i = SIZE-1; i >=1; i--){
            for(int j = SIZE-1; j>=1; j--){
                if(map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i-1][j-1] == DOT_O) computerMap[i][j] +=1;
                if(map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) computerMap[i][j] += 1;
            }
        }
    }
}
