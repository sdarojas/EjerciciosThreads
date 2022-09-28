package incrementarDecrementar;

public class IncrementalTask implements Runnable {

    private final Accumulator value;

    public IncrementalTask(Accumulator value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (value.getValue() != 0){
            value.inc();
            //System.out.println(value.getValue());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
