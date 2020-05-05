package Game.Controller;

import Game.Model.Card;
import Game.Model.InfoReader;
import Game.Model.User;
import Game.View.BoardGUI;
import Game.View.LogInGUI;
import Game.View.MenuGUI;
import Game.multiplicationGame.Rain;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author
 * Controls interaction with model and view, between different views and handles game logic.
 * @version 1.0
 * TODO: Separat klass för växling mellan gui:s?
 */
public class Controller {
    private BoardGUI boardGUI;
    private LogInGUI logInPlayer1;
    private LogInGUI logInPlayer2;
    private Rain rain;

    private InfoReader infoReader;

    private Card selectedCard;

    private Card[] pairOfCards = new Card[2];   // To handle the two cards for each round of pairings.
    private User[] multiPlayer = new User[2];   // Keeps information of logged in users.

    private boolean turnPlayer1 = true;         // Track which players turn it is.
    private int scorePlayer1;
    private int scorePlayer2;

    /**
     * Construct the controller and initialize a login view.
     */
    public Controller() {
        logInPlayer1 = new LogInGUI(this, "Player One ");
        infoReader = new InfoReader("textfiles/infopanel.txt", "textfiles/symbol.txt");
    }

    /**
     * Check if chosen card is first or second in a round.
     * Turn chosen card and delay if it is second card.
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
     * Check for matching cards and acts accordingly.
     */
    public void checkCards() {
        String firstSymbol = pairOfCards[0].getPathSymbol().substring(0, 9);
        String secondSymbol = pairOfCards[1].getPathSymbol().substring(0, 9);

        if (firstSymbol.equals(secondSymbol)) {
            // Disable buttons and flag as matched.
            pairOfCards[0].setEnabled(false);
            pairOfCards[1].setEnabled(false);
            pairOfCards[0].setMatched(true);
            pairOfCards[1].setMatched(true);

            if(secondSymbol.equals("images/Jo")) {
                rain = new Rain(this);
                boardGUI.setVisible(false);
            } else {
                incrementScore(10);
                showInfoOnPanel();
            }

            if (isGameWon()) { //OBS! ÄNDRA TILL isGameWon()
                if (scorePlayer1 > scorePlayer2) {
                   checkWin(multiPlayer[0].getUserName());
                } else if (scorePlayer2 > scorePlayer1) {
                    checkWin(multiPlayer[1].getUserName());
                }
            }
        } else {
            for (Card card : pairOfCards) {
                card.hideSymbol();
            }
            switchPlayers();
        }
        Arrays.fill(pairOfCards, null);                             // Empty the pair of cards after each round.
    }

    private void checkWin(String name) {
        int reply = JOptionPane.showConfirmDialog(null,
                "Grattis " + name + ", du vann!" + "\n" + "Vill ni spela igen?",
                "Spelet slut", JOptionPane.YES_NO_OPTION);

        if(reply == JOptionPane.YES_OPTION) {
            boardGUI.dispose();
            turnPlayer1 = true;
            scorePlayer1 = -10; //kompenserar för andra skeenden i koden
            scorePlayer2 = 0;
            boardGUI = new BoardGUI(this);
            boardGUI.revalidate();
        } else {
            System.exit(0);
        }
    }

    /**
     * Updated score in the view.
     */
    private void incrementScore(int pointsToAdd) {
        if (turnPlayer1) {
            boardGUI.setLblScore(scorePlayer1 += pointsToAdd);
        } else {
            boardGUI.setLblScore2(score2Player2 += pointsToAdd);
        }
    }

    /**
     * Update score from joker round.
     */
    public void addJokerPoints() {
        int jokerPoints = rain.getPoints();
        incrementScore(jokerPoints);
    }

    /**
     * To indicate in the view which player's round it is.
     * And turn all cards, symbol down.
     */
    private void switchPlayers() {
        if (turnPlayer1) {
            boardGUI.highlightPlayer2();
            turnPlayer1 = false;
        } else {
            boardGUI.highlightPlayer1();
            turnPlayer1 = true;
        }
    }

    /**
     * Returns true when all cards are ultimately out of play.
     */
    private boolean isGameWon() {
        for (Card card : boardGUI.getCards()) {
            if (!card.isMatched()) {
                return false;
            }
        }
        return true;
    }

    //TEST ska ej vara kvar, bara för att vinnna spelet snabbare vid 20 p
    public boolean test() {
            if ((scorePlayer1 == 20) || (scorePlayer2 == 20)) {
                return false;
            }
        return true;
    }

    /**
     * Open login view for second player to sign in.
     */
    public void switchGUI() {
        logInPlayer2 = new LogInGUI(this, "Player Two");
    }

    /**
     * Create a player from login window.
     * Go to menu after first player.
     * Go to game after second player and set names at view.
     */
    public void createUser() {
        if (multiPlayer[0] == null) {
            String name = logInPlayer1.getTxtUsername().getText();
            multiPlayer[0] = new User(name);
            JOptionPane.showMessageDialog(null, "Välkommen spelare 1: " + name);
            new MenuGUI(this);
        } else {
            String name = logInPlayer2.getTxtUsername().getText();
            multiPlayer[1] = new User(name);
            JOptionPane.showMessageDialog(null, "Välkommen spelare 2: " + name);
            boardGUI = new BoardGUI(this);
            boardGUI.getPnlPlayer1().setBorder(BorderFactory.createTitledBorder(multiPlayer[0].getUserName()));
            boardGUI.getPnlPlayer2().setBorder(BorderFactory.createTitledBorder(multiPlayer[1].getUserName()));
        }
    }

    private void showInfoOnPanel() {
        String secondSymbol = pairOfCards[1].getPathSymbol().substring(0, 9);

        System.out.println(infoReader.getInfoMap().get(secondSymbol));
    }

    public void showBoardGUI() {
        boardGUI.setVisible(true);
    }
}
