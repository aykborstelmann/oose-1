import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Primzahlrechner extends Thread {

    private int min;
    private final int max;

    private int[] primes;

    public Primzahlrechner(int minInclusive, int maxExclusive) {
        this.min = minInclusive;
        this.max = maxExclusive;
    }

    @Override
    public void run() {
        // Only used for debugging, since it's synchronized
        // System.out.printf("Thread %s calculating primes in interval (%d, %d]\n", Thread.currentThread().getName(), min, max);
        // long time1, time2;
        // time1 = System.nanoTime();

        if ((min % 2) == 0) {
            min++;
        }
        if (min < 2) {
            if (max <= 3) {
                primes = new int[0];
                return;
            }
            min = 3;
        }

        primes = new int[(max - min + 1) / 2];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = 2 * i + min;
        }

        int notPrime = 0;
        for (int i = 3; i <= Math.ceil(Math.sqrt(max)); i += 2) {
            if (i >= min && primes[(i - min) / 2] == 0) {
                continue;
            }
            int offset = (3 * i - (min % (2 * i))) % (2 * i);
            for (int j = offset / 2; j < primes.length; j += i) {
                if (primes[j] != 0 && primes[j] != i) {
                    notPrime++;
                    primes[j] = 0;
                }
            }
        }

        int[] temp = new int[primes.length - notPrime];
        int index = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] > 0) {
                temp[index++] = 2 * i + min;
            }
        }
        primes = temp;

        // time2 = System.nanoTime();
        // System.out.println("Thread " + Thread.currentThread().getName() + " took " + Math.round((float) ((time2 - time1) / 1000L)) / 1000.0 + " ms");
    }

    public int[] getPrimes() {
        return primes;
    }
}