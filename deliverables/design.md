###Overview - Requirements: 10, 20

The software will be a game. It will utilize the theming of the _Isle of dread_ campaign.
https://en.wikipedia.org/wiki/The_Isle_of_Dread

The story will take inspiration from the campaign. 
The player characters and monsters will be built in the style of dnd preferable from the campaign but if that's not possible then dnd in general will be the inspiration.

The game will be implemented using a game engine. LibGDX is suitable engine for the requirements https://libgdx.com/ and will be used for this project as the team all has familiarity using java.

### Primary Image Display - Requirments: 60, 62
This component will be a large component near the center and top of the UI. It will display an image relevant to the current story point. 
The data objects defined in _Data loading - Requirements: 70_ will have a path by which to load the image. Each time the current story context updates this component will pull that path from the object and load the image.

LibGDX defines a simple image class that will be used to display to given image in the component
https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/com/badlogic/gdx/scenes/scene2d/ui/Image.html

All story objects will be built to make sure this component is always displaying an image.

Images will be stored in the assets directory of the final project, meaning the LibGDX engine will be able to find and load them.

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
__