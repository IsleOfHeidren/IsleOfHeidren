package com.github.isleofheidren.game.repos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.github.isleofheidren.game.models.PlayerCharacter;
import com.github.isleofheidren.game.models.StoryEvent;
import com.google.gson.Gson;

public class PlayerCharacterRepo implements JSONRepo<PlayerCharacter> {

    @Override
    public PlayerCharacter get(String id) {
        String filePath = "data/players/" + id + ".json";
        FileHandle file = Gdx.files.internal(filePath);

        Gson gson = new Gson();
        return gson.fromJson(file.reader(), PlayerCharacter.class);
    }
}
