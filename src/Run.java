import javax.swing.*;

public class Run {
    /**
     * Ta bort kommentar för att se gui för Score
     */
    public void start(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        GuiTest test = new GuiTest();
        Score score = new Score();
        frame.add(test);
       // frame.add(score);
        frame.pack();


    }
    public static void main(String[] args){
        Run run = new Run();
        run.start();
    }
}