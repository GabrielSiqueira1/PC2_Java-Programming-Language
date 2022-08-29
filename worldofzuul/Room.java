package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Room 
{
    public String description;
    public ArrayList<Items> fill = new ArrayList<>();
    public ArrayList<Npc> nonPlayers = new ArrayList<>();
    public HashMap<String, Room> exits = new HashMap<>();
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    public Room upExit;
    public Room downExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Room(String description) 
    {
        this.description = description;
    }



    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setsItens(String itensInteract){
        Items contents = new Items(itensInteract);
        fill.add(contents);
    }
    
    public void setsNpc(String nonPlayer){
        Npc moreContents = new Npc(nonPlayer);
        nonPlayers.add(moreContents);
    }
    
    public HashMap<String, Room> setExits(HashMap <String,Room> relations) 
    {
        Set<String> keys = relations.keySet();
        for(String key : keys){
            switch (key) {
                case "north":
                    northExit = relations.get(key);
                    exits.put("north",northExit);
                    break;
                case "south":
                    southExit = relations.get(key);
                    exits.put("south",southExit);
                    break;
                case "west":
                    westExit = relations.get(key);
                    exits.put("west",westExit);
                    break;
                case "east":
                    eastExit = relations.get(key);
                    exits.put("east",eastExit);
                    break;
                case "up":
                    upExit = relations.get(key);
                    exits.put("up",upExit);
                    break;
                case "down":
                    downExit = relations.get(key);
                    exits.put("down",downExit);
                    break;
                default:
                    break;
            }
        }
        return exits;
    }

    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }
    
    public HashMap<String,Room> getExits() {
        return exits;
    }

}
