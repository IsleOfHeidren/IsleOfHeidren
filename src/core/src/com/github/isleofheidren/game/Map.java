package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.io.File;

public class Map extends Table {
    private short[][] grid;
    private int curCol;
    private int curRow;

    private Pixmap mapImage;
    public Map() {
        super();

        FileHandle mapImage = Gdx.files.internal("game_map.png");
        Pixmap pixmap = new Pixmap(mapImage);

        FileHandle xImage = Gdx.files.internal("current_location_marker.png");
        Pixmap xMap = new Pixmap(xImage);

        pixmap.drawPixmap(xMap, 252 - (xMap.getWidth() / 2), 189 - (xMap.getHeight() / 2));

        this.add(new Image(new Texture(pixmap)));

        initGrid();
    }

    private void moveXImage() {
        int xStarting = 252;
        int yStarting = 189;

        int x = xStarting + (167 * curCol);
        int y = yStarting + (167 * curRow);


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
    }

    public void goSouth() {
        if (canGoSouth()) {
            curRow++;
        }
    }

    public void goEast() {
        if (canGoEast()) {
            curCol++;
        }
    }

    public void goWest() {
        if (canGoWest()) {
            curCol--;
        }
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
