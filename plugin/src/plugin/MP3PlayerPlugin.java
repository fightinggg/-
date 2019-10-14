package plugin;

import javax.swing.*;

public class MP3PlayerPlugin implements IPlayerPlugin {

    public void loadFile(String filename) {
        JOptionPane.showMessageDialog(null, "MP3-loadFile" + filename, "", JOptionPane.NO_OPTION);
    }

    public void play() {
        JOptionPane.showMessageDialog(null, "MP3-play", "", JOptionPane.NO_OPTION);
    }

    public void stop() {
        JOptionPane.showMessageDialog(null, "MP3-stop", "", JOptionPane.NO_OPTION);

    }

    public void pause() {
        JOptionPane.showMessageDialog(null, "MP3-pause", "", JOptionPane.NO_OPTION);
    }
}
