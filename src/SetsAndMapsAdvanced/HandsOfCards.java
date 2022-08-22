package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> playerHand = new LinkedHashMap<>();
        Map<String, Integer> playerValue = new LinkedHashMap<>();

        while(true){
            String[] tokens = reader.readLine().split(":\\s+");

            if(tokens[0].equals("JOKER")) break;

            String name = tokens[0];

            playerHand.putIfAbsent(name, new HashSet<>());
            playerValue.putIfAbsent(name, 0);

            Arrays.stream(tokens[1].split(",\\s+")).forEach(c -> playerHand.get(name).add(c));
        }

        for (String name : playerValue.keySet()) {
            int value = calculateValue(playerHand.get(name).toArray(String[]::new));

            playerValue.put(name, playerValue.get(name) + value);
            System.out.println(name + ": " + playerValue.get(name));
        }

//        System.out.println();
    }

    private static int calculateValue(String[] cards) {
        int value = 0;

        for (int i = 0; i < cards.length; i++) {
            String card = cards[i];

            String power = card.substring(0, card.length() - 1);
            String type = card.substring(card.length() - 1);
            int powerValue = 0;
            int typeValue = 0;

            if(Character.isDigit(power.charAt(0)))
                powerValue = Integer.parseInt(power);
            else if(power.equals("J"))
                powerValue = 11;
            else if(power.equals("Q"))
                powerValue = 12;
            else if(power.equals("K"))
                powerValue = 13;
            else if(power.equals("A"))
                powerValue = 14;

            if(type.equals("S"))
                typeValue = 4;
            else if(type.equals("H"))
                typeValue = 3;
            else if(type.equals("D"))
                typeValue = 2;
            else if(type.equals("C"))
                typeValue = 1;

            value += (powerValue * typeValue);
        }

        return value;
    }
}
