package org.example.TicTacToe.Service.WinningStrategy;

import org.example.TicTacToe.Models.Board;
import org.example.TicTacToe.Models.Move;
import org.example.TicTacToe.Models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
