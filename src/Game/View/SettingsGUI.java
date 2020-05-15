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
 * @author Yasir Kakar
 */

public class SettingsGUI extends JFrame {
    private MusicController musicController = new MusicController();
    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    private ImageIcon inställningarLogo = new ImageIcon("images/inställningar.PNG");
    private ImageIcon musikLogo = new ImageIcon("images/Musik.PNG");
    private ImageIcon påLogo = new ImageIcon("images/PÅ.PNG");
    private ImageIcon avLogo = new ImageIcon("images/AV.PNG");
    private ImageIcon okLogo = new ImageIcon("images/OK.PNG");


    private JButton btnOn = new JButton(påLogo);
    private JButton btnOff = new JButton(avLogo);
    private JButton btnOk = new JButton(okLogo);

    private JLabel lblSettings = new JLabel(inställningarLogo);
    private JLabel lblMusic = new JLabel(musikLogo);

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
        lblSettings.setBounds(40, 10, 300, 50);
        lblMusic.setBounds(25,60,130,40);
        btnOn.setBounds(150, 67, 75,25);
        btnOff.setBounds(250,66,80,27);
        btnOk.setBounds(150,150,75,30);

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
        pnlMain.add(btnOff);
        pnlMain.add(btnOk);
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
            musicController.playMusic("music/TakeMeBack.wav");
        }
    }

    private class StopMusic implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            musicController.stopMusic();
        }
    }

    public static void main(String[] args) {
        SettingsGUI settingsGUI = new SettingsGUI();
    }
}
