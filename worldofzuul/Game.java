package principal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Iterator <Npc> itN;
    private Iterator <Items> itI;
    private Bag bag;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office, basement, attic;
        HashMap <String,Room> relationOutside = new HashMap<>();
        HashMap <String,Room> relationTheatre = new HashMap<>();
        HashMap <String,Room> relationPub = new HashMap<>();
        HashMap <String,Room> relationLab = new HashMap<>();
        HashMap <String,Room> relationOffice = new HashMap<>();
        HashMap <String,Room> relationBasement = new HashMap<>();
        HashMap <String,Room> relationAttic = new HashMap<>();
      
        // create the rooms
        
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");  
        pub = new Room("in the campus pub");
        pub.setsItens("Alcohol");
        pub.setsItens("Water");
        pub.setsItens("A piece of cake");
        lab = new Room("in a computing lab");
        lab.setsItens("Computers");
        office = new Room("in the computing admin office");
        office.setsItens("Computer");
        office.setsItens("A gun");
        office.setsNpc("Martha");
        basement = new Room("in the office basement");
        attic = new Room("in the office attic");
        attic.setsItens("A deadly potion");
        
        
        // initialise room exits
        // Outside exits
        relationOutside.put("east", theatre);
        relationOutside.put("south", lab);
        relationOutside.put("west", pub);
        
        outside.setExits(relationOutside);
        
        // Theatre exits
        relationTheatre.put("west", outside);
        
        theatre.setExits(relationTheatre);
        
        // Pub exits
        relationPub.put("east", outside);
        
        pub.setExits(relationPub);
        
        // Lab exits
        relationLab.put("north", outside);
        relationLab.put("east", office);
        
        lab.setExits(relationLab);
        
        // Office exits
        relationOffice.put("west", lab);
        relationOffice.put("down", basement);
        relationOffice.put("up", attic);
        
        office.setExits(relationOffice);

        // Basement exits
        relationBasement.put("up", office);
        
        basement.setExits(relationBasement);
        
        // Attic exits
        relationAttic.put("down", office);
        
        attic.setExits(relationAttic);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() throws InvalidCommandException 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command;
			command = parser.getCommand(JOptionPane.showInputDialog("Where do you want to go? Or do you need help?"));
			finished = processCommand(command);  
        }
        JOptionPane.showMessageDialog(null, "Thank you for playing.  Good bye.", "Game",JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Print out the opening message for the player.
     */
    
    private void roomItems(Room current){
        int counter = 1;
        if(current.fill.isEmpty() && current.nonPlayers.isEmpty()){
            JOptionPane.showMessageDialog(null, "There is nothing", "Game", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            if(!current.nonPlayers.isEmpty()){
                JOptionPane.showMessageDialog(null, "NPCs:", "Game", JOptionPane.PLAIN_MESSAGE);
                itN = current.nonPlayers.iterator();
                while (itN.hasNext()) {
                    JOptionPane.showMessageDialog(null, itN.next().getNpc(), "Game", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if(!current.fill.isEmpty()){
                JOptionPane.showMessageDialog(null, "Room items:", "Game", JOptionPane.PLAIN_MESSAGE);
                itI = current.fill.iterator();
                while (itI.hasNext()){
                    JOptionPane.showMessageDialog(null, counter+" "+itI.next().getItens(), "Game", JOptionPane.PLAIN_MESSAGE);
                    counter++;
                }
            }
        }
    }
    
    private void printExits(Room current){
        Set<String> exit = current.getExits().keySet();
        for(String exits : exit){
            if(!(exits == null)){
                JOptionPane.showInternalMessageDialog(null, exits, "Game", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    private void printWelcome()
    {
        JOptionPane.showMessageDialog(null,"Welcome to Adventure!\nAdventure is a new, incredibly boring adventure game.\nType 'help' if you need help.", "Game", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "You are " + currentRoom.getDescription()+"\nYou already have an ax in your backpack!", "Game", JOptionPane.PLAIN_MESSAGE);
        bag = new Bag();
        JOptionPane.showMessageDialog(null, "Exits: ", "Game",JOptionPane.PLAIN_MESSAGE);
        printExits(currentRoom);
        roomItems(currentRoom);
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
/*
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
*/
        CommandWords verify = new CommandWords();
        String commandWord = command.getCommandWord();
        try {
            verify.isCommand(commandWord);
        } catch (InvalidCommandException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom(command);
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
            case "search":
                printSearch();
                break;
            default:
                break;
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    
    private void printSearch(){
        JOptionPane.showMessageDialog(null, "You are " + currentRoom.getDescription(), "Game", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Exits: ", "Game",JOptionPane.PLAIN_MESSAGE);
        printExits(currentRoom);
        roomItems(currentRoom);
        
        if(!currentRoom.fill.isEmpty() || !currentRoom.nonPlayers.isEmpty()){   
            String act = JOptionPane.showInputDialog("Do you wanna do something? (take)");
            if(act.equals("take")){
                String number = JOptionPane.showInputDialog("Do you want to take something? (Acoording to the number)");
                int converter = Integer.parseInt(number);
                bag.setBackpack(currentRoom.fill.get(converter-1));
                currentRoom.fill.remove(converter-1);
                JOptionPane.showMessageDialog(null, "The bag contains:", "Game", JOptionPane.PLAIN_MESSAGE);
                itI = bag.getBackpack().iterator();
                while (itI.hasNext()) {
                    JOptionPane.showMessageDialog(null, itI.next().getItens(), "Game", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }
    
    private void printHelp() 
    {
        JOptionPane.showMessageDialog(null, "You are lost. You are alone. You wander\naround at the university.\nYour command words are:", "Game", JOptionPane.PLAIN_MESSAGE);
        CommandWords verify = new CommandWords();
        for (String validCommand : verify.getValidCommands()) {
            JOptionPane.showMessageDialog(null, validCommand, "Game", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            JOptionPane.showMessageDialog(null, "Go where?", "Game", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        switch (direction) {
            case "north":
                nextRoom = currentRoom.northExit;
                break;
            case "east":
                nextRoom = currentRoom.eastExit;
                break;
            case "south":
                nextRoom = currentRoom.southExit;
                break;
            case "west":
                nextRoom = currentRoom.westExit;
                break;
            case "up":
                nextRoom = currentRoom.upExit;
                break;
            case "down":
                nextRoom = currentRoom.downExit;
                break;
            default:
                break;
        }

        if (nextRoom == null)
            JOptionPane.showMessageDialog(null, "There is no door!", "Game", JOptionPane.PLAIN_MESSAGE);
        else {
            currentRoom = nextRoom;
            JOptionPane.showMessageDialog(null, "You are " + currentRoom.getDescription(), "Game", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Exits: ", "Game",JOptionPane.PLAIN_MESSAGE);
            printExits(currentRoom);
            roomItems(currentRoom);
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            JOptionPane.showMessageDialog(null, "Quit what?", "Game", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        else
            return true;  // signal that we want to quit
    }
}
