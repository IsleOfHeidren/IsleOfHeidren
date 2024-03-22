package com.github.isleofheidren.game.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter extends Character {
    private Feature[] features;

    public PlayerCharacter() {
        super();
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }

    public List<Action> getAllActionsForPlayer() {
        ArrayList<Action> list = new ArrayList<>();
        for (int i = 0; i < features.length; i++) {
            list.add(new Action(this, features[i]));
        }

        return list;
    }
}
