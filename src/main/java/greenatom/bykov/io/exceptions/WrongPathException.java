package greenatom.bykov.io.exceptions;

public class WrongPathException extends RuntimeException {

    @Override
    public String getMessage() {
        return "";
    }

    public WrongPathException(String command) {
        super("Incorrect file path: " + command);
    }
}