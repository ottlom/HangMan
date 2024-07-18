package gamecontrole;

import display.Display;
import storage.InMemoryPlayerStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static display.Display.hangManDisplay;
import static display.Display.hideWord;
import static util.PlayerUtil.getPlayer;

public class GameController {
    static int mistakeCounter = 0;
    private static final int MISTAKES_LIMIT = 6;
    private static StringBuilder staticWord;
    private static StringBuilder dynamicWord;


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

        getPlayer(reader);

        staticWord = getRandomWord();
        dynamicWord = staticWord;
        dynamicWord = hideWord(dynamicWord);
        System.out.println(dynamicWord);
        predictionCycle(dynamicWord.toString());
    }

    private static StringBuilder getRandomWord() {
        List<String> array = new ArrayList<>();
        File file = new File("C:\\Java\\projects\\HangMan\\src\\main\\resources\\dictionary.txt");
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

    private static void predictionCycle(String word) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!dynamicWord.toString().equals(word) | mistakeCounter < MISTAKES_LIMIT) {
            try {
                Display.openSymbol(reader.readLine().charAt(0), staticWord, dynamicWord);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (word.equals(dynamicWord.toString())) {
                mistakeCounter++;
                hangManDisplay(mistakeCounter);
            } else {
                hangManDisplay(mistakeCounter);
                word = String.valueOf(dynamicWord);
            }

            if (mistakeCounter == MISTAKES_LIMIT) {
                System.out.println("игра окончена");
                break;
            }
            System.out.println("\n" + dynamicWord);
        }
    }
}
