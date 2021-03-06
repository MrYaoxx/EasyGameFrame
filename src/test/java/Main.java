import io.github.mryaoxx.EasyGameFrame.frame.FrameInfo;
import io.github.mryaoxx.EasyGameFrame.frame.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        GameFrame frame = new GameFrame(new FrameInfo("Test", null, new Dimension(200, 200), null, JFrame.EXIT_ON_CLOSE, true));

        int id = frame.addMouseDragWindowAdapter(new Point(), frame.getSize());

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                frame.removeMouseDragWindowAdapter(id);
            }
        });

        frame.setVisible(true);
    }
}
