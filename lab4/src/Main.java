import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File dictFile = new File("./src/dictionary.txt");
            Dictionary dict = new Dictionary(dictFile);
            System.out.println("СЛОВАРЬ:");
            dict.printDict();
            Translator translator = new Translator(dict);
            File srcFile = new File("./src/example.txt");
            System.out.println("\nПЕРЕВОД:");
            translator.translate(srcFile);
        }
        catch(FileReadException | InvalidFileFormatException e)
        {
            System.err.println(e.getMessage());
        }
    }
}