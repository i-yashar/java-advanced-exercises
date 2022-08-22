package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findIndexOfTheSmallest = list -> {
            int minIndex = 0;

            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) <= list.get(minIndex))
                    minIndex = i;
            }

            return minIndex;
        };

        System.out.println(findIndexOfTheSmallest.apply(numbers));
    }
}
