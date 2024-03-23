package com.github.isleofheidren.game.repos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.github.isleofheidren.game.models.Monster;
import com.google.gson.Gson;

public class MonsterRepo implements JSONRepo<Monster> {
    @Override
    public Monster get(String id) {
        String filePath = "data/monsters/" + id + ".json";
        FileHandle file = Gdx.files.internal(filePath);

        Gson gson = new Gson();
        return gson.fromJson(file.reader(), Monster.class);
    }
}
