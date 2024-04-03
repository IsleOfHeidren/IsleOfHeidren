package com.github.isleofheidren.game;

public class MapStateManager extends StateManager{
    private final Map map;

    public MapStateManager(Map map) {

        this.map = map;
    }


    @Override
    public boolean doAction(String action) {
        if (action.toLowerCase().contains("north")) {
            if (!map.canGoNorth()) {
                return false;
            }
            map.goNorth();
        }
        else if (action.toLowerCase().contains("south")) {
            if (!map.canGoSouth()) {
                return false;
            }
            map.goSouth();
        }
        else if (action.toLowerCase().contains("east")) {
            if (!map.canGoEast()) {
                return false;
            }
            map.goEast();
        }
        else if (action.toLowerCase().contains("west")) {
            if (!map.canGoWest()) {
                return false;
            }
            map.goWest();
        }
        return true;
    }
}
