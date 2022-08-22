package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = new HashMap<>();

        while(true){
            String[] input = reader.readLine().split("-");

            if(input[0].equals("search")) break;

            String name = input[0];
            String number = input[1];

            phonebook.put(name, number);
        }
        while(true){
            String name = reader.readLine();

            if(name.equals("stop")) break;

            if(phonebook.containsKey(name))
                System.out.println(name + " -> " + phonebook.get(name));
            else
                System.out.println("Contact " + name + " does not exist.");
        }
    }
}
