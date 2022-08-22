package IteratorsAndComparators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList implements Iterable<Integer>{
    private List<Integer> elements;

    public MyLinkedList(){
        this.elements = new LinkedList<>();
    }

    public int getSize(){
        return this.elements.size();
    }

    public void add(int number){
        this.elements.add(number);
    }

    public boolean remove(int number){
        if(this.elements.contains(number)){
            this.elements.remove(Integer.valueOf(number));
            return true;
        }

        return false;
    }

    @Override
    public Iterator<Integer> iterator(){
        return this.elements.iterator();
    }
}
