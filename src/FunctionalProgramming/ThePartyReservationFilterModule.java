package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> exclusionList = new ArrayList<>();

        BiPredicate<String, String> startsWith = (word, start) -> word.contains(start) && word.indexOf(start) == 0;
        BiPredicate<String, String> endsWith = (word, end) -> word.contains(end) && (word.length() - word.lastIndexOf(end)) == end.length();
        BiPredicate<String, String> isGivenLength = (word, len) -> word.length() == Integer.parseInt(len);
        BiPredicate<String, String> contains = String::contains;

        while(true){
            String[] tokens = scanner.nextLine().split(";");

            if(tokens[0].equals("Print")) break;

            String action = tokens[0];
            String criteria = tokens[1];
            String value = tokens[2];

            if(action.equals("Add filter")){
                if(criteria.equals("Starts with")){
                    removeByGivenCriteria(people, startsWith, value, exclusionList);
                } else if(criteria.equals("Ends with")){
                    removeByGivenCriteria(people, endsWith, value, exclusionList);
                } else if(criteria.equals("Length")){
                    removeByGivenCriteria(people, isGivenLength, value, exclusionList);
                } else if(criteria.equals("Contains")){
                    removeByGivenCriteria(people, contains, value, exclusionList);
                }
            } else if(action.equals("Remove filter")){
                if(criteria.equals("Starts with")){
                    restoreByGivenCriteria(people, startsWith, value, exclusionList);
                } else if(criteria.equals("Ends with")){
                    restoreByGivenCriteria(people, endsWith, value, exclusionList);
                } else if(criteria.equals("Length")){
                    restoreByGivenCriteria(people, isGivenLength, value, exclusionList);
                } else if(criteria.equals("Contains")){
                    restoreByGivenCriteria(people, contains, value, exclusionList);
                }
            }
        }

        for (String person : people) {
            if(!exclusionList.contains(person))
                System.out.print(person + " ");
        }
//        System.out.println();
    }

    private static void restoreByGivenCriteria(List<String> people, BiPredicate<String, String> criteria, String value, List<String> list) {
        for (String person : people) {
            if(criteria.test(person, value))
                list.remove(person);
        }
    }

    private static void removeByGivenCriteria(List<String> people, BiPredicate<String, String> criteria, String value, List<String> list) {
        for (String person : people) {
            if(criteria.test(person, value)){
                list.add(person);
            }
        }
    }
}
