package Game.View;

import Game.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class contains Memorias main menu
 * @author Yasir Kakar
 * @author Adel Sabanovic
 * @version 3.0
 * @since 2020-04-16
 *
 */
public class MenuGUI extends JFrame {
    private Controller controller;

    private JPanel pnlMain = new JPanel();
    private JPanel pnlChoosePlayer = new JPanel();
    private JPanel pnlSettings = new JPanel();
    private JPanel pnlWest = new JPanel();

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
    private JLabel lblGhostSinglePlayer = new JLabel();
    private JLabel lblPiMultiPlayer = new JLabel(iconPi);
    private JLabel lblGhostMultiPlayer = new JLabel();
    private JLabel lblPiSettings = new JLabel(iconPi);
    private JLabel lblGhostSettings = new JLabel();
    private JLabel lblPiHelp = new JLabel(iconPi);
    private JLabel lblGhostHelp = new JLabel();


    /**
     * This method contains Memorias main menu GUI
     * @author Yasir Kakar
     * @author Adel Sabanovic
     * @version 3.0
     * @since 2020-04-16
     */
    //TODO ska kortas ner med en for-loop och hj??lpmetoder
    public MenuGUI(Controller controller) {
        this.controller = controller;

        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pnlMain.setBackground(Color.WHITE);

        add(pnlMain);
        pnlMain.add(pnlWest);

        panelWestContents();

        pnlWest.add(pnlChoosePlayer).setPreferredSize(new Dimension(350, 130));
        pnlChoosePlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlChoosePlayer.setBackground(Color.WHITE);
        pnlChoosePlayer.add(lblPiSinglePlayer);
        pnlChoosePlayer.add(lblGhostSinglePlayer);
        pnlChoosePlayer.add(btnSinglePlayer);
        pnlChoosePlayer.add(lblGhost4);
        btnSinglePlayer.setBackground(Color.WHITE);
        btnSinglePlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlChoosePlayer.add(lblGhost2);
        pnlChoosePlayer.add(lblPiMultiPlayer);
        pnlChoosePlayer.add(lblGhostMultiPlayer);
        pnlChoosePlayer.add(btnMultiPlayer);
        btnMultiPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnMultiPlayer.setBackground(Color.WHITE);
        pnlChoosePlayer.add(lblGhost5);

        pnlWest.add(pnlSettings).setPreferredSize(new Dimension(350, 90));
        pnlSettings.add(lblPiSettings);
        pnlSettings.add(lblGhostSettings);
        pnlSettings.setBackground(Color.WHITE);
        pnlSettings.add(btnSettings).setPreferredSize(new Dimension(75, 75));
        pnlSettings.add(lblGhost6);
        pnlSettings.add(lblPiHelp);
        pnlSettings.add(lblGhostHelp);
        btnSettings.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlSettings.add(btnHelp).setPreferredSize(new Dimension(56, 75));
        btnHelp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pnlSettings.add(lblGhost7);


        setPiSizes();
        setGhostSizes();
        addListeners();
    }

    /**
     * This method contains the contents of the west panel in the MenuGUI
     * @version 3.0
     * @author Adel Sabanovic
     */
    private void panelWestContents(){
        pnlWest.setPreferredSize(new Dimension(450, 340));
        pnlWest.setBackground(Color.WHITE);
        pnlWest.add(lblGhost);
        pnlWest.add(lblMemoria);
        pnlWest.add(lblMathLogo);
        pnlWest.add(lblGhost3);
        pnlWest.add(lblBeat);
        pnlWest.add(pnlChoosePlayer);
        pnlWest.add(pnlSettings);
    }

    /**
     * This method sets the sizes and the visibility for the PI symbols the
     * gets visible when the user is hovering over the buttons in the MenuGUI
     * @version 3.0
     * @author Adel Sabanovic
     */
    private void setPiSizes(){

        lblPiSinglePlayer.setPreferredSize(new Dimension(40, 40));
        lblPiSinglePlayer.setVisible(false);
        lblGhostSinglePlayer.setPreferredSize(new Dimension(40, 40));
        lblPiMultiPlayer.setPreferredSize(new Dimension(40, 40));
        lblPiMultiPlayer.setVisible(false);
        lblGhostMultiPlayer.setPreferredSize(new Dimension(40, 40));
        lblPiSettings.setPreferredSize(new Dimension(40, 40));
        lblPiSettings.setVisible(false);
        lblGhostSettings.setPreferredSize(new Dimension(40, 40));
        lblPiHelp.setPreferredSize(new Dimension(33, 40));
        lblPiHelp.setVisible(false);
        lblGhostHelp.setPreferredSize(new Dimension(33, 40));
    }

    /**
     * This method sets the sizes for the empty labels in MenuGUI
     * @version 3.0
     * @author Adel Sabanovic
     */
    private void setGhostSizes(){

        lblGhost2.setPreferredSize(new Dimension(300, 30));
        lblGhost4.setPreferredSize(new Dimension(30, 40));
        lblGhost5.setPreferredSize(new Dimension(30, 40));
        lblGhost6.setPreferredSize(new Dimension(15, 40));
        lblGhost7.setPreferredSize(new Dimension(26, 40));
        lblGhost.setPreferredSize(new Dimension(40, 40));
        lblMemoria.setPreferredSize(new Dimension(260, 40));
        lblBeat.setPreferredSize(new Dimension(450, 70));
    }

    /**
     * This method contains all the listeners in the MenuGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void addListeners(){

        btnSinglePlayer.addMouseListener(new MouseSinglePlayer());
        btnMultiPlayer.addMouseListener(new MouseMultiPlayer());
        btnSettings.addMouseListener(new MouseSettings());
        btnHelp.addMouseListener(new MouseHelp());
    }


    /**
     * This class contains the functions for the multi-player in the MenuGUI
     * @version 3.0
     * @author Yasir Kakar, Adel Sabanovic
     */
    private class MouseMultiPlayer implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            controller.switchGUI();
            dispose();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiMultiPlayer.setVisible(true);
            lblGhostMultiPlayer.setVisible(false);
        }

        public void mouseExited(MouseEvent e) {
            lblPiMultiPlayer.setVisible(false);
            lblGhostMultiPlayer.setVisible(true);
        }
    }

    /**
     * This class contains the functions for the single-player button in the MenuGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private class MouseSinglePlayer implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiSinglePlayer.setVisible(true);
            lblGhostSinglePlayer.setVisible(false);
        }

        public void mouseExited(MouseEvent e) {
            lblPiSinglePlayer.setVisible(false);
            lblGhostSinglePlayer.setVisible(true);
        }
    }

    /**
     * This class contains the functions for the settings button in the MenuGUI
     * @version 3.0
     * @author Yasir Kakar
     */
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
            lblGhostSettings.setVisible(false);
        }

        public void mouseExited(MouseEvent e) {
            lblPiSettings.setVisible(false);
            lblGhostSettings.setVisible(true);
        }
    }

    /**
     * This class contains the functions for the help button in the MenuGUI
     * @version 3.0
     * @author Yasir Kakar
     */
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
            lblGhostHelp.setVisible(false);
        }

        public void mouseExited(MouseEvent e) {
            lblPiHelp.setVisible(false);
            lblGhostHelp.setVisible(true);
        }
    }



    public static void main(String[] args) {
       //Game.Controller.Game.Model.View.MenuGUI start = new Game.Controller.Game.Model.View.MenuGUI();
        //TwoPlayer twoPlayer = new TwoPlayer();

    }
}
