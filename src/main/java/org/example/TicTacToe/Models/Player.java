package org.example.TicTacToe.Models;

import java.util.Scanner;

public class Player {
    private int id;
    private String Name;
    private char Symbol;
    private PlayerType playerType;//Bot or user

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        Name = name;
        Symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){      //returns a move played by a player
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Row:");
        int row=sc.nextInt();
        System.out.println("Enter the Column:");
        int col=sc.nextInt();
        // To Do : validations for Row And Column & Cell Status

        if( row < board.getSize() && col <board.getSize()){//validations for row and col
            CellState cellState=board.getBoard().get(row).get(col).getCellState();
            if(cellState==CellState.EMPTY){
                board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
                board.getBoard().get(row).get(col).setPlayer(this);
                return new Move(row,col,this);
            }else{
                System.out.println("Cell is Already Filled");
                return null;
            }
        }
        else{
            System.out.println("Out of Range Row:"+row +" && Column :"+col);
            System.out.println("Give new Choice");
            return null;
        }
     //   return new Move(row,col,this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
