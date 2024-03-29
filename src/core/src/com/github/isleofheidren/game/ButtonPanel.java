package com.github.isleofheidren.game;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.isleofheidren.game.models.Event;
import com.github.isleofheidren.game.models.PlayerCharacter;

public class ButtonPanel extends Heidren {
    TextButton textbutton;
    TextButtonStyle textButtonStyle;
    //BitmapFont font;
    Stage buttonStage;
    Table buttonpanel;

    //@Override
    public Table createStoryPanel(Event event) { // may pass in Event event
        // inits
        //font = new BitmapFont();
        buttonStage = new Stage();
        buttonpanel = new Table();
        textButtonStyle = new TextButtonStyle();

        buttonStage.addActor(buttonpanel); // makes button lookup easier later
        textButtonStyle.font = font;
        buttonpanel.setSize(150,200);
        buttonpanel.setDebug(true);

//        // test label (probably junk)
//        Label longbuttontext = new Label("this is a really long message, like reeeeally really long.", Heidren.skin.optional("default", Label.LabelStyle.class));
//        longbuttontext.setWrap(true);
//        longbuttontext.setWidth(buttonpanel.getWidth());
        // TODO: figure out center alignment


//        // change button - probably not necessary
//        textbutton = buttonStage.getRoot().findActor("button1");
//        textbutton.reset();
//        textbutton.add("this text was changed and it is also very long").width(buttonpanel.getWidth());
//        //textbutton.add("lil change").width(buttonpanel.getWidth());



        for(int i = 0; i < 4; i++) { // i < StoryEvent.branches.getsize or something
            // temp test label
            Label label = new Label(event.getButtonsText()[i], Heidren.skin.optional("default",Label.LabelStyle.class));
            label.setWrap(true);
            label.setWidth(buttonpanel.getWidth());


            textbutton = new TextButton("", Heidren.skin);
            int index = i+1; // for button name
            textbutton.setName("button" + index);
            textbutton.add(label).width(buttonpanel.getWidth());
            buttonpanel.add(textbutton).fill().space(5);

            buttonpanel.row();

            // TODO: if event options < 3 add fourth empty uniform button
        }

        return buttonpanel;
    }

    public Table createCombatPanel(PlayerCharacter current) {
        //font = new BitmapFont();
        Table panel = new Table();
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        for(int i = 0; i < 4; i++) {
            textbutton = new TextButton("Button", textButtonStyle);
            panel.add(textbutton);
        }

        return panel;
    }

    public void addListeners(ClickListener eventListener) {
        for (int i = 0; i < 4; i++) {
            TextButton tb = (TextButton) buttonpanel.getCells().get(i).getActor();
            tb.addListener(eventListener);
        }
    }
}