import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Inspiration och lånade bitar ur memoryspel hämtat från stackexchange 20.04.14.
 * https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 * <p>
 * This class contains the game board
 *
 * @author Adel Sabanovic
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
    private JPanel pnlCardsLayout = new JPanel();

    private ImageIcon iconBonus = new ImageIcon("images/bonus.jpg");
    private ImageIcon iconEmptyLogo = new ImageIcon();
    private ImageIcon iconMemoriaLogo = new ImageIcon("images/mem2.jpg");
    private ImageIcon iconBlueStripe = new ImageIcon("images/blue.jpg");
    private ImageIcon iconMathLogo = new ImageIcon("images/mathLogo.JPG");

    private JButton btnBonus = new JButton(iconBonus);

    private JLabel lblEmptyLogo = new JLabel(iconEmptyLogo);
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

    GameController gameController;
    public BoardGUI(GameController gameController) {
        this.gameController = gameController;
        setupFrame();
        setupComponentsSizes();
        setupComponents();
        addComponents();
        setupTheGame();
    }

    private void setupFrame() {
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pnlMain);
    }

    private void addComponents() {
        pnlMain.add(lblMemoriaLogo);
        pnlMain.add(lblGhost9);
        pnlMain.add(lblGhost10);
        pnlMain.add(pnlMain2);
        pnlCenter.add(lblGhost3);
        pnlCenter.add(pnlPlayer1);
        pnlCenter.add(pnlPlayer2);
        pnlCenter.add(lblGhost6);
        pnlCenter.add(btnBonus);
        pnlCenter.add(lblGhost5);
        pnlCenter.add(lblGhost4);
        pnlMain2.add(pnlCards);
        pnlMain2.add(pnlCenter);
        pnlCards.add(lblGhost);
        pnlCards.add(pnlCardsLayout);
        pnlCards.add(lblGhost2);
        pnlMain2.add(pnlInfo, BorderLayout.EAST);
        pnlInfo.add(lblGhost7);
        pnlInfo.add(pnlInfo2);
        pnlInfo.add(pnlScore);
        pnlInfo.add(lblEmptyLogo);
        pnlInfo.add(lblGhost8);
    }

    private void setupComponentsSizes() {
        pnlMain2.setPreferredSize(new Dimension(670, 386));
        lblMemoriaLogo.setPreferredSize(new Dimension(250, 55));
        lblEmptyLogo.setPreferredSize(new Dimension(126, 96));
        pnlCards.setPreferredSize(new Dimension(380, 380));
        pnlCardsLayout.setPreferredSize(new Dimension(380, 305));
        lblGhost.setPreferredSize(new Dimension(340, 20));
        lblGhost2.setPreferredSize(new Dimension(340, 20));
        lblGhost3.setPreferredSize(new Dimension(125, 20));
        lblGhost4.setPreferredSize(new Dimension(125, 20));
        lblGhost5.setPreferredSize(new Dimension(120, 18));
        lblGhost6.setPreferredSize(new Dimension(120, 18));
        lblGhost7.setPreferredSize(new Dimension(125, 20));
        lblGhost8.setPreferredSize(new Dimension(125, 20));
        lblGhost9.setPreferredSize(new Dimension(135, 35));
        lblGhost10.setPreferredSize(new Dimension(265, 35));
        pnlInfo2.setPreferredSize(new Dimension(126, 100));
        pnlScore.setPreferredSize(new Dimension(126, 100));
        pnlCenter.setPreferredSize(new Dimension(126, 380));
        pnlPlayer1.setPreferredSize(new Dimension(126, 100));
        pnlPlayer2.setPreferredSize(new Dimension(126, 100));
        pnlInfo.setPreferredSize(new Dimension(126, 380));
        btnBonus.setPreferredSize(new Dimension(126, 50));
    }

    private void setupComponents() {
        pnlMain.setBackground(Color.WHITE);
        pnlCards.setBackground(Color.WHITE);
        pnlCardsLayout.setBackground(Color.WHITE);
        pnlCenter.setBackground(Color.WHITE);
        pnlPlayer1.setBackground(Color.WHITE);
        pnlPlayer2.setBackground(Color.WHITE);
        pnlMain2.setBackground(Color.WHITE);
        pnlInfo.setBackground(Color.WHITE);
        pnlInfo2.setBackground(Color.WHITE);
        pnlScore.setBackground(Color.WHITE);

        pnlPlayer1.setBorder(BorderFactory.createTitledBorder("Player one score"));
        pnlPlayer2.setBorder(BorderFactory.createTitledBorder("Player two score"));
        pnlInfo2.setBorder(BorderFactory.createTitledBorder("Info"));
        pnlScore.setBorder(BorderFactory.createTitledBorder("Highscore"));
    }


    // TODO: Skapa en CardDeck-klass för nedanstående metoder?
    private Timer timer;
    private ArrayList<Card> cards;

    // Hjälper till att sätta upp spelet i konstruktorn.
    private void setupTheGame() {
        cards = new ArrayList<Card>();
        ArrayList<String> cardSymbolPaths;

        cardSymbolPaths = addSymbols();         // Lägg bilder på korten.
        Collections.shuffle(cardSymbolPaths);   // Blanda symbolerna.
        for (String symbol : cardSymbolPaths) { // Skapa jämna par av symboler.
            Card card = new Card();
            card.setPathSymbol(symbol);
            card.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    gameController.doTurn(card);
                }
            });
            card.hideSymbol();
            cards.add(card);
        }

        setupTimer();

        for (Card card : cards) {
            pnlCardsLayout.add(card);
        }
        revalidate();
        repaint();
    }

    // Lägger bilder/symboler på alla korten.
    private ArrayList<String> addSymbols() {
        ArrayList<String> cardSymbolPaths = new ArrayList<String>();

        cardSymbolPaths.add("images/minus.gif");
        cardSymbolPaths.add("images/plus.gif");
        cardSymbolPaths.add("images/plus2.jpg");
        cardSymbolPaths.add("images/minus2.jpg");
        cardSymbolPaths.add("images/pi.jpg");
        cardSymbolPaths.add("images/pi2.jpg");
        cardSymbolPaths.add("images/Algebra1.png");
        cardSymbolPaths.add("images/Algebra2.png");
        cardSymbolPaths.add("images/ALgebra3.png");
        cardSymbolPaths.add("images/ALgebra4.png");
        cardSymbolPaths.add("images/Agebra5.png");
        cardSymbolPaths.add("images/Agebra6.png");
        cardSymbolPaths.add("images/Bråk.png");
        cardSymbolPaths.add("images/Bråk2.png");
        cardSymbolPaths.add("images/Division.png");
        cardSymbolPaths.add("images/Division2.png");
        cardSymbolPaths.add("images/Joker.png");
        cardSymbolPaths.add("images/Joker2.png");
        cardSymbolPaths.add("images/Multiplikation.png");
        cardSymbolPaths.add("images/Multiplikation2.png");
        cardSymbolPaths.add("images/Ut.png");
        cardSymbolPaths.add("images/Ut2.png");
        cardSymbolPaths.add("images/Unit.png");
        cardSymbolPaths.add("images/Unit2.png");

        return cardSymbolPaths;
    }

    /**
     * Sätter upp en timer på händelsetråden.
     */
    private void setupTimer() {
        timer = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                gameController.checkCards();
            }
        });
        timer.setRepeats(false);
    }

    public Timer getTimer() {
        return timer;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

//    public static void main(String[] args) {
//        new BoardGUI();
//    }
}