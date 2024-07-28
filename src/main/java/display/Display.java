package display;

public class Display {
    public static void hangManDisplay(int mistakeNumber) {
        switch (mistakeNumber) {
            case 0:
                Mistake mistake = Mistake.CLEAR;
                mistake.doDisplay(mistake);
                break;
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

    public static StringBuilder hideWord(StringBuilder wordSource) {
        System.out.println(wordSource.toString().replaceAll("\\p{L}", "*"));
        return new StringBuilder(wordSource.toString().replaceAll("\\p{L}", "*"));
    }

    public static void openSymbol(char guess, StringBuilder hiddenWord, StringBuilder dynamicWord) {
        for (int i = 0; i < dynamicWord.length(); i++) {
            if (hiddenWord.charAt(i) == guess) {
                dynamicWord.setCharAt(i, guess);
            }
        }
    }
}
