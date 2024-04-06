package com.github.isleofheidren.game;

import com.github.isleofheidren.game.models.Event;

public abstract class StateManager {
    private Event currentEventObject;


    public Event getCurrentEventObject() {
        return currentEventObject;
    }

    public void setCurrentEventObject(Event currentEventObject) {
        this.currentEventObject = currentEventObject;
    }

    public abstract boolean doAction(String action);
}
