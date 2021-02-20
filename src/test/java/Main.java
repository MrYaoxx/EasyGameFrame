import org.GameFrame.frame.FrameInfo;
import org.GameFrame.frame.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class Main {
    public static void main(String[] args) {
        GameFrame frame = new GameFrame(new FrameInfo("Test", new Dimension(200, 200), null, JFrame.EXIT_ON_CLOSE, false, true));

        MouseAdapter a = frame.getMouseDragWindowAdapter(new Point(0, 0), frame.getDimensionByPercent(50, 50));
        frame.addMouseDragWindowAdapter(a);
    }
}
