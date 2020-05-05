package Game.multiplicationGame;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

/**
 * The task to add new words to the GUI. Word drops are raining down the screen.
 *
 * @author Robert Rosencrantz
 */
public class WordsRain implements Runnable {

    private GUI                 gui;
    private boolean             gameRunning = true;                                  // Set to false to stop thread.
    private Random random;
    private ArrayList<WordDrop> fallingWordsList;                                       // Stores word drop threads.
    private int                 points = 0;                                                  // Store current score.

    private final int NBR_OF_PROBLEMS_IN_BUFFER = 5;

    private int nbrOfSolved = 0;

    public static void main(String[] args) throws FileNotFoundException {
        new WordsRain();
    }

    /**
     * Construct and initialize a thread with this class' tasks.
     */
    public WordsRain() {
        gui = new GUI();
        random = new Random();
        fallingWordsList = new ArrayList<WordDrop>(NBR_OF_PROBLEMS_IN_BUFFER);

        setupWordsList();                                                             // Setup list of word threads.

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            dropWords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Drops a word on a random interval.
     */
    private void dropWords() throws InterruptedException {
        int delayWord;
        int i = 0;
        while(gameRunning && (i < NBR_OF_PROBLEMS_IN_BUFFER)) {
            delayWord = random.nextInt(5000) + 1000;
            fallingWordsList.get(i).setAlive(true);                                // Start a new word drop thread.

            gui.setPnlGame(fallingWordsList.get(i));                       // Put the new word on wordsrain thread.
            i++;

            Thread.sleep(delayWord);                                     // Delay next word to random intreval.
        }

        if (nbrOfSolved == NBR_OF_PROBLEMS_IN_BUFFER) {
            gui.setTextFieldWordTyped("                WINNER!   YOU GOT ALL!                  ");
        }
    }

    /**
     * Method is called when the game is over. Triggers changes in the view.
     */
    public void gameOver() {
        for (WordDrop wordDrop : fallingWordsList) {
            wordDrop.setAlive(false);                                 // Stop all word threads (not really matched).
        }
        gameRunning = false;                                                              // Stops this game thread.
        fallingWordsList.clear();                                     // To not keep getting points after game over.
    }

    /**
     * Called to update points.
     */
    public void incrementPoints() {
        points++;
        gui.setTextFieldPoints(points);
    }

    /**
     * Setup list of word threads.
     */
    private void setupWordsList() {
        WordScanner scanner = new WordScanner();
        ArrayList<String> problemsBuffer = scanner.getProblems();           // Create a list of string words.
        ArrayList<String> solvedBuffer = scanner.getSolved();           // Create a list of string words.

        System.out.println(problemsBuffer.size());
        System.out.println(solvedBuffer.size());

        for (int i = 0; i < NBR_OF_PROBLEMS_IN_BUFFER; i++) {               // Fill upp the falling words list with threads.
            String problem = problemsBuffer.remove(0);
            String solved = solvedBuffer.remove(0);

            System.out.println(i + ". Problem: " + problem + "    Answer: " + solved + "     Buffer size: " + problemsBuffer.size());

            fallingWordsList.add(new WordDrop(gui,this, problem, solved));
        }
    }

    public void incrementNbrOfSolved() {
        nbrOfSolved++;
    }
}