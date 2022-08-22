package Generics;

public class Tuple<T1, T2> {
    private T1 elementOne;
    private T2 elementTwo;

    public Tuple(T1 elementOne, T2 elementTwo){
        this.elementOne = elementOne;
        this.elementTwo = elementTwo;
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
}
