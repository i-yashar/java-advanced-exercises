package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int divisor = Integer.parseInt(scanner.nextLine());

        BiPredicate<Integer, Integer> isDivisibleByNumber = (num, div) -> num % div == 0;

        Collections.reverse(numbers);

        numbers.removeIf(num -> isDivisibleByNumber.test(num, divisor));

        Consumer<List<Integer>> printList = list -> list.forEach(num -> System.out.print(num + " "));

        printList.accept(numbers);
    }
}
