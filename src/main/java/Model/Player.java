package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private final String nickName;
    private final int id;
    private static final AtomicInteger idGenerate = new AtomicInteger(0);
    private int winCounter = 0;
    private int loseCounter = 0;

    public Player(String nickName) {
        this.nickName = nickName;
        this.id = idGenerate.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickName='" + nickName + '\'' +
                ", id=" + id +
                ", idGenerate=" + idGenerate +
                ", winCounter=" + winCounter +
                ", loseCounter=" + loseCounter +
                '}';
    }

    public void winIncrement() {
        this.winCounter++;
    }

    public void loseIncrement() {
        this.loseCounter++;
    }
}
