package IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer> {
    private List<Integer> elements;

    public Stack(){
        this.elements = new ArrayList<>();
    }

    public void push(List<Integer> items){
        this.elements.addAll(items);
    }

    public int pop(){
        if(!this.elements.isEmpty()){
            int item = this.elements.remove(this.elements.size() - 1);
            return item;
        } else {
            System.out.println("No elements");
            return -1;
        }
    }

    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            int index = elements.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return elements.get(index--);
            }
        };
    }
}
