package org.example.TicTacToe.Models;

import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player>players;
    private GameStatus gameStatus;
    private Player currentPlayer;
    private Player winner;
    private List<Move> move;                //for replay feature
    private List<Board>boardStates;         //for replay feature
    private WinningStrategy winningStrategy;
}
