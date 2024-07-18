package util;

import model.Player;
import storage.InMemoryPlayerStorage;

import java.io.BufferedReader;
import java.io.IOException;

public class PlayerUtil {
    static InMemoryPlayerStorage storage;

    public void statisticSum(Player player, boolean gameResult) {
        if (gameResult) {
            System.out.println(player.getWinCounter() + " win before");
            player.setWinCounter(player.getWinCounter() + 1);
            System.out.println(player.getWinCounter() + " win after");
        } else {
            System.out.println(player.getLoseCounter() + " lose before");
            player.setLoseCounter(player.getLoseCounter() + 1);
            System.out.println(player.getLoseCounter() + " lose after");
        }
    }

    public static Player getPlayer(BufferedReader reader) {
        Player player;
        String nickName = null;

        try {
            nickName = reader.readLine();
        } catch (IOException e) {
            System.out.println("ошибка ввода имени");
        }

        if (storage.get(nickName) == null) {
            System.out.println("гляжу ты тут новенький. Так какое бы слово загадать дай-ка подумать");
            player = new Player(nickName);
            storage.save(player);
        } else {
            System.out.println("да я помню тебя. Так какое бы слово загадать дай-ка подумать");
            player = storage.get(nickName);
        }
        return player;
    }
}
