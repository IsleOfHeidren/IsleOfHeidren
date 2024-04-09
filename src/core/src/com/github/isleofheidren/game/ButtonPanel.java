package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.isleofheidren.game.models.Event;
import com.github.isleofheidren.game.models.PlayerCharacter;

public class ButtonPanel extends Heidren {
    //create normal text button implemented by Libgdx
    TextButton textbutton;
    TextButtonStyle textButtonStyle;
    Stage buttonStage;
    Table buttonpanel;
    private Button[] buttons;

    //Events will dictate what buttons to be displayed in button panel
    public Table createStoryPanel(Event event) { // may pass in Event event
        buttonStage = new Stage();
        buttonpanel = new Table();
        textButtonStyle = new TextButtonStyle();

        buttonStage.addActor(buttonpanel); // makes button lookup easier later
        textButtonStyle.font = font;
        buttonpanel.setSize(150,200);

        buttons = new Button[4];

        //creates four buttons for each panel
        for(int i = 0; i < 4; i++) {

            Label label = new Label("", Heidren.skin.optional("default", Label.LabelStyle.class));
            if (i < event.getButtonsText().length) {
                label = new Label(event.getButtonsText()[i], Heidren.skin.optional("default", Label.LabelStyle.class));
            }
            label.setWrap(true);
            label.setWidth(buttonpanel.getWidth());


            textbutton = new TextButton("", Heidren.skin);
            int index = i+1; // for button name
            textbutton.setName("button" + index);
            textbutton.add(label).width(buttonpanel.getWidth());
            buttonpanel.add(textbutton).fill().space(5);

            buttons[i] = textbutton;
            buttonpanel.row();
        }

        return buttonpanel;
    }

    //returns Table to be added to the stage
    public Table createCombatPanel(PlayerCharacter current) {
        Event e = new Event();

        String[] texts = new String[4];
        for (int i = 0; i < 4; i++) {
            if (current.getAllCombatActions().size() > i) {
                texts[i] = current.getAllCombatActions().get(i).getMove().getName();
            }
            else {
                texts[i] = "";
            }
        }

        e.setButtonsText(texts);

        return createStoryPanel(e);
    }

    public void addListeners(ClickListener eventListener) {
        for (int i = 0; i < 4; i++) {
            TextButton tb = (TextButton) buttonpanel.getCells().get(i).getActor();
            tb.addListener(eventListener);
        }
    }
    
    public Button[] getButtons() {
        return buttons;
    } 
}