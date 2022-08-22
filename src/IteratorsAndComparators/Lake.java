package IteratorsAndComparators;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{
    private int[] numbers;

    public Lake(int... numbers){
        this.numbers = numbers;
    }

    private static class Frog implements Iterator<Integer>{
        private int[] numbers;
        private int counter;
        private int i;
        private int num;

        public Frog(int[] numbers){
            this.numbers = numbers;
            this.counter = 0;
            this.i = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < this.numbers.length;
        }

        @Override
        public Integer next() {
            if (i >= this.numbers.length) {
                i = 1;
            }
            num = this.numbers[i];

            i += 2;
            counter++;
            return num;
        }
    }

    @Override
    public Iterator<Integer> iterator(){
        return new Frog(this.numbers);
    }
}
