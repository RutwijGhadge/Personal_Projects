package org.example.TicTacToe.Models;

public class BOT extends Player{//Bot is the child class of player
    //it requires all the Attributes that Player has
    private BotDifficultyLevel botDifficultyLevel;

    public BOT(int id, String name, char symbol, PlayerType playerType,BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel=botDifficultyLevel;
    }
}
