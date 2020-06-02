package Game.multiplicationGame;

import Game.Controller.ClickController;
import Game.Controller.Controller;
import Game.Controller.MusicController;

import java.util.ArrayList;
import java.util.Random;

/**
 * The task to add new multiplication drops to the GUI. Problems are raining down the screen.
 * @author Robert Rosencrantz
 * @version 3.0
 */
public class DropCardsThread implements Runnable {
    private MusicController musicController = new MusicController();
    private ClickController clickController = new ClickController();
    private Controller controller;
    private JokerGameGUI jokerGameGui;

    private Random random;

    private ArrayList<CardDropTask> fallingDropsList;                                 // Stores drop threads.
    private boolean gameRunning = true;                                        // Set to false to stop thread.
    private int points = 0;                                                   // Store current score.
    private int matches = 0;
    private int NBR_OF_PROBLEMS_IN_BUFFER = 10;

    private int dropSpeed = 30;

    private boolean singlePlayer = false;

    /**
     * Construct and initialize a thread with this class' tasks.
     */
    public DropCardsThread(Controller controller) {
        this.controller = controller;
        jokerGameGui = new JokerGameGUI();
        random = new Random();
        singlePlayer = false;
        fallingDropsList = new ArrayList<CardDropTask>(NBR_OF_PROBLEMS_IN_BUFFER);

        setupDropList();                                                             // Setup list of drop threads.

        new Thread(this).start();
    }

    /**
     * Construct and initialize a thread with this class' tasks.
     */
    public DropCardsThread(Controller controller, int problems) {
        this.controller = controller;
        jokerGameGui = new JokerGameGUI();
        random = new Random();
        this.NBR_OF_PROBLEMS_IN_BUFFER = problems;
        singlePlayer = true;
        fallingDropsList = new ArrayList<CardDropTask>(NBR_OF_PROBLEMS_IN_BUFFER);

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

    /**
     * Release a drop on the rain panel in a random interval.
     * Keep dropping as long as the game is going.
     */
    private void drop() throws InterruptedException {
        int delayDrop;
        int problemsDropped = 0;

        while(gameRunning && (problemsDropped < NBR_OF_PROBLEMS_IN_BUFFER)) {
            delayDrop = random.nextInt(2000) + 1000;
            Thread.sleep(delayDrop);                                           // Delay next drop to random interval.

            if (!fallingDropsList.isEmpty()) {
                CardDropTask nextDrop = fallingDropsList.get(problemsDropped);
                nextDrop.setDropSpeed(dropSpeed);
                nextDrop.setAlive(true);// Start a new drop thread.

                if (singlePlayer) {
                    dropSpeed--;
                }

                jokerGameGui.addDropToGamePanel(fallingDropsList.get(problemsDropped));   // Put the new drop on rain thread.

                problemsDropped++;
            }
        }
    }

    /**
     * Called when the game is over. Secure all thread drops and rain thread to terminate.
     * Update score from joker game to main memory game and closes joker GUI.
     */
    public void gameOver() {
        if (singlePlayer) {
            singlePlayerGameOver();
        } else {
            multiPlayerGameOver();
        }
    }

    private void singlePlayerGameOver() {
        for (CardDropTask drop : fallingDropsList) {
            drop.setAlive(false);                                 // Stop all drop threads (not really matched).
        }

        musicController.stopMusic();
        gameRunning = false;                                                              // Stops this game thread.
        fallingDropsList.clear();                                     // To not keep getting points after game over.
//        controller.addJokerPoints();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jokerGameGui.dispose();
        musicController.stopMusic();
        controller.switchToMenu();
    }

    private void multiPlayerGameOver() {
        for (CardDropTask drop : fallingDropsList) {
            drop.setAlive(false);                                 // Stop all drop threads (not really matched).
        }
        musicController.stopMusic();
        gameRunning = false;                                                              // Stops this game thread.
        fallingDropsList.clear();                                     // To not keep getting points after game over.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jokerGameGui.dispose();
        controller.switchToBoard();
        musicController.playMusic("music/GameMusic.wav");
        controller.addJokerPoints();
    }

    /**
     * Update points score and set it visible in joker GUI.
     */
    public void incrementPoints() {
        points += 2;
        jokerGameGui.setTextFieldPoints(points);
        clickController.click("music/Point.wav");
    }

    public void incrementMatches() {
        matches++;
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

            CardDropTask cardDropTask = new CardDropTask(jokerGameGui,this, problem, solved);
            fallingDropsList.add(cardDropTask);
        }
    }

    /**
     * Check if the current score matches the total amount of problems to solve.
     * @return true if all problems was answered correctly.
     */
    public boolean gotAllProblemsRight() {
        return matches == NBR_OF_PROBLEMS_IN_BUFFER;
    }

    /**
     * Returns the current point score.
     * @return integer holding point score.
     */
    public int getPoints() {
        return points;
    }

    // TEST-MAIN-METOD för multiplikationsspelet.
    public static void main(String[] args) {
        new DropCardsThread();
    }
    public DropCardsThread() {
        jokerGameGui = new JokerGameGUI();
        random = new Random();
        fallingDropsList = new ArrayList<CardDropTask>(NBR_OF_PROBLEMS_IN_BUFFER);

        setupDropList();

        new Thread(this).start();
    }
}