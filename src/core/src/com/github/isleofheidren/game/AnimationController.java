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
    private final boolean addBackground;
    private List<Pixmap> pixmapList;
    private List<Pixmap> highlightPixmapList;
    private String spriteName;
    private int currentKey = 0;
    private boolean highlight;
    private Pixmap blackScreen;

    public AnimationController(String spriteName) {
        super();

        this.spriteName = spriteName;
        pixmapList = new ArrayList<>();
        highlightPixmapList = new ArrayList<>();
        loadFiles();

        highlight = false;
        addBackground = false;
    }

    public AnimationController(String spriteName, boolean addBackground) {
        super();

        this.spriteName = spriteName;
        pixmapList = new ArrayList<>();
        highlightPixmapList = new ArrayList<>();
        loadFiles();

        highlight = false;
        this.addBackground = addBackground;
    }

    private void loadFiles() {
        FileHandle f = Gdx.files.internal("sprites/" + spriteName + "-0.png");
        if (!f.exists()) {
            spriteName = "ape";
        }

        int count = 0;
        f = Gdx.files.internal("sprites/" + spriteName + "-0.png");
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

        f = Gdx.files.internal("black_screen.png");
        Pixmap p = new Pixmap(f);
        blackScreen = p;
    }

    public void goToNextKeyFrame() {
        this.clear();

        Image image;
        Pixmap toBeDrawn = null;
        if (highlight) {
            toBeDrawn = highlightPixmapList.get(currentKey);
        }
        else {
            toBeDrawn = pixmapList.get(currentKey);
        }

        if (addBackground) {
            image = new Image(new Texture(toBeDrawn));

        }
        else {
            image = new Image(new Texture(toBeDrawn));
            image.setScaleX(.55f);
        }

        image.setFillParent(true);



        this.add(image).expand();

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
    public String getSpriteName() {
        return this.spriteName;
    }
}
