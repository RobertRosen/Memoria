package Game.View;

import Game.Controller.Controller;
import Game.Controller.MusicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Klassen LogInGUI är ett GUI för login. TODO-kommentera hela klassen på engelska
 * @author Joakim Tell, Yasir Kakar, Adel Sabanovic
 * @version 3.0
 */
public class LogInGUI extends JFrame {
    private Controller controller;
    private ImageIcon welcomeLogo = new ImageIcon("images/MemoriaWelcome.PNG");
    private ImageIcon imgbtn = new ImageIcon("images/ok.PNG");

    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    ImageIcon piLogo = new ImageIcon("images/pi.jpg");

    private JLabel lblGame = new JLabel(welcomeLogo);

    private JLabel lblUsername = new JLabel("Användarnamn");
    private JLabel lblPi = new JLabel(piLogo);

    private JTextField txtUsername = new JTextField("Användarnamn (3-10 tecken)");

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    private JButton btnLogin = new JButton(imgbtn);

    /**
     * Konstruktor som initierar LogInGUI
     */
    public LogInGUI(Controller controller, String name) {
        this.controller = controller;
        frame.setSize(380, 255);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(pnlMain);
        pnlMain.setBackground(Color.WHITE);

        lblGame.setFont(myFont);

        pnlMain.setLayout(null);

        lblGame.setBounds(40, 20, 300, 50);
        lblUsername.setBounds(50, 60, 100, 100);
        txtUsername.setBounds(120, 100, 165, 25);
        btnLogin.setBounds(168, 150, 59, 38);
        lblPi.setBounds(128,145,33,40);

        lblPi.setVisible(false);

        lblUsername.setText(name);

        txtUsername.setForeground(Color.GRAY);

        pnlMain.add(lblGame);
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(btnLogin);
        pnlMain.add(lblPi);

        btnLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        listeners();
    }

    private void listeners(){
        txtUsername.addKeyListener(new LimitUsername());
        btnLogin.addActionListener(new Listener());
        txtUsername.addFocusListener(new Focus());
        btnLogin.addMouseListener(new MouseSubmit());

    }

    /**
     * This class makes the username hint disappear
     * @version 3.0
     * @author Yasir Kakar
     */
    private class Focus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            txtUsername.setText(null);
            txtUsername.setForeground(Color.BLACK);
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    private class LimitUsername implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if ((txtUsername.getText().length() > 10) || (txtUsername.getText().length() < 3)){
                txtUsername.setForeground(Color.RED);
                btnLogin.setEnabled(false);
            }
            else {
                txtUsername.setForeground(Color.GREEN);
                btnLogin.setEnabled(true);
            }
        }
    }

    private class MouseSubmit implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPi.setVisible(true);

        }

        public void mouseExited(MouseEvent e) {
            lblPi.setVisible(false);

        }
    }

    /**
     * Lyssnare som kontrollerar längd på usernamet.
     * Skapar sedan MenuGUI om giltligt användarnamn skrivits in och dispose av LogInGUI.
     */
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ((txtUsername.getText().trim().length() <= 10) && (txtUsername.getText().trim().length() >= 3)) {
                setVisible(false);
                dispose();
                controller.createUser();
            } else {
                JOptionPane.showMessageDialog(null, "Ogiltigt användarnamn");
            }
        }
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

}
