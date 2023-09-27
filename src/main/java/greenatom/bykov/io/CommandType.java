package greenatom.bykov.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public enum CommandType implements Operation{
    CREATE{
        public void process(String path, String args){
        new File(path);
        }
    },
    READ{
        public void process(String path, String args){
            try {
                Files.readAllLines(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    },
    WRITE{
        public void process(String path, String args){
            try {
                Files.writeString(Path.of(path), args);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    },
    DELETE{
        public void process(String path, String args){
            try {
                Files.delete(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static CommandType getType(String input) {
        switch (input) {
            case ("create"), ("c") -> {
                return CREATE;
            }
            case ("read"), ("r") -> {
                return READ;
            }
            case ("write"), ("w") -> {
                return WRITE;
            }
            case ("delete"), ("d") -> {
                return DELETE;
            }
        }
        return null;
    }
}
