package pingPong;

import java.util.concurrent.Semaphore;

public class PongTask implements Runnable{
    private Golpe hit;
    private Semaphore pingSemaphore;
    private Semaphore pongSemaPhore;

    public PongTask(Golpe hit, Semaphore pingSemaphore, Semaphore pongSemaPhore) {
        this.hit = hit;
        this.pingSemaphore = pingSemaphore;
        this.pongSemaPhore = pongSemaPhore;
    }

    @Override
    public void run() {
        for (int i = 0; i<10;i++) {
            try {
                pongSemaPhore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hit.pong();
            System.out.println(hit.getHit());
            pingSemaphore.release();
        }

    }
}
