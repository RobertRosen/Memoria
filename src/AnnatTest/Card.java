package AnnatTest;

import javax.swing.*;

public class Card extends JButton {

    private String symbol;

    private boolean matched = false;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    }
}
