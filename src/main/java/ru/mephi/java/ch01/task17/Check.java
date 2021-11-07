package ru.mephi.java.ch01.task17;

import java.math.BigDecimal;
import java.math.RoundingMode;//

public class Check {
    public static void main(String[] args) {
        BigDecimal first = new BigDecimal("1.0");
        BigDecimal second = new BigDecimal("3.0");
        System.out.println(first.divide(second,3,RoundingMode.HALF_UP));
    }
}
