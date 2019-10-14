package plugin;

import javax.swing.*;

public class OGGPlayerPlugin implements IPlayerPlugin{
    public void loadFile(String filename) {
        JOptionPane.showMessageDialog(null, "OGG-loadFile" + filename, "", JOptionPane.NO_OPTION);
    }

    public void play() {
        JOptionPane.showMessageDialog(null, "OGG-play", "", JOptionPane.NO_OPTION);
    }

    public void stop() {
        JOptionPane.showMessageDialog(null, "OGG-stop", "", JOptionPane.NO_OPTION);

    }

    public void pause() {
        JOptionPane.showMessageDialog(null, "OGG-pause", "", JOptionPane.NO_OPTION);
    }
}
