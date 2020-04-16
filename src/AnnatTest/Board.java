package AnnatTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
Länk till spelet: https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 */

public class Board extends JFrame {
    private List<Card> cards;
    private Card selectedCard;
    private Card card1;
    private Card card2;
    private Timer timer;

    public Board(){

        int pairs = 10;

        List<Card> cardsList = new ArrayList<Card>();
        List<String> cardSymbols = new ArrayList<String>();

        for (int i = 0; i < pairs; i++){
            cardSymbols.add("images/minus.gif");
            cardSymbols.add("images/plus.gif");
        }

        Collections.shuffle(cardSymbols);

        for (String symbol : cardSymbols){
            Card card = new Card();
            card.setSymbol(symbol);
            card.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = card;
                    doTurn();
                }
            });
            cardsList.add(card);
        }

        for (Card card : cardsList) {
            card.setIcon(new ImageIcon("images/math4.jpg"));
        }

        this.cards = cardsList;
        //set up the timer
        timer = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        timer.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Memory Match");
    }

    public void doTurn(){
        if (card1 == null && card2 == null){
            card1 = selectedCard;
            card1.setIcon(new ImageIcon(card1.getSymbol()));
        }

        if (card1 != null && card1 != selectedCard && card2 == null){
            card2 = selectedCard;
            card2.setIcon(new ImageIcon(card2.getSymbol()));
            timer.start();
        }
    }

    public void checkCards(){
        if (card1.getSymbol().equals(card2.getSymbol())) { //match condition
            card1.setEnabled(false); //disables the button
            card2.setEnabled(false);
            card1.setMatched(true); //flags the button as having been matched
            card2.setMatched(true);
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }

        else{
            card1.setIcon(new ImageIcon("images/math4.jpg")); //'hides' text
            card2.setIcon(new ImageIcon("images/math4.jpg"));
        }
        card1 = null; //reset c1 and c2
        card2 = null;
    }

    public boolean isGameWon(){
        for(Card card: this.cards){
            if (!card.getMatched()){
                return false;
            }
        }
        return true;
    }
}
