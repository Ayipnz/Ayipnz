package AliceInWonderland;

import java.io.*;


public class Game {
//private Adventure theCave;
//private Player thePlayer;

/** Our system-wide internal representation of directions
AdventureGame.java
is integers. Here, we convert input string directions
into integers. Internally, we use integers 0-9 as
directions throughout the program. This is a bit of
a cludge, but is simpler for now than creating a Direction
class. I use this cludge because Java in 1999 did not have
an enumerated data type. */

//public enum direction {} ??

private int convertDirection(String input){
String d = input.toString();
int theDirection = 9999;
d.toLowerCase();
switch(d){
    case "n": case "north": case "go north": theDirection = 0;break;
    case "s": case "south": case "go south":theDirection = 1;break;
    case "e": case "east": case "go east":theDirection = 2;break;
    case "w": case "west": case "go west":theDirection = 3;break;
    case "u": case "up": case "go up": theDirection = 4;break;
    case "d": case "down": case "go down": theDirection = 5;break;
}
return theDirection;
}

/** choosePickupItem determines the specific item
that a player wants to pick up. */
private Item choosePickupItem(Player p, BufferedReader keyB)
throws IOException{
Item[] contentsArray = (p.getLoc()).getRoomContents();
String inputString = "prepare";
int theChoice = -1;

    do {
        System.out.println("The room has:");
        for (int i = 0; i < contentsArray.length ; i++)
            System.out.println((i+1) + ": "
            + contentsArray[i].getDesc());
            System.out.print("Enter the number of the item to grab: ");
            inputString = keyB.readLine();
            System.out.println('\n');
            if (inputString.equals("")) inputString = " ";
        try {
            theChoice = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            theChoice = -1;
        }
        if (theChoice < 0 || theChoice > contentsArray.length)
            System.out.println("That item is not in the room.");
        } while (theChoice < 0 || theChoice > contentsArray.length);
        return contentsArray[theChoice-1];
    }

/** chooseEatItem determines the specific item
that a player wants to pick up. */
private Item chooseEatItem(Player p, BufferedReader keyB) 
throws IOException{
    String inputString = "prepare";
    int theChoice = -1;
    
    do {
        System.out.print("You are carrying: " +
        p.showMyThings() + '\n');
        System.out.print("Enter the number of the item to eat or drink: " );
        inputString = keyB.readLine();
        try {
            theChoice = Integer.parseInt(inputString);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            theChoice = -1;
    }
        if (theChoice < 0 || theChoice > p.numItemsCarried())
            System.out.print("Invalid choice.");
    } while (theChoice < 0 || theChoice > p.numItemsCarried());
    return p.MyThings()[theChoice-1];
    }
    
 /** choosePickupItem determines the specific item
that a player wants to pick up. */
private Character interactCharacter(Player p, BufferedReader keyB, String j)
    throws IOException{
    Room checkRoom =p.getLoc();
    Character[] characterArray = checkRoom.getRoomCharacters();
    // Character[] characterArray = p.getLoc().getRoomCharacters();
    String inputString = "prepare";
    String interact = "";
    int theChoice = -1;

    if (j == "talk"){
        interact = "Enter the number of the charater you want to talk to: ";
    }else if (j == "play"){
        interact = "Enter the number of the charater you want to play to: ";
    }

        do {
            System.out.println("Charaters in the room:");
            for (int i = 0; i < characterArray.length ; i++)
                System.out.println((i+1) + ": "+ characterArray[i].getCharacterName());
                System.out.print(interact);
                inputString = keyB.readLine();
                System.out.println('\n');
                if (inputString.equals("")) inputString = " ";
            try {
                theChoice = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                theChoice = -1;
            }
            if (theChoice < 0 || theChoice > characterArray.length)
                System.out.println("That charater is not in the room.");
            } while (theChoice < 0 || theChoice > characterArray.length);
            return characterArray[theChoice-1];
        }

/** chooseDropItem determines the specific item
that a player wants to drop */
private int chooseDropItem(Player p, BufferedReader keyB)
throws IOException{
String inputString = "prepare";
int theChoice = -1;

do {
    System.out.println("You are carrying: " +
    p.showMyThings() + '\n');
    System.out.print("Enter the number of the item to drop: " );
    inputString = keyB.readLine();
    try {
        theChoice = Integer.parseInt(inputString);
    }
    catch (NumberFormatException e) {
        System.out.println("Invalid input.");
        theChoice = -1;
}
    if (theChoice < 0 || theChoice > p.numItemsCarried())
        System.out.print("Invalid choice.");
} while (theChoice < 0 || theChoice > p.numItemsCarried());

return theChoice;
}


//time delay 
private void timeDelay(){
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }  
}

