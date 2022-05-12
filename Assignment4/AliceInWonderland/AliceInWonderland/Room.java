package AliceInWonderland;

/** Adventure Game Program Code
 Copyright (c) 1999 James M. Bieman

 To compile: javac AdventureGame.java
 To run: java AdventureGame

 The main routine is AdventureGame.main

 Update August 2010: refactored Vector contents into ArrayList<Item> contents.
 This gets rid of the use of obsolete Vector and makes it type safe.

 **/

 // class Room


 import java.util.ArrayList;
 import java.util.ListIterator;
 //import java.util.Enumeration;
 //import java.util.Vector;


 public class Room implements RabbitHole {
    private String roomName;
    private String fullDescription;
    private String shortDescription;
    private RabbitHole[] side = new RabbitHole[6];
    private ArrayList<Item> contents = new ArrayList<Item>();
    private ArrayList<Character> occupants = new ArrayList<Character>();
    public boolean firstEntry = true;

    Room(){
    side[0] = new Wall();
    side[1] = new Wall();
    side[2] = new Wall();
    side[3] = new Wall();
    side[4] = new Wall();
    side[5] = new Wall();
    }

    public void setRoomName(String d){
        this.roomName = d;
    }

    public String getRoomName(){
        return roomName;
    }

    public void setDesc(String d){
        fullDescription = d;
    }

    public void setShortDesc(String s){
        shortDescription = s;
    }

    public void setSide(int direction, RabbitHole m){
        side[direction] = m;
    }

    public void addItem(Item theItem){
        contents.add(theItem);
    }

    public void removeItem(Item theItem){
        contents.remove(theItem);
    }

    public boolean roomItemEmpty(){
        return contents.isEmpty();
    }

    public Item[] getRoomContents(){
        Item[] contentsArray = new Item[contents.size()];
        contentsArray = contents.toArray(contentsArray);
        return contentsArray;
    }

    public void addCharacter(Character theCharacter){
        occupants.add(theCharacter);
        }
    
    public void removeCharacter(Character theCharacter){
        occupants.remove(theCharacter);
    }

    public boolean roomCharacterEmpty(){
        return occupants.isEmpty();
        }

    public Character[] getRoomCharacters(){
        Character[] occupantsArray = new Character[occupants.size()];
        occupantsArray = occupants.toArray(occupantsArray);
        return occupantsArray;
        }
    
    public void enter(Player p) {
        p.setLoc(this);
    }

    public void exit(int direction, Player p){
    side[direction].enter(p);
    }

    public String getShortDesc(){
        return shortDescription;
    }

    public String getDesc(){
        String description = "";
        String contentString = "";
        String charaterString = "";

        ListIterator<Item> roomContents = contents.listIterator();
        while(roomContents.hasNext())
        contentString = contentString + (roomContents.next()).getDesc() + " ";

        ListIterator<Character> roomCharaters = occupants.listIterator();
        while(roomCharaters.hasNext())
        charaterString = charaterString + (roomCharaters.next()).getCharacterName() + " ";
        
        if (firstEntry == true){
            description = fullDescription;
            firstEntry=false;
            }
        else if (firstEntry == false){
            description = shortDescription; 
            } 
        return description + '\n' + '\n' +
        "Room Contents: " + contentString + '\n' +
        "Characters: " + charaterString + '\n';
    }

    public String getCharDesc(){
        String characterString = "";
        ListIterator<Character> roomCharaters = occupants.listIterator();
        while(roomCharaters.hasNext())
        characterString = characterString + (roomCharaters.next()).getCharacterName() + " ";
        return characterString + '\n' + '\n';
    }

    public Boolean checkRoomContents(String i){
        ListIterator<Item> roomContents = contents.listIterator();
        while(roomContents.hasNext())
        if (roomContents.next().getItemName() == i){
            return true;
        }
            return false;
        
    }
 }
