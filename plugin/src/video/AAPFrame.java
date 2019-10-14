package video;

import plugin.IPlayerPlugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;

public class AAPFrame extends JFrame {
    private IPlayerPlugin pPlugin;

    public void goGOGO() {
        JFrame frame = new JFrame("音乐播放器");
        JTextField jf = new JTextField(20);
        JButton choose_bt = new JButton("choose file");
        JButton play_bt=new JButton("play");
        JButton stop_bt=new JButton("stop");
        JButton pause_bt=new JButton("pause");
        frame.setLayout(new FlowLayout());
        frame.add(jf);
        frame.add(choose_bt);
        frame.add(play_bt);
        frame.add(stop_bt);
        frame.add(pause_bt);

        frame.setSize(600, 300);
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        choose_bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filename = jf.getText();
                try {
                    String name = filename.substring(filename.lastIndexOf(".") + 1);
                    String clas=AAPlayer.nametoclass.get(name);
                    Class c = Class.forName(clas);
                    pPlugin = (IPlayerPlugin) c.newInstance();
                    pPlugin.loadFile(filename);
                } catch (Exception x
                ) {
                    System.out.println(x);
                }
            }
        });

        play_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pPlugin.play();
            }
        });

        stop_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pPlugin.stop();
            }
        });

        pause_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pPlugin.pause();
            }
        });
    }
}
