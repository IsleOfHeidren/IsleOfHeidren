package com.github.isleofheidren.game.models;

public class Action {
    private Character character;
    private Feature move;

    public Action() {}

    public Action(Character character, Feature move) {
        this.character = character;
        this.move = move;
    }


    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Feature getMove() {
        return move;
    }

    public void setMove(Feature move) {
        this.move = move;
    }
}
