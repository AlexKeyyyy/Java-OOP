import exceptions.FileReadException;

import java.io.*;


public class Translator
{
    private static final String FILE_READ_EXCEPTION = "Can't read source file!";
    private final Dictionary dict_;

    public Translator(Dictionary dict) {
        this.dict_ = dict;
    }

    public void translate(File srcFile) throws FileReadException {
        try ( BufferedReader reader = new BufferedReader(new FileReader(srcFile)) )
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String translatedLine = dict_.getTranslation(line.toLowerCase());
                System.out.println(translatedLine);
            }
        }
        catch (IOException e)
        {
            throw new FileReadException(FILE_READ_EXCEPTION);
        }
    }
}
