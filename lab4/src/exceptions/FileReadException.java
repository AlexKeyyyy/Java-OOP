package exceptions;

import java.io.IOException;

public class FileReadException extends IOException
{
    public FileReadException()
    {
        super();
    }
    public FileReadException(String msg)
    {
        super(msg);
    }
}
