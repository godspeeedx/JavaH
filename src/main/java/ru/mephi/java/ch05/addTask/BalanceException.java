package ru.mephi.java.ch05.addTask;

public class BalanceException extends Exception{
    public BalanceException() {
        super("Недостаточно средств");
    }

    public BalanceException(String message, double money) {
        super(message + ". Вам не хватает " + money);
    }

    public BalanceException(String message) {
        super(message);
    }

    public BalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BalanceException(Throwable cause) {
        super(cause);
    }

    protected BalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
