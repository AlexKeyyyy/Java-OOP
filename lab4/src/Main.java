import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/alexykoba/Documents/Java-OOP/Java-OOP/lab4/src/dictionary.txt");
            //File file = new File("C:\\Users\\Алексей\\IdeaProjects\\Java-OOP\\lab4\\src\\dictionary.txt");
            Dictionary dict = new Dictionary(file);
            Translator translator = new Translator(dict);
            File file1 = new File("/Users/alexykoba/Documents/Java-OOP/Java-OOP/lab4/src/example.txt");
            //File file1 = new File("C:\\Users\\Алексей\\IdeaProjects\\Java-OOP\\lab4\\src\\example.txt");

            translator.translate(file1);
        }
        catch(InvalidFileFormatException | FileReadException e)
        {
            System.err.println(e.getMessage());
        }
    }
}