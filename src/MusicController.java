
import javax.sound.sampled.Clip;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MusicController{
    private static Clip clip;


    public static class PlayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            playMusic("music/Rune.wav");//filepath to the chosen song
        }
        public void playMusic(String filename){//this metod starts the music
            try {
                File file = new File(filename);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }catch (Exception e){

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
