import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGUI extends JFrame implements ActionListener{
    private JPanel mainPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel Mpanel = new JPanel();
    private JPanel estPanel = new JPanel();
    private JPanel panelP1 = new JPanel();
    private JPanel panelP2 = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JPanel infoPanel2 = new JPanel();
    private JPanel scorePanel = new JPanel();

   // private JPanel panelBonus = new JPanel();

    private ImageIcon card = new ImageIcon("images/math4.jpg");
    private ImageIcon iconPlus = new ImageIcon("images/plus.gif");
    private ImageIcon iconMinus = new ImageIcon("images/minus.gif");
    private ImageIcon iconPlus2 = new ImageIcon("images/plus.gif");
    private ImageIcon iconMinus2 = new ImageIcon("images/minus.gif");
    private ImageIcon iconPi = new ImageIcon("");
    private ImageIcon iconPi2 = new ImageIcon("");

    private ImageIcon bonus = new ImageIcon("images/bonus.jpg");
    private ImageIcon logo = new ImageIcon();
    private ImageIcon memoria = new ImageIcon("images/mem2.jpg");
    private ImageIcon red = new ImageIcon("images/blue.jpg");
    private ImageIcon mathLogo = new ImageIcon("images/mathLogo.JPG");

    private JButton btn1= new JButton(card);
    private JButton btn2= new JButton(card);
    private JButton btn3= new JButton(card);
    private JButton btn4= new JButton(card);
    private JButton btn5= new JButton(card);
    private JButton btn6= new JButton(card);
    private JButton btn7= new JButton(card);
    private JButton btn8= new JButton(card);
    private JButton btn9= new JButton(card);
    private JButton btn10= new JButton(card);
    private JButton btn11= new JButton(card);
    private JButton btn12= new JButton(card);
    private JButton btn13= new JButton(card);
    private JButton btn14= new JButton(card);
    private JButton btn15= new JButton(card);
    private JButton btn16= new JButton(card);
    private JButton btn17= new JButton(card);
    private JButton btn18= new JButton(card);
    private JButton btn19= new JButton(card);
    private JButton btn20= new JButton(card);
    private JButton btn21= new JButton(card);
    private JButton btn22= new JButton(card);
    private JButton btn23= new JButton(card);
    private JButton btn24= new JButton(card);

    private JButton panelBonus = new JButton(bonus);
    private JLabel logo1 = new JLabel(logo);

    private ImageIcon[] iconArray = new ImageIcon[6];

    private JLabel label = new JLabel(memoria);
    private JLabel ghost = new JLabel(red);
    private JLabel ghost2 = new JLabel(red);
    private JLabel ghost3 = new JLabel(red);
    private JLabel ghost4 = new JLabel(red);
    private JLabel ghost5 = new JLabel();
    private JLabel ghost6 = new JLabel();
    private JLabel ghost7 = new JLabel(red);
    private JLabel ghost8 = new JLabel(red);
    private JLabel ghost9 = new JLabel(mathLogo);
    private JLabel ghost10 = new JLabel();
    public BoardGUI(){
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        mainPanel.add(label);
        mainPanel.add(ghost9);
        mainPanel.add(ghost10);
        ghost9.setPreferredSize(new Dimension(135,35));
        ghost10.setPreferredSize(new Dimension(265,35));
        //label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ghost.setPreferredSize(new Dimension(340,20));
        ghost2.setPreferredSize(new Dimension(340,20));
        ghost3.setPreferredSize(new Dimension(125,20));
        ghost4.setPreferredSize(new Dimension(125,20));
        ghost5.setPreferredSize(new Dimension(120,18));
        ghost6.setPreferredSize(new Dimension(120,18));
        ghost7.setPreferredSize(new Dimension(125,20));
        ghost8.setPreferredSize(new Dimension(125,20));

        mainPanel.add(Mpanel);
        Mpanel.setPreferredSize(new Dimension(670,386));
       // Mpanel.setBackground(Color.WHITE);
        label.setPreferredSize(new Dimension(250,55));


        mainPanel.add(btn1);
        btn1.setPreferredSize(new Dimension(110,150));
        btn1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn1.setBackground(Color.WHITE);

        mainPanel.add(btn2);
        btn2.setPreferredSize(new Dimension(110,150));
        btn2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn2.setBackground(Color.WHITE);

        mainPanel.add(btn3);
        btn3.setPreferredSize(new Dimension(110,150));
        btn3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn3.setBackground(Color.WHITE);

        mainPanel.add(btn4);
        btn4.setPreferredSize(new Dimension(110,150));
        btn4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn4.setBackground(Color.WHITE);

        mainPanel.add(btn5);
        btn5.setPreferredSize(new Dimension(110,150));
        btn5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn5.setBackground(Color.WHITE);

        mainPanel.add(btn6);
        btn6.setPreferredSize(new Dimension(110,150));
        btn6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn6.setBackground(Color.WHITE);

        add(btn7);
        btn7.setPreferredSize(new Dimension(52,72));
        btn7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn7.setBackground(Color.WHITE);

        add(btn8);
        btn8.setPreferredSize(new Dimension(52,72));
        btn8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn8.setBackground(Color.WHITE);

        add(btn9);
        btn9.setPreferredSize(new Dimension(52,72));
        btn9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn9.setBackground(Color.WHITE);

        add(btn10);
        btn10.setPreferredSize(new Dimension(52,72));
        btn10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn10.setBackground(Color.WHITE);

        add(btn11);
        btn11.setPreferredSize(new Dimension(52,72));
        btn11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn11.setBackground(Color.WHITE);

        add(btn12);
        btn12.setPreferredSize(new Dimension(52,72));
        btn12.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn12.setBackground(Color.WHITE);

        add(btn13);
        btn13.setPreferredSize(new Dimension(52,72));
        btn13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn13.setBackground(Color.WHITE);

        add(btn14);
        btn14.setPreferredSize(new Dimension(52,72));
        btn14.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn14.setBackground(Color.WHITE);

        add(btn15);
        btn15.setPreferredSize(new Dimension(52,72));
        btn15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn15.setBackground(Color.WHITE);

        add(btn16);
        btn16.setPreferredSize(new Dimension(52,72));
        btn16.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn16.setBackground(Color.WHITE);

        add(btn17);
        btn17.setPreferredSize(new Dimension(52,72));
        btn17.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn17.setBackground(Color.WHITE);

        add(btn18);
        btn18.setPreferredSize(new Dimension(52,72));
        btn18.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn18.setBackground(Color.WHITE);

        add(btn19);
        btn19.setPreferredSize(new Dimension(52,72));
        btn19.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn19.setBackground(Color.WHITE);

        add(btn20);
        btn20.setPreferredSize(new Dimension(52,72));
        btn20.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn20.setBackground(Color.WHITE);

        add(btn21);
        btn21.setPreferredSize(new Dimension(52,72));
        btn21.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn21.setBackground(Color.WHITE);

        add(btn22);
        btn22.setPreferredSize(new Dimension(52,72));
        btn22.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn22.setBackground(Color.WHITE);

        add(btn23);
        btn23.setPreferredSize(new Dimension(52,72));
        btn23.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn23.setBackground(Color.WHITE);

        add(btn24);
        btn24.setPreferredSize(new Dimension(52,72));
        btn24.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn24.setBackground(Color.WHITE);




        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);
        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);
        btn17.addActionListener(this);
        btn18.addActionListener(this);
        btn19.addActionListener(this);
        btn20.addActionListener(this);
        btn21.addActionListener(this);
        btn22.addActionListener(this);
        btn23.addActionListener(this);
        btn24.addActionListener(this);

        Mpanel.add(panel);
        //panel.setBorder(BorderFactory.createTitledBorder(""));
        panel.add(ghost);
        panel.setPreferredSize(new Dimension(380,380));
        panel.setBackground(Color.WHITE);
        //panel.add(label);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btn10);
        panel.add(btn11);
        panel.add(btn12);
        panel.add(btn13);
        panel.add(btn14);
        panel.add(btn15);
        panel.add(btn16);
        panel.add(btn17);
        panel.add(btn18);
        panel.add(btn19);
        panel.add(btn20);
        panel.add(btn21);
        panel.add(btn22);
        panel.add(btn23);
        panel.add(btn24);
        panel.add(ghost2);

        Mpanel.add(estPanel);
        estPanel.add(ghost3);
        estPanel.setPreferredSize(new Dimension(126,380));
        estPanel.setBackground(Color.WHITE);

        estPanel.add(panelP1).setPreferredSize(new Dimension(126,100));
        estPanel.add(panelP2).setPreferredSize(new Dimension(126,100));
       // estPanel.setBorder(BorderFactory.createTitledBorder(""));
        estPanel.add(ghost6);
        estPanel.add(panelBonus).setPreferredSize(new Dimension(126,50));
       // estPanel.add(logo1).setPreferredSize(new Dimension(126,100));
        panelP1.setBorder(BorderFactory.createTitledBorder("Player one score"));
        panelP1.setBackground(Color.WHITE);
        panelP2.setBorder(BorderFactory.createTitledBorder("Player two score"));
        panelP2.setBackground(Color.WHITE);
        estPanel.add(ghost5);
        estPanel.add(ghost4);

        Mpanel.add(infoPanel, BorderLayout.EAST);
        Mpanel.setBackground(Color.WHITE);
        infoPanel.setPreferredSize(new Dimension(126,380));
        infoPanel.add(ghost7);
        infoPanel.setBackground(Color.WHITE);
        infoPanel.add(infoPanel2);
        infoPanel.add(scorePanel);
        infoPanel.add(logo1).setPreferredSize(new Dimension(126,96));
        infoPanel.add(ghost8);
        infoPanel2.setPreferredSize(new Dimension(126,100));
        scorePanel.setPreferredSize(new Dimension(126,100));
        infoPanel2.setBorder(BorderFactory.createTitledBorder("Info"));
        infoPanel2.setBackground(Color.WHITE);
        scorePanel.setBorder(BorderFactory.createTitledBorder("Highscore"));
        scorePanel.setBackground(Color.WHITE);

       // estPanel.setBorder(BorderFactory.createTitledBorder("Score"));
       // estPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.iconArray = randomArray();

    }

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btn1) {
                Image temp = iconArray[0].getImage();
                Image resizedImage = temp.getScaledInstance(200, 200,  Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                btn1.setIcon(icon);

            }
            if (e.getSource() == btn2) {
                Image temp = iconArray[1].getImage();
                Image resizedImage = temp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                btn2.setIcon(icon);

            }
            if (e.getSource() == btn3) {
                Image temp = iconArray[2].getImage();
                Image resizedImage = temp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                btn3.setIcon(icon);
            }
            if (e.getSource() == btn4) {
                Image temp = iconArray[3].getImage();
                Image resizedImage = temp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                btn4.setIcon(icon);
            }
            if (e.getSource() == btn5) {
                Image temp = iconArray[4].getImage();
                Image resizedImage = temp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                btn5.setIcon(icon);
            }
            if (e.getSource() == btn6) {
                Image temp = iconArray[5].getImage();
                Image resizedImage = temp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                btn6.setIcon(icon);
            }
        }

    public ImageIcon[] randomArray () {
        iconArray[0] = iconPlus;
        iconArray[1] = iconMinus;
        iconArray[2] = iconPlus2;
        iconArray[3] = iconMinus2;
        iconArray[4] = iconPi;
        iconArray[5] = iconPi2;


        for (int i = iconArray.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            ImageIcon temp = iconArray[i];
            iconArray[i] = iconArray[j];
            iconArray[j] = temp;
        }
        return iconArray;
    }

    public static void main(String[] args) {
        BoardGUI guiTest = new BoardGUI();
    }
    }



