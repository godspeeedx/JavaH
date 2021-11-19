package ru.mephi.java.ch06.task02;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackObj<E> {
    private Object[] stack;
    private int initialCapacity = 10;
    private int stackSize;

    public StackObj() {
        stack = new Object[initialCapacity];
        stackSize = 0;
    }

    public StackObj(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Аргумент должен быть положительным");
        }
        this.initialCapacity = initialCapacity;
        stack = new Object[initialCapacity];
        stackSize = 0;
    }
    /*
    but it will create array of objects so you will be able to insert there any object via raw type reference.
    It would be nice it you had some instance of T type or class literal,
    then you could use it to create normal array of T type for example like this.
     */
    /*public TypedStack(Class<E> c) {
        elementData = (E[])Array.newInstance(c, initialCapacity);
    }*/

    public Object push(Object element) {
        int len = stack.length;
        if (stack.length == stackSize) {
            len = stack.length * 2; // увеличивем длину в два раза
            Object[] newStack = new Object[len];
            System.arraycopy(stack, 0, newStack, 0, stackSize);
            newStack[stackSize] = element;
            stack = newStack;
        } else {
            stack[stackSize] = element;
        }
        stackSize++;
        return element;
    }

    public Object pop() {
        Object popElement = peek();
        remove();
        return popElement;
    }

    public Object remove() {
        if (stackSize == 0) {
            System.err.println("Невозможно удалить так как стек пустой");
            throw new EmptyStackException();
        }
        Object removedElement = stack[stackSize - 1];
        stack[stackSize - 1] = null;
        stackSize --;
        return removedElement;
    }

    public Object peek() {
        if (stack.length == 0) {
            System.err.println("Стек пустой");
            throw new EmptyStackException();
        }
        return stack[stackSize - 1];
    }


    @Override
    public String toString() {
        return "ObjectStack{" +
                "stack=" + Arrays.toString(stack) +
                ", initialCapacity=" + initialCapacity +
                ", stackSize=" + stackSize +
                '}';
    }

}
