import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ayk", "Borstelmann", 19));
        personList.add(new Person("Justus", "Groß-Hardt", 18));
        personList.add(new Person("Marco", "Adams", 20));
        personList.add(new Person("Julian", "Vogt", 20));
        personList.add(new Person("Julian", "Vogt", 18));

        personList.forEach(Person::print);

        System.out.println("--------");
        Collections.sort(personList);
        personList.forEach(Person::print);

        System.out.println("--------");
        Collections.sort(personList, new PersonSortierer());
        personList.forEach(Person::print);

        System.out.println("--------");
        final Person minComparable = Collections.min(personList);
        final Person maxComparable = Collections.max(personList);
        minComparable.print();
        maxComparable.print();

        System.out.println("--------");
        final Person minComparator = Collections.min(personList, new PersonSortierer());
        final Person maxComparator = Collections.max(personList, new PersonSortierer());
        minComparator.print();
        maxComparator.print();
    }
}
