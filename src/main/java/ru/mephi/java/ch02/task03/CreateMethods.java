/*
Может ли модифицирующий метод вообще возвращать что-нибудь, кроме
типа v o id ? Можно ли создать метод доступа с возвращаемым типом v o id , т.е.
ничего фактически не возвращающий? Приведите по возможности примеры
таких методов.
 */
package ru.mephi.java.ch02.task03;

import java.util.ArrayList;

public class CreateMethods {
    private ArrayList<String> str;

    public String add(String str) {
        this.str.add(str);

        return this.str.get(0);
    }

    public CreateMethods() {
        this.str = new ArrayList<>();
    }

    public void allString() {
        for (int i = 0; i < this.str.size(); i++) {
            System.out.printf("%s ", this.str.get(i));
        }
        System.out.println();
    }


}
