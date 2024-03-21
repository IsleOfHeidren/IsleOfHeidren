package com.github.isleofheidren.game.repos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.github.isleofheidren.game.models.Event;
import com.github.isleofheidren.game.models.StoryEvent;
import com.google.gson.Gson;

/*
Repo for story game events
 */
public class StoryEventRepo implements JSONRepo<StoryEvent> {

    /*
    Gets a story event based on the ID
     */
    @Override
    public StoryEvent get(String id) {
        String filePath = "data/events/" + id + ".json";
        FileHandle file = Gdx.files.internal(filePath);

        Gson gson = new Gson();
        return gson.fromJson(file.reader(), StoryEvent.class);
    }
}
