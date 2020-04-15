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
        frame.add(test);
        frame.pack();


    }

    public static void main(String[] args) {
        Run run = new Run();
    }
}
