package Game.multiplicationGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Represents a word dropping down.
 *
 * @author Robert Rosencrantz
 */
public class WordDrop extends JTextField implements Runnable {
    private WordsRain wordsRain;
    private GUI gui;

    private int yPosition = 0;                                                       // Origin of the word appearing

    private boolean alive = false;
    private int xPosition = new Random().nextInt(800);                  // Words appear random to this number

    /**
     * Constructs and initialize this thread.
     * @param wordsrain The thread where this word drop thread will be initiated.
     * @param word Word from list in GUI.
     */
    public WordDrop(GUI gui, WordsRain wordsrain, String word) {
        this.gui = gui;
        this.wordsRain = wordsrain;
        setText(word);                                      // Set this threads word from construction in wordsrain.
        initialize();
    }

    /**
     * Thread keeps running until there is a match typed in GUI.
     */
    @Override
    public void run() {
        try {
            match();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void match() throws InterruptedException {
        while(alive) {
            Thread.sleep(50);
            yPosition++;

            updateLocation();
            matchingWord();
            gameOver();
        }
    }

    private void matchingWord() {
        if (gui.getTextFieldWordTyped().equals(getText())) {
            alive = false;
            setToMatched();
            wordsRain.incrementPoints();
            gui.setTextFieldWordTyped("");                           // Reset typing area after a matching word.
        }
    }

    private void gameOver() {
        if (yPosition > 439) {
            yPosition = 269;                                           // Set enlarged text to bottom of screen.
            xPosition = 0;
            setToGameOver();                                                           // Calling GameOver view.
            wordsRain.gameOver();                                                    // Call words rain to stop.
        }
    }

    /**
     * Starts a new word thread if argument passed when called is true.
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
        setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        setSize(20*getText().length(), 30);
        setForeground(Color.WHITE);
        setOpaque(false);
        setBorder(null);
        setEditable(false);
    }

    /**
     * Set a new location.
     */
    private void updateLocation() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocation(xPosition, yPosition);
            }
        });
    }

    /**
     * Set this label to Green.
     */
    private void setToMatched() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setForeground(Color.GREEN);
            }
        });
    }

    /**
     * Turn this text field to a big Game Over sign.
     */
    private void setToGameOver() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocation(xPosition,yPosition);
                setSize(1000, 200);
                setText("Game Over");
                setFont(new Font("Comic Sans MS", Font.PLAIN, 190));                // Enlarge font size
                setForeground(Color.RED);
                repaint();
            }
        });
    }
}