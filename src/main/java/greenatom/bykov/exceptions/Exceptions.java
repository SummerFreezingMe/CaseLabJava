package greenatom.bykov.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Exceptions {
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            try {
                new MyException();//static init ar only throws once
            } catch (Throwable e) {
                System.out.println("e = " + e);
                if (e.getCause() instanceof MyException) {
                    MyException ex = (MyException) e.getCause();
                    System.out.println("e instanceof " + MyException.class.getName() + ", s = " + ex.get());
                }
            }
        }
    }

    private static void arrayExceptionExample() throws NoMoreElementsException {
        List<Integer> onlyTenElements = new ArrayList<>();
        while (true) {
            if (onlyTenElements.size() <= 10) {
                onlyTenElements.add(4);
            } else {
                throw new NoMoreElementsException();
            }
        }
    }
}

class MyException extends RuntimeException {
    private String s;

    static {
        init();
    }

    public MyException() {
        s = "Hello";
    }

    private static void init() {
        throw new MyException();
    }

    public String get() {
        return s;
    }
}


