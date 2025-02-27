package errorhandling;

public class ThresholdsNotDefinedException extends RuntimeException {
    public ThresholdsNotDefinedException(String message) {
        super(message);
    }
}
