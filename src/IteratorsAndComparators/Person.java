package IteratorsAndComparators;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInfo(){
        return this.name + " " + this.age;
    }

    @Override
    public boolean equals(Object other){
        if(this == other)
            return true;
        else if(other.getClass().getSimpleName().equals(getClass().getSimpleName())){
            Person otherPerson = (Person) other;
            return this.name.equals(otherPerson.name) && this.age == otherPerson.age;
        }

        return false;
    }

    @Override
    public int hashCode(){
        return 73 * (Integer.hashCode(age) + this.name.hashCode());
    }


    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);

        if(result == 0){
            result = Integer.compare(age, o.age);
        }

        return result;
    }
}
