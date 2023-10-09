package org.example.TicTacToe.Controller;

import org.example.TicTacToe.Models.*;
import org.example.TicTacToe.Service.WinningStrategy.WinningStrategies;
import org.example.TicTacToe.Service.WinningStrategy.WinningStrategyFactory;

import java.util.List;
import java.util.Scanner;

public class GameController {

    public Game createGame(int dimension, List<Player> players, WinningStrategies winningStrategy){
        try {
            return Game.builder()
                    .dimension(dimension)
                    .players(players)
                    .winningStrategy(WinningStrategyFactory.getWinningStrategy(winningStrategy, dimension))
                    .build();
        }
        catch (Exception e){
                System.out.println("Could not Start the Game -> Something went Wrong");
                System.out.println("Error:" +e.getMessage());
        }
        return null;
    }
    public void displayBoard(Game game){//printing board
         game.getCurrentBoard().printBoard();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public Player getGameWinner(Game game){
        return game.getWinner();
    }

    public Move executeMove(Game game,Player player,int index){
        Move move=player.makeMove(game.getCurrentBoard());
        if(move==null){
            return null;
        }
        game.setNo_of_Symbols(game.getNo_of_Symbols()+1);
        updateGameStatus(game);
        //current board is passed so that Move will be executed on this board
        updateListOfMoves(game,move);

        //played move is added in the listOf Moves -> for replay or undo
        updateBoardStates(game);
//       System.out.println("Do you want to undo your move? (Y/N)");
//        Scanner sc=new Scanner(System.in);
//        String response=sc.next();
//
//        if(response.equalsIgnoreCase("Y")){
//            undotheMove(game,move,index);
//        }
        return move;
    }

    private void updateGameStatus(Game game) {//Draw Status Logic
        int noOfSymbols=game.getNo_of_Symbols();
        int boardSize=game.getCurrentBoard().getSize();
        if(noOfSymbols == boardSize*boardSize){//symbols==cells
            game.setGameStatus(GameStatus.DRAW);
        }
    }

    private void updateListOfMoves(Game game,Move move){
        game.getMove().add(move);
    }

    private void undotheMove(Game game,Move move,int index){
        game.getMove().remove(index-1);
        game.getBoardStates().remove(index-1);
        index--;
    }

    private void updateBoardStates(Game game){
        game.getBoardStates().add(new Board(game.getCurrentBoard()));
    }

    public Player checkWinner(Game game , Move lastPlayedMove){//checking the winner of game
        Player player=game.getWinningStrategy().checkWinner(game.getCurrentBoard(),lastPlayedMove);
        if(player!=null){
            game.setWinner(player);
            game.setGameStatus(GameStatus.COMPLETED);
            return player;
      }
        return null;
    }
}
