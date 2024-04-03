package com.github.isleofheidren.game.models;

public class Event {
    private int sequence;
    private String consoleOutputText;
    private String[] buttonsText;
    private boolean mapEvent;
    private String mapPosition;


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

    public boolean isMapEvent() {
        return mapEvent;
    }

    public void setMapEvent(boolean mapEvent) {
        this.mapEvent = mapEvent;
    }

    public String getMapPosition() {
        return mapPosition;
    }

    public void setMapPosition(String mapPosition) {
        this.mapPosition = mapPosition;
    }
}
