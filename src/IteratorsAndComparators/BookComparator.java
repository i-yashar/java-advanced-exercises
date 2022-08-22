package IteratorsAndComparators;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book firstBook, Book secondBook){
        return firstBook.compareTo(secondBook);
    }
}
