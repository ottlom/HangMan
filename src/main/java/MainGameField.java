import gamecontrole.GameController;

public class MainGameField {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.greeting();
        controller.gameCycle();
    }
}
