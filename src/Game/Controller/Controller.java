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
 * Controls interaction with model and view, between different views and handles game logic.
 *
 * Inspiration och lånade bitar ur memoryspel hämtat från stackexchange 20.04.14.
 * https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 *
 * @author Robert Rosencrantz, Adel Sabanovic, Sonja Peric, Yasir Kakar, Joakim Tell
 * @version 3.0
 * TODO: Separat klass för växling mellan gui:s?
 */
public class Controller {
    private MusicController musicController = new MusicController();
    private BoardGUI boardGUI;
    private LogInGUI logInPlayer1;
    private LogInGUI logInPlayer2;

    private Rain rain;
    private InfoReader infoReader;
    private Card selectedCard;

    private Card[] pairOfCards = new Card[2];   // To handle the two cards for each round of pairings.
    private User[] multiPlayer = new User[2];   // Keeps information of logged in users.

    private boolean turnPlayer1 = true;         // Track which players turn it is.

    /**
     * Construct the controller and initialize a login view.
     */
    public Controller() {
        logInPlayer1 = new LogInGUI(this, "Player One ");
        infoReader = new InfoReader("textfiles/infopanel.txt", "textfiles/symbol.txt");
        musicController.playMusic("music/TakeMeBack.wav");
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
            //musicController.click("music/Point.wav");

            if(secondSymbol.equals("images/Jo")) {
                rain = new Rain(this);
                boardGUI.setVisible(false);
                musicController.stopMusic();
                musicController.playMusic("music/JokerRound.wav");
            } else {
                incrementScore(10);
                showInfoOnPanel();
            }

            if (isGameWon()) { //OBS! ÄNDRA TILL isGameWon()
                updatePoints();
            }
        } else {
            for (Card card : pairOfCards) {
                card.hideSymbol();
            }
            switchPlayers();
        }
        Arrays.fill(pairOfCards, null);                             // Empty the pair of cards after each round.
    }

    private void updatePoints() {
        int score1 = multiPlayer[0].getGameScore();
        int score2 = multiPlayer[1].getGameScore();
        int score1total = multiPlayer[0].getTotalPoints();
        int score2total = multiPlayer[1].getTotalPoints();
        if (score1 > score2) {
            checkWin(multiPlayer[0].getUserName());
        } else if (score2 > score1) {
            checkWin(multiPlayer[1].getUserName());
        }
        score1total += score1;
        score2total += score2;
        multiPlayer[0].setTotalPoints(score1total);
        multiPlayer[1].setTotalPoints(score2total);
        multiPlayer[0].setGameScore(0);
        multiPlayer[1].setGameScore(0);
    }

    /**
     * Shows a panel of who won the game and asks if they want to play again.
     * if yes a new boardGUI will appear.
     * @param name of who won
     */
    private void checkWin(String name) {
        int reply = JOptionPane.showConfirmDialog(null,
                "Grattis " + name + ", du vann!" + "\n" + "Vill ni spela igen?",
                "Spelet slut", JOptionPane.YES_NO_OPTION);

        if(reply == JOptionPane.YES_OPTION) {
            boardGUI.dispose();
            turnPlayer1 = true;
            boardGUI = new BoardGUI(this);
            boardGUI.getPnlPlayer1().setBorder(BorderFactory.createTitledBorder(multiPlayer[0].getUserName()));
            boardGUI.getPnlPlayer2().setBorder(BorderFactory.createTitledBorder(multiPlayer[1].getUserName()));
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
            int score1 = updateUserPoints(0, pointsToAdd);
            boardGUI.setLblScore(score1);
        } else {
            int score2 = updateUserPoints(1,pointsToAdd);
            boardGUI.setLblScore2(score2);
        }
    }

    private int updateUserPoints(int player, int pointsToAdd) {
        int score = multiPlayer[player].getGameScore() + pointsToAdd;
        multiPlayer[player].setGameScore(score);
        return multiPlayer[player].getGameScore();
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
//    public boolean test() {
//        return (multiPlayer[0].getGameScore() == 20) || (multiPlayer[1].getGameScore() == 20);
//    }

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

    /**
     * Method that matches secondsymbol with the infoHashmap.
     * Prints out a information about the pair that has been matched.
     * Will be implemented in a panel later.
     */
    private void showInfoOnPanel() {
        String secondSymbol = pairOfCards[1].getPathSymbol().substring(0, 9);
        String newString = infoReader.getInfoMap().get(secondSymbol).replaceAll("!","\n");
        boardGUI.getTxtInfoArea().setText("");
        boardGUI.getTxtInfoArea().setText(newString);
    }

    public void showBoardGUI() {
        boardGUI.setVisible(true);
    }
}
