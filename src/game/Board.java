package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Baseras på memoryspel hämtat från stackexchange 20.04.14.
 * https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 *
 * Anpassningar till Memoria: Robert Rosencrantz
 * TODO: Anpassa mer till Memoria (fixa så matchar gui) och implementera. Dela upp mvc. Ärv JPanel.
 */
public class Board extends JFrame {
    private Timer timer;

    private List<Card> cards;
    private Card selectedCard;

    private Card[] pairOfCards = new Card[2];

    public Board() {

        List<Card> cardsList = new ArrayList<Card>();
        List<String> cardSymbolPaths = new ArrayList<String>();

        // Skapa jämna par av symboler. (fler symboler)
        for (int i = 0; i < 3; i++) {
            cardSymbolPaths.add("images/minus.gif");
            cardSymbolPaths.add("images/plus.gif");
            cardSymbolPaths.add("images/plus2.jpg");
            cardSymbolPaths.add("images/minus2.jpg");
            cardSymbolPaths.add("images/pi.jpg");
            cardSymbolPaths.add("images/pi2.jpg");
        }
        cardSymbolPaths.add("images/pi.jpg");
        cardSymbolPaths.add("images/pi2.jpg");

        Collections.shuffle(cardSymbolPaths);   // Blanda symbolerna.

        // Skapa jämna par av symboler. (fler symboler)
        for (String symbol : cardSymbolPaths) {
            Card card = new Card();
            card.setPathSymbol(symbol);
            card.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedCard = card;
                    doTurn();
                }
            });
            card.hideSymbol();
            cardsList.add(card);
        }
        cards = cardsList;

        // Fördröjning på visning av kort på EDT.
        timer = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                checkCards();
            }
        });
        timer.setRepeats(false);

        // TODO: Gör till en panel och lägg in i Memoria istället.
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Card c : cards) {
            pane.add(c);
        }

        setTitle("Matcha symbol med uttryck!");
    }

    /**
     * Vänder upp valt kort.
     * TODO: Snygga till och eventuellt skapa en par-klass.
     */
    public void doTurn() {
        if (pairOfCards[0] == null) {
            pairOfCards[0] = selectedCard;
            pairOfCards[0].revealSymbol();
        }

        if ((pairOfCards[0] != null) && (pairOfCards[0] != selectedCard) && (pairOfCards[1] == null)) {
            pairOfCards[1] = selectedCard;
            pairOfCards[1].revealSymbol();
            timer.start();
        }
    }

    /**
     * Kontrollera om paret matchar.
     * Visa matchning och ta korten ur spel, eller vänd tillbaks kort.
     * TODO: Snygga till och eventuellt par-klass. Snygga till villkoren.
     */
    public void checkCards() {
        if ((pairOfCards[0].getPathSymbol().substring(0,9).equals(pairOfCards[1].getPathSymbol().substring(0,9))) &&
                !(pairOfCards[0].getPathSymbol().equals(pairOfCards[1].getPathSymbol()))) {
            // Matcha paret.
            pairOfCards[0].setEnabled(false); //disables the button
            pairOfCards[1].setEnabled(false);
            pairOfCards[0].setMatched(true); //flags the button as having been matched
            pairOfCards[1].setMatched(true);
            if (isGameWon()) {
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        } else {
            // Dölj paret
            for (Card card : pairOfCards) {
                card.hideSymbol();
            }
        }
        Arrays.fill(pairOfCards, null);     // Töm paret av kort.
    }

    // Kontrollerar om spelet är slut.
    private boolean isGameWon() {
        for (Card card : this.cards) {
            if (!card.getMatched()) {
                return false;
            }
        }
        return true;
    }
}
