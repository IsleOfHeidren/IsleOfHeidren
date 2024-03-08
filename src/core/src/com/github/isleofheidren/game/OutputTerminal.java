package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class OutputTerminal {
    private ScrollPane scrollPane;
    private VerticalGroup consoleContent;
    private TextArea textField;

    public enum MessageType {
        NPC_DIALOG,
        GAME_EVENT,
        COMBAT_RESULT,
        STORY_TEXT,
        SKILL_CHECK_RESULT
    }

    public OutputTerminal() {
        textField = new TextArea("", new TextArea.TextFieldStyle());
        consoleContent = new VerticalGroup();
        consoleContent.addActor(textField);
        scrollPane = new ScrollPane(consoleContent);
        scrollPane.setScrollingDisabled(true, false); // Allow vertical scrolling only
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollbarsOnTop(false);
        scrollPane.setForceScroll(false, true);
        scrollPane.setOverscroll(false, false);

        // Add input listener for mouse wheel scrolling
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean scrolled(float amountX, float amountY) {
                scrollPane.setScrollY(scrollPane.getScrollY() + amountY * 20); // Adjust scrolling speed as needed
                return true;
            }
        });
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public void appendMessage(String message, MessageType messageType) {
        String formattedMessage = getMessagePrefix(messageType) + message;
        textField.setText(textField.getText() + "\n" + formattedMessage);
        scrollPane.layout(); // Update layout to reflect the new text
        scrollPane.setScrollY(Math.max(0, scrollPane.getMaxY())); // Scroll to the bottom
    }

    private String getMessagePrefix(MessageType messageType) {
        switch (messageType) {
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

    // Add mouse input handling for scrolling
    public void update(float delta) {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            float deltaY = Gdx.input.getDeltaY();
            scrollPane.setScrollY(scrollPane.getScrollY() + deltaY);
        }
    }
}
