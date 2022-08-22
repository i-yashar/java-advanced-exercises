package IteratorsAndComparators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        MyLinkedList myList = new MyLinkedList();

        while(n-- > 0){
            String[] tokens = reader.readLine().split(" ");

            switch (tokens[0]){
                case "Add":
                    myList.add(Integer.parseInt(tokens[1]));
                    break;

                case "Remove":
                    myList.remove(Integer.parseInt(tokens[1]));
                    break;
            }
        }

        System.out.println(myList.getSize());
        for (Integer num : myList) {
            System.out.print(num + " ");
        }

//        System.out.println();
    }
}
