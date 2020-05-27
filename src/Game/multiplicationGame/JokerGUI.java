package Game.multiplicationGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Contains the main parts of the GUI, where rain and drops are painted.
 * @author Robert Rosencrantz
 * @version 3.0
 */
public class JokerGUI extends JFrame {

    private JPanel pnlMain;
    private JPanel pnlTyping;
    private JPanel pnlGame;
    private JTextField textFieldPoints;
    private JLabel labelTyping;
    private JLabel lblTwoPoints;

    /**
     * Construct and initialize the GUI.
     */
    public JokerGUI() {
        labelTyping = new JLabel("") {
            @Override
            public boolean isValidateRoot() {
                return true;
            }
        };
        labelTyping.setFont(new Font("monospaced", Font.BOLD, 90));
        labelTyping.setBackground(Color.WHITE);

        setupGamePanel();
        setupTypePanel();
        setupMainPanel();
        addTwoPointsText();

        setupFrame();
        xButtonPressed();
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

        ImageIcon imageShowing = new ImageIcon("images/svar_memoria.png");
        JLabel lblLogo = new JLabel(imageShowing);

        lblLogo.setBackground(Color.WHITE);
        setupTextFieldPoints();

        pnlTyping.add(lblLogo, BorderLayout.WEST);
        JPanel pnlCenterTyping = new JPanel(new BorderLayout());
        pnlCenterTyping.setBackground(Color.WHITE);
        pnlCenterTyping.add(labelTyping, BorderLayout.CENTER);
        pnlTyping.add(pnlCenterTyping, BorderLayout.CENTER);
        pnlTyping.add(textFieldPoints, BorderLayout.EAST);
    }

    private void setupGamePanel() {
        pnlGame = new JPanel();
        pnlGame.setBackground(Color.WHITE);
    }

    private void setupTextFieldPoints() {
        textFieldPoints = new JTextField("0p  ");
        textFieldPoints.setFont(new Font("monospaced", Font.BOLD, 80));
        textFieldPoints.setBackground(Color.WHITE);
        textFieldPoints.setForeground(Color.BLACK);
        textFieldPoints.setEditable(false);
        textFieldPoints.setFocusable(false);
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
                addTwoPointsThread();
            }
        });
    }

    private void addTwoPointsThread() {
        new Thread(){
            @Override
            public void run() {
                lblTwoPoints.setVisible(true);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lblTwoPoints.setVisible(false);
            }
        }.start();
    }

    /**
     * Show final points in large numbers after game ends.
     */
    public void addPointsText() {
        JLabel lblFinalPoints = new JLabel("GRATTIS: " + textFieldPoints.getText());
        lblFinalPoints.setHorizontalAlignment(SwingConstants.CENTER);
        lblFinalPoints.setVerticalAlignment(SwingConstants.CENTER);
        lblFinalPoints.setSize(1000, 500);
        lblFinalPoints.setFont(new Font("monospaced", Font.BOLD, 100));           // Enlarge font size
        lblFinalPoints.setForeground(Color.BLACK);

        pnlGame.add(lblFinalPoints);
        revalidate();
    }

    private void addTwoPointsText() {
        lblTwoPoints = new JLabel(new ImageIcon("images/plus_two_points.png")){
            @Override
            public boolean isValidateRoot() {
                return true;
            }
        };
        lblTwoPoints.setHorizontalAlignment(SwingConstants.CENTER);
        lblTwoPoints.setVerticalAlignment(SwingConstants.CENTER);
        lblTwoPoints.setSize(1000, 500);
        lblTwoPoints.setVisible(false);

        pnlGame.add(lblTwoPoints);
        revalidate();
    }

    @Override
    public void setFocusable(boolean b) {
        super.setFocusable(b);
    }

    private String answerTyped = "";

    public String getAnswerTyped() {
        return answerTyped;
    }

    public void setLabelTyping(String answer) {
        answerTyped = answer;
    }

    private class TypeListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {

            char c = e.getKeyChar();

            if ("1234567890".contains(String.valueOf(c))) {
                if (answerTyped.length() == 1) {
                    answerTyped += String.valueOf(c);

                } else {
                    answerTyped = String.valueOf(c);
                }
            }

            labelTyping.setText(answerTyped);
            repaint();

            // Print out the code
            System.out.println(c);
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    /**
     * If X on frame i pressed asks the user if the want to close the program.
     */
    public void xButtonPressed() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int x = JOptionPane.showConfirmDialog(null,
                        "Do you really want to close Memoria?");
                if(x==JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                } else {
                    System.out.println("We are happy you are back :)");
                }
            }
        });
    }
}