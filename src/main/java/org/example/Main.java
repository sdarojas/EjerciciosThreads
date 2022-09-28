package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Accumulator acumulator = new Accumulator(0);
        LinkedList<Thread> threadList = new LinkedList<>();
        for (int i = 0; i<100;i++){
            Thread incrementalThread = new Thread(new IncrementalTask(100,acumulator));
            threadList.add(incrementalThread);
            incrementalThread.start();

        }
        try {
            for (Thread hilo:threadList) {
                hilo.join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(acumulator.getValue());

    }
}