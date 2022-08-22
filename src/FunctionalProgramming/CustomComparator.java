package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (l, r) -> {
            if(Math.abs(l) % 2 == 1 && Math.abs(r) % 2 == 0)
                return 1;
            else if(Math.abs(l) % 2 == 0 && Math.abs(r) % 2 == 1)
                return -1;
            else if((Math.abs(l) % 2 == 0 && Math.abs(r) % 2 == 0) || (Math.abs(l) % 2 == 1 && Math.abs(r) % 2 == 1)){
                if(l > r)
                    return 1;
                else
                    return -1;
            }

            return 0;
        };

        numbers.sort(comparator);

        numbers.forEach(n -> System.out.print(n + " "));
    }
}
