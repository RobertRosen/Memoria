import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameController {
    private BoardGUI boardGUI;

    private Card selectedCard;
    private Card[] pairOfCards = new Card[2];

    private boolean turnPlayer1 = true;
    private String namePlayer1 = "Player1";
    private String namePlayer2 = "Player2";

    private int score;
    private int score2;

    public GameController() {
        new LogInGUI(this);
        switchPlayerTurns();
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
     * TODO: Ta bort andra vilkoret i if-satsen
     * TODO: Vad ska hända efter isGamewon?
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

    public void switchPlayerTurns(){
        String firstSymbol = pairOfCards[0].getPathSymbol().substring(0,9);
        String secondSymbol = pairOfCards[1].getPathSymbol().substring(0,9);

        if (firstSymbol.equals(secondSymbol)){
            incrementScore();
        }

        else {
           highlightedPanel();
        }
    }

    public void incrementScore(){
        if (turnPlayer1){
            boardGUI.setScore1(score += 10);
        }
        if (!turnPlayer1){
            boardGUI.setScore2(score2 += 10);
        }
    }

    public void highlightedPanel(){
        if (turnPlayer1){
            boardGUI.getPnlPlayer1().setBorder(BorderFactory.createLineBorder(Color.GREEN));
            boardGUI.getPnlPlayer2().setBorder(BorderFactory.createLineBorder(Color.RED));
            turnPlayer1 = false;
        }
        if (!turnPlayer1){
            boardGUI.getPnlPlayer1().setBorder(BorderFactory.createLineBorder(Color.RED));
            boardGUI.getPnlPlayer2().setBorder(BorderFactory.createLineBorder(Color.GREEN));
            turnPlayer1 = true;
        }
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

    /**
     * Go game view.
     */
    public void switchGUI() {
        boardGUI = new BoardGUI(this);
    }
}
