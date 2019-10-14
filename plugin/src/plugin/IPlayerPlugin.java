package plugin;

public interface IPlayerPlugin {
    public void loadFile(String filename);
    public void play();
    public void stop();
    public void pause();
}
