package Game.View;

import Game.Controller.MusicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class contains all the code for the Setting interface
 * @version 3.0
 * @author Yasir Kakar, Adel Sabanovic
 */

public class SettingsGUI extends JFrame {
    private MusicController musicController = new MusicController();
    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    private ImageIcon inställningarLogo = new ImageIcon("images/settings.PNG");
    private ImageIcon musikLogo = new ImageIcon("images/music.PNG");
    private ImageIcon påLogo = new ImageIcon("images/on.PNG");
    private ImageIcon avLogo = new ImageIcon("images/Off.PNG");
    private ImageIcon okLogo = new ImageIcon("images/ok.PNG");
    private ImageIcon piLogo = new ImageIcon("images/pi.jpg");


    private JButton btnOn = new JButton(påLogo);
    private JButton btnOff = new JButton(avLogo);
    private JButton btnOk = new JButton(okLogo);

    private JLabel lblSettings = new JLabel(inställningarLogo);
    private JLabel lblMusic = new JLabel(musikLogo);
    private JLabel lblPiOn = new JLabel(piLogo);
    private JLabel lblPiOff= new JLabel(piLogo);
    private JLabel lblPi3Ok = new JLabel(piLogo);

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    /**
     * This constructor contains the functions for the settingsGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    public SettingsGUI(){
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(pnlMain);

        pnlMain.setBackground(Color.WHITE);

        pnlMain.setLayout(null);

        lblSettings.setFont(myFont);
        lblMusic.setFont(myFont);
        lblPiOn.setVisible(false);
        lblPiOff.setVisible(false);
        lblPi3Ok.setVisible(false);

        btnOk.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnOff.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnOn.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        addContents();
        addListeners();
        setBoundsForContents();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method sets size and location for the buttons and labels in the SettingsGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void setBoundsForContents(){
        lblSettings.setBounds(40, 10, 300, 60);
        lblMusic.setBounds(10,97,130,40);
        btnOn.setBounds(240, 100, 60,25);
        lblPiOn.setBounds(200,90,33,40);
        btnOff.setBounds(240,150,71,24);
        lblPiOff.setBounds(200,140,33,40);
        btnOk.setBounds(150,200,59,38);
        lblPi3Ok.setBounds(110,200,33,40);

    }

    /**
     * This method the buttons and labels in the SettingsGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void addContents(){

        pnlMain.add(lblSettings);
        pnlMain.add(lblMusic);
        pnlMain.add(btnOn);
        pnlMain.add(lblPiOn);
        pnlMain.add(btnOff);
        pnlMain.add(lblPiOff);
        pnlMain.add(btnOk);
        pnlMain.add(lblPi3Ok);
    }

    /**
     * This method adds listeners to the buttons in the SettingsGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void addListeners(){

        btnOk.addActionListener(new OkListener());
        btnOn.addActionListener(new PlayMusic());
        btnOff.addActionListener(new StopMusic());
        btnOn.addMouseListener(new MouseOn());
        btnOff.addMouseListener(new MouseOff());
        btnOk.addMouseListener(new MouseOk());
    }

    private class MouseOn implements MouseListener {
        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiOn.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPiOn.setVisible(false);
        }
    }

    private class MouseOff implements MouseListener {
        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPiOff.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPiOff.setVisible(false);
        }
    }

    private class MouseOk implements MouseListener {
        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPi3Ok.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            lblPi3Ok.setVisible(false);
        }
    }


    /**
     * This class contains the functions for the "OK" button in the SettingsGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
    private class PlayMusic implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            musicController.playMusic("music/MenuMusic.wav");
        }
    }

    private class StopMusic implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            musicController.stopMusic();
        }
    }
}
