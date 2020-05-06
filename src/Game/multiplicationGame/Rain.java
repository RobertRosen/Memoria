package Game.multiplicationGame;

import Game.Controller.Controller;

import java.util.ArrayList;
import java.util.Random;

/**
 * The task to add new multiplication drops to the GUI. Problems are raining down the screen.
 * @author Robert Rosencrantz
 * @version 0.0
 */
public class Rain implements Runnable {
    private Controller controller;
    private JokerGUI jokerGui;

    private Random random;

    private ArrayList<CardDrop> fallingDropsList;                                 // Stores drop threads.
    private boolean gameRunning = true;                                        // Set to false to stop thread.
    private int points = 0;                                                   // Store current score.
    private final int NBR_OF_PROBLEMS_IN_BUFFER = 10;

    /**
     * Construct and initialize a thread with this class' tasks.
     */
    public Rain(Controller controller) {
        this.controller = controller;
        jokerGui = new JokerGUI();
        random = new Random();
        fallingDropsList = new ArrayList<CardDrop>(NBR_OF_PROBLEMS_IN_BUFFER);

        setupDropList();                                                             // Setup list of drop threads.

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            drop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int problemsDropped = 0;
    /**
     * Release a drop on the rain panel in a random interval.
     * Keep dropping as long as the game is going.
     */
    private void drop() throws InterruptedException {
        int delayDrop;


        while(gameRunning && (problemsDropped < NBR_OF_PROBLEMS_IN_BUFFER)) {
            delayDrop = random.nextInt(2000) + 1000;
            Thread.sleep(delayDrop);                                           // Delay next drop to random interval.

            fallingDropsList.get(problemsDropped).setAlive(true);                         // Start a new drop thread.


            jokerGui.addDropToGamePanel(fallingDropsList.get(problemsDropped));   // Put the new drop on rain thread.

            problemsDropped++;
        }
    }

    /**
     * Called when the game is over. Secure all thread drops and rain thread to terminate.
     * Update score from joker game to main memory game and closes joker GUI.
     */
    public void gameOver() {
        for (CardDrop drop : fallingDropsList) {
            drop.setAlive(false);                                 // Stop all drop threads (not really matched).
        }
        gameRunning = false;                                                              // Stops this game thread.
        fallingDropsList.clear();                                     // To not keep getting points after game over.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.addJokerPoints();
        jokerGui.dispose();
        controller.showBoardGUI();
    }

    /**
     * Update points score and set it visible in joker GUI.
     */
    public void incrementPoints() {
        points += 2;
        jokerGui.setTextFieldPoints(points);

    }

    /**
     * Setup list of word threads.
     */
    private void setupDropList() {
        NumbersScanner scanner = new NumbersScanner();
        ArrayList<String> problemsBuffer = scanner.getProblems();           // Create a list of problem strings.
        ArrayList<String> solvedBuffer = scanner.getSolved();               // Create a list of answer strings.

        for (int i = 0; i < NBR_OF_PROBLEMS_IN_BUFFER; i++) {      // Fill upp the falling drops list with threads.
            String problem = problemsBuffer.remove(0);
            String solved = solvedBuffer.remove(0);

            fallingDropsList.add(new CardDrop(jokerGui,this, problem, solved));
        }
    }

    /**
     * Check if the current score matches the total amount of problems to solve.
     * @return true if all problems was answered correctly.
     */
    public boolean gotAllProblemsRight() {
        return (points/2) == NBR_OF_PROBLEMS_IN_BUFFER;
    }

    /**
     * Returns the current point score.
     * @return integer holding point score.
     */
    public int getPoints() {
        return points;
    }

    // TEST-MAIN-METOD för multiplikationsspelet.
//    public static void main(String[] args) {
//        new Rain();
//    }
//    public Rain() {
//        jokerGui = new JokerGUI();
//        random = new Random();
//        fallingDropsList = new ArrayList<CardDrop>(NBR_OF_PROBLEMS_IN_BUFFER);
//
//        setupDropList();
//
//        new Thread(this).start();
//    }
}