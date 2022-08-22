package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, int[]>> types = new LinkedHashMap<>();
        Map<String, double[]> typeAverages = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while(n-- > 0){
            String[] tokens = reader.readLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if(!tokens[2].equals("null")){
                damage = Integer.parseInt(tokens[2]);
            }
            if(!tokens[3].equals("null")){
                health = Integer.parseInt(tokens[3]);
            }
            if(!tokens[4].equals("null")){
                armor = Integer.parseInt(tokens[4]);
            }
            types.putIfAbsent(type, new TreeMap<>());
            types.get(type).put(name, new int[]{damage, health, armor});
        }

        for (Map.Entry<String, Map<String, int[]>> entry : types.entrySet()) {
            String type = entry.getKey();
            int damage = 0;
            int health = 0;
            int armor = 0;

            for (Map.Entry<String, int[]> dragonEntry : types.get(type).entrySet()) {
                damage += dragonEntry.getValue()[0];
                health += dragonEntry.getValue()[1];
                armor += dragonEntry.getValue()[2];
            }


            typeAverages.put(type, new double[]{damage, health, armor});

        }

        types.entrySet().stream().forEach(e -> {
            int size = e.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(), typeAverages.get(e.getKey())[0] / size, typeAverages.get(e.getKey())[1] / size, typeAverages.get(e.getKey())[2] / size);
            e.getValue().entrySet().stream().forEach(f -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", f.getKey(), f.getValue()[0], f.getValue()[1], f.getValue()[2]));
        });

        System.out.println();
    }
}
