import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.*;
import java.util.*;

public class Dictionary
{
    private static final String INVALID_FILE_FORMAT_EXCEPTION = "Invalid structure of dictionary!";
    private static final String FILE_READ_EXCEPTION = "Can't read dictionary file!";
    private final TreeMap< String, String > wordMap = new TreeMap<>((s1, s2) -> {
        int lengthCompare = Integer.compare(s2.length(), s1.length());
        return lengthCompare != 0 ? lengthCompare : s2.compareTo(s1);
    });

    public Dictionary(File file) throws InvalidFileFormatException, FileReadException
    {
        readFile(file);
    }

    private void readFile(File file) throws InvalidFileFormatException, FileReadException
    {
        try ( BufferedReader reader = new BufferedReader( new FileReader(file)) )
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|");

                if (parts.length != 2)
                {
                    throw new InvalidFileFormatException(INVALID_FILE_FORMAT_EXCEPTION);

                }
                String word = parts[0].toLowerCase().trim();
                String translation = parts[1].toLowerCase().trim();
                wordMap.put(word, translation);
            }

        }
        catch(IOException e)
        {
            throw new FileReadException(FILE_READ_EXCEPTION);
        }
    }

    public String getTranslation(String line)
    {
        for (String key : wordMap.keySet())
        {
            if (line.contains(key))
            {
                String regex = "(?i)\\b" + key + "\\b";
                line = line.replaceAll(regex, wordMap.get(key));
            }
        }
        return line;
    }

    public void printDict()
    {
        for (Map.Entry<String, String> entry : wordMap.entrySet())
        {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}
