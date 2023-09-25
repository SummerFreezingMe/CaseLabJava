package greenatom.bykov.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
    private String name;
    private int age;
    private transient String occupation;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setOccupation(){
        this.occupation = calculateOccupation();
    }

    private String calculateOccupation() {
        if (age >= 0 && age < 3) {
            return "сидит дома";
        } else if (age >= 3 && age < 7) {
            return "ходит в детский сад";
        } else if (age >= 7 && age < 18) {
            return "учится в школе";
        } else if (age >= 17 && age < 23) {
            return "учится в институте";
        } else if (age >= 24 && age < 65) {
            return "работает";
        } else {
            return "на пенсии";
        }
    }


}