import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class contains Memorias main menu
 * @author Yasir Kakar
 * @author Adel Sabanovic
 * @version 1.0
 * @since 2020-04-16
 *
 */
public class MenuGUI extends JFrame {
    private GameController gameController;

    private JPanel pnlMain = new JPanel();
    private JPanel pnlChoosePlayer = new JPanel();
    private JPanel pnlSettings = new JPanel();
    private JPanel pnlWest = new JPanel();

    private ScoreGUI scoreGUI = new ScoreGUI();

    private ImageIcon iconLogo = new ImageIcon("images/mem3.JPG");
    private ImageIcon iconMthLogo = new ImageIcon("images/mathLogo.JPG");
    private ImageIcon iconBeatLogo = new ImageIcon("images/beat2.JPG");
    private ImageIcon iconSingle = new ImageIcon("images/single.JPG");
    private ImageIcon iconMulti = new ImageIcon("images/multi.JPG");
    private ImageIcon iconGear = new ImageIcon("images/gear.jpg");
    private ImageIcon iconOption = new ImageIcon("images/QM2.JPG");
    private ImageIcon iconPi = new ImageIcon("images/pi.JPG");

    private JButton btnSettings = new JButton(iconGear);
    private JButton btnHelp = new JButton(iconOption);
    private JButton btnSinglePlayer = new JButton(iconSingle);
    private JButton btnMultiPlayer = new JButton(iconMulti);

    private JLabel lblMemoria = new JLabel(iconLogo);
    private JLabel lblMathLogo = new JLabel(iconMthLogo);
    private JLabel lblBeat = new JLabel(iconBeatLogo);

    private JLabel lblGhost = new JLabel();
    private JLabel lblGhost2 = new JLabel();
    private JLabel lblGhost3 = new JLabel();
    private JLabel lblGhost4 = new JLabel();
    private JLabel lblGhost5 = new JLabel();
    private JLabel lblGhost6 = new JLabel();
    private JLabel lblGhost7 = new JLabel();

    private JLabel lblPiSinglePlayer = new JLabel(iconPi);
    private JLabel lblPiMultiPlayer = new JLabel(iconPi);
    private JLabel lblPiSettings = new JLabel(iconPi);
    private JLabel lblPiHelp = new JLabel(iconPi);


