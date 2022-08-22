package FunctionalProgramming;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> peopleList = new TreeMap<>();

        BiPredicate<String, String> startsWith = (word, start) -> word.contains(start) && word.indexOf(start) == 0;
        BiPredicate<String, String> endsWith = (word, end) -> word.contains(end) && (word.length() - word.lastIndexOf(end)) == end.length();
        BiPredicate<String, String> isGivenLength = (word, len) -> word.length() == Integer.parseInt(len);

        for (String person : scanner.nextLine().split(" ")) {
            peopleList.put(person, 1);
        }

        while(true){
            String[] tokens = scanner.nextLine().split(" ");

            if(tokens[0].equals("Party!")) break;

            String action = tokens[0];
            String criteria = tokens[1];
            String value = tokens[2];

            if(action.equals("Double")){
                if(criteria.equals("StartsWith")){
                    doubleByGivenCriteria(peopleList, startsWith, value);
                } else if(criteria.equals("EndsWith")){
                    doubleByGivenCriteria(peopleList, endsWith, value);
                } else{
                    doubleByGivenCriteria(peopleList, isGivenLength, value);
                }
            } else if(action.equals("Remove")){
                if(criteria.equals("StartsWith")){
                    removeByGivenCriteria(peopleList, startsWith, value);
                } else if(criteria.equals("EndsWith")){
                    removeByGivenCriteria(peopleList, endsWith, value);
                } else{
                    removeByGivenCriteria(peopleList, isGivenLength, value);
                }
            }
        }

        if(peopleList.isEmpty())
            System.out.println("Nobody is going to the party!");
        else{
            List<String> partyList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : peopleList.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    partyList.add(entry.getKey());
                }
            }

            System.out.println(String.join(", ", partyList) + " are going to the party!");
        }
//        System.out.println();
    }

    private static void removeByGivenCriteria(Map<String, Integer> list, BiPredicate<String, String> predicate, String value) {
        List<String> removeList = new ArrayList<>();
        for (String name : list.keySet()) {
            if(predicate.test(name, value))
                removeList.add(name);
        }
        for (String n : removeList) {
            list.remove(n);
        }
    }

    private static void doubleByGivenCriteria(Map<String, Integer> list, BiPredicate<String, String> predicate, String value) {
        for (String name : list.keySet()) {
            if(predicate.test(name, value))
                list.put(name, list.get(name) * 2);
        }
    }
}
