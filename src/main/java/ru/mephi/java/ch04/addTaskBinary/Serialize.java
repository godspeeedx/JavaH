package ru.mephi.java.ch04.addTaskBinary;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serialize {
    public static <T> byte[] serialize(T obj) throws Exception {
        List<Byte> result = new ArrayList<Byte>();
        for(Field field : obj.getClass().getDeclaredFields()) { // перебираем все поля в классе
            field.setAccessible(true); // если поле приватное, меняем доступ к нему
            Object data = field.get(obj); // читаем значение из поля
            if(data instanceof byte[]) {
                for(byte b : (byte[])data){
                    result.add(b);
                }
                continue;
            }
            if(data instanceof Byte){
                result.add((Byte)data);
                continue;
            }
        }
        byte[] array = new byte[result.size()];
        for(int i = result.size()-1; i>=0; i--){
            array[i]=result.get(i);
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        Dog dog = new Dog();
        dog.name = "Falco\"";
        dog.age = 4;
        dog.bitable = false;
        System.out.println(Arrays.toString(serialize(dog)));
        System.out.println(1/0);
    }
}
