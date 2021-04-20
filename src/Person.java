import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String vorname;
    private String nachname;
    private int alter;

    public Person(String vorname, String nachname, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getAlter() {
        return alter;
    }

    public void print() {
        System.out.printf("%s %s, %d\n", vorname, nachname, alter);
    }

    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getNachname)
                .thenComparing(Person::getVorname)
                .thenComparingInt(Person::getAlter)
                .compare(this, o);
    }
}