public void startQuest() throws IOException{
    Player thePlayer = new Player();
    Adventure theCave = new Adventure();
    Room startRm = theCave.createAdventure();
    thePlayer.setRoom(startRm);
    boolean winGame = false;

    /** Create the keyboard to control the game; we only need one */
    BufferedReader keyboard
    = new BufferedReader(new InputStreamReader(System.in));
    String inputString = "prepare";

    /* The main query user, get command, interpret, execute cycle. */
    while (!inputString.toString().equals("q")) {

        timeDelay();
        System.out.println(thePlayer.look());
        timeDelay();
        System.out.println("You are carrying: " + thePlayer.showMyThings() + '\n');
        timeDelay();
        /* get next move */
        int direction = 9;
        System.out.println("Which way (n,s,e,w,u,d)," +
        " or grab (g) or toss (t) an item." +
        " or eat (eat) an item." +
        " or give (give) an item." +
        " Or play (p) a game with a charater."+
        " Or quit (q)?" + '\n');
        inputString = keyboard.readLine();
        inputString.toLowerCase();
        System.out.println('\n');
        String key = inputString.toString().toLowerCase();
        switch (key){
            // Go
            case "n": case "north": case "go north": 
            case "s": case "south": case "go south":
            case "e": case "east": case "go east":
            case "w": case "west": case "go west":
            case "u": case "up": case "go up": 
            case "d": case "down": case "go down": 
            direction = convertDirection(key);
            thePlayer.go(direction);
            break;
        // Grab Item
            case "g": case "grab": case "grab item":
                if (thePlayer.handsFull()){
                    System.out.println("Your hands are full.");
                }else if ((thePlayer.getLoc()).roomItemEmpty()){
                    System.out.println("The room is empty.");
                }else{
                    Item itemToGrab = choosePickupItem(thePlayer,keyboard);
                    thePlayer.pickUp(itemToGrab);
                    (thePlayer.getLoc()).removeItem(itemToGrab);
                }
                break;
            // Drop Item
            case "t": case "toss": case "toss item":
            if (thePlayer.handsEmpty()){
                System.out.println("You have nothing to drop.");
            }else{
                int itemToToss = chooseDropItem(thePlayer,keyboard);
                thePlayer.drop(itemToToss);
            }
            break;

            // Eat Item
            case "eat": 
                if (thePlayer.handsEmpty ()== true){
                    System.out.println("You have nothing to eat.");
                }else{
                    Item eatDrink = chooseEatItem(thePlayer, keyboard);
                    if (eatDrink.getEdiable() == 1){
                        if(thePlayer.setSize(-1) == true){
                            System.out.println("\nAlice is shrunk 2 feet shorter ");
                            System.out.print("Alice! you are now "+ thePlayer.getSizeDesc() + " sized!\n");
                        }
                    }else if(eatDrink.getEdiable() == 2){
                        if(thePlayer.setSize(1) == true){
                            System.out.println("\nAlice is grown 2 feet taller ");
                            System.out.print("Alice! you are now "+ thePlayer.getSizeDesc() + " sized!\n");
                        }
                    }else if(eatDrink.getEdiable() == 3){
                            System.out.println("\nAlice wakes up dazed and confused");
                            thePlayer.setRoom(startRm);
                    }else{
                        System.out.println("\nYou cant eat that!!");
                    }
                }
                break;

            // Eat Item
            case "talk": 
            if(thePlayer.getLoc().roomCharacterEmpty() == true){
                System.out.println("There are no charaters in the room.");
            }else{
                Character characterToTalk = interactCharacter(thePlayer, keyboard,"talk");
                System.out.println(characterToTalk.getCharacterBlurb());
                characterToTalk.addChatCount();
                if (characterToTalk.getChatCount() == 3 && thePlayer.getLoc().getRoomName() == "r9"){
                    System.out.println("**The final key for to access the Queens location magically appearred\n"); 
                    Character[] character = thePlayer.getLoc().getRoomCharacters();
                    for (int i = 0; i < character.length; i++){
                        thePlayer.getLoc().getRoomCharacters()[i].dropItem(character[i].getItem("Final Key"),thePlayer.getLoc());
                    }
                }
            }
            break;

            case "give": 
                int itemToToss = 9999;
                if (thePlayer.handsEmpty())
                    System.out.println("You have nothing to drop.");
                else {
                    itemToToss = chooseDropItem(thePlayer,keyboard);
                    thePlayer.drop(itemToToss);
                    if (thePlayer.getLoc().getRoomName().equals("r3")
                    && thePlayer.getLoc().checkRoomContents("Gloves") == true
                    && thePlayer.getLoc().checkRoomContents("Fan") == true){
                        System.out.println("**The final key for to access the Queens location magically appearred\n"); 
                        Character[] character = thePlayer.getLoc().getRoomCharacters();
                        for (int i = 0; i < character.length; i++){
                            thePlayer.getLoc().getRoomCharacters()[i].dropItem(character[i].getItem("Letter"),thePlayer.getLoc());
                        }
                    }
                }
                break;

            //play game 
            case "p": case "play": case "play game": 
                if (thePlayer.getLoc().getRoomName() == "r11" && thePlayer.checkItem("Rock")
                && thePlayer.checkItem("Paper")
                && thePlayer.checkItem("Scissors")){
                    System.out.println("Please select either rock (r), scissor (s) or paper(p)!");  
                    int gameChoice = 9999;
                    int count = 0;

                    while (count < 3){
                        RockPaperScissor playRPC = new RockPaperScissor();
                        
                        String input = keyboard.readLine();
                        String d = input.toString();
                        d.toLowerCase();
                        switch(d){
                            case "p": case "paper": gameChoice = 1; break;
                            case "s": case "scissor":gameChoice = 2;break;
                            case "r": case "rock":gameChoice = 3;break;
                        }
                        if (playRPC.playGame(gameChoice) == true){
                            System.out.println("**Alice wins**"); 
                            thePlayer.go(5);
                            winGame = true;
                            break;
                        }if (playRPC.playGame(gameChoice) == false){
                            System.out.println("Alice loses: Please select either sock (r), scissor (s) or paper(p)!"); 
                            count++;
                        }if (count == 2){
                            System.out.println("**Alice loses and goes to start room\n"); 
                            thePlayer.setRoom(startRm);
                            break;
                        }
                    }
                }else{ 
                    System.out.println("**No games to be played here**");
                    break; 
                }   
                default: 
                System.out.println("**INVALID INPUT**");
                break;
            }
        }  
        if (winGame = false){
            System.out.println("**GAME OVER**");
        }else if (winGame = true){
            System.out.println("**WINNER WINNER CHICKEN DINNER!!!**");
    }         
}

public static void main(String args[])
throws IOException{
    System.out.println("\nWelcome to the Alice in Wonderland Game.\nYou must move throught the rooms in the rabbit hole to reach the end.\nThere you must beat the Queen at here own game\n\n");
    Game theGame = new Game();
    theGame.startQuest();
    }
}

