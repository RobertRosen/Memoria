import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameController {
    private BoardGUI boardGUI;

//    private Timer timer;
//    private ArrayList<Card> cards;
    private Card selectedCard;
    private Card[] pairOfCards = new Card[2];

    public GameController() {
        boardGUI = new BoardGUI(this);

//        setupTheGame();
    }

    /**
     * Vänder upp valt kort.
     * TODO: Snygga till och eventuellt skapa en par-klass.
     */
    public void doTurn(Card card) {
        selectedCard = card;
        if (pairOfCards[0] == null) {
            pairOfCards[0] = selectedCard;
            pairOfCards[0].revealSymbol();
        }

        if ((pairOfCards[0] != null) && (pairOfCards[0] != selectedCard) && (pairOfCards[1] == null)) {
            pairOfCards[1] = selectedCard;
            pairOfCards[1].revealSymbol();
            boardGUI.getTimer().start();
        }
    }

    /**
     * Kontrollera om paret matchar.
     * Visa matchning och ta korten ur spel, eller vänd tillbaks kort.
     * TODO: Snygga till och eventuellt par-klass. Snygga till villkoren.
     */
    public void checkCards() {
        if ((pairOfCards[0].getPathSymbol().substring(0, 9).equals(pairOfCards[1].getPathSymbol().substring(0, 9))) &&
                !(pairOfCards[0].getPathSymbol().equals(pairOfCards[1].getPathSymbol()))) {
            // Matcha paret.
            pairOfCards[0].setEnabled(false); //disables the button
            pairOfCards[1].setEnabled(false);
            pairOfCards[0].setMatched(true); //flags the button as having been matched
            pairOfCards[1].setMatched(true);
            if (isGameWon()) {
                JOptionPane.showMessageDialog(boardGUI, "You win!");
                boardGUI.dispose();
                boardGUI = new BoardGUI(this);
            }
        } else {
            // Dölj paret
            for (Card card : pairOfCards) {
                card.hideSymbol();
            }
        }
        Arrays.fill(pairOfCards, null);     // Töm paret av kort.
    }

    /**
     * Kontrollerar om spelet är slut.
     * TODO: Lös det här snyggare.
     */
    private boolean isGameWon() {
        for (Card card : boardGUI.getCards()) {
            if (!card.isMatched()) {
                return false;
            }
        }
        return true;
    }

//    // Hjälper till att sätta upp spelet i konstruktorn.
//    private void setupTheGame() {
//        ArrayList<Card> cardsList = new ArrayList<Card>();
//        ArrayList<String> cardSymbolPaths;
//
//        cardSymbolPaths = addSymbols();         // Lägg bilder på korten.
//        Collections.shuffle(cardSymbolPaths);   // Blanda symbolerna.
//        // Skapa jämna par av symboler.
//        for (String symbol : cardSymbolPaths) {
//            Card card = new Card();
//            card.setPathSymbol(symbol);
//            card.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent ae) {
//                    selectedCard = card;
//                    doTurn();
//                }
//            });
//            card.hideSymbol();
//            cardsList.add(card);
//        }
//        cards = cardsList;
//
//        setupTimer();
//
//        for (Card card : cards) {
////            pnlMain.add(card);
////            pnlCards.add(card);
////            boardGUI.setPnlMain(card);
////            boardGUI.setPnlCards(card);
//        }
//    }

//    // Sätter upp en timer på händelsetråden.
//    private void setupTimer() {
//        timer = new Timer(750, new ActionListener() {
//            public void actionPerformed(ActionEvent ae) {
//                checkCards();
//            }
//        });
//        timer.setRepeats(false);
//    }

//    // Lägger bilder/symboler på alla korten.
//    private ArrayList<String> addSymbols() {
//        ArrayList<String> cardSymbolPaths = new ArrayList<String>();
//
//        cardSymbolPaths.add("images/minus.gif");
//        cardSymbolPaths.add("images/plus.gif");
//        cardSymbolPaths.add("images/plus2.jpg");
//        cardSymbolPaths.add("images/minus2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//        cardSymbolPaths.add("images/pi.jpg");
//        cardSymbolPaths.add("images/pi2.jpg");
//
//        return cardSymbolPaths;
//    }


    public static void main(String[] args) {
        new GameController();
    }
}
