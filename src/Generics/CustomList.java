package Generics;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<E extends Comparable<E>> implements Iterable<E>{
    private List<E> elements;

    public CustomList(){
        this.elements = new ArrayList<>();
    }

    public void add(E element){
        this.elements.add(element);
    }

    public E remove(int index){
        return this.elements.remove(index);
    }

    public boolean contains(E element){
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2){
        E el1 = elements.get(index1);
        E el2 = elements.get(index2);

        elements.set(index1, el2);
        elements.set(index2, el1);
    }

    public int countGreaterThan(E element){
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public E getMax(){
        return elements.stream().max(Comparable::compareTo).get();
    }

    public E getMin(){
        return elements.stream().min(Comparable::compareTo).get();
    }

    public int size(){
        return this.elements.size();
    }

    public E get(int index){
        return this.elements.get(index);
    }

    @Override
    public Iterator<E> iterator(){
        return new Iterator<E> (){
            private int index = 0;

            @Override
            public boolean hasNext(){
                return index < elements.size();
            }

            @Override
            public E next(){
                return elements.get(index++);
            }
        };
    }
}
