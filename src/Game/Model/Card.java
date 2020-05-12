package Game.Model;

import Game.Controller.MusicController;

import javax.swing.*;
import java.awt.*;

/**
 * The card class represents a card in the memory game.
 * @version 3.0
 * @author Robert Rosencrantz, Adel Sabanovic
 * TODO: Kanske inte ärva JButton?
 */
public class Card extends JButton {
    private MusicController musicController = new MusicController();
    private String pathSymbol;          // Location of image.
    private ImageIcon imageShowing;     // The visible front side of the card.
    private boolean matched = false;    // True if this card is matched with another card.

    /**
     * Initiate and construct a card.
     */
    public Card() {
        setPreferredSize((new Dimension(60, 78)));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }

    /**
     * Turn card to show symbol.
     */
    public void revealSymbol() {
        imageShowing = new ImageIcon(pathSymbol);
        //musicController.click("music/CardClick.wav");
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
        // TODO: Possibly make back side image optional in the game.
        //imageShowing = new ImageIcon("images/math4.jpg");
        //imageShowing = new ImageIcon("images/Back.png");
        //imageShowing = new ImageIcon("images/BackDark.png");
        //imageShowing = new ImageIcon("images/BackGreen.png");
        imageShowing = new ImageIcon("images/BackMan.png");
        Image imageToScale = imageShowing.getImage();
        Image scaledImage = imageToScale.getScaledInstance(60, 68, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        setIcon(scaledImageIcon);
    }

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
