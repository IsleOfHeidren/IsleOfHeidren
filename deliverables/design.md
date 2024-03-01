##50 - 54
[characters](./characters.md)

### 70
The game will have all of the necessary objects for story, monsters, players, events stored in json objects that are loaded in sequence as needed. Event objects will include references to different possible branches that can be obtained. The UI will load these then go and fetch the next object as needed.

Event Object Mock: [mock](./mocks/eventobject.json)

Loading data sequence diagram

![dataseqdia](./images/req-70-sequence.png)

The UI will control the flow to the next data object determined by the possible branches or the statues within the object.
Each event object will contain the necessary data to update all the UI conponents.

### 110
