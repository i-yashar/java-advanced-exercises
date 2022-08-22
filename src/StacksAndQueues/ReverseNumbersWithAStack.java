package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(e -> numbers.push(e));

        while(!numbers.isEmpty())
            System.out.print(numbers.pop() + " ");
    }
}
