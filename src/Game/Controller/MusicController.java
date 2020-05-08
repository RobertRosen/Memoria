package Game.Controller;

import javax.sound.sampled.Clip;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 * This class contains all the code for the music functions in the SettingsGUI
 * @version 3.0
 * @author Yasir Kakar
 */
public class MusicController{
    private static Clip clip;

    /**
     * This class lets the user to start och stop the chosen song
     * @version 3.0
     * @author Yasir Kakar
     */
    public static class PlayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            playMusic("music/TakeMeBack.wav");//Filepath for the chosen background song
        }

        /**
         * This method plays the music chosen for the background music in a loop
         * @version 3.0
         * @author Yasir Kakar
         */
        public void playMusic(String filename){
            try {
                File file = new File(filename);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This class allows the user to turn off the music either through
     * the settingsGUI or by closing the program
     * @version 3.0
     * @author Yasir Kakar
     */
    public static class StopListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {//stops the music
            clip.stop();
        }
    }

}
