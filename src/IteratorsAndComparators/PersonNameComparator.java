package IteratorsAndComparators;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = o1.getName().length() - o2.getName().length();

        if(result == 0){
            result = Character.toUpperCase(o1.getName().charAt(0)) - Character.toUpperCase(o2.getName().charAt(0));
        }

        return result;
    }
}
