package pingPong;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Golpe golpe = new Golpe("");
        Semaphore pingSemaphore = new Semaphore(1);
        Semaphore pongSemaphore = new Semaphore(1);
        Thread ping = new Thread(new PingTask(golpe,pingSemaphore,pongSemaphore));
        Thread pong = new Thread(new PongTask(golpe,pingSemaphore,pongSemaphore));

        try {
            pongSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ping.start();
        pong.start();




    }
}
