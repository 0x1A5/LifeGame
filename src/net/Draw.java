package net;

import main.Game;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    public Boolean[][] map = new Boolean[60][60];
    public int fpsCount = 0;
    public int windowSize = Game.windowSize;

    public Draw() {
    }

    public void rePaint(Boolean[][] $map) {
        map = $map;
        fpsCount++;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, windowSize, windowSize);

        g.setColor(Color.black);

        for (int x = 0; x < (windowSize / 10 - 1); x++) {
            for (int y = 0; y < (windowSize / 10 - 1); y++) {
                if (map[x][y] != null) {
                    if (map[x][y]) {
                        g.fillRect(10 * x, 10 * y, 10, 10);
                    }
                }
            }
        }

        g.setColor(new Color(127, 127, 127));
        g.drawString(("Total: " + fpsCount), 0, 10);
    }
}
