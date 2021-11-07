package ru.mephi.java.ch04.addTaskBinary;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.ByteArrayOutputStream;

public class Dog {
    public String name;
    public int age;
    public boolean bitable;

    // Create a dog instance
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.name = "Falco\"";
        dog.age = 4;
        dog.bitable = false;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
// Create Jsonb and serialize
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(dog);
        System.out.println(result);

// Deserialize back
        dog = jsonb.fromJson("{\"age\":4,\"bitable\":false,\"name\":\"Falco\"}", Dog.class);
    }
}
