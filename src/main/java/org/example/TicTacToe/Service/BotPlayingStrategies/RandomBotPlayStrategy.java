package org.example.TicTacToe.Service.BotPlayingStrategies;

import org.example.TicTacToe.Models.Board;
import org.example.TicTacToe.Models.Cell;
import org.example.TicTacToe.Models.CellState;
import org.example.TicTacToe.Models.Move;
import org.example.TicTacToe.exceptions.GameOverException;

import java.util.List;

public class RandomBotPlayStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) throws GameOverException {
            List<List<Cell>>matrix=board.getBoard();//Board

            for(int i=0;i< matrix.size();i++){//loop through the board
                for(int j=0;j<matrix.size();j++){
                    if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY))//if the cell is empty
                        return new Move(i,j);//make a new move(i th row, j th col)
                }
            }
            throw new GameOverException("No Cell to Play for BOT : GameOver");
    }
}
