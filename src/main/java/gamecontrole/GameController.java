package gamecontrole;

import display.Mistake;
import model.Player;
import storage.InMemoryPlayerStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    static Mistake mistake;
    static int mistakeCounter = 0;
    private static final int MISTAKES_LIMIT = 6;
    private final static InMemoryPlayerStorage storage = InMemoryPlayerStorage.getStorage();

    public static void main(String[] args) {
        System.out.println("Привет сыграем? ответь yes если хочешь начать игру, либо stop если хочешь остановить игру");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String answer = reader.readLine();
            while (!answer.equals("yes") || !answer.equals("stop")) {
                if (answer.equals("yes")) {
                    System.out.println("чтож представься и начнём");
                    break;
                } else if (answer.equals("stop")) {
                    System.exit(0);
                } else {
                    System.out.println("введите уes если хочешь сыграть или же stop если хочешь остановить");
                    answer = reader.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("answer player error");
        }

        Player player = getPlayer(reader);

        System.out.println("так какое бы слово загадать дай ка подумать");
    }

    private static void display(int mistakeNumber) {
        switch (mistakeNumber) {
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

    private static Player getPlayer(BufferedReader reader) {
        Player player;
        String nickName = null;

        try {
            nickName = reader.readLine();
        } catch (IOException e) {
            System.out.println("ошибка ввода имени");
        }

        if (storage.get(nickName) == null) {
            System.out.println("гляжу ты тут новенький");
            player = new Player(nickName);
            storage.save(player);
        } else {
            System.out.println("да я помню тебя");
            player = storage.get(nickName);
        }
        return player;
    }
}
