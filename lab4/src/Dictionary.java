import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.*;
import java.util.*;

public class Dictionary {
    private static final String INVALID_FILE_FORMAT_EXCEPTION = "Invalid structure of dictionary!";
    private static final String FILE_READ_EXCEPTION = "Can't read dictionary file!";

    public final Map<String, String > wordMap = new HashMap<>();

    public Dictionary(File file) throws InvalidFileFormatException, FileReadException
    {
        readFile(file);
    }

    private void readFile(File file) throws InvalidFileFormatException, FileReadException
    {
        try
        {
            BufferedReader reader = new BufferedReader( new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|");

                if (parts.length == 2)
                {
                    String word = parts[0].toLowerCase().trim();
                    String translation = parts[1].toLowerCase().trim();
                    wordMap.put(word, translation);
                }
                else
                {
                    throw new InvalidFileFormatException(INVALID_FILE_FORMAT_EXCEPTION);
                }
            }

            reader.close();
        }
        catch(IOException e)
        {
            throw new FileReadException(FILE_READ_EXCEPTION);
        }
    }

    public String getTranslation(String line)
    {
        for (String key : wordMap.keySet()) {
            if (line.contains(key)) {
                line = line.replace(key, wordMap.get(key));
            }
        }
        return line;

    }
}
