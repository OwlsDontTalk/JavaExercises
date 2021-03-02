package unit7;

import javax.swing.*;

public class GameButton extends JButton{
    private int buttonIndex;
    private GameBoard board;

    GameButton(int gameGuttonIndex, GameBoard currentGameBoard){
        this.buttonIndex = gameGuttonIndex;
        this.board = currentGameBoard;

        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener( new GameActionListener(rowNum, cellNum, this));
    }

    public GameBoard getBoard(){return this.board;}
}
