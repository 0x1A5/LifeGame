package main;

import net.Draw;
import net.Map;

import javax.swing.*;
import java.util.TimerTask;

public class Game {
    public static JFrame window;
    public static Map map;
    public static Draw draw;

    public static int windowSize = 800;

    public static void fps() {
        new Thread(() -> {
            for (int i = 0; i < ((double) (windowSize * windowSize) / 100 * .45); i++) {
                int x = (int) (Math.random() * ((double) windowSize / 10));
                int y = (int) (Math.random() * ((double) windowSize / 10));
                map.map[x][y] = true;
            }
            draw.rePaint(map.map);
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                map.next();
                draw.rePaint(map.map);
            }
        }).start();
    }

    public static void windowInit() {
        window = new JFrame();
        window.setTitle("Life Game -- Made By 0x1A5");
        window.setSize(windowSize, windowSize);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void renderInit() {
        map = new Map();
        draw = new Draw();
        window.add(draw);
    }

    public static int getArgs(String[] args, String key) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals(key)) {
                return Integer.valueOf(args[i + 1]);
            }
        }
        return 80;
    }

    public static void main(String[] args) {
        windowSize = getArgs(args, "-windowBlocks") * 10;
        windowInit();
        renderInit();
        window.setVisible(true);

        fps();
    }
}
