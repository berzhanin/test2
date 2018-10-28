package tests.task13;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class LengthComparator implements Comparator<String> {

    public int compare(Person obj1, Person obj2) {
        if (obj1.compareTo(obj1) < obj2.compareTo(obj2)) {
            return -1;
        }
        if (obj1.compareTo(obj1) > obj2.compareTo(obj2)) {
            return 1;
        }
        return 0;
    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Override
    public Comparator<String> reversed() {
        return null;
    }

    @Override
    public Comparator<String> thenComparing(Comparator<? super String> other) {
        return null;
    }

    @Override
    public <U> Comparator<String> thenComparing(Function<? super String, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<String> thenComparing(Function<? super String, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<String> thenComparingInt(ToIntFunction<? super String> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<String> thenComparingLong(ToLongFunction<? super String> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<String> thenComparingDouble(ToDoubleFunction<? super String> keyExtractor) {
        return null;
    }
}
