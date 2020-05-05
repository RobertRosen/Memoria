package Game.multiplicationGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Represents a multiplication problem to drop down a component.
 * @author Robert Rosencrantz
 * @version 0.0
 */
public class Drop extends JTextField implements Runnable {
    private Rain rain;
    private JokerGUI jokerGui;

    private boolean alive = false;
    private int xPosition = new Random().nextInt(800);                // Problem appear random to this number
    private int yPosition = 0;                                                    // Origin of the problem appearing

    private String solved;

    /**
     * Constructs and initialize this thread.
     * @param jokerGui Where the game is played.
     * @param wordsrain the thread where this drop thread will be initiated.
     * @param problem the question to answer.
     * @param solved the answer to the problem.
     */
    public Drop(JokerGUI jokerGui, Rain wordsrain, String problem, String solved) {
        this.jokerGui = jokerGui;
        this.rain = wordsrain;
        setText(problem);                             // Set this threads problem from construction in rain.
        this.solved = solved;
        initialize();
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
            Thread.sleep(30);
            yPosition++;

            updateLocation();
            matchingWord();
            gameOver();
        }
    }

    /**
     * Check if the drop is matching user input.
     */
    private void matchingWord() {
        if (jokerGui.getTextFieldUserTyping().equals(solved)) {
            alive = false;

            updateViewToMatchedDrop();
            rain.incrementPoints();

            if (rain.gotAllProblemsRight()) {
                updateViewToWinning();
                updateViewToGameOver();
                rain.gameOver();                                                    // Stop rain.
            }
        }
    }

    /**
     * Game over when drop reaches bottom of panel.
     */
    private void gameOver() {
        if (yPosition > 439) {
            yPosition = 269;
            xPosition = 0;
            updateViewToGameOver();                                                   // Calling GameOver view.
            rain.gameOver();                                                                // Stop rain.
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

    /**
     * Setup initial settings of this text field.
     */
    private void initialize() {
        setFont(new Font("monospaced", Font.BOLD, 35));
        setSize(30*getText().length(), 30);
        setForeground(Color.BLACK);
        setOpaque(false);
        setBorder(null);
        setEditable(false);
    }

    /**
     * Set this textfield at the new location.
     */
    private void updateLocation() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocation(xPosition, yPosition);
            }
        });
    }

    private void updateViewToMatchedDrop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jokerGui.setTextFieldUserTyping("");                 // Reset typing area after a matching word.
                setForeground(Color.GREEN);
                setText(getText() + "=" + solved);
                setSize(30*getText().length(), 30);
            }
        });
    }

    private void updateViewToWinning() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jokerGui.setTextFieldUserTyping(
                        "                WINNER!   YOU GOT ALL!                  ");
            }
        });
    }

    private void updateViewToGameOver() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocation(300,0);
                setSize(1000, 500);
                setText(rain.getPoints() +  "p");
                setFont(new Font("monospaced", Font.BOLD, 290));                // Enlarge font size
                setForeground(Color.GREEN);
                repaint();
            }
        });
    }
}