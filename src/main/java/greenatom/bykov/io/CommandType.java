package greenatom.bykov.io;

import greenatom.bykov.io.exceptions.WrongCommandException;
import greenatom.bykov.io.exceptions.WrongPathException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public enum CommandType implements Operation{
    CREATE{
        public void process(String path, String args){
        new File(path);
        }
    },
    READ{
        public void process(String path, String args){
            try {
                List<String> lines = Files.readAllLines(Path.of(path));
                for (String line: lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new WrongPathException(path);
            }
        }
    },
    WRITE{
        public void process(String path, String args){
            try {
                Files.writeString(Path.of(path), args);
            } catch (IOException e) {
                throw new WrongPathException(path);
            }
        }
    },
    DELETE{
        public void process(String path, String args){
            try {
                Files.delete(Path.of(path));
            } catch (IOException e) {
                throw new WrongPathException(path);
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
        throw new WrongCommandException(input);
    }
}
