
package ru.mephi.java.ch04.task09;
import ru.mephi.java.ch02.task09.Car;
import ru.mephi.java.ch04.addTask.SerializeRef;
import ru.mephi.java.ch04.task01.LabeledPoint;
import ru.mephi.java.ch04.task08.BagPack;
import ru.mephi.java.ch04.task08.Person;

public class Tester09 {
    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car(12);
        LabeledPoint labeledPoint = new LabeledPoint(3,4,"fdf");
        Person<Double> person = new Person<>(3.5,"6");
        //System.out.println(UnivToString.toString(car));
        //System.out.println(UnivToString.toString(person));
        Class1 class1 = new Class1(1,2, "lsafl");
        Class2 class2 = new Class2(class1, "dsff");
        System.out.println(SerializeRef.toString(class2));
        //System.out.println(SerializeRef.toString(class1));
    }
}
