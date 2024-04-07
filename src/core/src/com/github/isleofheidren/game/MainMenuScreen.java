package com.github.isleofheidren.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.ApplicationAdapter;
import com.github.isleofheidren.game.models.*;
import com.github.isleofheidren.game.repos.PlayerCharacterRepo;
import com.github.isleofheidren.game.repos.StoryEventRepo;
import org.w3c.dom.Text;
import sun.tools.jconsole.Tab;

import javax.lang.model.element.AnnotationMirror;
import java.util.ArrayList;
import java.util.List;


public class MainMenuScreen implements Screen {

    final Heidren game;

    public Animation<TextureRegion> runningAnimation;

    public SpriteBatch batch;

    OrthographicCamera camera;

    ShapeRenderer border;

    Stage rootstage;
    Table roottable; // table that holds all the tables
    Table buttonPanelTable;
    TextButton textbutton; // test button
    ButtonPanel buttonPanelObject;

    List<PlayerCharacter> players;
    AnimationController[] playerAnimations;

    private ConsoleComponent console;
    private double totalDelta = 0;
    private Map map;
    private int currentSeq;
    private Event currentEvent;
    private CombatController combatController;
    private StatPanel statPanel;
    private Table mainImageDisplay;
    private AnimationController monsterAnimation;

    public MainMenuScreen(final Heidren game) {

        // all the inits
        this.game = game;
        rootstage = new Stage();
        roottable = new Table();
        buttonPanelTable = new Table();
        console = new ConsoleComponent();
        buttonPanelObject = new ButtonPanel();
        playerAnimations = new AnimationController[4];
        mainImageDisplay = new Table();

        loadPlayers();

        //Here we are going to do all the necessary setup to start the game
        StoryEventRepo repo = new StoryEventRepo();
        currentEvent = repo.get("0");

        buttonPanelTable = buttonPanelObject.createStoryPanel(currentEvent);

        buttonPanelObject.addListeners(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                buttonHandler(event);
            }
        });

        // Heidren.font.getData().setScale(0.5f); // font scale test (broken)

        loadPlayers();

        Gdx.input.setInputProcessor(rootstage);

        // int help_guide = 10; // might not need these
        // int row_height = Gdx.graphics.getHeight() /10;

        //border = new ShapeRenderer(); // add border to main screen, possibly garbage

        roottable.setFillParent(true); // everything should be added to this table
        roottable.pad(10);
        rootstage.addActor(roottable);



        // table.setSkin(Heidren.skin); // don't remember what this is for

        // playing with simplified animation (broken)
        //runningAnimation = new Animation<TextureRegion>(0.125f, atlas.findRegions("monk"), Animation.PlayMode.LOOP);

        // test labels for blocking
        Label title = new Label("Isle of Heidren", Heidren.skin.optional("default", Label.LabelStyle.class));
        Label space = new Label("", Heidren.skin.optional("default", Label.LabelStyle.class));

        // console add text
