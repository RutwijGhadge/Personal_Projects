package org.example.TicTacToe.Models;

public class Cell {
    private int row;
    private int col;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;//initially the cell state is empty
    }

    public void display(){//display the empty cell and cell with the Symbol
        if(player==null)
            System.out.println("|  |");
        else
            System.out.println("| "+player.getSymbol()+" |");
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    private CellState cellState;
    private Player player;
}
