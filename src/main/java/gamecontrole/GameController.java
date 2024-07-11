package gamecontrole;

import display.Mistake;

public class GameController {
    static Mistake mistake;
    static int mistakeCounter;
    private static final int MISTAKES_LIMIT = 6;

    public static void main(String[] args) {
        display();
    }

    public void gameProcess() {
    }

    private static void display() {
        for (mistakeCounter = 0; mistakeCounter <= MISTAKES_LIMIT; mistakeCounter++) {
            switch (mistakeCounter) {
                case 1:
                    mistake = Mistake.HEAD;
                    mistake.doDisplay(Mistake.HEAD);
                    break;
                case 2:
                    mistake = Mistake.BODY;
                    mistake.doDisplay(Mistake.BODY);
                    break;
                case 3:
                    mistake = Mistake.LEFT_HAND;
                    mistake.doDisplay(Mistake.LEFT_HAND);
                    break;
                case 4:
                    mistake = Mistake.RIGHT_HAND;
                    mistake.doDisplay(Mistake.RIGHT_HAND);
                    break;
                case 5:
                    mistake = Mistake.LEFT_FOOT;
                    mistake.doDisplay(Mistake.LEFT_FOOT);
                    break;
                case 6:
                    mistake = Mistake.RIGHT_FOOT;
                    mistake.doDisplay(Mistake.RIGHT_FOOT);
                    break;
            }
        }
    }
}
