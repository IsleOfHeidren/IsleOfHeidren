package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;
import java.util.List;

public class AnimationController extends Table {
    private List<Pixmap> pixmapList;
    private List<Pixmap> highlightPixmapList;
    private String spriteName;
    private int currentKey = 0;
    private boolean highlight;

    public AnimationController(String spriteName) {
        super();

        this.spriteName = spriteName;
        pixmapList = new ArrayList<>();
        highlightPixmapList = new ArrayList<>();
        loadFiles();

        highlight = false;
    }

    private void loadFiles() {
        int count = 0;
        FileHandle f = Gdx.files.internal("sprites/" + spriteName + "-0.png");
        while (f.exists()) {
            Pixmap p = new Pixmap(f);
            pixmapList.add(p);

            count++;
            f = Gdx.files.internal("sprites/" + spriteName + "-" + count + ".png");
        }

        count = 0;
        f = Gdx.files.internal("sprites/" + spriteName + "-highlight-0.png");
        while (f.exists()) {
            Pixmap p = new Pixmap(f);
            highlightPixmapList.add(p);

            count++;
            f = Gdx.files.internal("sprites/" + spriteName + "-highlight-" + count + ".png");
        }
    }

    public void goToNextKeyFrame() {
        this.clear();

        Image i;
        if (highlight) {
            i = new Image(new Texture(highlightPixmapList.get(currentKey)));
        }
        else {
            i = new Image(new Texture(pixmapList.get(currentKey)));
        }

        i.setScale(.5f);
        this.add(i);

        if (currentKey >= pixmapList.size() - 1) {
            currentKey = 0;
        }
        else {
            currentKey++;
        }
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public boolean getHighlight() {
        return this.highlight;
    }
}
