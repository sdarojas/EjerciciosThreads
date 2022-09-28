package org.example;

public class IncrementalTask implements Runnable{
    private int times;
    private Accumulator value;


    public IncrementalTask(int times, Accumulator value) {
        this.times = times;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i<times;i++){
            value.inc();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
