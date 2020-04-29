package Game.Model;

import Game.Game;

public class User {

    private String userName;
    private int totalPoints;
    private int gameScore;

    public User() {

    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, int totalPoints) {
        this.totalPoints = totalPoints;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    /*
    Som en användare behöver jag ett användarnamn, poäng under tiden jag spelar en match, totala poäng.
    set och get metoder
    konstruktor
     */
}
