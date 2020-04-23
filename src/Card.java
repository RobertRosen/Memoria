import javax.swing.*;
import java.awt.*;

/**
 * Baseras på memoryspel hämtat från stackexchange 20.04.14.
 * https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 *
 * Anpassningar till Memoria av: Robert Rosencrantz
 * TODO: Kanske inte ärva JButton?
 */
public class Card extends JButton {

    private String pathSymbol;

    private ImageIcon imageShowing;     //The visible front side of the card.

    private boolean matched = false;

    /**
     * Initiate and construct a card.
     */
    public Card() {
        setPreferredSize(new Dimension(52, 72));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }

    /**
     * Turn card to show symbol.
     */
    public void revealSymbol() {
        imageShowing = new ImageIcon(pathSymbol);

        double imageWidth   = imageShowing.getIconWidth();
        double imageHeight  = imageShowing.getIconHeight();
        double cardHeight   = getHeight();
        double cardWidth    = getWidth();

        double scaleHeight  = cardHeight/imageHeight;
        double scaleWidth   = cardWidth/imageWidth;
        double scale        = Math.min(scaleHeight, scaleWidth); // Get appropriate scale for this cards image.

        int width           = (int) (imageWidth*scale);
        int height          = (int) (imageHeight*scale);

        Image imageToScale = imageShowing.getImage();
        Image scaledImage = imageToScale.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        setIcon(scaledImageIcon);
    }

    /**
     * Turn card symbol down.
     */
    public void hideSymbol() {
        imageShowing = new ImageIcon("images/math4.jpg");
        setIcon(imageShowing);
    }

    // Setters och getters
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