//        console.appendMessage("Hello, world! what happens if the text goes on for so goddamn long it has to wrap. does it wrap?? what next!!!?!", MessageType.GAME_EVENT); // Game Event Ex.
//        console.appendMessage("This is NPC dialog.", MessageType.NPC_DIALOG); // NPC Event Ex.

        // root table construction
        roottable.row(); //r1 - title
        roottable.add(title); // r2 c1


        //TODO: figure out images + add stats panel
        roottable.row(); //r2 - image window + stats panel

        map = new Map();
        mainImageDisplay.add(map);
        roottable.add(mainImageDisplay).space(10);// r2 c1 image

        statPanel = new StatPanel();
        roottable.add(statPanel); //r2 c2 stats

        // TODO: sprite add + animation

        playerAnimations[0] = new AnimationController("wizard");
        playerAnimations[1] = new AnimationController("monk");
        playerAnimations[2] = new AnimationController("barbarian");
        playerAnimations[3] = new AnimationController("rogue");

        roottable.row(); // r3 - sprites (potentially 4 cols??)
        Table animationTable = new Table();

        animationTable.add(playerAnimations[0]);
        animationTable.add(playerAnimations[1]); //r3 c2
        animationTable.add(playerAnimations[2]);//r3 c3
        animationTable.add(playerAnimations[3]);//r3 c3

        roottable.add(animationTable).fill();

        roottable.row(); // r4 - console + button panel
        roottable.add(console).grow().space(10); //r2c2
        roottable.add(buttonPanelTable).right().top().space(10);//r2c3

        camera = new OrthographicCamera();
        camera.setToOrtho(false,1000,600);


    }

    private void buttonHandler(com.badlogic.gdx.scenes.scene2d.Event event) {
        TextButton tb = (TextButton) event.getListenerActor();
        String[] texts = currentEvent.getButtonsText();

        //Get the last character of the button name which is an 1-4 int that is which seq it was
        int index = Integer.parseInt(String.valueOf(tb.getName().toCharArray()[tb.getName().toCharArray().length - 1])) - 1;

        if (currentEvent instanceof CombatEvent) {

            //If currently in combat advance combat
            if (combatController.isInCombat()) {
                advanceCombat(index);

                if (!combatController.isInCombat()) {
                    //If combat ended then determine if it was a win or loss
                    if (combatController.isLastCombatVictory()) {
                        //Goto the right next branch
                        if (combatController.getVictoryBranch() != -1) {
                            doStoryEvent(combatController.getVictoryBranch());
                        }
                        //Make a dummy event that'll send us into the map after the user clicks next
                        else {
                            Event e = new StoryEvent();
                            e.setButtonsText(new String[] {"Next"});
                            currentEvent = e;
                        }
                    }
                    //If not a combat victory then goto game over screen
                    else {
                        //TODO GAME OVER HERE
                    }

                }
            }
        }
        else if (currentEvent instanceof StoryEvent) {
            StoryEvent e = (StoryEvent) currentEvent;
            if (e.getBranches() == null || e.getBranches().length == 0) {
                advanceMap(index);
            }
            else {
                advanceStory(index);
            }

            mainImageDisplay.clear();
            mainImageDisplay.add(map);

            //Start Combat
            if (currentEvent instanceof CombatEvent) {
                float height = mainImageDisplay.getHeight();
                mainImageDisplay.clear();
                monsterAnimation = new AnimationController(((CombatEvent) currentEvent).getMonsters()[0], true);

                mainImageDisplay.add(monsterAnimation).height(height);

                advanceCombat(-1);
            }
        }
    }

    private void advanceStory(int index) {
        int branch = ((StoryEvent) currentEvent).getBranches()[index];
        doStoryEvent(branch);
    }

    private void doStoryEvent(int seq) {
        StoryEventRepo repo = new StoryEventRepo();
        currentEvent = repo.get(Integer.toString(seq));

        console.appendMessage(currentEvent.getConsoleOutputText(), MessageType.STORY_TEXT);

        buttonPanelTable.clear();
        buttonPanelTable.add(buttonPanelObject.createStoryPanel(currentEvent));

        buttonPanelObject.addListeners(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                buttonHandler(event);
            }
        });
    }

    private void advanceCombat(int index) {
        if (combatController == null) {
            combatController = new CombatController(console, statPanel);
            combatController.StartCombat((CombatEvent) currentEvent, players.toArray(new PlayerCharacter[0]));

            buttonPanelTable.clear();
            buttonPanelTable.add(buttonPanelObject.createCombatPanel(combatController.getCurrentPlayer()));

            buttonPanelObject.addListeners(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    buttonHandler(event);
                }
            });

            if (((StoryEvent) currentEvent).getBranches() != null && ((StoryEvent) currentEvent).getBranches().length > 0) {
                combatController.setVictoryBranch(((StoryEvent) currentEvent).getBranches()[0]);
            }


            currentEvent = new CombatEvent();
        }
        else {
            //Do the action the user selected
            combatController.doNextTurn(combatController.getCurrentPlayer().getAllActions().get(index));

            if (combatController.isInCombat()) {
                buttonPanelTable.clear();
                buttonPanelTable.add(buttonPanelObject.createCombatPanel(combatController.getCurrentPlayer()));

                buttonPanelObject.addListeners(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        buttonHandler(event);
                    }
                });
            }
        }

        String name = "";
        if (combatController.isInCombat()) {
            name = combatController.getCurrentPlayer().getName();
        }

        for (int i = 0; i < playerAnimations.length; i++) {
            if (name.equalsIgnoreCase(playerAnimations[i].getSpriteName())) {
                playerAnimations[i].setHighlight(true);
            }
            else {
                playerAnimations[i].setHighlight(false);
            }
        }


    }

    private void advanceMap(int index) {
        if (currentEvent.isMapEvent()) {
            int seq = -1;
            if (index == 0) {
                seq = map.goNorth();
            } else if (index == 1) {
                seq = map.goSouth();
            } else if (index == 2) {
                seq = map.goEast();
            } else {
                seq = map.goWest();
            }

            if (seq != -1) {
                doStoryEvent(seq);
            }
        }
        else {
            Event mapEvent = new StoryEvent();
            mapEvent.setButtonsText(new String[]{"Go North", "Go South", "Go East", "Go West"});
            mapEvent.setMapEvent(true);

            currentEvent = mapEvent;

            buttonPanelTable.clear();
            buttonPanelTable.add(buttonPanelObject.createStoryPanel(mapEvent));

            buttonPanelObject.addListeners(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    buttonHandler(event);
                }
            });
        }
    }

    private int count = 0;
    @Override
    public void show() {

    }

    private float deltaTotal = 0;
    @Override
    public void render (float delta){

        ScreenUtils.clear(0,0,0,1);
        camera.update();

        //

        // game.batch.begin(); // forget what these are for
        // game.batch.end();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        rootstage.act(Gdx.graphics.getDeltaTime());
        rootstage.draw();

        /*if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            dispose();
        }*/


        if (totalDelta > .1625) {
            totalDelta = 0;
            count ++;

            for (int i = 0; i < playerAnimations.length; i++) {
                playerAnimations[i].goToNextKeyFrame();
            }

            if (monsterAnimation != null) {
                monsterAnimation.goToNextKeyFrame();
            }
        }



        totalDelta += delta;

        //GAME LOOP GOES HERE?

    }

    @Override
    public void resize(int width, int height) { rootstage.getViewport().update(width, height, true);}

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() { rootstage.dispose(); }

    /*
    Loads all the characters from the character folder into memory
     */
    private void loadPlayers() {
        PlayerCharacterRepo repo = new PlayerCharacterRepo();
        players = new ArrayList<PlayerCharacter>();

        players.add(repo.get("monk"));
        players.add(repo.get("wizard"));
        players.add(repo.get("barbarian"));
        players.add(repo.get("rouge"));
    }
}
