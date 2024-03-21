package com.github.isleofheidren.game.models;

public class Event {
    private int sequence;
    private String consoleOutputText;
    private String[] buttonsText;

    public String[] getButtonsText() {
        return buttonsText;
    }

    public void setButtonsText(String[] buttonsText) {
        this.buttonsText = buttonsText;
    }

    public String getConsoleOutputText() {
        return consoleOutputText;
    }

    public void setConsoleOutputText(String consoleOutputText) {
        this.consoleOutputText = consoleOutputText;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setDirections() {
        String[] buttonsText = {"East", "NorthEast", "North", "NorthWest", "West", "SouthWest", "SouthEast", "South"};
        this.buttonsText = buttonsText;
    }

    //TODO add in a prop for the image URI or the image bits themselves
}
