package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, double[]> studentsAndNames = new TreeMap<>();

        while(n-- > 0){
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            studentsAndNames.put(name, grades);
        }

        studentsAndNames.forEach((k, v) -> {
            BigDecimal bd = BigDecimal.valueOf(Arrays.stream(v).average().orElse(0.0));
            System.out.printf("%s is graduated with %s%n", k, bd.stripTrailingZeros());
        });
    }
}
