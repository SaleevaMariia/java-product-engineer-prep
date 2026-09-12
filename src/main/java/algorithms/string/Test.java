package algorithms.string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Ann", 20);
        Person p2 = new Person("Ann", 30);

        Set<Person> hashSet = new HashSet<>();
        hashSet.add(p1);
        hashSet.add(p2);

        Set<Person> treeSet = new TreeSet<>();
        treeSet.add(p1);
        treeSet.add(p2);

        System.out.println(hashSet.size());
        System.out.println(treeSet.size());
    }
}
