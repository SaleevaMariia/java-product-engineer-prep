package java_core.record_examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonDtoTest {

    @Test
    void name() {
        PersonDto person = new PersonDto("Masha", 33);
        Assertions.assertEquals("Masha", person.name());
    }

    @Test
    void age() {
        PersonDto person = new PersonDto("Masha", 33);
        Assertions.assertEquals(33, person.age());
    }

    @Test
    void equalsObject() {
        PersonDto person1 = new PersonDto("Masha", 33);
        PersonDto person2 = new PersonDto("Masha", 33);
        Assertions.assertEquals(person1, person2);
    }

    @Test
    void equalsHashCode() {
        PersonDto person1 = new PersonDto("Masha", 33);
        PersonDto person2 = new PersonDto("Masha", 33);
        Assertions.assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void toStringTest() {
        PersonDto person = new PersonDto("Masha", 33);
        Assertions.assertTrue(person.toString().contains("Masha"));
        Assertions.assertTrue(person.toString().contains("33"));
    }
}