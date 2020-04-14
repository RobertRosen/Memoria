import javax.swing.*;

public class Run {
    /**
     * Ta bort kommentar för att se gui för Score
     */
    public Run(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        GuiTest test = new GuiTest();
        Score score = new Score();
       // frame.add(test);
        frame.add(score);
        frame.pack();


    }
}
