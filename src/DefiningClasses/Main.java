package DefiningClasses;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while(true){
            String[] tokens = scanner.nextLine().split(" ");

            if(tokens[0].equals("Tournament")) break;

            String trainer = tokens[0];
            String pokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon newPokemon = new Pokemon(pokemon, element, health);
            if(trainers.containsKey(trainer)){
                trainers.get(trainer).addPokemon(newPokemon);
            } else {
                trainers.put(trainer, new Trainer(trainer, newPokemon));
            }
        }

        while(true){
            String element = scanner.nextLine();

            if(element.equals("End")) break;

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                entry.getValue().checkForElement(element);
            }
        }

        trainers.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(System.out::println);

        System.out.println();
    }
}
