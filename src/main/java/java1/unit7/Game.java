package java1.unit7;

import javax.swing.*;

public class Game {
    private GameBoard board;
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    private int playersTurn = 0;

    Game(){
        this.board = new GameBoard(this);
        initGame();
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
        playersTurn = 0;
    }

    void passTurn(){
        if(playersTurn == 0){
            playersTurn = 1;
        } else {
            playersTurn = 0;
        }
    }

    GamePlayer getCurrentPlayer(){ return gamePlayers[playersTurn]; }

    public void setPlayersTurn(){this.playersTurn = 0;}

    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }
}
