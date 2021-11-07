package ru.mephi.java.ch03.task11;

public class Test11 {
    public static void main(String[] args) {
        String[] str = MyList.getFilesWithName("/Users/sasha/Desktop/6 сем/Защита информации", ".docx");
        if (str != null) {
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
        }
    }
}
