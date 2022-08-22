package StacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci2 {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        memory = new long[n + 1];

        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if(n <= 1)
            return 1;

        if(memory[n] != 0)
            return memory[n];

        return memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
