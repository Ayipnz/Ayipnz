package AliceInWonderland;

 /** Adventure Game Program Code
 Copyright (c) 1999 James M. Bieman

 To compile: javac AdventureGame.java
 To run: java AdventureGame

 The main routine is AdventureGame.main

 **/

 // class Door

 public class Door implements RabbitHole {
 /** In this implementation doors are always locked.
 A player must have the correct key to get through
 a door. Doors automatically lock after a player
 passes through. */

    /** The door's location. */
    private RabbitHole outSite;
    private RabbitHole inSite;
    private int doorSize;
    private Item myKey;


    /** We can construct a door at the site. */
    Door(RabbitHole out, RabbitHole in, Item key, int doorSize){
    outSite = out;
    inSite = in;
    this.myKey = key;
    this.doorSize = doorSize;
    }

    /** A player will need the correct key to enter. */
    public void enter(Player p){
        if (p.haveItem(myKey) && (p.getSize() == doorSize)) {
            System.out.println("Your key works! The door creaks open,");
            System.out.println("and slams behind you after you pass through.\n");
            if (p.getLoc() == outSite) inSite.enter(p);
            else if (p.getLoc() == inSite) outSite.enter(p);
        }else if(!p.haveItem(myKey) && (p.getSize() == doorSize)){
            System.out.println("You are the right size for the door");
            System.out.println("BUT");
            System.out.println("You don't have the right key for this door!");
            System.out.println("Sorry.\n");
        }else if(p.haveItem(myKey) && (p.getSize() != doorSize)){
            System.out.println("You have the correct key");
            System.out.println("BUT");
            System.out.println("You are not the right size for the door!");
            System.out.println("Sorry.\\");
        }
        else {
            System.out.println("You don't have the key for this door and you are the wrong size for the door!");
            System.out.println("Sorry.\n");
        }
    }
 }