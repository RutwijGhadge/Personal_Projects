package org.example.TicTacToe.Service.WinningStrategy;

public class WinningStrategyFactory {
    public WinningStrategy getWinningStrategy(WinningStrategies winningStrategies,int dimension){
        //Switch case based on Strategy
            return new OrderWinningStrategy(dimension);
    }
}
