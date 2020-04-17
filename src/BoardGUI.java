import game.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Inspiration och lånade bitar ur memoryspel hämtat från stackexchange 20.04.14.
 * https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 *
 * This class contains the game board
 * @author Adel Sabanovic
 * @version 1.0
 * @version 1.1 Robert
 * @since 2020-04-16
 */
public class BoardGUI extends JFrame {

    private JPanel pnlMain = new JPanel();
    private JPanel pnlCards = new JPanel();
    private JPanel pnlMain2 = new JPanel();
    private JPanel pnlCenter = new JPanel();
    private JPanel pnlPlayer1 = new JPanel();
    private JPanel pnlPlayer2 = new JPanel();
    private JPanel pnlInfo = new JPanel();
    private JPanel pnlInfo2 = new JPanel();
    private JPanel pnlScore = new JPanel();
    // private JPanel panelBonus = new JPanel();

    private ImageIcon iconCard = new ImageIcon("images/math4.jpg");
    private ImageIcon iconPlus = new ImageIcon("images/plus.gif");
    private ImageIcon iconMinus = new ImageIcon("images/minus.gif");
    private ImageIcon iconPlus2 = new ImageIcon("images/plus.gif");
    private ImageIcon iconMinus2 = new ImageIcon("images/minus.gif");
    private ImageIcon iconPi = new ImageIcon("");
    private ImageIcon iconPi2 = new ImageIcon("");

    private ImageIcon iconBonus = new ImageIcon("images/bonus.jpg");
    private ImageIcon iconEmptyLogo = new ImageIcon();
    private ImageIcon iconMemoriaLogo = new ImageIcon("images/mem2.jpg");
    private ImageIcon iconBlueStripe = new ImageIcon("images/blue.jpg");
    private ImageIcon iconMathLogo = new ImageIcon("images/mathLogo.JPG");

    private JButton btnBonus = new JButton(iconBonus);
    private JLabel lblEmptyLogo = new JLabel(iconEmptyLogo);

    private ImageIcon[] iconArray = new ImageIcon[6];

    private JLabel lblMemoriaLogo = new JLabel(iconMemoriaLogo);
    private JLabel lblGhost = new JLabel(iconBlueStripe);
    private JLabel lblGhost2 = new JLabel(iconBlueStripe);
    private JLabel lblGhost3 = new JLabel(iconBlueStripe);
    private JLabel lblGhost4 = new JLabel(iconBlueStripe);
    private JLabel lblGhost5 = new JLabel();
    private JLabel lblGhost6 = new JLabel();
    private JLabel lblGhost7 = new JLabel(iconBlueStripe);
    private JLabel lblGhost8 = new JLabel(iconBlueStripe);
    private JLabel lblGhost9 = new JLabel(iconMathLogo);
    private JLabel lblGhost10 = new JLabel();

    // Grejer...
    private Timer timer;
    private java.util.List<Card> cards;
    private Card selectedCard;
    private Card[] pairOfCards = new Card[2];

