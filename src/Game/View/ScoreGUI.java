package Game.View;

import javax.swing.*;
import java.awt.*;

/**
 * TODO Kommentera Score-GUI om den ska användas.
 * @author Adel Sabanovic
 * @version 3.0
 */

public class ScoreGUI extends JPanel {
    private JPanel ctrPanel = new JPanel();
    private JPanel wstPanel = new JPanel();
    private JPanel estPanel = new JPanel();

    private ImageIcon memoria = new ImageIcon("images/nem2.jpg");
    private ImageIcon logo = new ImageIcon("images/.jpg");
    private ImageIcon blue = new ImageIcon("images/blue.jpg");
    private ImageIcon highscore = new ImageIcon("images/Highscore.jpg");
    private ImageIcon online = new ImageIcon("images/online.jpg");
    private ImageIcon offline = new ImageIcon("images/offline.jpg");
    private ImageIcon back = new ImageIcon("images/back.jpg");

    private JLabel label = new JLabel(memoria);
    private JLabel label2 = new JLabel(logo);
    private JLabel blueLabel = new JLabel(blue);
    private JLabel blueLabel2 = new JLabel(blue);
    private JLabel blueLabel3 = new JLabel(blue);
    private JLabel blueLabel4 = new JLabel(blue);
    private JLabel Score = new JLabel(highscore);
    private JLabel On = new JLabel(online);
    private JLabel Off = new JLabel();
    private JButton back1 = new JButton(back);
    private JLabel ghost = new JLabel();

    private JList scoreList = new JList();
    private JList onlineList = new JList();
    private JLabel ghost2 = new JLabel();

    public ScoreGUI() {
        setPreferredSize(new Dimension(445, 370));
        setBackground(Color.WHITE);
        add(ghost2);
        ghost2.setPreferredSize(new Dimension(400, 35));
        blueLabel.setPreferredSize(new Dimension(198, 15));
        blueLabel2.setPreferredSize(new Dimension(198, 15));
        blueLabel3.setPreferredSize(new Dimension(198, 15));
        blueLabel4.setPreferredSize(new Dimension(198, 15));
        Score.setPreferredSize(new Dimension(180, 30));
        On.setPreferredSize(new Dimension(180, 30));
        Off.setPreferredSize(new Dimension(180, 30));

        back1.setPreferredSize(new Dimension(25, 18));
        back1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        add(label);
        add(label2);

        add(ctrPanel).setPreferredSize(new Dimension(445, 360));
        ctrPanel.add(back1);
        ctrPanel.add(ghost).setPreferredSize(new Dimension(380, 35));
        ctrPanel.setBackground(Color.WHITE);
        wstPanel.setBackground(Color.WHITE);
        estPanel.setBackground(Color.WHITE);
        // ctrPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ctrPanel.add(wstPanel).setPreferredSize(new Dimension(200, 300));
        ctrPanel.add(estPanel).setPreferredSize(new Dimension(200, 300));
        wstPanel.add(blueLabel);
        wstPanel.add(Score);
        wstPanel.add(scoreList).setPreferredSize(new Dimension(200, 180));
        scoreList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        wstPanel.add(blueLabel2);

        estPanel.add(blueLabel3);
        estPanel.add(On);
        estPanel.add(onlineList).setPreferredSize(new Dimension(200, 180));
        onlineList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        estPanel.add(blueLabel4);
    }
}
