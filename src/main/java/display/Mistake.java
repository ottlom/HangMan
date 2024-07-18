package display;

public enum Mistake {
    CLEAR(0,(char) 45),
    HEAD(30, (char) 111),
    BODY(44, (char) 124),
    LEFT_HAND(43, (char) 47),
    RIGHT_HAND(45, (char) 92),
    LEFT_FOOT(57, (char) 47),
    RIGHT_FOOT(59, (char) 92);

    private final int place;
    private final char mistake;

    public int getPlace() {
        return place;
    }

    public char getMistake() {
        return mistake;
    }

    Mistake(int place, char c) {
        this.place = place;
        this.mistake = c;
    }

    public static final StringBuilder initialState = new StringBuilder(
            "-------------\n" +
                    "  |         |\n" +
                    "            |\n" +
                    "            |\n" +
                    "            |\n" +
                    "           / \\");

    public void doDisplay(Mistake mistake) {
        initialState.replace(mistake.getPlace(), mistake.getPlace() + 1, String.valueOf(mistake.getMistake()));
        System.out.println(initialState);
    }
}