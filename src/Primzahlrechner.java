import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Primzahlrechner extends Thread {

    private final int min;
    private final int max;

    private List<Integer> primes = new ArrayList<>();

    public Primzahlrechner(int minInclusive, int maxExclusive) {
        this.min = minInclusive;
        this.max = maxExclusive;
    }

    @Override
    public void run() {
        primes = IntStream.range(min, max)
                .filter(n -> n % 2 != 0)
                .filter(this::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isPrime(int currentPossiblePrime) {
        if (currentPossiblePrime <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(currentPossiblePrime))
                .noneMatch(n -> (currentPossiblePrime % n == 0));
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
