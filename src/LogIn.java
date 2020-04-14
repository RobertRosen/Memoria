import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    private JPanel userpanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private JLabel user = new JLabel("Username");

    private JTextField userTxt = new JTextField();

    private JButton loginButton = new JButton("LogIn");


    public LogIn() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(loginButton);
        loginButton.setSize(40, 30);
        loginButton.addActionListener(new Listener());
    }


    class Listener implements ActionListener {



        @Override
        public void actionPerformed(ActionEvent e) {

            Start start = new Start();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.add(start);
            frame.pack();
            dispose();
        }
    }

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
    }
}