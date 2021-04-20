import java.util.Comparator;

public class PersonSortierer implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Comparator.comparing(Person::getVorname)
                .thenComparing(Person::getNachname)
                .thenComparingInt(Person::getAlter)
                .compare(o1, o2);
    }
}
