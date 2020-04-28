import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpGUI extends JFrame implements ActionListener {

    public CardLayout card = new CardLayout();
    public JPanel container = new JPanel();
    public JPanel panel1 = new JPanel();
    public JPanel panel2 = new JPanel();
    public JPanel panel3 = new JPanel();
    public JPanel panel4 = new JPanel();
    public JPanel panel5 = new JPanel();
    public JPanel panel6 = new JPanel();

    public JButton btn[] = new JButton[6];

    public HelpGUI(){
        container.setLayout(card);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
        panel6.setLayout(null);

        for (int i = 0; i <btn.length; i++){
            btn[i] = new JButton("Nästa");
            btn[i].setBounds(200,350,100,40);
            btn[i].addActionListener(this);
        }

        panel1.add(btn[0]);
        panel2.add(btn[1]);
        panel3.add(btn[2]);
        panel4.add(btn[3]);
        panel5.add(btn[4]);
        panel6.add(btn[5]);

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

    public static void main(String[] args) {
        HelpGUI c = new HelpGUI();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < btn.length; i++){
            if (e.getSource() == btn[0]){
                card.show(container, "" + 3);
            }
            if (e.getSource() == btn[1]){
                card.show(container, "" + 4);
            }
            if (e.getSource() == btn[2]){
                card.show(container, "" + 5);
            }
            if (e.getSource() == btn[3]){
                card.show(container, "" + 6);
            }
            if (e.getSource() == btn[4]){
                card.show(container, "" + 7);
            }
            if (e.getSource() == btn[5]){
                card.show(container, "" + 2);
            }
        }
    }
}
