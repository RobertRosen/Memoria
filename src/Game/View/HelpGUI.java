package Game.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains everything concerning the HelpGUI
 * @version 3.0
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

    /**
     * This constructor brings all the methods together for the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    public HelpGUI(){

        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);
        add(container);

        container.setLayout(card);
        card.show(container, "1");

        setLayouts();
        createButtons();
        addButtons();
        addInnerClasses();
        addPanels();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method lets the developers to place the panels anywhere necessary in the Frame
     * @version 3.0
     * @author Yasir Kakar
     */
    private  void setLayouts(){
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
        panel6.setLayout(null);

    }

    /**
     * This method adds the constructors of the innerclasses to the panels shown in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void addInnerClasses(){
        panel1.add(new Panel1());
        panel2.add(new Panel2());
        panel3.add(new Panel3());
        panel4.add(new Panel4());
        panel5.add(new Panel5());
        panel6.add(new Panel6());
    }

    /**
     * This method adds the Panels in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void addPanels(){
        container.add(panel1, "2");
        container.add(panel2, "3");
        container.add(panel3, "4");
        container.add(panel4, "5");
        container.add(panel5, "6");
        container.add(panel6, "7");

    }

    /**
     * This method adds the buttons in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void addButtons(){
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
    }

    /**
     * This method creates the buttons in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private void createButtons(){

        for (int i = 0; i < btnNext.length; i++){
            btnNext[i] = new JButton("N??sta");
            btnNext[i].setBounds(150,600,100,40);
            btnNext[i].addActionListener(new NextListener());
        }

        for (int i = 0; i < btnOK.length; i++){
            btnOK[i] = new JButton("OK");
            btnOK[i].setBounds(300,600,100,40);
            btnOK[i].addActionListener(new OKListener());
        }
    }

    /**
     * Each panelclass below contains the images that are presented in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private class Panel1 extends JPanel {
        private ImageIcon hj??lp1Bild = new ImageIcon("images/hj??lp1.PNG");

        private JLabel lblbild = new JLabel(hj??lp1Bild);
        public Panel1(){
            setSize(700,700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    private class Panel2 extends JPanel {
        private ImageIcon hj??lp2Bild = new ImageIcon("images/hj??lp2.PNG");

        private JLabel lblbild = new JLabel(hj??lp2Bild);
        public Panel2(){
            setSize(700,700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            lblbild.setBounds(0,0,550,350);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    private class Panel3 extends JPanel {
        private ImageIcon hj??lp3Bild = new ImageIcon("images/hj??lp3.PNG");

        private JLabel lblbild = new JLabel(hj??lp3Bild);
        public Panel3(){
            setSize(700,700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            lblbild.setBounds(0,0,550,350);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    private class Panel4 extends JPanel {
        private ImageIcon hj??lp4Bild = new ImageIcon("images/hj??lp4.PNG");

        private JLabel lblbild = new JLabel(hj??lp4Bild);
        public Panel4(){
            setSize(700,700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    private class Panel5 extends JPanel {
        private ImageIcon hj??lp5Bild = new ImageIcon("images/hj??lp5.PNG");

        private JLabel lblbild = new JLabel(hj??lp5Bild);
        public Panel5(){
            setSize(700,700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }
    private class Panel6 extends JPanel {
        private ImageIcon hj??lp6Bild = new ImageIcon("images/hj??lp6.PNG");

        private JLabel lblbild = new JLabel(hj??lp6Bild);
        public Panel6(){
            setSize(700,700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(lblbild);
            setBackground(Color.WHITE);
        }
    }

    /**
     * This class contains the functions for the "Next" button in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    private class NextListener implements ActionListener{

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

    /**
     * This class contains the functions for the "OK" button in the HelpGUI
     * @version 3.0
     * @author Yasir Kakar
     */
    class OKListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public static void main(String[] args) {
        HelpGUI helpGUI = new HelpGUI();

    }


}
