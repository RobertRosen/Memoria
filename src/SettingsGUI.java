import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI extends JFrame {

    private JButton btnOn = new JButton("ON");
    private JButton btnOff = new JButton("OFF");
    private JButton btnOk = new JButton("OK");

    private JLabel lblSettings = new JLabel("Settings");
    private JLabel lblMusic = new JLabel("Music");

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    public SettingsGUI(){
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblSettings.setFont(myFont);
        lblMusic.setFont(myFont);

        lblSettings.setBounds(140, 10, 300, 50);
        lblMusic.setBounds(40,60,100,25);
        btnOn.setBounds(100, 60, 80,25);
        btnOff.setBounds(200,60,80,25);
        btnOk.setBounds(150,100,80,25);

        add(lblSettings);
        add(lblMusic);
        add(btnOn);
        add(btnOff);
        add(btnOk);

        btnOk.addActionListener(new OkListener());
        btnOn.addActionListener(new MusicController.PlayListener());
        btnOff.addActionListener(new MusicController.StopListener());
    }
    private class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
