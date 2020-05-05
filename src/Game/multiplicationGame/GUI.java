package Game.multiplicationGame;

import javax.swing.*;
import java.awt.*;

/**
 * Contains the main parts of the GUI.
 *
 * @author Robert Rosencrantz
 */
public class GUI extends JFrame {

    private JPanel pnlMain;
    private JPanel pnlTyping;
    private JPanel pnlGame;
    private JTextField textFieldWordTyped;
    private JTextField textFieldPoints;

    /**
     * Construct and initialize the GUI.
     */
    public GUI() {
        setupGamePanel();
        setupTypePanel();
        setupMainPanel();
        setupFrame();
    }

    private void setupFrame() {
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setTitle("The Best Words");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        setVisible(true);
        setResizable(false);
        pack();
    }

    private void setupMainPanel() {
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        pnlMain.setPreferredSize(new Dimension(1000, 600));

        pnlMain.add(pnlTyping, BorderLayout.NORTH);
        pnlMain.add(pnlGame, BorderLayout.CENTER);
    }

    private void setupTypePanel() {
        pnlTyping = new JPanel(new BorderLayout());

        JLabel lblTrump = new JLabel();
        lblTrump.setIcon(new ImageIcon("images/i_know_words.jpg"));

        setupTextFieldWordTyped();
        setupTextFieldPoints();

        pnlTyping.add(lblTrump, BorderLayout.WEST);
        pnlTyping.add(textFieldWordTyped, BorderLayout.CENTER);
        pnlTyping.add(textFieldPoints, BorderLayout.EAST);
    }

    private void setupGamePanel() {
        pnlGame = new JPanel();
        pnlGame.setBackground(Color.BLACK);
    }

    private void setupTextFieldWordTyped() {
        textFieldWordTyped = new JTextField("");
        textFieldWordTyped.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        textFieldWordTyped.setBackground(Color.BLACK);
        textFieldWordTyped.setForeground(Color.WHITE);
        textFieldWordTyped.setOpaque(true);
        textFieldWordTyped.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    private void setupTextFieldPoints() {
        textFieldPoints = new JTextField("0p  ");
        textFieldPoints.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        textFieldPoints.setBackground(Color.BLACK);
        textFieldPoints.setForeground(Color.WHITE);
        textFieldPoints.setOpaque(true);
        textFieldPoints.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    /**
     * Updates the GUI on the EDT
     * @param word Word (implements JTextField) to add on GUI.
     */
    public void setPnlGame(WordDrop word) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pnlGame.add(word);
            }
        });
    }

    public void setTextFieldWordTyped(String text) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textFieldWordTyped.setText(text);
            }
        });
    }

    public void setTextFieldPoints(int points) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textFieldPoints.setText(points + "p");
            }
        });
    }

    public String getTextFieldWordTyped() {
        return textFieldWordTyped.getText();
    }
}