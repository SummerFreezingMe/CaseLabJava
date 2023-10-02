package greenatom.bykov.io.exceptions;

public class WrongCommandException extends RuntimeException {

    @Override
    public String getMessage() {
        return "";
    }

    public WrongCommandException(String command) {
        super("Incorrect input command: " + command);
    }
}
