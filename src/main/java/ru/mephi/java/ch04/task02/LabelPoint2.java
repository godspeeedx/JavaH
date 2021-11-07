package ru.mephi.java.ch04.task02;
// исправить на вызов из суперкласса

import java.util.Objects;

public class LabelPoint2 extends Point2 {
    public String label;

    public LabelPoint2(double x, double y, String label) {
        super(x, y);
        this.label = label;

    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[x=" + getX() + ", y=" + getY() +
                ", label=" + getLabel() + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        //  if (this == otherObject) return true;
        // if (otherObject == null) return false;
        // if (getClass() != otherObject.getClass()) return false;
        if (!super.equals(otherObject)) return false;
        LabelPoint2 other = (LabelPoint2) otherObject;
        return this.label.equals(other.getLabel());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getLabel());
    }
}
