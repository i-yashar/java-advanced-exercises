package IteratorsAndComparators;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        this.title = title;
        this.year = year;
        setAuthors(authors);
    }

    private void setAuthors(String... authors){
        if(authors.length == 0){
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(List.of(authors));
        }
    }

    public List<String> getAuthors(){
        return this.authors;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public int compareTo(Book other){
        int result = this.getTitle().compareTo(other.getTitle());

        if(result == 0){
            result = Integer.compare(other.getYear(), this.getYear());
        }

        return result;
    }
}
