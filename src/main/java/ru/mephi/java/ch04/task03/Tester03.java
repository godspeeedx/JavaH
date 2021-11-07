package ru.mephi.java.ch04.task03;

import ru.mephi.java.ch04.ForTest.AddLabelPoint;

public class Tester03 {
    public static void main(String[] args) {
        LabeledPoint3 labeledPoint = new LabeledPoint3(2,4,"dsf");
        System.out.println(labeledPoint.x);
        Point3 point = labeledPoint;
        System.out.println(point.x);
        AddLabelPoint addLabelPoint = new AddLabelPoint(2, 3 );
        //addLabelPoint.x - не возможно
        LabelPointExtra x = new LabelPointExtra(4,7);
        //x.x; //impossible
    }
}
