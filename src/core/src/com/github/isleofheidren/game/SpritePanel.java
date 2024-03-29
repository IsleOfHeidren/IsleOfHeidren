package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class SpritePanel extends Table {
    Animation<TextureRegion> runningAnimation;

    Table spriteTable;
    TextureAtlas spriteAtlas;

    public Table createSpritePanel() {
        spriteAtlas = new TextureAtlas("skin/sprites.atlas");
        runningAnimation = new Animation<TextureRegion>(0.33f, spriteAtlas.findRegions("gnome"), Animation.PlayMode.LOOP);



        return spriteTable;
    }
}
