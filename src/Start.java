import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JPanel implements ActionListener {
    // Hej jag är här och jobbar
    //Försök2
    private JPanel westPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();

    private Score score = new Score();
    private ImageIcon logo = new ImageIcon("images/mem3.JPG");
    private ImageIcon mthLogo = new ImageIcon("images/mathLogo.JPG");
    private ImageIcon beatLogo = new ImageIcon("images/beat2.JPG");
    private ImageIcon single = new ImageIcon("images/single.JPG");
    private ImageIcon multi = new ImageIcon("images/multi.JPG");
    private ImageIcon gear = new ImageIcon("images/gear.jpg");
    private ImageIcon option = new ImageIcon("images/QM2.JPG");
    private ImageIcon pi = new ImageIcon("images/pi.JPG");

    private JButton btnOP = new JButton(gear);
    private JButton btnIS = new JButton(option);
    private JButton btnSnigle = new JButton(single);
    private JButton btnMulti = new JButton(multi);

    private JLabel memoria = new JLabel(logo);
    private JLabel mathLogo = new JLabel(mthLogo);
    private JLabel beat = new JLabel(beatLogo);

    private JLabel ghost = new JLabel();
    private JLabel ghost2 = new JLabel();
    private JLabel ghost3 = new JLabel();
    private JLabel ghost4 = new JLabel();
    private JLabel ghost5 = new JLabel();
    private JLabel ghost6 = new JLabel();
    private JLabel ghost7 = new JLabel();

    private JLabel pointer = new JLabel(pi);
    private JLabel pointer2 = new JLabel(pi);
    private JLabel pointer3 = new JLabel(pi);
    private JLabel pointer4 = new JLabel(pi);

    public Start() {
        setPreferredSize(new Dimension(940, 430));
        setBackground(Color.WHITE);

        add(westPanel);
        westPanel.setPreferredSize(new Dimension(450, 340));
        westPanel.setBackground(Color.WHITE);
        westPanel.add(ghost);
        westPanel.add(memoria);
        westPanel.add(mathLogo);
        westPanel.add(ghost3);
        westPanel.add(beat);
        westPanel.add(panel);
        westPanel.add(panel2);


        pointer.setPreferredSize(new Dimension(40, 40));
        pointer.setVisible(false);
        pointer2.setPreferredSize(new Dimension(40, 40));
        pointer2.setVisible(false);
        pointer3.setPreferredSize(new Dimension(40, 40));
        pointer3.setVisible(false);
        pointer4.setPreferredSize(new Dimension(40, 40));
        pointer4.setVisible(false);

        ghost4.setPreferredSize(new Dimension(30, 40));
        ghost5.setPreferredSize(new Dimension(30, 40));
        ghost6.setPreferredSize(new Dimension(19, 40));
        ghost7.setPreferredSize(new Dimension(26, 40));

        //add(ghost);
        ghost.setPreferredSize(new Dimension(40, 40));
        //add(memoria);
        memoria.setPreferredSize(new Dimension(260, 40));
        //add(mathLogo);

        //add(ghost3).setPreferredSize(new Dimension(300, 30));

       // add(beat);
        beat.setPreferredSize(new Dimension(450, 70));

        westPanel.add(panel).setPreferredSize(new Dimension(350, 130));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.setBackground(Color.WHITE);
        panel.add(pointer);
        panel.add(btnSnigle);
        panel.add(ghost4);
        btnSnigle.setBackground(Color.WHITE);
        btnSnigle.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel.add(ghost2);
        ghost2.setPreferredSize(new Dimension(300, 30));
        panel.add(pointer2);
        panel.add(btnMulti);
        btnMulti.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnMulti.setBackground(Color.WHITE);
        panel.add(ghost5);

        btnSnigle.addActionListener(this);
        btnMulti.addActionListener(this);
        btnOP.addActionListener(this);
        btnIS.addActionListener(this);

         westPanel.add(panel2).setPreferredSize(new Dimension(350, 90));
        panel2.add(pointer3);
        panel2.setBackground(Color.WHITE);
        //  panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel2.add(btnOP).setPreferredSize(new Dimension(75, 75));
        panel2.add(ghost6);
        panel2.add(pointer4);
        btnOP.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel2.add(btnIS).setPreferredSize(new Dimension(56, 75));
        btnIS.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel2.add(ghost7);
        add(score);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSnigle) {
            pointer.setVisible(true);
            pointer2.setVisible(false);
            pointer3.setVisible(false);
            pointer4.setVisible(false);
        }
        if (e.getSource() == btnMulti) {
            pointer.setVisible(false);
            pointer2.setVisible(true);
            pointer3.setVisible(false);
            pointer4.setVisible(false);
        }
        if (e.getSource() == btnOP) {
            pointer.setVisible(false);
            pointer2.setVisible(false);
            pointer3.setVisible(true);
            pointer4.setVisible(false);
        }
        if (e.getSource() == btnIS) {
            pointer.setVisible(false);
            pointer2.setVisible(false);
            pointer3.setVisible(false);
            pointer4.setVisible(true);
        }

    }

    public static void main(String[] args) {
        Start start = new Start();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(start);
        frame.pack();
    }
}
