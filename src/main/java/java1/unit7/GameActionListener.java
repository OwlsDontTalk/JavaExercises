package java1.unit7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {

    private GameButton button;
    private int row;
    private int cell;

    public GameActionListener(int rowNum, int cellNum, GameButton gameButton) {
        this.button = gameButton;
        this.row = rowNum;
        this.cell = cellNum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if(board.isTurnable(row, cell)){
            updateByPlayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("Draw");
                board.emptyField();
            } else {
                updateByAiData(board);
            }
        } else {
           board.getGame().showMessage("Incorrect turn");
        }
    }

    private void updateByAiData(GameBoard board) {
        int x, y;
        int dimension = board.getDimension();
        x = -1;
        y = -1;
        Random rnd = new Random();
        boolean moveFound = false;
        char[][] gameField = board.getGameField();
        char aiSymbol = board.getGame().getCurrentPlayer().getPlayerSign();


        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(gameField[i][j] == '\u0000'){
                    if(i - 1 >= 0 && j - 1 >= 0 && gameField[i-1][j-1] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }
                    else if(i - 1 >= 0 && gameField[i-1][j] == aiSymbol) {
                        y = i;
                        x = j;
                        moveFound = true;
                    }else if(i - 1 >= 0 && j + 1 < dimension && gameField[i - 1][j + 1] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }else if (j + 1 < dimension && gameField[i][j + 1] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }else if (i + 1 < dimension && j + 1 < dimension && gameField[i + 1][j + 1] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }else if (i + 1 < dimension && gameField[i + 1][j] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }else if (i + 1 < dimension && j - 1 >= 0 && gameField[i + 1][j - 1] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }else if (i - 1 >=0 && gameField[i-1][j] == aiSymbol){
                        y = i;
                        x = j;
                        moveFound = true;
                    }

                }

                if(moveFound){
                    break;
                }
            }

            if(moveFound){
                break;
            }
        }

        if(x == -1){
            do{
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x, y));
        }

        board.updateGameField(x, y);

        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("AI win");
        } else {
            board.getGame().passTurn();
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row, cell);

        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("You win");
        } else {
            board.getGame().passTurn();
        }
    }
}
