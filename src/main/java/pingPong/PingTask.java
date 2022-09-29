package pingPong;

import java.util.concurrent.Semaphore;

public class PingTask implements Runnable{
    private Golpe hit;
    private Semaphore pingSemaphore;
    private Semaphore pongSemaPhore;

    public PingTask(Golpe hit, Semaphore pingSemaphore, Semaphore pongSemaPhore) {
        this.hit = hit;
        this.pingSemaphore = pingSemaphore;
        this.pongSemaPhore = pongSemaPhore;
    }

    @Override
    public void run() {
        for (int i = 0; i<10;i++) {
            try {
                pingSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hit.ping();
            System.out.println(hit.getHit());
            pongSemaPhore.release();
        }

    }
}
