package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Map extends Table {
    private short[][] grid;
    private int curCol;
    private int curRow;
    private final Pixmap markerPixmap;
    public Map() {
        super();

        FileHandle currentLocationFileHandle = Gdx.files.internal("current_location_marker.png");
        markerPixmap = new Pixmap(currentLocationFileHandle);

        initGrid();

        moveMarker();
    }

    private void moveMarker() {
        int xStarting = 252;
        int yStarting = 189;

        int x = xStarting + (167 * curCol) - (markerPixmap.getWidth() / 2);
        int y = yStarting + (125 * curRow) - (markerPixmap.getWidth() / 2);

        FileHandle mapFileHandle = Gdx.files.internal("game_map.png");
        Pixmap displayMap = new Pixmap(mapFileHandle);
        displayMap.drawPixmap(markerPixmap, x, y);
        this.clear();
        this.add(new Image(new Texture(displayMap)));
    }

    private void initGrid() {
        grid = new short[10][10];

        setAllPositionsToZero();
    }

    private void setAllPositionsToZero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void setLocation(int row, int col) {
        this.curCol = col;
        this.curRow = row;
    }

    public void goNorth() {
        if (canGoNorth()) {
            curRow--;
        }

        moveMarker();
    }

    public void goSouth() {
        if (canGoSouth()) {
            curRow++;
        }

        moveMarker();
    }

    public void goEast() {
        if (canGoEast()) {
            curCol++;
        }

        moveMarker();
    }

    public void goWest() {
        if (canGoWest()) {
            curCol--;
        }

        moveMarker();
    }

    public boolean canGoNorth() {
        return curRow != 0;
    }

    public boolean canGoSouth() {
        return curRow != 9;
    }

    public boolean canGoEast() {
        return curCol != 9;
    }

    public boolean canGoWest() {
        return curCol != 0;
    }
}
