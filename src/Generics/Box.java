package Generics;

import java.util.List;

public class Box<T> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        StringBuilder outputText = new StringBuilder();
        outputText.append(value.getClass().getName()).append(": ").append(this.value);

        return outputText.toString();
    }

    public static <T> void swapElements(List<Box<T>> elements, int index1, int index2){
        Box<T> temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    public T getValue(){
        return this.value;
    }

    public static <T extends Comparable<T>> int getCount(List<Box<T>> elements, Box<T> element){
        return (int) elements.stream().filter(b -> b.getValue().compareTo(element.getValue()) > 0).count();
    }
}
