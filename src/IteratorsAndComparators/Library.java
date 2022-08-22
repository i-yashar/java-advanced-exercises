package IteratorsAndComparators;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;


    @Override
    public Iterator<Book> iterator(){
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book>{
        int counter = 0;

        @Override
        public boolean hasNext(){
            return counter < books.length;
        }

        @Override
        public Book next(){
            return books[counter++];
        }
    }
}
