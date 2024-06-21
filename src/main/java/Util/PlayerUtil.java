package Util;

import Model.Player;

public class PlayerUtil {
    public void statisticSum(Player player, boolean gameResult) {
        if (gameResult) {
            player.winIncrement();
        } else {
            player.loseIncrement();
        }
    }
}
