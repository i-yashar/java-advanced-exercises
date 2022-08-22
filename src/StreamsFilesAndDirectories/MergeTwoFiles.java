package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        List<String> firstFileLines = Files.readAllLines(Paths.get("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        List<String> secondFileLines = Files.readAllLines(Paths.get("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));

        Path path = Path.of("output.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (String line : firstFileLines) {
            writer.write(line);
            writer.write(System.lineSeparator());
        }
        for (String line : secondFileLines) {
            writer.write(line);
            writer.write(System.lineSeparator());
        }

        writer.close();
    }
}
