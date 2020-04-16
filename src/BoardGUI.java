import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the game board
 * @author Adel Sabanovic
 * @version 1.0
 * @since 2020-04-16
 */
public class BoardGUI extends JFrame implements ActionListener {

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

    private JButton btn1 = new JButton(iconCard);
    private JButton btn2 = new JButton(iconCard);
    private JButton btn3 = new JButton(iconCard);
    private JButton btn4 = new JButton(iconCard);
    private JButton btn5 = new JButton(iconCard);
    private JButton btn6 = new JButton(iconCard);
    private JButton btn7 = new JButton(iconCard);
    private JButton btn8 = new JButton(iconCard);
    private JButton btn9 = new JButton(iconCard);
    private JButton btn10 = new JButton(iconCard);
    private JButton btn11 = new JButton(iconCard);
    private JButton btn12 = new JButton(iconCard);
    private JButton btn13 = new JButton(iconCard);
    private JButton btn14 = new JButton(iconCard);
    private JButton btn15 = new JButton(iconCard);
    private JButton btn16 = new JButton(iconCard);
    private JButton btn17 = new JButton(iconCard);
    private JButton btn18 = new JButton(iconCard);
    private JButton btn19 = new JButton(iconCard);
    private JButton btn20 = new JButton(iconCard);
    private JButton btn21 = new JButton(iconCard);
    private JButton btn22 = new JButton(iconCard);
    private JButton btn23 = new JButton(iconCard);
    private JButton btn24 = new JButton(iconCard);

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

        //TODO - Ska kortas ner med en for-loop.
        pnlMain.add(btn1);
        btn1.setPreferredSize(new Dimension(52, 72));
        btn1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn1.setBackground(Color.WHITE);

        pnlMain.add(btn2);
        btn2.setPreferredSize(new Dimension(52, 72));
        btn2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn2.setBackground(Color.WHITE);

        pnlMain.add(btn3);
        btn3.setPreferredSize(new Dimension(52, 72));
        btn3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn3.setBackground(Color.WHITE);

        pnlMain.add(btn4);
        btn4.setPreferredSize(new Dimension(52, 72));
        btn4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn4.setBackground(Color.WHITE);

        pnlMain.add(btn5);
        btn5.setPreferredSize(new Dimension(52, 72));
        btn5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn5.setBackground(Color.WHITE);

        pnlMain.add(btn6);
        btn6.setPreferredSize(new Dimension(52, 72));
        btn6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn6.setBackground(Color.WHITE);

        pnlMain.add(btn7);
        btn7.setPreferredSize(new Dimension(52, 72));
        btn7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn7.setBackground(Color.WHITE);

        pnlMain.add(btn8);
        btn8.setPreferredSize(new Dimension(52, 72));
        btn8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn8.setBackground(Color.WHITE);

        pnlMain.add(btn9);
        btn9.setPreferredSize(new Dimension(52, 72));
        btn9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn9.setBackground(Color.WHITE);

        pnlMain.add(btn10);
        btn10.setPreferredSize(new Dimension(52, 72));
        btn10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn10.setBackground(Color.WHITE);

        pnlMain.add(btn11);
        btn11.setPreferredSize(new Dimension(52, 72));
        btn11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn11.setBackground(Color.WHITE);

        pnlMain.add(btn12);
        btn12.setPreferredSize(new Dimension(52, 72));
        btn12.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn12.setBackground(Color.WHITE);

        pnlMain.add(btn13);
        btn13.setPreferredSize(new Dimension(52, 72));
        btn13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn13.setBackground(Color.WHITE);

        pnlMain.add(btn14);
        btn14.setPreferredSize(new Dimension(52, 72));
        btn14.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn14.setBackground(Color.WHITE);

        pnlMain.add(btn15);
        btn15.setPreferredSize(new Dimension(52, 72));
        btn15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn15.setBackground(Color.WHITE);

        pnlMain.add(btn16);
        btn16.setPreferredSize(new Dimension(52, 72));
        btn16.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn16.setBackground(Color.WHITE);

        pnlMain.add(btn17);
        btn17.setPreferredSize(new Dimension(52, 72));
        btn17.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn17.setBackground(Color.WHITE);

        pnlMain.add(btn18);
        btn18.setPreferredSize(new Dimension(52, 72));
        btn18.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn18.setBackground(Color.WHITE);

