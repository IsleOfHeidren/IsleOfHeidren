###Overview - Requirements: 10, 20

The software will be a game. It will utilize the theming of the _Isle of dread_ campaign.
https://en.wikipedia.org/wiki/The_Isle_of_Dread

The story will take inspiration from the campaign. 
The player characters and monsters will be built in the style of dnd preferable from the campaign but if that's not possible then dnd in general will be the inspiration.

The game will be implemented using a game engine. LibGDX is suitable engine for the requirements https://libgdx.com/ and will be used for this project as the team all has familiarity using java.

### Defined Characters - Requirements: 40
Characters will be defined using JSON objects they will follow the formatting defined in the [characters.md](./characters.md)

The characters file contains a set of "features" which include combat abilities and non-combat abilities that will be included in the actions the player can perform. These actions will be created and implemented based from there original DND counterparts 

All actions the player can take in game will come from the pre-defined characters.

### Buttons - Requirements: 60, 61
Buttons will be implemented using three button components defined by LibGDX

https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/TextButton.html
https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/ImageButton.html
https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/ImageButton.html

These three components will implement the game control for branching through the story and taking actions in combat. 
The image button should be used over the standard button in cases where high levels of styling is needed. The skin class can be applied to an image button which lets it act within an image.

https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/Skin.html



### Console Component - Requirements: 60, 63
A console like component will be created. 
It will be in the style of a game dialog box and allow the user to scroll up or down to view previous and the current text. The scrolling action will respond to mouse click and drag or mouse wheel input. 

Each output to the console will be delinted based on what the source of the text was. Types will be defined for each possible source.
The types of text this box handles are at least as follows:
* Non-Player Character Dialog
* Game Events
* Combat Results (including dice rolls, damage)
* General Story Text
* Skill Check Results

This component will be implemented in such a way to allow either a prefix for each message showing the source of the text or color to distinguish between them. For example the prefix would be "Character Name:" for character dialog.

In order to accomplish displaying text from any source this component will have a public method that can be called passing in the string value to append to the console and the type of message being appended. 

The types of messages should be defined  in a separate object as based on the needs of other requirements and designs. The object defining the types of messages will be an enum or something similar, only defining the types of messages that are valid and can be handled. 

LibGDX defines a scroll pane object that would suit the needs of this component https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/ScrollPane.html
After each update the component would set it scroll positions to the maximum value.
This way by default it stays with the most recent appended text. 
A text field will be a child within the scroll component which should allow vertical scaling to enable the scrolling https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/TextArea.html

### Character and Ability Definitions - Requirments: 40, 50, 51, 52, 53, 54
[characters.md](./characters.md)

### Data loading - Requirments: 70
The game will have all of the necessary objects for story, monsters, players, events stored in json objects that are loaded in sequence as needed. Event objects will include references to different possible branches that can be obtained. The UI will load these then go and fetch the next object as needed.

Event Object Mock: [mock.json](./mocks/eventobject.json)

Loading data sequence diagram

![dataseqdia](./images/req-70-sequence.png)

The UI will control the flow to the next data object determined by the possible branches or the statues within the object.
Each event object will contain the necessary data to update all the UI conponents.

### 110
[monsters.md](./monsters.md)
