package Generics;

public class Threeuple<T1, T2, T3> {
    private T1 elementOne;
    private T2 elementTwo;
    private T3 elementThree;

    public Threeuple(T1 elementOne, T2 elementTwo, T3 elementThree){
        this.elementOne = elementOne;
        this.elementTwo = elementTwo;
        this.elementThree = elementThree;
    }

    public T1 getElementOne() {
        return elementOne;
    }

    public void setElementOne(T1 elementOne) {
        this.elementOne = elementOne;
    }

    public T2 getElementTwo() {
        return elementTwo;
    }

    public void setElementTwo(T2 elementTwo) {
        this.elementTwo = elementTwo;
    }

    public T3 getElementThree() {
        return elementThree;
    }

    public void setElementThree(T3 elementThree) {
        this.elementThree = elementThree;
    }
}
