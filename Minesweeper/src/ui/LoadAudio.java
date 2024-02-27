package ui;

import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class LoadAudio {
    public static Hashtable<String, Clip> listAudio;

    public static void LoadData() {
        listAudio = new Hashtable<>();

        try {


            AudioInputStream loseInputStream = AudioSystem.getAudioInputStream(new File("assets/audio/lose.wav"));
            AudioFormat loseBaseFormat = loseInputStream.getFormat();
            AudioFormat loseDecodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    loseBaseFormat.getSampleRate(),
                    16,
                    loseBaseFormat.getChannels(),
                    loseBaseFormat.getChannels() * 2,
                    loseBaseFormat.getSampleRate(),
                    false
            );
            AudioInputStream lose =
                    AudioSystem.getAudioInputStream(
                            loseDecodeFormat, loseInputStream);
            Clip loseClip = AudioSystem.getClip();
            loseClip.open(lose);

            AudioInputStream winInputStream = AudioSystem.getAudioInputStream(new File("assets/audio/win.wav"));
            AudioFormat winBaseFormat = winInputStream.getFormat();
            AudioFormat winDecodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    winBaseFormat.getSampleRate(),
                    16,
                    winBaseFormat.getChannels(),
                    winBaseFormat.getChannels() * 2,
                    winBaseFormat.getSampleRate(),
                    false
            );
            AudioInputStream win =
                    AudioSystem.getAudioInputStream(
                            winDecodeFormat, winInputStream);
            Clip winClip = AudioSystem.getClip();
            winClip.open(win);

            listAudio.put("Lose", loseClip);
            listAudio.put("Win", winClip);
//            listAudio.get("Bomb").start();
//            listAudio.get("Lose").start();
//            listAudio.get("Win").start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void playLose(){
        listAudio.get("Lose").start();
    }

    public static void playWin(){
        listAudio.get("Win").start();
    }

}
