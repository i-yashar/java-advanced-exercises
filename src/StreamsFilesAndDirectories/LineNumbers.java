package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));

        int counter = 0;

        for (String line : lines) {
            writer.println(++counter + ". " + line);
        }

        writer.close();
    }
}
