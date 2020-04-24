import javax.swing.*;
import java.awt.*;

public class HelpGUI extends JFrame {
    private JLabel lblHelp = new JLabel("Memoria hjälpcenter");

    private JTextArea txta = new JTextArea();

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);


    public HelpGUI(){
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblHelp.setFont(myFont);

        lblHelp.setBounds(200, 10, 300, 50);

        add(lblHelp);

    }

    public static void main(String[] args) {
        HelpGUI helpGUI = new HelpGUI();
    }
}
