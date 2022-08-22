package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] divisors = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = IntStream.range(1, n + 1).toArray();

        BiPredicate<Integer, Integer> isDivisible = (num, div) -> num % div == 0;

        for (int divisor : divisors) {
            numbers = Arrays.stream(numbers).boxed().filter(num -> isDivisible.test(num, divisor)).mapToInt(v -> v).toArray();
        }

        Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
    }
}
