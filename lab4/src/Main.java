import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("./src/dictionary.txt");
            Dictionary dict = new Dictionary(file);
            System.out.println("СЛОВАРЬ:");
            dict.printDict();
            Translator translator = new Translator(dict);
            File file1 = new File("./src/test.txt");
            System.out.println("\nПЕРЕВОД:");
            translator.translate(file1);
        }
        catch(InvalidFileFormatException | FileReadException e)
        {
            System.err.println(e.getMessage());
        }
    }
}