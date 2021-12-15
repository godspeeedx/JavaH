package ru.mephi.java.ch06.extraTask.contrvar;

import ru.mephi.java.ch03.task01.Employee;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.IntFunction;


public class MyStack<T> {
    public static void main(String[] args) {
        MyStack<Manager> managerMyStack = new MyStack<>(10, Manager[]::new);
        Manager manager1 = new Manager("Sasha", 10, 20);
        Manager manager2 = new Manager("Pasha", 20, 40);
        Manager manager3 = new Manager("Rasha", 30, 50);
        managerMyStack.push(manager1);
        managerMyStack.push(manager2);
        managerMyStack.push(manager3);
        ArrayList<Employee> arrayList = new ArrayList<>();
        managerMyStack.popAll(arrayList);
        System.out.println(arrayList.get(0).getName());
        System.out.println(Arrays.toString(arrayList.toArray()));


    }
    public MyStack(){
        this(10);
    }

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity){
        elementData = (T[]) new Object[initialCapacity];
    }

// В первом случае создаётся массив объектов, в то время как во втором создаётся сразу массив, переданного параметра,
// В данном случае удобнее первое, так каr
// метод AL.get() можно усовершнствовать кидая туда класс, а потом кастить с помощью рефлексии
    public MyStack(int initialCapacity, IntFunction<T[]> constr)  {
        elementData = constr.apply(initialCapacity);
    }


    private T[] elementData; // 10
    private int elementCount = 0; // 10

    private void ensureCapacityHelper(int minCapacity){
        if (minCapacity - elementData.length > 0)
            elementData = Arrays.copyOf(elementData, 2 * elementData.length);
    }

    public T push(T item){
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = item;
        return item;
    }

    public T pop(){
        T item;
        if (elementCount == 0)
            throw new EmptyStackException();
        item = elementData[elementCount - 1];
        elementCount--;
        elementData[elementCount] = null;
        return item;
    }
    public void pushAll(Collection<? extends T> c) {
        for(T item: c)
            push(item);
    }

    public void popAll(Collection<? super T> c) {
        while(elementCount > 0)
            c.add(pop());
    }

}
