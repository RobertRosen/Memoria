package game;

import javax.swing.*;
import java.awt.*;

/**
 * Baseras på memoryspel hämtat från stackexchange 20.04.14.
 * https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 *
 * Anpassningar till Memoria av: Robert Rosencrantz
 * TODO: Anpassa mer till Memoria och implementera. Dela upp mvc. Kanske inte ärva JButton?
 */
public class Card extends JButton {

    /* Avgör bild som visas på kortet och matchning av kort*/
    private String pathSymbol;

    private ImageIcon imageShowing;

    private boolean matched = false;

    public Card() {
        setPreferredSize(new Dimension(52, 72));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }

    public void revealSymbol() {
        imageShowing = new ImageIcon(pathSymbol);
        Image temp = imageShowing.getImage();
        Image resizedImage = temp.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(resizedImage);
        setIcon(icon);
    }

    public void hideSymbol() {
        imageShowing = new ImageIcon("images/math4.jpg");
        setIcon(imageShowing);
    }

    // Setters och getters.
    public String getPathSymbol() {
        return pathSymbol;
    }

    public void setPathSymbol(String pathSymbol) {
        this.pathSymbol = pathSymbol;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean isMatched() {
        return matched;
    }
}
