package model;

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

    public String getNickName() {
        return nickName;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setLoseCounter(int loseCounter) {
        this.loseCounter = loseCounter;
    }

    public int getLoseCounter() {
        return loseCounter;
    }

    public void viewStatistic() {
        System.out.println("статистика игрока " + getNickName() +
                ": побед - " + getWinCounter() +
                ", поражений - " + getLoseCounter());
    }
}