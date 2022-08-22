package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', '.', ',', '?');

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        String line = reader.readLine();

        while(line != null){
            for (char c : line.toCharArray()) {
                if(vowels.contains(c))
                    vowelCount++;
                else if(punctuation.contains(c))
                    punctuationCount++;
                else if(c != ' ' && c != '\n')
                    consonantCount++;

            }

            line = reader.readLine();
        }

        writer.println("Vowels: " + vowelCount);
        writer.println("Consonants: " + consonantCount);
        writer.println("Punctuation: " + punctuationCount);

        writer.close();
    }
}
