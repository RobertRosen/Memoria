package Game.View;

import Game.Controller.MusicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klassen SettingGUI är en klass som innehåller Memorias inställningar
 * @version 1.0
 * @author Yasir Kakar
 */

public class SettingsGUI extends JFrame {
    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    private ImageIcon inställningarLogo = new ImageIcon("images/inställningar.PNG");

    private JButton btnOn = new JButton("PÅ");
    private JButton btnOff = new JButton("AV");
    private JButton btnOk = new JButton("OK");

    private JLabel lblSettings = new JLabel(inställningarLogo);
    private JLabel lblMusic = new JLabel("Musik");

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    public SettingsGUI(){
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(pnlMain);

        pnlMain.setBackground(Color.WHITE);

        pnlMain.setLayout(null);

        lblSettings.setFont(myFont);
        lblMusic.setFont(myFont);

        lblSettings.setBounds(40, 10, 300, 50);
        lblMusic.setBounds(40,60,100,25);
        btnOn.setBounds(100, 60, 80,25);
        btnOff.setBounds(200,60,80,25);
        btnOk.setBounds(150,100,80,25);

        pnlMain.add(lblSettings);
        pnlMain.add(lblMusic);
        pnlMain.add(btnOn);
        pnlMain.add(btnOff);
        pnlMain.add(btnOk);

        btnOk.addActionListener(new OkListener());
        btnOn.addActionListener(new MusicController.PlayListener());
        btnOff.addActionListener(new MusicController.StopListener());
    }
    private class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        //Game.Controller.Game.Model.View.SettingsGUI settingsGUI = new Game.Controller.Game.Model.View.SettingsGUI();
    }
}
