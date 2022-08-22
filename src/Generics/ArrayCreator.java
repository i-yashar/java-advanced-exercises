package Generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayCreator {

    public static<T> T[] create(Class<?> clazz, int length, T item){
        T[] elements = (T[]) Array.newInstance(clazz, length);

        IntStream.range(0, length).forEach(i -> elements[i] = item);

        return elements;
    }

    public static <T> T[] create(int length, T item){
        return create(item.getClass(), length, item);
    }
}
