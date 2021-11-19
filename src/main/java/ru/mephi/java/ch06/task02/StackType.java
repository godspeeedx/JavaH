package ru.mephi.java.ch06.task02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class StackType<E> {
    private E[] stack;
    private int initialCapacity = 10;
    private int stackSize;

    @SuppressWarnings("unchecked")
    public StackType() {
        stack = (E[]) new Object[initialCapacity];
        stackSize = 0;
    }

    @SuppressWarnings("unchecked")
    public StackType(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Аргумент должен быть положительным");
        }
        this.initialCapacity = initialCapacity;
        stack = (E[]) new Object[initialCapacity];
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

    @SuppressWarnings("unchecked")
    public E push(E element) {
        int len = stack.length;
        if (stack.length == stackSize) {
            len = stack.length * 3 / 2;
            E[] newStack = (E[]) StackType.newArray(element.getClass(), len);
            System.arraycopy(stack, 0, newStack, 0, stackSize);
            newStack[stackSize] = element;
            stack = newStack;
        } else {
            stack[stackSize] = element;
        }
        stackSize++;
        return element;
    }

    public E pop() {
        E popElement = peek();
        remove();
        return popElement;
    }

    public E remove() {
        if (stackSize == 0) {
            System.err.println("Нельзя удалить элемент из пустого стека");
            throw new EmptyStackException();
        }
        E removedElement = stack[stackSize - 1];
        stack[stackSize - 1] = null;
        stackSize --;
        return removedElement;
    }

    public E peek() {
        if (stack.length == 0) {
            System.err.println("Нельзя удалить элемент из пустого стека");
            throw new EmptyStackException();
        }
        return stack[stackSize - 1];
    }


    @SuppressWarnings("unchecked")
    private static <T> T[] newArray(Class<T> type, int len) {
        return (T[]) Array.newInstance(type, len);
    }

    @Override
    public String toString() {
        return "TypedStack{" +
                "stack=" + Arrays.toString(stack) +
                ", initialCapacity=" + initialCapacity +
                ", stackSize=" + stackSize +
                '}';
    }
}
