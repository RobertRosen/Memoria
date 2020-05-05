package Game.View;

import Game.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klassen Game.Controller.Game.Model.View.LogInGUI är ett GUI för login.
 * @author Joakim Tell och Yasir Kakar
 * @version 1.0
 */
public class LogInGUI extends JFrame {
    private Controller controller;
    private ImageIcon welcomeLogo = new ImageIcon("images/välkommen.PNG");

    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    private JLabel lblGame = new JLabel(welcomeLogo);
    private JLabel lblUsername = new JLabel("Användarnamn");


    private JTextField txtUsername = new JTextField();

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    private JButton btnLogin = new JButton("Gå vidare");

    /**
     * Konstruktor som initierar Game.Controller.Game.Model.View.LogInGUI
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

        btnLogin.addActionListener(new Listener());
    }

    /**
     * Lyssnare som kontrollerar längd på usernamet.
     * Skapar sedan Game.Controller.Game.Model.View.MenuGUI om giltligt användarnamn skrivits in och dispose av Game.Controller.Game.Model.View.LogInGUI.
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

    //    public static void main(String[] args) {
//        Game.Controller.Game.Model.View.LogInGUI logInGUI = new Game.Controller.Game.Model.View.LogInGUI();
//    }

}