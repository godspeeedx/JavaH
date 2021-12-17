package ru.mephi.java.ch06.AdditionalTask;

import ru.mephi.java.ch06.task08.Pair;

public class InjectPoint2<T extends Number & Comparable<T>> extends InjectPointTemplate<Integer>{
    private Pair<T> n;
}
