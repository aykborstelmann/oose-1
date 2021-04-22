import java.util.HashMap;
import java.util.Map;

public class PersonMapMain {
    public static void main(String[] args) {
        // Aufgabe 2
        // a
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("Ayk Borstelmann", new Person("Ayk", "Borstelmann", 19));
        personMap.put("Justus Groß-Hardt", new Person("Justus", "Groß-Hardt", 18));
        personMap.put("Marco Adams", new Person("Marco", "Adams", 20));
        personMap.put("Julian Vogt", new Person("Julian", "Vogt", 20));

        personMap.values().forEach(Person::print);

        /*
        b)
        Das Laden eines Personen Objekts aus einer HashMap mit gegebenem vollständigem Namen geht schneller, da es in O(1) liegt.
        Denn beim Laden eines Objekts aus einer HashMap wird nur an einer Stelle nachgesehen, ob das Objekt existiert oder nicht.
        Beim Durchsuchen einer Liste liegt die Laufzeit in O(n), da alle Objekte in der Liste mit dem gesuchten verglichen werden müssen.
         */

        personMap.values().stream().forEach(Person::print);
        personMap.forEach((s, p) -> p.print());
        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            Person p = entry.getValue();
            p.print();
        }
        for (Person person : personMap.values()) {
            person.print();
        }
        for (String string : personMap.keySet()) {
            System.out.println(string);
        }
    }
}
