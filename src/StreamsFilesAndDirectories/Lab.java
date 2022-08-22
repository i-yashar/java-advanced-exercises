package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lab {

    static class Cube implements Serializable{
        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Cube{" +
                    "color='" + color + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", depth=" + depth +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String path = "";

        Cube cube = new Cube("green", 13, 42, 63);

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
        os.writeObject(cube);
        os.flush();
        os.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
        Cube myCube = (Cube)is.readObject();

        System.out.println(myCube);
    }
}
