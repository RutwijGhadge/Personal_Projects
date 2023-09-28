package org.example.TicTacToe.Service.WinningStrategy;

import org.example.TicTacToe.Models.Board;
import org.example.TicTacToe.Models.Move;
import org.example.TicTacToe.Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character,Integer>>rowHashMaps;        //List of Hashmaps for rows
    private List<HashMap<Character,Integer>>colHashMaps;
    private HashMap<Character,Integer>topLeftHashMap;
    private HashMap<Character,Integer>topRightHashMap;
    private HashMap<Character,Integer>cornersHashMap;

    public OrderWinningStrategy(int dimension) {//constructor
        this.dimension = dimension;
        topLeftHashMap = new HashMap<>();
        topRightHashMap = new HashMap<>();
        cornersHashMap = new HashMap<>();

        rowHashMaps=new ArrayList<>();
        colHashMaps=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            //initializing Hashmaps in the ArrayList for rowHashmaps and columnHashmaps
            rowHashMaps.add(new HashMap<>());
            colHashMaps.add(new HashMap<>());
        }
    }

    public boolean isTopLeftDiagonalCell(int row,int col){
        return row==col;
    }
    public boolean isTopRightDiagonalCell(int row,int col){
        return row+col==dimension;
    }
    public boolean isCornerCell(int row,int col){
        //[0,0] [dimension-1,0] [0,dimension-1] [dimension-1,dimension-1]
        if(row==0 || row==dimension-1)
            return (col==0 || col==dimension-1);
        return false;
    }

    @Override
    public Player checkWinner(Board board,Move lastMove){
        //to check the winner we will require the board and the lastMove
        Player player=lastMove.getPlayer();
        char Symbol=lastMove.getPlayer().getSymbol();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();

        if(checkRowWin(row,Symbol))//checking the winning Conditions (whether it fits in or not)
            return player;
        else if (checkColumnWin(row,Symbol))
            return player;
        else if (isTopLeftDiagonalCell(row,col) && checkTopLeftDiagonalWin(Symbol))
            return player;
        else if (isTopRightDiagonalCell(row,col) && checkTopRightDiagonalWin(Symbol))
            return player;
        else if (isCornerCell(row,col) && checkCornersWin(Symbol))
            return player;

        return null;
        }

    public boolean checkRowWin(int row,char Symbol){
        //if the symbol not present then add the symbol and count
        if(!rowHashMaps.get(row).containsKey(Symbol)){
            rowHashMaps.get(row).put(Symbol,0);
        }
        else{
            rowHashMaps.get(row).put(Symbol,rowHashMaps.get(row).get(Symbol)+1);//update the count if present
        }

        if(rowHashMaps.get(row).get(Symbol)==dimension-1)//if the symbol cnt is equal to dimension -1
            return true;
        return false;
    }
    public boolean checkColumnWin(int col,char Symbol){
        if(!colHashMaps.get(col).containsKey(Symbol)){
            colHashMaps.get(col).put(Symbol,0);
        }
        else{
            colHashMaps.get(col).put(Symbol,colHashMaps.get(col).get(Symbol)+1);//update the count if present
        }

        if(colHashMaps.get(col).get(Symbol)==dimension-1)//if the symbol cnt is equal to dimension -1
            return true;
        return false;
    }
    public boolean checkTopLeftDiagonalWin(char Symbol){
        if(!topLeftHashMap.containsKey(Symbol)){
            topLeftHashMap.put(Symbol,0);
        }
        else{
            topLeftHashMap.put(Symbol,topLeftHashMap.get(Symbol)+1);//update the count if present
        }

        if(topLeftHashMap.get(Symbol)==dimension-1)//if the symbol cnt is equal to dimension -1
            return true;
        return false;

    }
    public boolean checkTopRightDiagonalWin(char Symbol){
        if(!topRightHashMap.containsKey(Symbol)){
            topRightHashMap.put(Symbol,0);
        }
        else{
            topRightHashMap.put(Symbol,topRightHashMap.get(Symbol)+1);//update the count if present
        }

        if(topRightHashMap.get(Symbol)==dimension-1)//if the symbol cnt is equal to dimension -1
            return true;
        return false;

    }
    public boolean checkCornersWin(char Symbol){
        if(!cornersHashMap.containsKey(Symbol)){
            cornersHashMap.put(Symbol,0);
        }
        else{
            cornersHashMap.put(Symbol,cornersHashMap.get(Symbol)+1);    //update the count if present
        }

        if(cornersHashMap.get(Symbol)==4)   //if the symbol cnt is equal to 4 corners
            return true;
        return false;
    }

}
