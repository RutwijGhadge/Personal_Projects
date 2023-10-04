package org.example.TicTacToe.Service.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategies winningStrategy, int dimension){
        //Switch case based on Strategy
            return new OrderWinningStrategy(dimension);
    }
}
