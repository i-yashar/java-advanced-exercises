package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        Map<Character, Integer> characters = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            characters.putIfAbsent(ch, 0);
            characters.put(ch, characters.get(ch) + 1);
        }

        for (Character ch : characters.keySet()) {
            System.out.println(ch + ": " + characters.get(ch) + " time/s");
        }
    }
}