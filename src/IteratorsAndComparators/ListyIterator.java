package IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> items;
    private int index = 0;

    public ListyIterator(String... items){
        this.items = new ArrayList<>(List.of(items));
    }

    public boolean move(){
        if(index < this.items.size() - 1){
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext(){
        return this.index < this.items.size() - 1;
    }

    public void print(){
        if(!this.items.isEmpty())
            System.out.println(this.items.get(index));
        else
            System.out.println("Invalid Operation!");
    }

    public static class ListyListIterator implements Iterator<String>{
        private List<String> items;
        private int index = 0;

        public ListyListIterator(List<String> items){
            this.items = items;
        }

        @Override
        public boolean hasNext(){
            return index < items.size();
        }

        @Override
        public String next(){
            return this.items.get(index++);
        }
    }

    public Iterator<String> iterator(){
        return new ListyListIterator(this.items);
    }

    public void printAll(){
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
