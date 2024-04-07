# Requirements

* 10\. Will be a desktop game
    * 10e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Does the program open on the desktop |

* 20\. Will be based on DnD
    * 20e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Play the game and see if any of the elements are based from DnD |

* 30\. Will have a start screen
    * 30e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Run the game and see if first a start screen opens |

* 40\. Will play as a pre-defined character
    * 40e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Run the game is see if it has a character defined |


* 50\. Will play with 4 characters
    * 50e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Play the game and look for four seperate player characters |
    | #2      | Look in the filesystem of the game and see if four player JSON objects are defined |


* 51\. Each player will have a set of stats, features/abilities that differ from one another. These stats will be based from DnD
    * 51e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Play the game and compare players |
    | #2      | Inspect the player json files for differeces |


* 60\. Will have a main GUI with components that change dynamically based on the game state
    * 60e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Load the game executable and iteract with the mouse |

* 61.0\. Will have buttons that are mouse clickable to interact with the game
    * 61.0e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Load the game executable and iteract with the mouse |


* 61.1\. buttons shall be dynamic based on valid story actions, and will include character specific actions
  * 61.1e:

      | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Compare JSON file text to text displayed in buttons |


* 61.2\. In combat each player will take turns doing one action which will be defined in the button panel
  * 61.2e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Play through a combat interaction in the game, and see if buttons show action|

  
* 62.0\. Shall have a primary image container showing environmental PNGs that are relevant to the current game state
    * 62.0e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Load and start the game and inspect if PNG image exists |
    


* 62.1\. During combat or NPC interactions, the image container will display relevant NPCs and monsters
  * 62.1e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Play a combat instance in the game and inspect if the image container displays a relevant image |


* 63\. Will have a console-like output for game text, battle results, and story
    * 63e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Open and start game, inspect if a console like component exists|


* 64.0\. Each playable character shall be pictured as sprites in the main window. These sprites may be animated.
  * 64.0e:
      
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Open and start the game, inspect that |


* 64.1\. UI will indicate which character is active (turn) in combat by highlighting the character's sprite. This includes monster and NPC sprites
  * 64.1e:

      | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Open and play game, play though combat scenario. Inspect if sprites have an indicator on them |


* 65\. In combat, the currently selected character's stats shall be pictured next to the image container. Outside of battle, the panel shall be blank
  * 65e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Open and play game, get to combat encounter. Inspect if the stat panel exists and has relvant information for the current player |

* 70\. Shall have a way to retrieve data for stats, characters, monsters, and events
    * 70e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Demonstrate code accessing JSON files|


* 80\. Will have map in database that either will be shown by text or GUI component
    * 80e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Open and play game, inspect if a map components exists|


* 81\. Map will have multiple locations
    * 81e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Inspect map component to see if multiple locations are displayed |


* 90\. Will have story from start to finish no matter what combination of pre-defined actions each character takes
    * 90e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Play through game and demonstrate end screen occuring|
  

* 100\. Shall have at least 3 types of monsters
    * 100e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Inspect game directory for JSON files for the three monsters |

* 105\. The combat system with a clear winner and damage taken to each side, the combat will take the format of DND according to https://www.dndbeyond.com/sources/basic-rules/combat
    * 105e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Demonstrate that the combat system uses a DND format |


* 110\. The game will prompt the player with story options displayed in the UI utilizing the buttons, image container, and console
    * 110e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Demonstrate button container showing and progressing though the story |


* 120\. The game will have a combat mode when the story dictates it necessary
    * 120e:
    
    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Inspect JSON objects for combat events linked to story events |

* 130\. Will have an end screen that displays a game over or game won text
    * 130e:

    | Test #  | Test Content                         |        
    |---------|--------------------------------------|
    | #1      | Demonstrate game over screen occuring|
