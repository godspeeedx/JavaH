package ru.mephi.java.ch04.ForTest;

import ru.mephi.java.ch04.ClassesForTest.*;
import ru.mephi.java.ch04.addTask.SerializeRef;
import ru.mephi.java.ch04.addTaskBinary.Serialize;

import java.lang.reflect.InvocationTargetException;

public class TesterSerialize {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        AddLabelPoint.per("Start");
        ClassWithDouble classWithDouble = new ClassWithDouble(3.0, 2);
        byte[] bytesD = SerializeRef.serialize(classWithDouble);
        Object objD = SerializeRef.deSerialize(bytesD);
        System.out.println(classWithDouble.toString());
        First first = new First(4, "\"133 ru.mephi.java.ch04.ClassesForTest.Second [first=ru.mephi.java.ch04.ClassesForTest.First [length=4,name=\"4 5432\"],secondName=\"4 435'\"]\"");
        Second second = new Second(first, "\'");
        byte[] bytes = SerializeRef.serialize(second);
        Object obj = SerializeRef.deSerialize(bytes);
        System.out.println((obj).equals(second));
        ClassCharacter character = new ClassCharacter('\'', '\"');
        byte[] bytesC = SerializeRef.serialize(character);
        Object objC = SerializeRef.deSerialize(bytesC);
        System.out.println(objC.equals(character));
        // Boolean second1 = (Boolean) obj;
        // System.out.println(second1.toString());
        // Double doub = 1/3.0;
        // Double doub = 1/3.0;
        // Double doub2 = (Double) SerializeRef.deSerialize(SerializeRef.serialize(doub));
        // System.out.println(doub2.equals(doub));
        /*Integer numb = 5;
        byte[] bytes2 = SerializeRef.serialize(numb);
        Object obj2 = SerializeRef.deSerialize(bytes2);
        Integer numb1 = (Integer) obj2;
        System.out.println(numb1.toString());
        System.out.println(numb1.equals(numb));*/

        AddLabelPoint.per("End");




    }
}
