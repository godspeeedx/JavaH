package ru.mephi.java.ch05.task04;

public enum Error {
    OK(1),
    FILE_NOT_FOUND(2),
    INCORRECT_FORMAT(3);

    public final int code;

    Error(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    @Override
    public String toString(){
        return "code = " + this.code;
    }
}
