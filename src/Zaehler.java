public class Zaehler {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void inkrementiereCounter() {
        counter++;
        System.out.printf("%s %d\n", Thread.currentThread().getName(), counter);
    }
}
