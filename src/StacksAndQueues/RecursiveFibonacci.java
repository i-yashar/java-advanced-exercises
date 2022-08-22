package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacciNumbers = new ArrayDeque<>();

        fibonacciNumbers.push(1L);
        fibonacciNumbers.push(1L);

        while(n-- > 1){
            long topNum = fibonacciNumbers.pop();
            long bottomNum = fibonacciNumbers.pop();

            fibonacciNumbers.push(topNum);
            fibonacciNumbers.push(bottomNum + topNum);
        }

        System.out.println(fibonacciNumbers.pop());
    }
}
