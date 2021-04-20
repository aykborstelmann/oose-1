public class Inkrementierer implements Runnable {

    private final Zaehler zaehler;

    public Inkrementierer(Zaehler zaehler) {
        this.zaehler = zaehler;
    }

    @Override
    public void run() {
        while (true)
            synchronized (zaehler) {
                if (zaehler.getCounter() >= 1000) break;
                zaehler.inkrementiereCounter();
            }
    }
}
