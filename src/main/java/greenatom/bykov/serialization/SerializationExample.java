package greenatom.bykov.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {
    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    private static void serialize() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Иван", 25));
        people.add(new Person("Мария", 10));
        people.add(new Person("Петр", 70));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "persons.txt"))) {
            oos.writeObject(people);
            System.out.println("Список людей успешно сериализован в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons" +
                ".txt"))) {
            List<Person> deserializedPeople = (List<Person>) ois.readObject();
            for (Person person : deserializedPeople) {
                person.setOccupation();
                System.out.println(person.getName() + " - " + person.getAge() + " лет, " +
                        person.getOccupation());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
