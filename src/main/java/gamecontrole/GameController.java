package gamecontrole;

import display.Mistake;
import model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static display.Display.*;
import static util.PlayerUtil.*;

public class GameController {
    static Player player;
    static int mistakeCounter = 0;
    private static final int MISTAKES_LIMIT = 6;
    private static StringBuilder staticWord;
    private static StringBuilder dynamicWord;

    public void gameCycle() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                player = getPlayer(reader);
                staticWord = getRandomWord();
                dynamicWord = hideWord(staticWord);
                boolean result = CycleGuessWord(dynamicWord.toString());
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

    public void greet() {
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

    private String compareWord;
    private boolean CycleGuessWord(String word) {
        boolean result = false;
        compareWord = word;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (mistakeCounter < MISTAKES_LIMIT) {
            System.out.println("введите букву русского алфавита");
            try {
                String playerAnswer = reader.readLine();
                while (playerAnswer.equals("")) {
                    System.out.println("вы должны ввести букву русского алфавита а не пустую строку");
                    playerAnswer = reader.readLine();
                }
                openSymbol(playerAnswer.charAt(0), staticWord, dynamicWord);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            result = isChangeWord(compareWord);
            if (result) {
                break;
            }
        }
        mistakeCounter = 0;
        Mistake.clearState();
        return result;
    }

    private boolean isChangeWord(String word) {
        boolean isChange = false;
        if (word.equals(dynamicWord.toString())) {
            mistakeCounter++;
            hangManDisplay(mistakeCounter);
            infoAboutStateOfGame(mistakeCounter);
        } else {
            hangManDisplay(mistakeCounter);
            compareWord = String.valueOf(dynamicWord);
            if (infoAboutStateOfGame(mistakeCounter)) {
                isChange = true;
            }
        }
        return isChange;
    }

    private StringBuilder getRandomWord() {
        List<String> array = new ArrayList<>();
        File file = new File("src\\main\\resources\\dictionary.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                array.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        return new StringBuilder(array.get(random.nextInt(array.size())));
    }

    private boolean infoAboutStateOfGame(int mistake) {
        boolean result = false;
        if (dynamicWord.toString().equals(staticWord.toString())) {
            System.out.println("вы выиграли");
            result = true;
        } else if (mistake == MISTAKES_LIMIT) {
            System.out.println("вы проиграли,слово которое было загаданно - " + staticWord);
        } else if (mistake < MISTAKES_LIMIT) {
            System.out.println("совершенно ошибок: " + mistake + ", 6-я ошибка приведёт к проигрышу");
            System.out.println(dynamicWord);
        }
        return result;
    }
}