        pnlMain.add(btn19);
        btn19.setPreferredSize(new Dimension(52, 72));
        btn19.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn19.setBackground(Color.WHITE);

        pnlMain.add(btn20);
        btn20.setPreferredSize(new Dimension(52, 72));
        btn20.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn20.setBackground(Color.WHITE);

        pnlMain.add(btn21);
        btn21.setPreferredSize(new Dimension(52, 72));
        btn21.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn21.setBackground(Color.WHITE);

        pnlMain.add(btn22);
        btn22.setPreferredSize(new Dimension(52, 72));
        btn22.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn22.setBackground(Color.WHITE);

        pnlMain.add(btn23);
        btn23.setPreferredSize(new Dimension(52, 72));
        btn23.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn23.setBackground(Color.WHITE);

        pnlMain.add(btn24);
        btn24.setPreferredSize(new Dimension(52, 72));
        btn24.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn24.setBackground(Color.WHITE);


        //TODO - Ska kortas ner med en for-loop.
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);
        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);
        btn17.addActionListener(this);
        btn18.addActionListener(this);
        btn19.addActionListener(this);
        btn20.addActionListener(this);
        btn21.addActionListener(this);
        btn22.addActionListener(this);
        btn23.addActionListener(this);
        btn24.addActionListener(this);

        pnlMain2.add(pnlCards);
        //panel.setBorder(BorderFactory.createTitledBorder(""));
        pnlCards.add(lblGhost);
        pnlCards.setPreferredSize(new Dimension(380, 380));
        pnlCards.setBackground(Color.WHITE);
        //panel.add(label);
        // TODO - Ska kortas ner med en for-loop.
        pnlCards.add(btn1);
        pnlCards.add(btn2);
        pnlCards.add(btn3);
        pnlCards.add(btn4);
        pnlCards.add(btn5);
        pnlCards.add(btn6);
        pnlCards.add(btn7);
        pnlCards.add(btn8);
        pnlCards.add(btn9);
        pnlCards.add(btn10);
        pnlCards.add(btn11);
        pnlCards.add(btn12);
        pnlCards.add(btn13);
        pnlCards.add(btn14);
        pnlCards.add(btn15);
        pnlCards.add(btn16);
        pnlCards.add(btn17);
        pnlCards.add(btn18);
        pnlCards.add(btn19);
        pnlCards.add(btn20);
        pnlCards.add(btn21);
        pnlCards.add(btn22);
        pnlCards.add(btn23);
        pnlCards.add(btn24);
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

        this.iconArray = randomIconArray();

    }

    //TODO - Ska kortas ner med en for-loop.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            Image temp = iconArray[0].getImage();
            Image resizedImage = temp.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            btn1.setIcon(icon);

        }
        if (e.getSource() == btn2) {
            Image temp = iconArray[1].getImage();
            Image resizedImage = temp.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            btn2.setIcon(icon);

        }
        if (e.getSource() == btn3) {
            Image temp = iconArray[2].getImage();
            Image resizedImage = temp.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            btn3.setIcon(icon);
        }
        if (e.getSource() == btn4) {
            Image temp = iconArray[3].getImage();
            Image resizedImage = temp.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            btn4.setIcon(icon);
        }
        if (e.getSource() == btn5) {
            Image temp = iconArray[4].getImage();
            Image resizedImage = temp.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            btn5.setIcon(icon);
        }
        if (e.getSource() == btn6) {
            Image temp = iconArray[5].getImage();
            Image resizedImage = temp.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            btn6.setIcon(icon);
        }
    }

    /**
     * Shuffles the player cards randomly on the player board
     * https://stackoverflow.com/questions/47577638/create-a-memory-game-using-jbuttons
     */

    private ImageIcon[] randomIconArray() {
        iconArray[0] = iconPlus;
        iconArray[1] = iconMinus;
        iconArray[2] = iconPlus2;
        iconArray[3] = iconMinus2;
        iconArray[4] = iconPi;
        iconArray[5] = iconPi2;

//Källa
        for (int i = iconArray.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            ImageIcon temp = iconArray[i];
            iconArray[i] = iconArray[j];
            iconArray[j] = temp;
        }
        return iconArray;
    }

    public static void main(String[] args) {
        BoardGUI guiTest = new BoardGUI();
    }
}



