package ru.mephi.java.ch04.ClassesForTest;

import java.util.Objects;

public class ClassCharacter {
    private char charecters;
    private Character character;


    public void setCharecters(char charecters) {
        this.charecters = charecters;
    }

    public void setCharacter(Character aChar) {
        this.character = aChar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassCharacter)) return false;
        ClassCharacter character1 = (ClassCharacter) o;
        return charecters == character1.charecters && Objects.equals(character, character1.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charecters, character);
    }

    public ClassCharacter(){
        this.charecters = ' ';
        this.character = ' ';

    }
    public ClassCharacter(char charecters, Character character) {
        this.charecters = charecters;
        this.character = character;
    }
}
