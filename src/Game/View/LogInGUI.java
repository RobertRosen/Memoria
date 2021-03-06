package Game.View;

import Game.Controller.Controller;
import Game.Controller.MusicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Klassen LogInGUI är ett GUI för login. TODO-kommentera hela klassen på engelska
 * @author Joakim Tell och Yasir Kakar
 * @version 3.0
 */
public class LogInGUI extends JFrame {
    private Controller controller;
    private ImageIcon welcomeLogo = new ImageIcon("images/välkommen.PNG");

    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    private JLabel lblGame = new JLabel(welcomeLogo);
    private JLabel lblUsername = new JLabel("Användarnamn");

    private JTextField txtUsername = new JTextField("Användarnamn (3-10 tecken)");

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    private JButton btnLogin = new JButton("Gå vidare");

    /**
     * Konstruktor som initierar LogInGUI
     */
    public LogInGUI(Controller controller, String name) {
        this.controller = controller;
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(pnlMain);
        pnlMain.setBackground(Color.WHITE);

        lblGame.setFont(myFont);

        pnlMain.setLayout(null);

        lblGame.setBounds(40, 20, 300, 50);
        lblUsername.setBounds(50, 60, 100, 100);
        txtUsername.setBounds(160, 100, 165, 25);
        btnLogin.setBounds(120, 150, 150, 40);

        lblUsername.setText(name);

        pnlMain.add(lblGame);
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(btnLogin);

        listeners();
    }

    private void listeners(){
        txtUsername.addKeyListener(new LimitUsername());
        btnLogin.addActionListener(new Listener());
        txtUsername.addFocusListener(new Focus());

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

    /**
     * Lyssnare som kontrollerar längd på usernamet.
     * Skapar sedan MenuGUI om giltligt användarnamn skrivits in och dispose av LogInGUI.
     */
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ((txtUsername.getText().trim().length() <= 10) && (txtUsername.getText().trim().length() >= 3)) {
                controller.createUser();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ogiltigt användarnamn");
            }
        }
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

}
