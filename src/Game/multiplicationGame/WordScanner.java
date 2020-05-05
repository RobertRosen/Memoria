package Game.multiplicationGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Reads a text file, and returns a list of words from getListWords-method.
 */
public class WordScanner {

    private int SIZE = 50;

    private Random random;

    private ArrayList<String> problems;
    private ArrayList<String> solved;

    public WordScanner() {
        random = new Random();

        problems = new ArrayList<>();
        solved = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            int number1 = random.nextInt(10);
            int number2 = random.nextInt(10);
            int answer = (number1 * number2);
            String problem = number1 + "*" + number2;
            String ansString = "" + answer;

            problems.add(problem);
            solved.add(ansString);
        }
    }

    public ArrayList<String> getProblems() {
        return problems;
    }

    public ArrayList<String> getSolved() {
        return solved;
    }
}