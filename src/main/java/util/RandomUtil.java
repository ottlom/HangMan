package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomUtil {
    public final StringBuilder getRandomWord() {
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
}
