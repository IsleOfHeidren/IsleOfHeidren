package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.github.isleofheidren.game.models.StoryEvent;
import com.github.isleofheidren.game.repos.StoryEventRepo;

import java.util.List;

/**/
public class Map extends Table {
    private int[][] grid;
    private int curCol = 6;
    private int curRow = 9;
    private final Pixmap markerPixmap;

    /**
     * Default map constructor
     */
    public Map() {
        super();

        FileHandle currentLocationFileHandle = Gdx.files.internal("current_location_marker.png");
        markerPixmap = new Pixmap(currentLocationFileHandle);

        initGrid();

        moveMarker();
    }

    /**
     * Moves the map marker displayed to the correct position based on the current col and current row
     */
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

        displayMap.dispose();
    }

    /**
     * Sets all values in grid to -1 or to the sequence value of the story sequence that exists in that spot
     */
    private void initGrid() {
        grid = new int[10][10];

        setAllPositionsToNegativeOne();

        StoryEventRepo repo = new StoryEventRepo();
        List<StoryEvent> storyEvents = repo.getAll();

        for (int i = 0; i < storyEvents.size(); i++) {
            StoryEvent event = storyEvents.get(i);

            if (event.getLocX() != -1 && event.getLocY() != -1) {
                if (grid[event.getLocX()][event.getLocY()] == -1) {
                    grid[event.getLocX()][event.getLocY()] = event.getSequence();
                }
            }
        }
    }

    /**
     * Sets all the ints in the grid to -1
     */
    private void setAllPositionsToNegativeOne() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = -1;
            }
        }
    }

    /**
     * Returns the seq number in the current grid pos
     * @return the sequence number
     */
    private int getSeqForGridPos() {
        return grid[curCol][curRow];
    }

    /**
     * Moves the current map position and marker north by one square
     * @return the sequence number for the new square we are in
     */
    public int goNorth() {
        if (canGoNorth()) {
            curRow--;
        }

        moveMarker();
        return getSeqForGridPos();
    }

    /**
     * Moves the current map position and marker south by one square
     * @return the sequence number for the new square we are in
     */
    public int goSouth() {
        if (canGoSouth()) {
            curRow++;
        }

        moveMarker();
        return getSeqForGridPos();
    }

    /**
     * Moves the current map position and marker east by one square
     * @return the sequence number for the new square we are in
     */
    public int goEast() {
        if (canGoEast()) {
            curCol++;
        }

        moveMarker();
        return getSeqForGridPos();
    }

    /**
     * Moves the current map position and marker west by one square
     * @return the sequence number for the new square we are in
     */
    public int goWest() {
        if (canGoWest()) {
            curCol--;
        }

        moveMarker();
        return getSeqForGridPos();
    }

    /**
     * Returns if the current map position can go further north in the 10x10 grid. Returns false if cur row = 0
     * @return boolean for if the move can be done
     */
    public boolean canGoNorth() {
        return curRow != 0;
    }

    /**
     * Returns if the current map position can go further south in the 10x10 grid. Returns false if cur row = 9
     * @return boolean for if the move can be done
     */
    public boolean canGoSouth() {
        return curRow != 9;
    }

    /**
     * Returns if the current map position can go further east in the 10x10 grid. Returns false if cur col = 9
     * @return boolean for if the move can be done
     */
    public boolean canGoEast() {
        return curCol != 9;
    }

    /**
     * Returns if the current map position can go further west in the 10x10 grid. Return false if cur col = 0
     * @return boolean for if the move can be done
     */
    public boolean canGoWest() {
        return curCol != 0;
    }
}
