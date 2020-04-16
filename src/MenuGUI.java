import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuGUI extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel westPanel = new JPanel();

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

    public MenuGUI() {

        setSize(940, 430);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setBackground(Color.WHITE);

        add(mainPanel);
        mainPanel.add(westPanel);
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
        ghost.setPreferredSize(new Dimension(40, 40));
        memoria.setPreferredSize(new Dimension(260, 40));
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

        btnSnigle.addMouseListener(new MouseSingel());
        btnMulti.addMouseListener(new MouseMulti());
        btnOP.addMouseListener(new MouseOP());
        btnIS.addMouseListener(new MouseIS());

        westPanel.add(panel2).setPreferredSize(new Dimension(350, 90));
        panel2.add(pointer3);
        panel2.setBackground(Color.WHITE);
        panel2.add(btnOP).setPreferredSize(new Dimension(75, 75));
        panel2.add(ghost6);
        panel2.add(pointer4);
        btnOP.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel2.add(btnIS).setPreferredSize(new Dimension(56, 75));
        btnIS.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panel2.add(ghost7);

        mainPanel.add(score);
    }

    private class MouseMulti implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            new BoardGUI();
            dispose();
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            pointer2.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            pointer2.setVisible(false);
        }
    }

    private class MouseSingel implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            pointer.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            pointer.setVisible(false);
        }
    }

    private class MouseOP implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            pointer3.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            pointer3.setVisible(false);
        }
    }

    private class MouseIS implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            pointer4.setVisible(true);
        }

        public void mouseExited(MouseEvent e) {
            pointer4.setVisible(false);
        }
    }

/*    public static void main(String[] args) {
        MenuGUI start = new MenuGUI();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(start);
        frame.pack();
    }*/
}