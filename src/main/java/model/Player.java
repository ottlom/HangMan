package model;

import java.util.Random;

public class Player {
    private String nickName;
    private int id;
    private int winCounter;
    private int loseCounter;

    public Player() {
    }

    public Player(String nickName) {
        this.nickName = nickName;
        this.id = new Random().nextInt();
    }

    @Override
    public String toString() {
        return "Player " +
                "nickName='" + nickName + '\'' +
                ", id=" + id +
                ", winCounter=" + winCounter +
                ", loseCounter=" + loseCounter;
    }

    public String getNickName() {
        return nickName;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public int getLoseCounter() {
        return loseCounter;
    }

    public void setLoseCounter(int loseCounter) {
        this.loseCounter = loseCounter;
    }

    public void viewStatistic() {
        System.out.println("статистика игрока " + getNickName() +
                ": побед - " + getWinCounter() +
                ", поражений - " + getLoseCounter());
    }
}