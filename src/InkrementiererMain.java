import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InkrementiererMain {
    public static void main(String[] args) throws InterruptedException {
        Zaehler zaehler = new Zaehler();
        List<Thread> inkrementierers = IntStream.range(0, 4).mapToObj(i -> new Inkrementierer(zaehler)).map(Thread::new).collect(Collectors.toList());
        inkrementierers.forEach(Thread::start);

        for (Thread t : inkrementierers) {
            t.join();
        }
    }
}
