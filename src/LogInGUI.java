import javax.swing.*;
import java.awt.*;

public class LogInGUI extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel lblGame = new JLabel("Welcome to Memoria");
    private JLabel lblUser = new JLabel("Username");
    private JTextField txtUser = new JTextField();
    private JLabel lblPassword = new JLabel("Password");
    private JTextField txtPassword = new JTextField();
    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);
    private JButton btnlogin = new JButton("Enter the game");

    public void setUpGUI()
    {
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        lblGame.setFont(myFont);

        panel.setLayout(null);

        lblGame.setBounds(80,20,300,50);
        panel.add(lblGame);

        lblUser.setBounds(80,20,100,100);
        panel.add(lblUser);

        txtUser.setBounds(160,60,165,25);
        panel.add(txtUser);

        lblPassword.setBounds(80,60,100,100);
        panel.add(lblPassword);

        txtPassword.setBounds(160,100,165,25);
        panel.add(txtPassword);

        btnlogin.setBounds(120,150,150,40);
        panel.add(btnlogin);


    }


    public static void main(String[] args) {
        LogInGUI logInGUI = new LogInGUI();
        logInGUI.setUpGUI();
    }
}
