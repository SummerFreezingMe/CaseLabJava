package greenatom.bykov.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class NoMoreElementsException extends Throwable {
    public NoMoreElementsException() {
        super();
    }

    private StackTraceElement[] stackTrace = new StackTraceElement[0];

    public NoMoreElementsException(String message) {
        super(message);
    }

    public NoMoreElementsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreElementsException(Throwable cause) {
        super(cause);
    }

    protected NoMoreElementsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return "This exception occurs whenever there's attempt to add 11th " +
                "element of the array";
    }

    @Override
    public String getLocalizedMessage() {
        return "This exception occurs whenever there's attempt to add 11th " +
                "element of the array";
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return "NoMoreElementsException - Custom";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }
}
