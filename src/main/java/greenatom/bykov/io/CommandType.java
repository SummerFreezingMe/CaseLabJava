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
            File file = new File(Path.of(path).toUri());
            if (file.exists()) {
                System.out.println("Файл уже существует.");
            } else {
                try {
                    file.createNewFile();
                    System.out.println("Файл успешно создан.");
                } catch (Exception e) {
                    System.out.println("Ошибка при создании файла.");
                    e.printStackTrace();
                }
            }
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
