package AliceInWonderland;

/** Adventure Game Program Code
Copyright (c) 1999 James M. Bieman

To compile: javac AdventureGame.java
To run: java AdventureGame

The main routine is AdventureGame.main

**/


// class Item

public class Item {

    private String description;
    private String itemName;
    private Integer ediable;

    public void setDesc(String d){
        description = d;
    }

    public String getDesc(){
        return description;
    }

    public void setItemName(String d){
        itemName = d;
        }
        
    public String getItemName(){
        return itemName;
    }

    public void setEdiable(int d){
        ediable = d;
        }
        
    public int getEdiable(){
        return ediable;
    }
}