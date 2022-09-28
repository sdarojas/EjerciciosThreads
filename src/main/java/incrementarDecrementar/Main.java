package incrementarDecrementar;

public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(100);

        Thread incremental = new Thread(new IncrementalTask(accumulator));
        Thread decremental = new Thread(new DecrementalTask(accumulator));

        incremental.start();
        decremental.start();

        try {
            incremental.join();
            decremental.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(accumulator.getValue());


    }
}
