package AnnatTest;

import javax.swing.*;
import java.awt.*;

/*
Länk till spelet: https://codereview.stackexchange.com/questions/85833/basic-memory-match-game-in-java
 */

public class Game {
    public static void main(String[] args){
        Board b = new Board();
        b.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
        b.setLocation(500, 250);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }
}