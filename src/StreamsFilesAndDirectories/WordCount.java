package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader readerOne = new BufferedReader(new FileReader("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        BufferedReader readerTwo =new BufferedReader(new FileReader("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));

        PrintStream printer = new PrintStream(new FileOutputStream("output.txt"));

        List<String> words = new ArrayList<>();

        Files.readAllLines(Paths.get("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt")).stream()
                .map(l -> l.split(" ")).forEach(w -> Collections.addAll(words, w));

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.putIfAbsent(word, 0);
        }

        String line = readerTwo.readLine();

        while(line != null){
            for (String w : line.split(" ")) {
                for (String word : words) {
                    if(word.equalsIgnoreCase(w))
                        wordCount.put(word, wordCount.get(word) + 1);
                }
            }
            line = readerTwo.readLine();
        }

        wordCount.entrySet().stream().sorted((l, r) -> r.getValue().compareTo(l.getValue())).forEach(e -> printer.printf("%s - %d%n", e.getKey(), e.getValue()));
        printer.close();
    }
}
