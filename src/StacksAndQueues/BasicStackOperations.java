package StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] counts = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = counts[0];
        int S = counts[1];
        int X = counts[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int[] numberArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            numbers.push(numberArr[i]);
        }
        for (int i = 0; i < S; i++) {
            numbers.pop();
        }

        numbers = numbers.stream().sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toCollection(ArrayDeque::new));

        if(numbers.isEmpty())
            System.out.println(0);
        else if(numbers.contains(X))
            System.out.println("true");
        else
            System.out.println(numbers.pop());
    }
}