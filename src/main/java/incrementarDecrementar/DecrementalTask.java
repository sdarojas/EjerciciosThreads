package incrementarDecrementar;

public class DecrementalTask implements Runnable{
    private final Accumulator value;

    public DecrementalTask(Accumulator value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (value.getValue() != 0){
            value.dec();
            //System.out.println(value.getValue());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
