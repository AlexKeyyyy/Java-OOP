import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/alexykoba/IdeaProjects/lab4/src/dictionary.txt");
            Dictionary dict = new Dictionary(file);
            Translator translator = new Translator(dict);
            File file1 = new File("/Users/alexykoba/IdeaProjects/lab4/src/example.txt");

            System.out.println(translator.translate(file1));
        }
        catch(InvalidFileFormatException | FileReadException e)
        {
            System.err.println(e.getMessage());
        }
    }
}