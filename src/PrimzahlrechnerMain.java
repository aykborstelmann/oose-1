import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimzahlrechnerMain {
    public static void main(String[] args) {
        // Aufgabe 3 a)

        final int maxExclusive = 4001;
        final int threads = 4;
        final int range = maxExclusive / threads;

        final List<Primzahlrechner> primzahlrechner = IntStream.range(0, threads)
                .mapToObj(i -> new Primzahlrechner(i * range, (i + 1) * range))
                .collect(Collectors.toList());

        primzahlrechner.forEach(Primzahlrechner::start);
        for (Primzahlrechner p : primzahlrechner) {
            try {
                p.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        final List<Integer> primes = Stream.concat(Stream.of(2), primzahlrechner.stream().map(Primzahlrechner::getPrimes).flatMap(Collection::stream)).collect(Collectors.toList());
        System.out.println(primes);

        /*
        Aufgabe 3b)
        Ein Objekt der Klasse Thread erstellen und ein Runnable übergeben, bspw. so:
         */

        Thread t = new Thread(() -> {
            /*
            Hier kann was passieren
             */
        });
    }
}
