package net;

import main.Game;

public class Map {

    public Boolean[][] map;
    public Boolean[][] nextMap;
    public int xyBlocks = Game.windowSize / 10;


    public Map() {
        map = new Boolean[xyBlocks][xyBlocks];
        for (int x = 0; x < xyBlocks - 1; x++) {
            for (int y = 0; y < xyBlocks - 1; y++) {
                map[x][y] = false;
            }
        }
        nextMap = new Boolean[xyBlocks][xyBlocks];
    }


    public void next() {
        for (int x = 0; x < xyBlocks; x++) {
            for (int y = 0; y < xyBlocks; y++) {
                int count = countLife(x, y);
                if (map[x][y] != null) {
                    if (map[x][y]) {
                        if (count > 3 || count < 2) {
                            nextMap[x][y] = false;
                        } else {
                            nextMap[x][y] = true;
                        }
                    } else {
                        if (count == 3) {
                            nextMap[x][y] = true;
                        } else {
                            nextMap[x][y] = false;
                        }
                    }
                } else {
                    nextMap[x][y] = false;
                }
            }
        }
        map = nextMap;
        nextMap = new Boolean[xyBlocks][xyBlocks];
    }

    public int countLife(int x, int y) {
        int count = 0;


        if (map[(x - 1 + xyBlocks) % (xyBlocks)][(y - 1 + xyBlocks) % (xyBlocks)] != null && map[(x - 1 + xyBlocks) % (xyBlocks)][(y - 1 + xyBlocks) % (xyBlocks)]) {
            count++;
        }
        if (map[(x - 1 + xyBlocks) % (xyBlocks)][y] != null && map[(x - 1 + xyBlocks) % (xyBlocks)][y]) {
            count++;
        }
        if (map[(x - 1 + xyBlocks) % (xyBlocks)][(y + 1 + xyBlocks) % (xyBlocks)] != null && map[(x - 1 + xyBlocks) % (xyBlocks)][(y + 1 + xyBlocks) % (xyBlocks)]) {
            count++;
        }
        if (map[x][(y + 1 + xyBlocks) % (xyBlocks)] != null && map[x][(y + 1 + xyBlocks) % (xyBlocks)]) {
            count++;
        }
        if (map[x][(y - 1 + xyBlocks) % (xyBlocks)] != null && map[x][(y - 1 + xyBlocks) % (xyBlocks)]) {
            count++;
        }
        if (map[(x + 1 + xyBlocks) % (xyBlocks)][(y - 1 + xyBlocks) % (xyBlocks)] != null && map[(x + 1 + xyBlocks) % (xyBlocks)][(y - 1 + xyBlocks) % (xyBlocks)]) {
            count++;
        }
        if (map[(x + 1 + xyBlocks) % (xyBlocks)][y] != null && map[(x + 1 + xyBlocks) % (xyBlocks)][y]) {
            count++;
        }
        if (map[(x + 1 + xyBlocks) % (xyBlocks)][(y + 1 + xyBlocks) % (xyBlocks)] != null && map[(x + 1 + xyBlocks) % (xyBlocks)][(y + 1 + xyBlocks) % (xyBlocks)]) {
            count++;
        }


        return count;
    }
}
