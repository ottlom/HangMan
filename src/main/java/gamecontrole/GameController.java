package gamecontrole;

import display.Mistake;
import model.Player;
import util.RandomUtil;
import util.ValidationUtil;

import java.io.*;

import static display.Display.*;
import static util.PlayerUtil.*;

public class GameController {
    private int mistakeCounter = 0;
    private final int MISTAKES_LIMIT = 6;
    private StringBuilder immutableWord;
    private StringBuilder dynamicMutableWord;
    private final RandomUtil randomUtil = new RandomUtil();
    private final ValidationUtil util = new ValidationUtil();

    public void gameCycle() {
        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                Player player = getPlayer(reader);
                immutableWord = randomUtil.getRandomWord();
                dynamicMutableWord = hideWord(immutableWord);
                boolean result = CycleGuessWord(dynamicMutableWord.toString());
                statisticSum(player, result);

                System.out.println("игра окончена хотите сыграть ещё? если да введите yes либо нажмите enter");
                if (!reader.readLine().equals("yes")) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("answer player error");
            }
        }
    }

    public void greeting() {
        System.out.println("Привет сыграем? введите yes если хочешь начать игру, либо stop если хочешь остановить игру");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String answer = reader.readLine();
            while (!answer.equals("yes") || !answer.equals("stop")) {
                if (answer.equals("yes")) {
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
    }

    private String copyDynamicWordForCompare;

    private boolean CycleGuessWord(String hiddenWord) {
        boolean result = false;
        copyDynamicWordForCompare = hiddenWord;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (mistakeCounter < MISTAKES_LIMIT) {
            System.out.println("введите букву русского алфавита");
            try {
                String playerAnswer;
                do {
                    playerAnswer = reader.readLine().toLowerCase();
                } while (!util.isEmpty(playerAnswer) || !util.isDataValid(playerAnswer) | !util.isSameCharacter(playerAnswer.charAt(0), dynamicMutableWord.toString()));

                openSymbol(playerAnswer.charAt(0), immutableWord, dynamicMutableWord);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            result = isChangeWord(copyDynamicWordForCompare);
            if (result) {
                break;
            }
        }
        mistakeCounter = 0;
        Mistake.clearState();
        return result;
    }

    private boolean isChangeWord(String copyWord) {
        boolean isChange = false;
        if (copyWord.equals(dynamicMutableWord.toString())) {
            mistakeCounter++;
            hangManDisplay(mistakeCounter);
            infoAboutStateOfGame(mistakeCounter);
        } else {
            hangManDisplay(mistakeCounter);
            copyDynamicWordForCompare = String.valueOf(dynamicMutableWord);
            if (infoAboutStateOfGame(mistakeCounter)) {
                isChange = true;
            }
        }
        return isChange;
    }

    private boolean infoAboutStateOfGame(int mistake) {
        boolean result = false;
        if (dynamicMutableWord.toString().equals(immutableWord.toString())) {
            System.out.println("вы выиграли");
            result = true;
        } else if (mistake == MISTAKES_LIMIT) {
            System.out.println("вы проиграли,слово которое было загаданно - " + immutableWord);
        } else if (mistake < MISTAKES_LIMIT) {
            System.out.println("совершенно ошибок: " + mistake + ", 6-я ошибка приведёт к проигрышу");
            System.out.println(dynamicMutableWord);
        }
        return result;
    }
}
