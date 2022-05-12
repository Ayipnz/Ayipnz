package AliceInWonderland;

import java.util.ArrayList;

public class Character{
    private String characterName;
    private String characterBlurb;
    private int chatCount = 0;
    private ArrayList<Item> myThings = new ArrayList<Item>();


    public void addItem(Item i){
            myThings.add(i);
        }

    public void dropItem(Item i, Room r){
        r.addItem(i);
        myThings.remove(i);
    }

    public Item getItem(String s){
        Item tempItem = new Item();
        tempItem.setItemName("tempItem");
        for (int i = 0; i < myThings.size(); i++){
            if (myThings.get(i).getItemName() == s){
                Item theItem = myThings.get(i);
                return theItem;
            }
        }
        return tempItem;
    }

    public void setCharacterName(String a){
        this.characterName = a;
    }

    public String getCharacterName(){
        return characterName;
    }

    public void setCharacterBlurb(String a){
        this.characterBlurb = a;
    }

    public String getCharacterBlurb(){
        return characterBlurb;
    }

    public void addChatCount(){
        this.chatCount = chatCount + 1;
    }

    public int getChatCount(){
        return chatCount;
        }
}



    
