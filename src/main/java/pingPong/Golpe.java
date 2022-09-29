package pingPong;

public class Golpe {
    private String hit;

    public Golpe(String hit) {
        this.hit = hit;
    }

    public String getHit() {
        return hit;
    }
    public synchronized void ping(){
        hit = "PING";
    }
    public synchronized void pong(){
        hit = "PONG¡¡¡¡¡¡¡¡¡¡¡¡¡¡";

    }


}
