package ru.mephi.java.ch04.addTask;

public class Converter {
    public static Object convert(String type, String value){
        if (type.equals("String")) return value;
        if (type.equals("Boolean")) return Boolean.valueOf(value);
        if (type.equals("Integer")) return  Integer.parseInt(value);
        if (type.equals("Double")) return  Double.parseDouble(value);
        if (type.equals("int")) return  Integer.parseInt(value);
        if (type.equals("double")) return  Double.parseDouble(value);
        if (type.equals("char")) return value.charAt(0);
        if (type.equals("Character")) return value.charAt(0);
        return null;
    }
}
