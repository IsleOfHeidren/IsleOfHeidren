package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ConsoleComponent extends Table {
    private ScrollPane scrollPane;
    private TextArea textArea;

    public ConsoleComponent() {
        textArea = new TextArea("", Heidren.skin);
        scrollPane = new ScrollPane(textArea);

        add(scrollPane).expand().fill().row();
    }

    public void appendMessage(String message, MessageType type) {
        String prefix = getMessagePrefix(type);
        String formattedMessage = prefix + message + "\n";
        textArea.appendText(formattedMessage);

        // Set scroll position to maximum after each update
        scrollPane.setScrollPercentY(100);
    }

    private String getMessagePrefix(MessageType type) {
        switch (type) {
            case NPC_DIALOG:
                return "Character Name: ";
            case GAME_EVENT:
                return "Game Event: ";
            case COMBAT_RESULT:
                return "Combat Result: ";
            case STORY_TEXT:
                return "Story: ";
            case SKILL_CHECK_RESULT:
                return "Skill Check: ";
            default:
                return "";
        }
    }
}
