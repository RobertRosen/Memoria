package Game.multiplicationGame;

import java.util.*;

/**
 * Creates two lists of text strings. This simulates some pairs of
 * multiplication problems with solved answers on corresponding positions in the lists.
 * @author Robert Rosencrantz
 * @version 0.0
 */
public class NumbersScanner {

    private int SIZE = 50;

    private Random random;

    private ArrayList<String> problems;
    private ArrayList<String> solved;

    public NumbersScanner() {
        createLists();
    }

    private void createLists() {
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