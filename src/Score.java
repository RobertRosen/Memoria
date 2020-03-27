import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
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
    private JLabel Off = new JLabel(offline);
    private JLabel back1 = new JLabel(back);
    private JLabel ghost = new JLabel();

    private JList list = new JList();
    private JList list2 = new JList();
    private JList list3 = new JList();

    public Score(){
        setPreferredSize(new Dimension(490,650));
        setBackground(Color.WHITE);
        blueLabel.setPreferredSize(new Dimension(198,15));
        blueLabel2.setPreferredSize(new Dimension(198,15));
        blueLabel3.setPreferredSize(new Dimension(198,15));
        blueLabel4.setPreferredSize(new Dimension(198,15));
        Score.setPreferredSize(new Dimension(180,30));
        On.setPreferredSize(new Dimension(180,30));
        Off.setPreferredSize(new Dimension(180,30));

        //add(back1);
        back1.setPreferredSize(new Dimension(40,35));
        add(label);
        add(label2);

        add(ctrPanel).setPreferredSize(new Dimension(450, 560));
        ctrPanel.add(back1);
        ctrPanel.add(ghost).setPreferredSize(new Dimension(380, 35));
        ctrPanel.setBackground(Color.WHITE);
        wstPanel.setBackground(Color.WHITE);
        estPanel.setBackground(Color.WHITE);
        ctrPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ctrPanel.add(wstPanel).setPreferredSize(new Dimension(200,496));
        ctrPanel.add(estPanel).setPreferredSize(new Dimension(200,496));
        wstPanel.add(blueLabel);
        wstPanel.add(Score);
        wstPanel.add(list).setPreferredSize(new Dimension(200,402));
        list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        wstPanel.add(blueLabel2);

        estPanel.add(blueLabel3);
        estPanel.add(On);
        estPanel.add(list2).setPreferredSize(new Dimension(200,181));
        estPanel.add(Off);
        list2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        estPanel.add(list3).setPreferredSize(new Dimension(200,181));
        list3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        estPanel.add(blueLabel4);

    }
}
