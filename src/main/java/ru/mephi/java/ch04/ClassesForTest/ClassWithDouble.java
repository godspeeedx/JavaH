package ru.mephi.java.ch04.ClassesForTest;

public class ClassWithDouble {
    public Double length;
    public Integer code;
    public ClassWithDouble(){
        length = 0.0;
        code = 0;
    }


    public ClassWithDouble(Double length, Integer code) {
        this.length = length;
        this.code = code;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ClassWithDouble{" +
                "length=" + length +
                ", code=" + code +
                '}';
    }
}
