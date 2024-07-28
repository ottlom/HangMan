package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    private final Pattern patternValidation = Pattern.compile("[а-яА-ЯёЁ]");

    public boolean isDataValid(String guessOfPlayer) {
        Matcher matcher = patternValidation.matcher(guessOfPlayer);
        if (!matcher.find()) {
            System.out.println("вы должны вводить только русские буквы");
            return false;
        } else {
            return true;
        }
    }

    public boolean isSameCharacter(char guessOfPlayer, String hiddenWord) {
        int i = 0;
        boolean isSame = true;
        while (i < hiddenWord.length()) {
            if (guessOfPlayer == hiddenWord.charAt(i)) {
                System.out.println("Вы уже отгадали символ " + guessOfPlayer + " введите другой");
                isSame = false;
                break;
            }
            i++;
        }
        return isSame;
    }

    public boolean isEmpty(String guessOfPlayer) {
        if (guessOfPlayer.equals("")) {
            System.out.println("нельзя вводить пустое поле");
            return false;
        } else {
            return true;
        }
    }
}