package org.example;

public class Accumulator {
    private int value;

    public Accumulator(int value) {
        this.value = value;
    }

    public synchronized void  inc(){
        value = value + 1;
    }

    public int getValue(){
        return value;
    }
}
