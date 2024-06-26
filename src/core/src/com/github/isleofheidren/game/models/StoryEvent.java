package com.github.isleofheidren.game.models;
// "button handler (4)" determines game state
/*
Model for story events, anything that doesn't occur in combat and doesn't refer to the map
 */
public class StoryEvent extends Event {
    private int[] branches;
    private String[] branchesText;

    public StoryEvent() {
        super();
    }
    /*
    Getters and setters
     */
    public String[] getBranchesText() {
        return branchesText;
    }

    public void setBranchesText(String[] branchesText) {
        this.branchesText = branchesText;
    }

    public int[] getBranches() {
        return branches;
    }

    public void setBranches(int[] branches) {
        this.branches = branches;
    }
}
