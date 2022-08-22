package Generics;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        for (int i = 1; i < list.size(); i++) {
           T key = list.get(i);
           int j = i - 1;

           while(j >= 0 && list.get(j).compareTo(key) > 0){
               list.swap(j, j + 1);
               j--;
           }
        }
    }
}
