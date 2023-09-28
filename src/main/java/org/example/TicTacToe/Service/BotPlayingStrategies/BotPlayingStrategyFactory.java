package org.example.TicTacToe.Service.BotPlayingStrategies;

import org.example.TicTacToe.Models.Board;
import org.example.TicTacToe.Models.Move;
import org.example.TicTacToe.exceptions.GameOverException;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy getBotPlayingStrategy(){
        return new RandomBotPlayStrategy();
    }
}
