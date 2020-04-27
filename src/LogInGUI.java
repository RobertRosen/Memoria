import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klassen LogInGUI är ett GUI för login.
 * @version 1.0
 * @author Joakim Tell och Yasir Kakar
 */
public class LogInGUI extends JFrame {
    private GameController gameController;

    private JFrame frame = new JFrame();

    private JPanel pnlMain = new JPanel();

    private JLabel lblGame = new JLabel("Welcome to Memoria");
    private JLabel lblUsername = new JLabel("Username");


    private JLabel lblPassword = new JLabel("Password");

    private JTextField txtUsername = new JTextField();
    private JTextField txtPassword = new JTextField();

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    private JButton btnLogin = new JButton("Enter the game");

    /**
     * Konstruktor som initierar LogInGUI
     */
    public LogInGUI(GameController gameController) {
        this.gameController = gameController;
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(pnlMain);

        lblGame.setFont(myFont);

        pnlMain.setLayout(null);

        lblGame.setBounds(80, 20, 300, 50);
        lblUsername.setBounds(80, 20, 100, 100);
        lblPassword.setBounds(80, 60, 100, 100);
        txtUsername.setBounds(160, 60, 165, 25);
        txtPassword.setBounds(160, 100, 165, 25);
        btnLogin.setBounds(120, 150, 150, 40);

        pnlMain.add(lblGame);
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        pnlMain.add(btnLogin);

        btnLogin.addActionListener(new Listener());
    }

    /**
     * Lyssnare som kontrollerar längd på usernamet.
     * Skapar sedan MenuGUI om giltligt användarnamn skrivits in och dispose av LogInGUI.
     */
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ((txtUsername.getText().trim().length() <= 10) && (txtUsername.getText().trim().length() >= 3)) {
                JOptionPane.showMessageDialog(null, "Welcome " + txtUsername.getText());

                new MenuGUI(gameController);
                gameController.createUser();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username");
            }
        }
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    //    public static void main(String[] args) {
//        LogInGUI logInGUI = new LogInGUI();
//    }
}
