package org.example.TicTacToe.exceptions;

public class InvalidPlayerSymbolException extends Exception{
    public InvalidPlayerSymbolException() {
    }

    public InvalidPlayerSymbolException(String message) {
        super(message);
    }

    public InvalidPlayerSymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPlayerSymbolException(Throwable cause) {
        super(cause);
    }

    public InvalidPlayerSymbolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
