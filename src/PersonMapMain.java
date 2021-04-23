import java.util.Arrays;
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
            personMap.get(string).print();
        }
        for (String key : personMap.keySet()) {
            personMap.get(key).print();
        }

        long t1, t2;
        t1 = System.nanoTime();

        personMap = new HashMap<>();
        personMap.put("Ayk", new Person("Ayk", "Borstelmann", 19));
        personMap.put("Tom", new Person("Tom", "Hanks", 64));
        personMap.put("Jim", new Person("Jim", "Carrey", 59));
        personMap.put("Amy", new Person("Amy", "Adams", 46));
        personMap.put("Kim", new Person("Kim", "Possible", 17));

        // Not recommended for key lengths > 3
        // Only works with full-ascii keys
        int longestKey = personMap.keySet().stream().mapToInt(String::length).max().orElse(0);
        for (int i = 1; i <= longestKey; i++) {
            char[] currentKey = new char[i];
            Arrays.fill(currentKey, (char) 0);

            boolean done = false;
            while (!done) {
                String key = new String(currentKey);
                if (personMap.containsKey(key)) {
                    personMap.get(key).print();
                }

                for (int j = i - 1; j >= 0; j--) {
                    currentKey[j] = (char) ((currentKey[j] + 1) % 256);
                    if (currentKey[j] > 0) {
                        break;
                    }
                    if (j == 0) {
                        done = true;
                    }
                }
            }
        }

        t2 = System.nanoTime();

        System.out.print(Math.round((float) ((t2 - t1) / 1000L)) / 1000.0);
        System.out.println(" ms");
    }
}
