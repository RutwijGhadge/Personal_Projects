package org.example.TicTacToe;

import org.example.TicTacToe.Controller.GameController;
import org.example.TicTacToe.Models.*;
import org.example.TicTacToe.Service.WinningStrategy.WinningStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GameController gameController=new GameController();

        System.out.println("Enter the Dimension of the Game");
        int dimension=sc.nextInt();

        System.out.println("Is BOT present in the Game(Y/N)");
        String isBOTPresent=sc.next();

        List<Player>players=new ArrayList<>();
        int iterator=dimension-1;//n-1 players for size n*n

        if(isBOTPresent.equalsIgnoreCase("Y")){
            iterator-=1;
            System.out.println("Name of the BOT:");
            String name=sc.next();

            System.out.println("Symbol of the BOT");
            String Symbol=sc.next();//no way to take input as character in Scanner
            BotDifficultyLevel botDifficultyLevel=BotDifficultyLevel.EASY;

            players.add(new BOT(dimension-1,name,Symbol.charAt(0), PlayerType.Bot,botDifficultyLevel));
            //last player to add
        }

        for(int i=1;i<=iterator;i++){
            System.out.println("Name of the Player,Number:"+i);
            String name=sc.next();

            System.out.println("Symbol of the Player,Number:"+i);
            String Symbol=sc.next();//no way to take input as character in Scanner

            players.add(new Player(i,name,Symbol.charAt(0), PlayerType.Human));
        }

        Collections.shuffle(players);//shuffle/Randomizes the List of Players

        Game game=gameController.createGame(dimension,players, WinningStrategies.OrderOne_WinningStrategy);
        //Validations will be done : createGame() -> Build() ->Validate()

        int playerIndex=0;

        while(gameController.getGameStatus(game).equals(GameStatus.PROGRESS)){
            System.out.println("Current Board Status:");
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex=playerIndex % players.size();
            Player winner = null;

            System.out.println("Make Your Move "+players.get(playerIndex).getName() );
            Move movePlayed=gameController.executeMove(game,players.get(playerIndex));

            winner=gameController.checkWinner(game,movePlayed);

            if(winner!=null) {
                System.out.println("Thanks for the Participation");
                System.out.println("Winner of the Game is:" + winner.getName());
                break;
            }

            if(gameController.getGameStatus(game).equals(GameStatus.DRAW)){
                System.out.println("Game has been Drawn : Thanks for the Participation");
            }
        }
        System.out.println("Final Board Status:");
        gameController.displayBoard(game);

        System.out.println("Do you want the game replay? Y/N");
        Scanner sct=new Scanner(System.in);
        String isReplayReq = sct.next();
        if(isReplayReq.equalsIgnoreCase("Y")) {
            System.out.println("========================================================");
            System.out.println();
            gameController.replay(game);
        }
    }
}
