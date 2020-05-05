package Game.multiplicationGame;

import javax.swing.*;
import java.awt.*;

/**
 * Contains the main parts of the GUI, where rain and drops are painted.
 * @author Robert Rosencrantz
 * @version 0.0
 */
public class JokerGUI extends JFrame {

    private JPanel pnlMain;
    private JPanel pnlTyping;
    private JPanel pnlGame;
    private JTextField textFieldUserTyping;
    private JTextField textFieldPoints;

    /**
     * Construct and initialize the GUI.
     */
    public JokerGUI() {
        setupGamePanel();
        setupTypePanel();
        setupMainPanel();
        setupFrame();
    }

    private void setupFrame() {
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setTitle("JOKER ROUND");
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
        pnlTyping.setBackground(Color.WHITE);

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon("images/mem2.jpg"));
        lblLogo.setBackground(Color.WHITE);

        setupTextFieldUserTyped();
        setupTextFieldPoints();

        pnlTyping.add(lblLogo, BorderLayout.WEST);
        pnlTyping.add(textFieldUserTyping, BorderLayout.CENTER);
        pnlTyping.add(textFieldPoints, BorderLayout.EAST);
    }

    private void setupGamePanel() {
        pnlGame = new JPanel();
        pnlGame.setBackground(Color.WHITE);
        pnlGame.setLayout(new BorderLayout());

        JLabel lblGameChallenge = new JLabel("Get as many right answers as you can!");
        lblGameChallenge.setLocation(0,139);
        lblGameChallenge.setSize(1000, 200);
        lblGameChallenge.setFont(new Font("monospaced", Font.BOLD, 45));         // Enlarge font size
        lblGameChallenge.setForeground(Color.BLUE);

        pnlGame.add(lblGameChallenge, BorderLayout.SOUTH);
    }

    private void setupTextFieldUserTyped() {
        textFieldUserTyping = new JTextField("");
        textFieldUserTyping.setFont(new Font("monospaced", Font.BOLD, 24));
        textFieldUserTyping.setBackground(Color.WHITE);
        textFieldUserTyping.setForeground(Color.BLACK);
        textFieldUserTyping.setOpaque(true);
        textFieldUserTyping.setBorder(null);;
    }

    private void setupTextFieldPoints() {
        textFieldPoints = new JTextField("0p  ");
        textFieldPoints.setFont(new Font("monospaced", Font.BOLD, 80));
        textFieldPoints.setBackground(Color.WHITE);
        textFieldPoints.setForeground(Color.BLACK);
        textFieldPoints.setOpaque(true);
        textFieldPoints.setBorder(null);
    }

    /**
     * Updates the GUI on the EDT
     * @param drop Drop (implements JTextField) to add on GUI.
     */
    public void setPnlGame(Drop drop) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pnlGame.add(drop);
            }
        });
    }

    public void setTextFieldUserTyping(String answer) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textFieldUserTyping.setText(answer);
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

    public String getTextFieldUserTyping() {
        return textFieldUserTyping.getText();
    }
}