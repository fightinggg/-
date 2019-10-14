package plugin;

import javax.swing.*;

public class WAVPlayerPlugin implements IPlayerPlugin {
    public void loadFile(String filename) {
        JOptionPane.showMessageDialog(null, "WAV-loadFile" + filename, "", JOptionPane.NO_OPTION);
    }

    public void play() {
        JOptionPane.showMessageDialog(null, "WAV-play", "", JOptionPane.NO_OPTION);
    }

    public void stop() {
        JOptionPane.showMessageDialog(null, "WAV-stop", "", JOptionPane.NO_OPTION);

    }

    public void pause() {
        JOptionPane.showMessageDialog(null, "WAV-pause", "", JOptionPane.NO_OPTION);
    }
}
