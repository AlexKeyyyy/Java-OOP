import exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Translator
{
    private static final String INVALID_DATA_EXCEPTION = "Can't read data from file!";
    private static final String FILE_READ_EXCEPTION = "Can't read source file!";
    private final Dictionary dict_;

    public Translator(Dictionary dict)
    {
        this.dict_ = dict;
    }

    public String translate(File file) throws FileReadException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder translatedText = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");
                    String translation = dict_.getTranslation(cleanedWord.toLowerCase());

                    StringBuilder translatedWord = new StringBuilder();
                    translatedWord.append(translation);
                    int i = 0;
                    while (i < word.length()) {
                        if (!Character.isLetterOrDigit(word.charAt(i))) {
                            translatedWord.append(word.charAt(i));
                        }
                        i++;
                    }

                    translatedText.append(translatedWord.toString()).append(" ");
                }
            }
            reader.close();
            return translatedText.toString();
        } catch (IOException e) {
            throw new FileReadException(FILE_READ_EXCEPTION);
        }
    }
}
