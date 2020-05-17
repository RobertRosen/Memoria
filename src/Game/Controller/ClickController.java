package Game.Controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This class contains code the functions for both the click sound and the points sound
 * @version 4.0
 * @author Yasir Kakar
 */
public class ClickController {
    public static void click(String filename){
        Clip clip;
    try {
        File file = new File(filename);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
