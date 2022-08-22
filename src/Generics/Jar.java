package Generics;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements;

    public Jar(){
        this.elements = new ArrayDeque<>();
    }

    public void add(T item){
        elements.push(item);
    }

    public T remove(){
        return elements.pop();
    }
}
