package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while(true){
            String command = scanner.nextLine();

            if(command.equals("end")) break;

            switch(command){
                case "add":
                    numbers = transformList(numbers, n -> n + 1);
                    break;
                case "multiply":
                    numbers = transformList(numbers, n -> n * 2);
                    break;
                case "subtract":
                    numbers = transformList(numbers, n -> n - 1);
                    break;
                case "print":
                    System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }

        }
    }

    public static List<Integer> transformList(List<Integer> numbers, Function<Integer, Integer> function){
        return numbers.stream().map(function).collect(Collectors.toList());
    }
}
