package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int leftBoundary = Integer.parseInt(tokens[0]);
        int rightBoundary = Integer.parseInt(tokens[1]);
        String type = scanner.nextLine();

        IntPredicate predicate = type.equals("even") ? n -> n % 2 == 0 : n -> n % 2 == 1;

        System.out.println(getSpecifiedNumbers(leftBoundary, rightBoundary, predicate));
    }

    public static String getSpecifiedNumbers(int l, int r, IntPredicate predicate){
        return IntStream.range(l, r + 1).filter(predicate).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
