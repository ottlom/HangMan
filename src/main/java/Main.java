import Model.Player;
import Util.PlayerUtil;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Maks");
        PlayerUtil util = new PlayerUtil();

        util.statisticSum(player, true);
        util.statisticSum(player, false);
    }
}
