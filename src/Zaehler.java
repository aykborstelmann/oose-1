public class Zaehler {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public synchronized void inkrementiereCounter() {
        counter++;
        System.out.printf("%s %d\n", Thread.currentThread().getName(), counter);
    }
}
