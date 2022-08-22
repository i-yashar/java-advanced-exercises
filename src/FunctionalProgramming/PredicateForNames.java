package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkNameLength = name -> name.length() <= n;

        System.out.println(Arrays.stream(scanner.nextLine().split("\\s+")).filter(checkNameLength).collect(Collectors.joining(System.lineSeparator())));
    }
}
