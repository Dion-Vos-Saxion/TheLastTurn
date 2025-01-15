package utils;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {
    private Clip clip; // Cached clip instance

    public Sound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // forcing audio format to be 44100 Hz and 16-bit sample rate
            AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100,
                    16, 2, 4, 44100, false);
            audioStream = AudioSystem.getAudioInputStream(targetFormat, audioStream);

            // Cache the clip
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        new Thread(() -> {
            try {
                if (clip.isRunning()) {
                    clip.stop();
                }
                clip.setFramePosition(0);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public boolean isPlaying() {
        return clip.isRunning();
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /**
     * A volume value between 0 and 1
     * @param volume
     */
    public void setVolume(float volume) {
        if (volume < 0.0f) volume = 0.0f;
        if (volume > 1.0f) volume = 1.0f;

        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            float minGain = volumeControl.getMinimum();
            float maxGain = volumeControl.getMaximum();

            float targetGain = minGain + (maxGain - minGain) * volume;

            volumeControl.setValue(targetGain);
        } else {
            System.out.println("Volume control not supported for this clip.");
        }
    }
}
