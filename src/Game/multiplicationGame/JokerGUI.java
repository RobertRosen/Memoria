package Game.multiplicationGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Contains the main parts of the GUI, where rain and drops are painted.
 * @author Robert Rosencrantz
 * @version 3.0
 */
public class JokerGUI extends JFrame {

    private JPanel pnlMain;
    private JPanel pnlTyping;
    private JPanel pnlGame;
    private JTextField textFieldUserTyping;
    private JTextField textFieldPoints;

    private JLabel labelAnswer;
    private JLabel labelTyping;

    /**
     * Construct and initialize the GUI.
     */
    public JokerGUI() {
        labelAnswer = new JLabel("Answer: ");
        labelTyping = new JLabel("") {
            @Override
            public boolean isValidateRoot() {
                return true;
            }
        };
        labelAnswer.setFont(new Font("monospaced", Font.BOLD, 44));
        labelTyping.setFont(new Font("monospaced", Font.BOLD, 44));
        labelAnswer.setBackground(Color.WHITE);
        labelTyping.setBackground(Color.WHITE);


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

        addKeyListener(new TypeListener());
        setFocusable(true);

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

        ImageIcon imageShowing = new ImageIcon("images/mem2.jpg");
//        Image imageToScale = imageShowing.getImage();
//        Image scaledImage = imageToScale.getScaledInstance(500, 100, Image.SCALE_SMOOTH);
//        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel lblLogo = new JLabel(imageShowing);

        lblLogo.setBackground(Color.WHITE);

        setupTextFieldUserTyped();
        setupTextFieldPoints();

        pnlTyping.add(lblLogo, BorderLayout.WEST);
//        pnlTyping.add(textFieldUserTyping, BorderLayout.CENTER);
        JPanel pnlCenterTyping = new JPanel(new BorderLayout());
        pnlCenterTyping.setBackground(Color.WHITE);
        pnlCenterTyping.add(labelAnswer, BorderLayout.WEST);
        pnlCenterTyping.add(labelTyping, BorderLayout.CENTER);
        pnlTyping.add(pnlCenterTyping, BorderLayout.CENTER);
        pnlTyping.add(textFieldPoints, BorderLayout.EAST);
    }

    private void setupGamePanel() {
        pnlGame = new JPanel();
        pnlGame.setBackground(Color.WHITE);
        pnlGame.setLayout(new BorderLayout());

        ImageIcon imageShowing = new ImageIcon("images/joker_get_answers.png");
        Image imageToScale = imageShowing.getImage();
        Image scaledImage = imageToScale.getScaledInstance(1000, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel lblGameChallenge = new JLabel(scaledImageIcon);

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
    public void addDropToGamePanel(CardDrop drop) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pnlGame.add(drop);
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

    public void setTextFieldUserTyping(String answer) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textFieldUserTyping.setText(answer);
            }
        });
    }

    public String getTextFieldUserTyping() {
        return textFieldUserTyping.getText();
    }

    /**
     * Show final points in large numbers after game ends.
     */
    public void addPointsText() {
        JLabel lblFinalPoints = new JLabel(textFieldPoints.getText());
        lblFinalPoints.setHorizontalAlignment(SwingConstants.CENTER);
        lblFinalPoints.setVerticalAlignment(SwingConstants.CENTER);
        lblFinalPoints.setSize(1000, 500);
        lblFinalPoints.setFont(new Font("monospaced", Font.BOLD, 290));           // Enlarge font size
        lblFinalPoints.setForeground(Color.BLUE);
        pnlGame.add(lblFinalPoints);
        revalidate();
    }

    @Override
    public void setFocusable(boolean b) {
        super.setFocusable(b);
    }

    private String answerTyped = "";

    public String getLabelTyping() {
        return labelTyping.getText();
    }

    public String getAnswerTyped() {
        return answerTyped;
    }

    public void setLabelTyping(String answer) {
        answerTyped = answer;
//        labelTyping.setText(answerTyped);
    }

    private class TypeListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();

            if (answerTyped.length() == 1) {
                answerTyped += String.valueOf(c);
            } else {
                answerTyped = String.valueOf(c);
            }

            labelTyping.setText(answerTyped);
            repaint();

            // Print out the code
            System.out.println(c);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}