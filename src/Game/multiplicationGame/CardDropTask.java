package Game.multiplicationGame;

import Game.Controller.ClickController;
import Game.Model.Card;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Represents a multiplication problem to drop down a component.
 * @author Robert Rosencrantz
 * @version 3.0
 */
public class CardDropTask extends Card implements Runnable {
    private DropCardsThread dropCardsThread;
    private JokerGameGUI jokerGameGui;
    private ClickController clickController = new ClickController();

    private boolean alive = false;
    private int xPosition = new Random().nextInt(800);                // Problem appear random to this number
    private int yPosition = 0;                                                    // Origin of the problem appearing
    private int dropSpeed = 30;

    private String problem;
    private String solved;

    /**
     * Constructs and initialize this thread.
     * @param jokerGameGui Where the game is played.
     * @param wordsrain the thread where this drop thread will be initiated.
     * @param problem the question to answer.
     * @param solved the answer to the problem.
     */
    public CardDropTask(JokerGameGUI jokerGameGui, DropCardsThread wordsrain, String problem, String solved) {
        this.jokerGameGui = jokerGameGui;
        this.dropCardsThread = wordsrain;
        this.problem = problem;
        this.solved = solved;
        hideSymbol(65,64);   // Method in super.
        setFocusable(false);
        initialize();
    }

    /**
     * Has to be overridden to not revalidate the whole GUI for each
     * update in this thread. This component is now always root.
     * This prevents unpredictable events in the GUI.
     * @return boolean is always true.
     */
    @Override
    public boolean isValidateRoot() {
        return true;
    }

    private void initialize() {
        setupDrop(Color.BLACK, Color.WHITE, problem);
    }

    private void setupDrop(Color colorF, Color colorB, String message) {
        setText(message);
        setFont(new Font("monospaced", Font.BOLD, 15));
        setSize((new Dimension(60, 88)));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createRaisedBevelBorder()
                ));
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);
        setForeground(colorF);
        setBackground(colorB);
        setLocation(xPosition, yPosition);
    }

    @Override
    public void run() {
        try {
            keepDropping();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This drop tread keeps running until there is a match typed in by the user,
     * or the drop reaches the end of the panel.
     * @throws InterruptedException
     */
    private void keepDropping() throws InterruptedException {
        while(alive) {
            Thread.sleep(dropSpeed);
            yPosition++;

            setupDrop(Color.BLACK, Color.WHITE, problem);
            matchingWord();
            loosing();
            winning();
        }
    }

    /**
     * Check if the drop is matching user input.
     * Todo: Syncronisering. Så att inte flera kort matchar.
     */
    private void matchingWord() throws InterruptedException {
        if (jokerGameGui.getAnswerTyped().equals(solved)) {
            jokerGameGui.setLabelTyping("");                 // Reset typing area after a matching word.

            updateViewToMatchedDrop();

            alive = false;
            dropCardsThread.incrementPoints();

            Thread.sleep(2500);
            setVisible(false);

            dropCardsThread.incrementMatches();    // Synchronizes points updates
        }
    }

    /**
     * Game over when the user get all answers right.
     */
    private void winning() {
        if (dropCardsThread.gotAllProblemsRight()) {
            clickController.click("music/JokerWin.wav");
            updateViewToWinning();
            dropCardsThread.gameOver();                                                    // Stop rain.
        }
    }

    /**
     * Game over when drop reaches bottom of panel.
     */
    private void loosing() {
        if (yPosition > 409) {
            clickController.click("music/GameOver.wav");
            updateViewToLoosing();
            dropCardsThread.gameOver();
        }
    }

    /**
     * Starts a new thread if argument passed when called is true.
     * Stops thread if argument is false.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
        if (alive) {
            new Thread(this).start();
        }
    }

    private void updateViewToMatchedDrop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageIcon imageShowing = new ImageIcon("images/Joker2.png");
                Image imageToScale = imageShowing.getImage();
                Image scaledImage = imageToScale.getScaledInstance(40, 58, Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                setIcon(scaledImageIcon);
                setupDrop(Color.WHITE, Color.BLACK, (problem + "=" + solved));
            }
        });
    }

    private void updateViewToWinning() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jokerGameGui.addPointsText();
            }
        });
    }

    private void updateViewToLoosing() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jokerGameGui.addPointsText();
            }
        });
    }

    public void setDropSpeed(int dropSpeed) {
        this.dropSpeed = dropSpeed;
    }
}