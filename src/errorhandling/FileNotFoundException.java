package errorhandling;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String message) {
            super(message);
        }
    }
