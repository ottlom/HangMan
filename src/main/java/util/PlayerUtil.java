package util;

import model.Player;

public class PlayerUtil {
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
}
