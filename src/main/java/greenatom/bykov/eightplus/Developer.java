package greenatom.bykov.eightplus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Developer {
    private String name;
    private List<String> languages;


    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
        Stream<Developer> developerStreamFirst = Stream.of(dev1, dev2, dev3);
        Stream<Developer> developerStreamSecond = Stream.of(dev1, dev2, dev3);

    //todo: 1-stream attempt
        List<String> uniqueLanguages = developerStreamFirst
                .map(Developer::getLanguages)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

        developerStreamSecond
                .filter(dev -> dev.getLanguages().stream().anyMatch(uniqueLanguages::contains))
                .forEach(System.out::println);

    }

}