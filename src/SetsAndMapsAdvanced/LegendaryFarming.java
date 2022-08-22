package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> items = new TreeMap<>();

        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        while(true){
            String[] input = reader.readLine().split(" ");

            boolean isReached = false;

            for (int i = 0; i < input.length / 2; i++) {
                int quantity = Integer.parseInt(input[2 * i]);
                String name = input[2 * i + 1].toLowerCase();

                items.putIfAbsent(name, 0);
                items.put(name, items.get(name) + quantity);
                if(items.containsKey("shards") && items.get("shards") >= 250){
                    System.out.println("Shadowmourne obtained!");
                    items.put("shards", items.get("shards") - 250);
                    isReached = true;
                    break;
                } else if(items.containsKey("fragments") && items.get("fragments") >= 250){
                    System.out.println("Valanyr obtained!");
                    items.put("fragments", items.get("fragments") - 250);
                    isReached = true;
                    break;
                } else if(items.containsKey("motes") && items.get("motes") >= 250){
                    System.out.println("Dragonwrath obtained!");
                    items.put("motes", items.get("motes") - 250);
                    isReached = true;
                    break;
                }
            }
            if(isReached) break;
        }
        items.entrySet().stream().filter(entry -> entry.getKey().equals("shards") || entry.getKey().equals("fragments") || entry.getKey().equals("motes"))
                .sorted((l, r) -> l.getValue().compareTo(r.getValue())).sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        items.remove("shards");
        items.remove("fragments");
        items.remove("motes");

        items.keySet().stream().sorted(String::compareTo).forEach(s -> System.out.println(s + ": " + items.get(s)));
    }
}