    public BoardGUI() {
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnlMain.setBackground(Color.WHITE);
        add(pnlMain);
        pnlMain.add(lblMemoriaLogo);
        pnlMain.add(lblGhost9);
        pnlMain.add(lblGhost10);
        lblGhost9.setPreferredSize(new Dimension(135, 35));
        lblGhost10.setPreferredSize(new Dimension(265, 35));
        //label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblGhost.setPreferredSize(new Dimension(340, 20));
        lblGhost2.setPreferredSize(new Dimension(340, 20));
        lblGhost3.setPreferredSize(new Dimension(125, 20));
        lblGhost4.setPreferredSize(new Dimension(125, 20));
        lblGhost5.setPreferredSize(new Dimension(120, 18));
        lblGhost6.setPreferredSize(new Dimension(120, 18));
        lblGhost7.setPreferredSize(new Dimension(125, 20));
        lblGhost8.setPreferredSize(new Dimension(125, 20));
        pnlMain.add(pnlMain2);
        pnlMain2.setPreferredSize(new Dimension(670, 386));
        // Mpanel.setBackground(Color.WHITE);
        lblMemoriaLogo.setPreferredSize(new Dimension(250, 55));
        pnlMain2.add(pnlCards);
        //panel.setBorder(BorderFactory.createTitledBorder(""));
        pnlCards.add(lblGhost);
        pnlCards.setPreferredSize(new Dimension(380, 380));
        pnlCards.setBackground(Color.WHITE);
        //panel.add(label);

        doGuiStuff();

        pnlCards.add(lblGhost2);
        pnlMain2.add(pnlCenter);
        pnlCenter.add(lblGhost3);
        pnlCenter.setPreferredSize(new Dimension(126, 380));
        pnlCenter.setBackground(Color.WHITE);
        pnlCenter.add(pnlPlayer1).setPreferredSize(new Dimension(126, 100));
        pnlCenter.add(pnlPlayer2).setPreferredSize(new Dimension(126, 100));
        // estPanel.setBorder(BorderFactory.createTitledBorder(""));
        pnlCenter.add(lblGhost6);
        pnlCenter.add(btnBonus).setPreferredSize(new Dimension(126, 50));
        // estPanel.add(logo1).setPreferredSize(new Dimension(126,100));
        pnlPlayer1.setBorder(BorderFactory.createTitledBorder("Player one score"));
        pnlPlayer1.setBackground(Color.WHITE);
        pnlPlayer2.setBorder(BorderFactory.createTitledBorder("Player two score"));
        pnlPlayer2.setBackground(Color.WHITE);
        pnlCenter.add(lblGhost5);
        pnlCenter.add(lblGhost4);

        pnlMain2.add(pnlInfo, BorderLayout.EAST);
        pnlMain2.setBackground(Color.WHITE);
        pnlInfo.setPreferredSize(new Dimension(126, 380));
        pnlInfo.add(lblGhost7);
        pnlInfo.setBackground(Color.WHITE);
        pnlInfo.add(pnlInfo2);
        pnlInfo.add(pnlScore);
        pnlInfo.add(lblEmptyLogo).setPreferredSize(new Dimension(126, 96));
        pnlInfo.add(lblGhost8);
        pnlInfo2.setPreferredSize(new Dimension(126, 100));
        pnlScore.setPreferredSize(new Dimension(126, 100));
        pnlInfo2.setBorder(BorderFactory.createTitledBorder("Info"));
        pnlInfo2.setBackground(Color.WHITE);
        pnlScore.setBorder(BorderFactory.createTitledBorder("Highscore"));
        pnlScore.setBackground(Color.WHITE);

        // estPanel.setBorder(BorderFactory.createTitledBorder("Score"));
        // estPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // Sätter upp i konstruktorn.
    private void doGuiStuff() {
        java.util.List<Card> cardsList = new ArrayList<Card>();
        java.util.List<String> cardSymbolPaths = new ArrayList<String>();

        // Skapa jämna par av symboler. (fler symboler)
        for (int i = 0; i < 4; i++) {
            cardSymbolPaths.add("images/minus.gif");
            cardSymbolPaths.add("images/plus.gif");
            cardSymbolPaths.add("images/plus2.jpg");
            cardSymbolPaths.add("images/minus2.jpg");
            cardSymbolPaths.add("images/pi.jpg");
            cardSymbolPaths.add("images/pi2.jpg");
        }

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

        setupTimer();

        for (Card card : cards) {
            pnlMain.add(card);
            pnlCards.add(card);
        }
    }

    // Timer setup
    private void setupTimer() {
        // Fördröjning på visning av kort på EDT.
        timer = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                checkCards();
            }
        });
        timer.setRepeats(false);
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
                this.dispose();
                new BoardGUI();
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
     *    Kontrollerar om spelet är slut.
     */
    private boolean isGameWon() {
        for (Card card : this.cards) {
            if (!card.getMatched()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new BoardGUI();
    }
}



