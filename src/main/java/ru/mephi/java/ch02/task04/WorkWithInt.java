/*
 Почему в Java нельзя реализовать метод, меняющий местами содержимое двух
переменных типа i n t ? Вместо этого напишите метод, меняющий местами
содержимое двух объектов типа In t H o ld e r . (Описание этого малоизвестного

класса можно найти в документации на прикладной программный интер-
фейс Java API.) Можно ли поменять местами содержимое двух объектов типа

In t e g e r ?
 */
package ru.mephi.java.ch02.task04;

public class WorkWithInt {
    public static void main(String[] args) {
        int first = 1;
        int second = 10;
        Integer first1 = 1;
        Integer second1 = 10;
        changeInt(first, second);
        System.out.println("After change: int first equals =" + first);
        System.out.println("After change: int second equals =" + second);
        changeInt(first1, second1);
        System.out.println("After change: int first equals =" + first1);
        System.out.println("After change: int second equals =" + second1);
        IntHolder x = new IntHolder(5);
        IntHolder y = new IntHolder(10);
        changeInt(x,y);
        System.out.println("Intholder x = " + x.getInteger());
        System.out.println("Intholder y = " + y.getInteger());
    }

    public static class IntHolder {
        private int integer;

        public IntHolder() {
            integer = 0;
        }

        public IntHolder(int x) {
            integer = x;
        }
        public IntHolder(Integer x){
            integer = x;
        }

        public void setInteger(int integer) {
            this.integer = integer;
        }

        public int getInteger() {
            return integer;
        }
    }

    public static void changeInt(int first, int second) {
        int buf = first;
        first = second;// данные
        second = buf;
    }

    public static void changeInt(Integer first, Integer second) {
        int buf1 = first;
        int buf2 = second;
        first = buf2;
        second = buf1;
    }
    public static void changeInt(IntHolder first, IntHolder second) {
        int frst = first.getInteger();
        first.setInteger(second.getInteger());
        second.setInteger(frst);
    }

}
