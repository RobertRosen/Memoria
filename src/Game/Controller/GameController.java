package Game.Controller;

import Game.Model.Card;
import Game.Model.InfoReader;
import Game.Model.User;
import Game.View.BoardGUI;
import Game.View.LogInGUI;
import Game.View.MenuGUI;

import javax.swing.*;
import java.util.Arrays;

public class GameController {
    private BoardGUI boardGUI;
    private LogInGUI logInGUI;
    private MenuGUI menuGUI;
    private User[] multiPlayer = new User[2];

    private InfoReader infoReader;

    private Card selectedCard;
    private Card[] pairOfCards = new Card[2];
    private String player2;

    private boolean turnPlayer1 = true;

    private int score;
    private int score2;

    public GameController() {
        logInGUI = new LogInGUI(this, "Player One ");
        infoReader = new InfoReader("textfiles/infopanel.txt","textfiles/symbol.txt");
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
        String firstSymbol = pairOfCards[0].getPathSymbol().substring(0,9);
        String secondSymbol = pairOfCards[1].getPathSymbol().substring(0,9);

        if (firstSymbol.equals(secondSymbol)) {
            // Matcha paret.
            pairOfCards[0].setEnabled(false); //disables the button
            pairOfCards[1].setEnabled(false);
            pairOfCards[0].setMatched(true); //flags the button as having been matched
            pairOfCards[1].setMatched(true);
            //KALLA PÅ METOD SOM VISAR INFO TEXT.
            if (isGameWon()) {
                JOptionPane.showMessageDialog(boardGUI, "You win!");
                boardGUI.dispose();
                boardGUI = new BoardGUI(this);
            }
            incrementScore();
        } else {
            // Dölj paret
            for (Card card : pairOfCards) {
                card.hideSymbol();
            }
            switchPlayers();
        }
        Arrays.fill(pairOfCards, null);     // Töm paret av kort.
    }

    public void incrementScore(){
        if (turnPlayer1) {
            boardGUI.setLblScore(score += 10);
        } else {
            boardGUI.setLblScore2(score2 += 10);
        }
    }

    public void switchPlayers(){
        if (turnPlayer1){
            boardGUI.highlightPlayer2();
            turnPlayer1 = false;
        } else {
            boardGUI.highlightPlayer1();
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

    LogInGUI logInPlayer2;
    /**
     * Go game view.
     */
    public void switchGUI() {
        logInPlayer2 = new LogInGUI(this, "Player Two");
    }

    public void createUser() {
        if (multiPlayer[0] == null) {
            String name = logInGUI.getTxtUsername().getText();
            multiPlayer[0] = new User(name);
            JOptionPane.showMessageDialog(null, "Välkommen spelare1: " + name);
            new MenuGUI(this);
        }
        else {
            String name = logInPlayer2.getTxtUsername().getText();
            multiPlayer[1] = new User(name);
            JOptionPane.showMessageDialog(null, "Välkommen spelare 2: " + name);
            boardGUI = new BoardGUI(this);
            boardGUI.getPnlPlayer1().setBorder(BorderFactory.createTitledBorder(multiPlayer[0].getUserName()));
            boardGUI.getPnlPlayer2().setBorder(BorderFactory.createTitledBorder(multiPlayer[1].getUserName()));
        }
    }

    public void showInfoOnPanel() {
          /*
    När AL och AL matchas i boardgui behövs en metod som kollar vilka det är som matchats (AL & AL).
    Då behöver AL matchas med (AL i symbol.txt) och därefter hämta ut rätt info och visa det i infopanelen i boardgui.
    Använda metoden igen när kort matchas eller kalla på en metod?

     */
        if(matched) {


        }
    }

    public Card[] getPairOfCards() {
        return pairOfCards;
    }
}
