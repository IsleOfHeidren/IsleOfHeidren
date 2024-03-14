package com.github.isleofheidren.game.models;

public class StoryEvent extends Event {
    private int[] branches;
    private String[] branchesText;
    private String consoleOutputText;

    /**
     *
     */
    public StoryEvent() {
    }

    public String getConsoleOutputText() {
        return consoleOutputText;
    }

    public void setConsoleOutputText(String consoleOutputText) {
        this.consoleOutputText = consoleOutputText;
    }

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


    //TODO add in a prop for the image URI or the image bits themselves
}
