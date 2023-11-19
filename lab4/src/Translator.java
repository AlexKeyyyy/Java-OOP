import exceptions.FileReadException;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Translator {
    //private static final String INVALID_DATA_EXCEPTION = "Can't read data from file!";
    private static final String FILE_READ_EXCEPTION = "Can't read source file!";
    private final Dictionary dict_;

    public Translator(Dictionary dict) {
        this.dict_ = dict;
    }

    public void translate(File file) throws FileReadException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder translatedText = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String translatedLine = translateLine(line.toLowerCase());
                System.out.println(translatedLine);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(FILE_READ_EXCEPTION);
        }
    }

    /*private String findBestTranslation(String word) {
        if (dict_.wordMap.containsKey(word)) {
            return dict_.wordMap.get(word);
        } else {
            // Поиск наиболее подходящего варианта по максимальной длине левой части
            String maxMatch = "";
            for (String key : dict_.wordMap.keySet()) {
                if (word.startsWith(key) && key.length() > maxMatch.length()) {
                    maxMatch = key;
                }
            }
            return dict_.wordMap.getOrDefault(maxMatch, word);
        }
    }
     */

    private String translateLine(String line) {
        for (String key : dict_.wordMap.keySet()) {
            if (line.contains(key)) {
                line = line.replace(key, dict_.wordMap.get(key));
            }
        }
        return line;
    }
}
