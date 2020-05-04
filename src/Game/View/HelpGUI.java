package Game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klassen Game.Controller.Game.Model.View.HelpGUI innehåller allt som finns med i Memorias hjälpcenter
 * @version 1.0
 * @author Yasir Kakar
 */
public class HelpGUI extends JFrame {

    private CardLayout card = new CardLayout();
    private JPanel container = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();

    private JButton btnNext[] = new JButton[6];
    private JButton btnOK[] = new JButton[6];

    public HelpGUI(){
        container.setLayout(card);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
        panel6.setLayout(null);

        createButtons();

        panel1.add(btnNext[0]);
        panel2.add(btnNext[1]);
        panel3.add(btnNext[2]);
        panel4.add(btnNext[3]);
        panel5.add(btnNext[4]);
        panel6.add(btnNext[5]);

        panel1.add(btnOK[0]);
        panel2.add(btnOK[1]);
        panel3.add(btnOK[2]);
        panel4.add(btnOK[3]);
        panel5.add(btnOK[4]);
        panel6.add(btnOK[5]);

        panel1.add(new Panel1());
        panel2.add(new Panel2());
        panel3.add(new Panel3());
        panel4.add(new Panel4());
        panel5.add(new Panel5());
        panel6.add(new Panel6());

        setSize(550,435);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(container);

        container.add(panel1, "2");
        container.add(panel2, "3");
        container.add(panel3, "4");
        container.add(panel4, "5");
        container.add(panel5, "6");
        container.add(panel6, "7");

        card.show(container, "1");

    }
    //skapar knapparna "Nästa" och "OK" som finns i GUIT
    public void createButtons(){

        for (int i = 0; i < btnNext.length; i++){
            btnNext[i] = new JButton("Nästa");
            btnNext[i].setBounds(150,350,100,40);
            btnNext[i].addActionListener(new NextListener());
        }

        for (int i = 0; i < btnOK.length; i++){
            btnOK[i] = new JButton("OK");
            btnOK[i].setBounds(300,350,100,40);
            btnOK[i].addActionListener(new OKListener());
        }
    }

    //Inre klasserna nedan är de olika panelerna som visas när spelaren klickar på frågetecknet i MenuGUIT
    class Panel1 extends JPanel {
        private ImageIcon hjälp1Bild = new ImageIcon("images/hjälp1.PNG");

        private JLabel lblbild = new JLabel(hjälp1Bild);
        public Panel1(){
            setSize(550,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    class Panel2 extends JPanel {
        private ImageIcon hjälp2Bild = new ImageIcon("images/hjälp2.PNG");

        private JLabel lblbild = new JLabel(hjälp2Bild);
        public Panel2(){
            setSize(550,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            lblbild.setBounds(0,0,550,350);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    class Panel3 extends JPanel {
        private ImageIcon hjälp3Bild = new ImageIcon("images/hjälp3.PNG");

        private JLabel lblbild = new JLabel(hjälp3Bild);
        public Panel3(){
            setSize(550,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            lblbild.setBounds(0,0,550,350);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    class Panel4 extends JPanel {
        private ImageIcon hjälp4Bild = new ImageIcon("images/hjälp4.PNG");

        private JLabel lblbild = new JLabel(hjälp4Bild);
        public Panel4(){
            setSize(550,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    class Panel5 extends JPanel {
        private ImageIcon hjälp5Bild = new ImageIcon("images/hjälp5.PNG");

        private JLabel lblbild = new JLabel(hjälp5Bild);
        public Panel5(){
            setSize(550,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    class Panel6 extends JPanel {
        private ImageIcon hjälp6Bild = new ImageIcon("images/hjälp6.PNG");

        private JLabel lblbild = new JLabel(hjälp6Bild);
        public Panel6(){
            setSize(550,400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    //i denna klassen så finns funktionen för knappen "Nästa"
    class NextListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < btnNext.length; i++){
                if (e.getSource() == btnNext[0]){
                    card.show(container, "" + 3);
                }
                if (e.getSource() == btnNext[1]){
                    card.show(container, "" + 4);
                }
                if (e.getSource() == btnNext[2]){
                    card.show(container, "" + 5);
                }
                if (e.getSource() == btnNext[3]){
                    card.show(container, "" + 6);
                }
                if (e.getSource() == btnNext[4]){
                    card.show(container, "" + 7);
                }
                if (e.getSource() == btnNext[5]){
                    card.show(container, "" + 2);
                }
            }
        }
    }

    class OKListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public static void main(String[] args) {
        HelpGUI c = new HelpGUI();

    }


}
