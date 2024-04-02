### Elevator Pitch Slide

Hi, our names our Joe Claborn, Bella Brickler, Ren Paxson, and Heidi Raber. Together we have created a game much like D&D called "Isle of Heidren". The game is based on D&D's "Isle of Dread" campaign and pertains the use of a 4-player combat system with pre-defined characters along with a game map that is used to tell the story. Mind if we take you down the intricates of our game?

--------------------------------------------------------------------------------------------------------------------------------------------------------

### User Story Pertaining To Each Major Component Slide(s)

- Main GUI - Story Map
    - Within our game, there is a map that the game is played throughout within the GUI. The map is used to house the playable characters, npcs, and to allow for the story of the game to be told alongside combat instances.

--------------------------------------------------------------------------------------------------------------------------------------------------------

- Main GUI - Panel Showing Actions For Game State
    - Within the GUI alongside the story map, there is also a panel that shows actions based on the game state. If a combat instance is currently in play, then there will be buttons that the user can click to pick a given attack to use on a monster. Also, there is a panel for the output of the game, such as dialogue and narration. There is also a panel if no combat instance is occurring where the text pertains to the current story events of the game.

--------------------------------------------------------------------------------------------------------------------------------------------------------

- Main GUI - Panel Displaying All Characters Showing Which Is Currently Selected
    - Within the GUI, all of the playable characters are shown on the map and move based on a square-to-square movement system.

--------------------------------------------------------------------------------------------------------------------------------------------------------

- Combat AI
    - Within the game there are combat instances that pertain to the current story of the game. When these instances occur, combat will ensue. The way we have laid out our system for this is to have JSON files that hold our player objects and monster objects. These files allow for the monster combat to be based on a simple AI auto-attack system, while the player gets to choose the attack that they use and what monster they want to use the attack on. The output of the combat instance is displayed in the console during the instance to show what attacks are used, damage taken, etc.

--------------------------------------------------------------------------------------------------------------------------------------------------------

- JSON Objects
    - Within the game our main use for creating objects that take care of the characters, monsters, npcs, location, and battlemap are JSON files. These files allow for the combat to run smoothly between the playable characters and monsters. They allow for the npcs to house their quests that are given to the characters. 

--------------------------------------------------------------------------------------------------------------------------------------------------------

- Quests
    - During gameplay, there is one main quest that is followed by the characters. Along with this, there are also two side quests and events that can be spurred by NPC interaction.

--------------------------------------------------------------------------------------------------------------------------------------------------------

- Main Quest
    - During the main quest of the game, the players find themselves stranded on an island. There are options of foraging the island or walking into the forest which then branches off into which cardinal direction they would like to walk in. Depending on the direction the party goes in, the village of Tanaroa can also be found at this instance of time within the story. If they forage the island, RB's notebook can be found, along with a map, compass, a friendly village Tanaroa that can be explored or the City of Gods that houses gold, and they are warned of monsters. If the City of Gods is chosen to be explored, the players will enter a cave and try to steal the gold that they find. However, the Hydra will awaken and combat will ensue. If the route of exploring Tanaroa is taken, then the party will enter the village and have the option to speak to 4 different villagers along with not entering the village if they do not want to. If the party wants to talk to 1 of the 4 villagers they can have the option to speak to a villager or rob from them. If they speak to the villager of their choice, then they can ask about the RB notebook that was found, the City of Gods, or the monsters on the island. On the contrary, if the party choose to the rob the villager that they are speaking to, they further have the choice to either pickpocket, or coerce ally to attack the villager. Depending on how the party finds the villages, they can seem scared to enter them due to the unknowing presence of what is in them. The party can then choose to explore the villages, if so, they can get attacked by the village. If they choose not to, the cardinal direction movement options will become available to the party again to continue their adventure.

--------------------------------------------------------------------------------------------------------------------------------------------------------

### Architecture Slide

![System Architecture](./images/overall-game-flow.png)

--------------------------------------------------------------------------------------------------------------------------------------------------------

### Requirement Slide(s) Linking To Specific Elements / Implementations
