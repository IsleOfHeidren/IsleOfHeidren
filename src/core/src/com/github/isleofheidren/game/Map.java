package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Map extends Table {
    private short[][] grid;
    private int curCol;
    private int curRow;

    public Map() {
        super();

        FileHandle mapImage = Gdx.files.internal("game_map.png");
        Pixmap pixmap = new Pixmap(mapImage);


        this.add(new Image(new Texture(pixmap)));

        initGrid();
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



}
