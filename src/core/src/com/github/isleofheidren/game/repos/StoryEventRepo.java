package com.github.isleofheidren.game.repos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.github.isleofheidren.game.models.Event;
import com.github.isleofheidren.game.models.StoryEvent;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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

    public StoryEvent getByMapPosition(int row, int col) {
        List<StoryEvent> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMapPosition().equals(row + "," + col)) {
                return  list.get(i);
            }
        }
        return null;
    }

    public List<StoryEvent> getAll() {
        String path = "data/events/1.json";
        int index = 1;
        ArrayList<StoryEvent> al = new ArrayList<>();
        while (Gdx.files.internal(path).exists()) {
            al.add(get(String.valueOf(index)));
            index++;
        }

        return al;
    }
}
