package ru.mephi.java.ch06.AdditionalTask;


import ru.mephi.java.ch06.task08.Pair;

public class InjectPointTemplate <T extends Comparable<T>>{
    private Pair<T> field; // проверить, кто от этого наследуется
}