    /**
     * This method contains Memorias main menu GUI
     * @author Yasir Kakar
     * @author Adel Sabanovic
     * @version 1.0
     * @since 2020-04-16
     */
    //TODO ska kortas ner med en for-loop och hjälpmetoder
    public MenuGUI(GameController gameController) {
        this.gameController = gameController;

        setSize(940, 430);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnlMain.setBackground(Color.WHITE);

        add(pnlMain);
        pnlMain.add(pnlWest);
        pnlWest.setPreferredSize(new Dimension(450, 340));
        pnlWest.setBackground(Color.WHITE);
        pnlWest.add(lblGhost);
        pnlWest.add(lblMemoria);
        pnlWest.add(lblMathLogo);
        pnlWest.add(lblGhost3);
        pnlWest.add(lblBeat);
        pnlWest.add(pnlChoosePlayer);
        pnlWest.add(pnlSettings);

        lblPiSinglePlayer.setPreferredSize(new Dimension(40, 40));
        lblPiSinglePlayer.setVisible(false);
        lblPiMultiPlayer.setPreferredSize(new Dimension(40, 40));
        lblPiMultiPlayer.setVisible(false);
        lblPiSettings.setPreferredSize(new Dimension(40, 40));
        lblPiSettings.setVisible(false);
        lblPiHelp.setPreferredSize(new Dimension(40, 40));
        lblPiHelp.setVisible(false);

        lblGhost4.setPreferredSize(new Dimension(30, 40));
        lblGhost5.setPreferredSize(new Dimension(30, 40));
        lblGhost6.setPreferredSize(new Dimension(19, 40));
        lblGhost7.setPreferredSize(new Dimension(26, 40));
        lblGhost.setPreferredSize(new Dimension(40, 40));
        lblMemoria.setPreferredSize(new Dimension(260, 40));
        lblBeat.setPreferredSize(new Dimension(450, 70));

        pnlWest.add(pnlChoosePlayer).setPreferredSize(new Dimension(350, 130));
        pnlChoosePlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlChoosePlayer.setBackground(Color.WHITE);
        pnlChoosePlayer.add(lblPiSinglePlayer);
        pnlChoosePlayer.add(btnSinglePlayer);
        pnlChoosePlayer.add(lblGhost4);
        btnSinglePlayer.setBackground(Color.WHITE);
        btnSinglePlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlChoosePlayer.add(lblGhost2);
        lblGhost2.setPreferredSize(new Dimension(300, 30));
        pnlChoosePlayer.add(lblPiMultiPlayer);
        pnlChoosePlayer.add(btnMultiPlayer);
        btnMultiPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnMultiPlayer.setBackground(Color.WHITE);
        pnlChoosePlayer.add(lblGhost5);

        btnSinglePlayer.addMouseListener(new MouseSinglePlayer());
        btnMultiPlayer.addMouseListener(new MouseMultiPlayer());
        btnSettings.addMouseListener(new MouseSettings());
        btnHelp.addMouseListener(new MouseHelp());

        pnlWest.add(pnlSettings).setPreferredSize(new Dimension(350, 90));
        pnlSettings.add(lblPiSettings);
        pnlSettings.setBackground(Color.WHITE);
        pnlSettings.add(btnSettings).setPreferredSize(new Dimension(75, 75));
        pnlSettings.add(lblGhost6);
        pnlSettings.add(lblPiHelp);
        btnSettings.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlSettings.add(btnHelp).setPreferredSize(new Dimension(56, 75));
        btnHelp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlSettings.add(lblGhost7);

        pnlMain.add(scoreGUI);
    }
    class TwoPlayer extends JFrame implements ActionListener{
        private JPanel pnlMain = new JPanel();

        private JLabel lblGame = new JLabel("Spelare 2");
        private JLabel lblUsername = new JLabel("Användarnamn");

        private JTextField txtUsername = new JTextField();

        private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

        private JButton btnLogin = new JButton("Starta spel");

        public TwoPlayer(){
                setSize(400, 300);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
                setLocationRelativeTo(null);
                add(pnlMain);

                lblGame.setFont(myFont);

                pnlMain.setLayout(null);

                lblGame.setBounds(120, 10, 300, 50);
                lblUsername.setBounds(60, 20, 100, 100);
                txtUsername.setBounds(160, 60, 165, 25);
                btnLogin.setBounds(120, 150, 150, 40);

                pnlMain.add(lblGame);
                pnlMain.add(lblUsername);
                pnlMain.add(txtUsername);
                pnlMain.add(btnLogin);

                btnLogin.addActionListener(this);
            }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((txtUsername.getText().trim().length() <= 10) && (txtUsername.getText().trim().length() >= 3)) {
                JOptionPane.showMessageDialog(null, "Välkommen " + txtUsername.getText());
                gameController.switchGUI();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ogiltigt användarnamn");
            }
        }

        public JTextField getTxtUsername() {
            return txtUsername;
        }
    }



    /**
     * This class contains the listeners that starts Memorias Boards class
     * @author Yasir Kakar
     * @author Adel Sabanovic
     * @version 1.0
     * @since 2020-04-16
     *
     */
    private class MouseMultiPlayer implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            new TwoPlayer();

            dispose();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiMultiPlayer.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPiMultiPlayer.setVisible(false);
        }
    }

    private class MouseSinglePlayer implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiSinglePlayer.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPiSinglePlayer.setVisible(false);
        }
    }

    private class MouseSettings implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            new SettingsGUI();

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiSettings.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPiSettings.setVisible(false);
        }
    }

    private class MouseHelp implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            new HelpGUI();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiHelp.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPiHelp.setVisible(false);
        }
    }



    public static void main(String[] args) {
       //MenuGUI start = new MenuGUI();
        //TwoPlayer twoPlayer = new TwoPlayer();

    }
}
