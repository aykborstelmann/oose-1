import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class PrimzahlrechnerMain {
    public static void main(String[] args) throws InterruptedException {
        // Aufgabe 3 a)

        long time1, time2;
        // Start time measurement
        time1 = System.nanoTime();

        final long max = 100000000L;
        final long threadCount = 16L;

        Primzahlrechner[] primzahlrechners = new Primzahlrechner[(int) threadCount];
        primzahlrechners[0] = new Primzahlrechner(0, (int) ((max * 2) / (threadCount + 1)));
        primzahlrechners[0].start();
        for (long i = 1; i < threadCount; i++) {
            primzahlrechners[(int) i] = new Primzahlrechner((int) ((max * (i + 1)) / (threadCount + 1)),
                                                            (int) ((max * (i + 2)) / (threadCount + 1)));
            primzahlrechners[(int) i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            primzahlrechners[i].join();
        }

        // Stop time measurement
        time2 = System.nanoTime();
        double dt = Math.round((double) ((time2 - time1) / 1000L)) / 1000.0;

        int primeCount = 1; // 2 isn't counted otherwise
        int[][] primes2D = new int[(int) threadCount][];
        for (int i = 0; i < threadCount; i++) {
            primes2D[i] = primzahlrechners[i].getPrimes();
            primeCount += primes2D[i].length;
        }

        int[] primes = new int[primeCount];
        primes[0] = 2; // 2 is skipped otherwise, as it's even

        int startIndex = 1;
        for (int i = 0; i < threadCount; i++) {
            System.arraycopy(primes2D[i], 0, primes, startIndex, primes2D[i].length);
            startIndex += primes2D[i].length;
        }

        int[] firstThousand = new int[Math.min(1000, primes.length)];
        System.arraycopy(primes, 0, firstThousand, 0, firstThousand.length);

        Locale.setDefault(new Locale("en_US"));
        System.out.printf("Calculated %d primes in %.3f ms!\n", primes.length, dt);
        System.out.println(Arrays.toString(firstThousand));

        /*
        Aufgabe 3b)
        Ein Objekt der Klasse Thread erstellen und ein Runnable als lambda übergeben, bspw. so:
         */

        Thread t = new Thread(() -> {
            /*
            Hier kann was passieren
             */
        });

        class Beispiel implements Runnable {
            Beispiel() {}

            @Override
            public void run() {
                /*
                Code goes here
                 */
            }
        }

        Thread t2 = new Thread(new Beispiel());

        IntStream.range(0, 16).parallel().forEach(i -> System.out.println(Thread.currentThread().getName()));
    }
}
