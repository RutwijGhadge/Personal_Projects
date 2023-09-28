package org.example.TicTacToe.Models;

import org.example.TicTacToe.exceptions.InvalidBoardSizeException;
import org.example.TicTacToe.exceptions.InvalidBotCountException;
import org.example.TicTacToe.exceptions.InvalidPlayerCountException;
import org.example.TicTacToe.exceptions.InvalidPlayerSymbolException;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
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

    public Game(Board currentBoard,List<Player> players,WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.gameStatus = GameStatus.INPROGRESS;//starting of the game status should be inprogress
        this.move = new ArrayList<Move>();//no moves during the initialization so declared empty arraylist
        this.winningStrategy = winningStrategy;
        this.boardStates = new ArrayList<Board>();//No boardstates at the beginning
        // this.currentPlayer = currentPlayer; wont be able to declare the current player during the start
       // this.winner = winner;  No winner at the start of the game
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
    //validations will be done only for the Attributes that we are passing
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder dimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder Players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder WinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validateBotCount() throws InvalidBotCountException {
            int BotCount=0;
            for(Player player: players){//loop thrugh all the players if the playertype is Bot the count
                if(player.getPlayerType().equals(PlayerType.Bot))
                    BotCount++;
            }
            if(BotCount>1)
                throw new InvalidBotCountException("Invalid Bot Count -> Bot Count Cannot be > 1" +
                        ",Current BotCount is:"+BotCount);
        }
        public void validateBoardSize() throws InvalidBoardSizeException {
            if(dimension<3 || dimension>10)
                throw new InvalidBoardSizeException("Board Size is Invalid ->Board size >3 && <10,Current Board Size is "+dimension);
        }

        public void validatePlayerCount() throws InvalidPlayerCountException {
            if(players.size()>(dimension-1))
                throw new InvalidPlayerCountException("Player Count is Invalid , Current Player Count is:"
                        + players.size());
        }

        public void validatePlayerSymbols() throws InvalidPlayerSymbolException {
            HashSet<Character>hs=new HashSet<>();
            for(Player player:players){ //looping through the list of Players
                hs.add(player.getSymbol());//adding the symbols of each player
            }

            if(hs.size()!=players.size())
                throw new InvalidPlayerSymbolException("Invalid Player Symbol Exception : " +
                        "All Players should have Unique Symbol");
        }

        public void Validate() throws InvalidPlayerSymbolException, InvalidBotCountException, InvalidBoardSizeException, InvalidPlayerCountException {
            validateBoardSize();
            validatePlayerSymbols();
            validateBotCount();   //calling all validations from this method
            validatePlayerCount();
        }

        public Game build() throws InvalidBotCountException, InvalidPlayerCountException, InvalidBoardSizeException, InvalidPlayerSymbolException {
            Validate();
            return new Game(new Board(dimension),players,winningStrategy);//returning the game type object
        }
    }
}
