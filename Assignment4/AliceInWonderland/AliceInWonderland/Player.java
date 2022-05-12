package AliceInWonderland;

 public class Player {
    private Room myLoc;
    private Item[] myThings = new Item[5];
    private int itemCount = 0;
    private int size = 2;

    public void setRoom(Room r){
    myLoc = r;
    }
 
    public String look() {
        return myLoc.getDesc();
    }

    public void go(int direction){
        myLoc.exit(direction,this);
    }

    public void pickUp(Item i){
    if (itemCount < 4) {
        myThings[itemCount] = i;
        itemCount++;
        myLoc.removeItem(i);
        }
    }

    public boolean checkItem(String itemToFind){
        for (Item n: myThings)
            if (n.getDesc().equals(itemToFind)) return true;
                return false;
    }

    public boolean haveItem(Item itemToFind){
        for (int n = 0; n < itemCount ; n++)
            if (myThings[n] == itemToFind) return true;
                return false;
    }

    public void drop(int itemNum){
        if (itemNum > 0 & itemNum <= itemCount && myLoc.getRoomName() == "r3" ||myLoc.getRoomName() == "r4" || myLoc.getRoomName() == "r11"|| myLoc.getRoomName() == "r6"){
            switch(itemNum){
                case 1: { 
                    myLoc.addItem(myThings[0]);
                    myThings[0]=myThings[1];
                    itemCount--;
                    break;
                }
                case 2: { 
                    myLoc.addItem(myThings[1]);
                    myThings[1]=myThings[2];
                    itemCount--;
                    break;
                }
                case 3: { 
                    myLoc.addItem(myThings[2]);
                    myThings[2]=myThings[3];
                    itemCount--;
                    break;
                }
                case 4: { 
                    myLoc.addItem(myThings[3]);
                    myThings[3]=myThings[4];
                    itemCount--;
                    break;
                }
            }
        } else{
            System.out.println("**Cannot leave item here safely**");
        }
    }
    public void setLoc(Room r){
        myLoc = r;
    }

    public Room getLoc(){
        return myLoc;
    }

    public boolean setSize(int s){
        int aliceSize = size + s;
        if (aliceSize < 1){
            System.out.println("Alice cannot get any smaller");
            System.out.println("Please eat or drink something else");
            return false;
        }
        else if (aliceSize >3){
            System.out.println("Alice cannot get any bigger");
            System.out.println("Please eat or drink something else");
            return false;
        }else{
            size = aliceSize;
            return true;
        }    
    }

    public String getSizeDesc(){
        String aliceSize = "";
        if (size == 1){
            aliceSize = "Small";
        }
        if (size == 2){
            aliceSize = "Normal";
        }
        if (size == 3){
            aliceSize = "Large";
        }
        return aliceSize;
    }

    public int getSize(){
        return size;
    }

    public String showMyThings(){
        String outString = "";
        for (int n = 0; n < itemCount ; n++)
            outString = outString + Integer.toString(n+1) + ": "
            + myThings[n].getDesc() + " ";
            return outString;
    }

    public Item[] MyThings(){
            return myThings;
    }

    public boolean handsFull(){return itemCount==4;}

    public boolean handsEmpty(){return itemCount==0;}

    public int numItemsCarried(){return itemCount;}
 }