package ru.mephi.java.ch06.AdditionalTask;

import ru.mephi.java.ch04.task01.Point;
import ru.mephi.java.ch06.task08.Pair;

// Если что могу искакть на уровне пакета
public class InjectPoint extends InjectPointTemplate<Integer>{
    private Pair<? extends Number> n ; //
    // Pair<Number> // сравнить на тайп параметры
}
