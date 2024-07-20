package util;

import model.Player;
import storage.InMemoryPlayerStorage;

import java.io.BufferedReader;
import java.io.IOException;

public class PlayerUtil {
    static InMemoryPlayerStorage storage = InMemoryPlayerStorage.getStorage();

    public static void statisticSum(Player player, boolean gameResult) {
        if (gameResult) {
            player.setWinCounter(player.getWinCounter() + 1);
        } else {
            player.setLoseCounter(player.getLoseCounter() + 1);
        }
        player.viewStatistic();
    }

    public static Player getPlayer(BufferedReader reader) {
        Player player;
        String nickName = null;

        try {
            System.out.println("введите имя");
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
