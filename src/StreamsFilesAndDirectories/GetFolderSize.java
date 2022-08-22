package StreamsFilesAndDirectories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Ibrahim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        writer.println("Folder size: " + file.length());
        writer.close();
    }
}
