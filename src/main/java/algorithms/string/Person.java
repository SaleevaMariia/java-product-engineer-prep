package algorithms.string;

import java.util.Objects;

public final class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        if ( (Integer.compare(this.age, other.age) < 0) || (this.name.compareTo(other.name) < 0)){
            return -1;
        }
        if((Integer.compare(this.age, other.age) == 0) && (this.name.compareTo(other.name) == 0)){
            return 0;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return this.age == person.age
                && this.name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
