package Game.Controller;

import javax.sound.sampled.Clip;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 * MusicController är en klass som innehåller logiken för musiken i SettingsGUIt
 * @version 1.0
 * @author Yasir Kakar
 */
public class MusicController{
    private static Clip clip;


    public static class PlayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            playMusic("music/TakeMeBack.wav");//Filväg till valda låt
        }

        //Denna metod startar musiken som ska spelas upp i bakgrunden i en loop tills spelaren stänger
        //av antingen spelet eller musiken via inställningarna
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


    public static class StopListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {//stops the music
            clip.stop();
        }
    }

}
