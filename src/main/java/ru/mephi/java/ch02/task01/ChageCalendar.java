/*
Измените представленную в этой главе программу вывода календаря таким об-
разом, чтобы неделя начиналась с воскресенья. Кроме того, организуйте пере-
вод на новую строку в конце предыдущей, но только один раз.
 */
package ru.mephi.java.ch02.task01;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.System.out;

public class ChageCalendar {
    public static void main(String[] args) {
        final int month = 9;
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        LocalDate date = LocalDate.of(2020, month, 1);
        if (date.getDayOfWeek().ordinal() != 7) {
            int weekOffset = Math.abs((date.getDayOfWeek().ordinal() + 7) - DayOfWeek.SUNDAY.ordinal());
            String firstLineOffset = new String(
                    new char[weekOffset]).replace("\0", "    ");
            System.out.print(firstLineOffset);
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
        System.out.println();
    }
}
