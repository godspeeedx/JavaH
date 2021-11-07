package ru.mephi.java.ch03.taskComporator;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public interface ComparatorNew<T> {
    int compare(T o1, T o2);

    default ComparatorNew<T> thenComparing(ComparatorNew<T> other) {
        return (T c1, T c2) -> {
            int res = compare(c1, c2);
            if (res != 0) {
                return res;
            } else {
                return other.compare(c1, c2);
            }
        };
    }

    static <T> ComparatorNew<T> comparing(Function<T, Comparable> keyExtractor) {
        return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    static <T, U> ComparatorNew<T> comparing(Function<T, U> keyExtractor,
                                             ComparatorNew<U> keyComparator) {
        return (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1),
                keyExtractor.apply(c2));
    }

    default Comparator<T> reversed() {
        return (x, y) -> {
            if (this.compare(x, y) > 0) {
                return -1;
            }
            if (this.compare(x, y) == 0) {
                return 0;
            }
            return 1;

        };
    }

}

