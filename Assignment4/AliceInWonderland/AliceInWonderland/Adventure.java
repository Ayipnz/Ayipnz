package AliceInWonderland;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

 public class Adventure {
 private Room entrance;

 public Room createAdventure() throws FileNotFoundException{

    File locDesc = new File("LocationDesc.txt");
    Scanner locDescReader = new Scanner(locDesc);
    File shortLocDesc = new File("ShortLocationDesc.txt");
    Scanner ShortLocDescReader = new Scanner(shortLocDesc);

    ArrayList<String> roomDesc = new ArrayList<String>();
    ArrayList<String> shortRoomDesc = new ArrayList<String>();

    while (locDescReader.hasNextLine()) {      
        String data = locDescReader.nextLine(); //read data into a variable
        String strData = data.toString(); //convert into string data
        roomDesc.add(strData);//input data into array based on count 
    }

    while (ShortLocDescReader.hasNextLine()) {      
        String data = ShortLocDescReader.nextLine(); //read data into a variable
        String strData = data.toString(); //convert into string data
        shortRoomDesc.add(strData);//input data into array based on count 
    }

    // The RiverBank:
    Room riverBank = new Room();
    riverBank.setDesc(roomDesc.get(0));
    riverBank.setShortDesc(shortRoomDesc.get(0));
    riverBank.setRoomName("RiverBank");

    // Room 1:
    Room r1 = new Room();
    r1.setDesc(roomDesc.get(1));
    r1.setShortDesc(shortRoomDesc.get(1));
    r1.setRoomName("r1");
    

    //r1.setSide(4,outside);
    entrance = riverBank;

    // Room 2:
    Room r2 = new Room();
    r2.setDesc(roomDesc.get(2));
    r2.setShortDesc(shortRoomDesc.get(2));
    r2.setRoomName("r2");

    Key tinyKey = new Key();
    tinyKey.setDesc("[Tiny gold key]");
    tinyKey.setEdiable(0);
    r2.addItem(tinyKey);

    Item bottle = new Item ();
    bottle.setDesc("[Bottle: Drink me to get Bigger]");
    bottle.setItemName("Bottle");
    bottle.setEdiable(2);
    r2.addItem(bottle);

    Item cake = new Item();
    cake.setDesc("[Cake: Eat me to get Smaller]");
    cake.setItemName("Cake");
    cake.setEdiable(1);
    r2.addItem(cake);

    // Room 3:
    Room r3 = new Room();
    r3.setDesc(roomDesc.get(3));
    r3.setShortDesc(shortRoomDesc.get(3));
    r3.setRoomName("r3");

    Character rabbit = new Character();
    rabbit.setCharacterName("Rabbit");
    rabbit.setCharacterBlurb("Bring me my gloves and extra fan!");
    r3.addCharacter(rabbit);

    Key letterKey = new Key();
    letterKey.setDesc("[Letter of Permission]");
    letterKey.setItemName("Letter");
    rabbit.addItem(letterKey);

    // Room 4:
    Room r4 = new Room();
    r4.setDesc(roomDesc.get(4));
    r4.setShortDesc(shortRoomDesc.get(4));
    r4.setRoomName("r4");

    // Room 5:
    Room r5 = new Room();
    r5.setDesc(roomDesc.get(5));
    r5.setShortDesc(shortRoomDesc.get(5));
    r5.setRoomName("r5");

    Character madHatter = new Character();
    madHatter.setCharacterName("Mad Hatter");
    madHatter.setCharacterBlurb("Oh, what a delightful child!We never get compliments, you must have a cup of tea from inside the house!");
    r5.addCharacter(madHatter);

    Item scissors = new Item();
    scissors.setDesc("[Scissors]");
    scissors.setEdiable(0);
    r5.addItem(scissors);

    // Room 6:
    Room r6 = new Room();
    r6.setDesc(roomDesc.get(6));
    r6.setShortDesc(shortRoomDesc.get(6));
    r6.setRoomName("r6");
    Item gloves = new Item();
    gloves.setDesc("[Little rabbit shaped gloves]");
    gloves.setItemName("Gloves");
    gloves.setEdiable(0);
    r6.addItem (gloves);


    Item fan = new Item();
    fan.setDesc("[Tiny Fan]");
    fan.setItemName("Fan");
    fan.setEdiable(0);
    r6.addItem(fan);

    Item mysteryDrink = new Item();
    mysteryDrink.setDesc("[Mysterious looking drink]");
    mysteryDrink.setItemName("MysteryDrink");
    mysteryDrink.setEdiable(0);
    r6.addItem(mysteryDrink);

    Character hare = new Character();
    hare.setCharacterName("March Hare");
    hare.setCharacterBlurb("How about a nice cup of tea?");
    r6.addCharacter(hare);

    // Room 7:
    Room r7 = new Room();
    Item flamingo = new Item();
    flamingo.setDesc("[Golf clubs shaped flamingos]");
    flamingo.setItemName("Flamingo");
    flamingo.setEdiable(0);
    r7.addItem(flamingo);

    Item hedgehog = new Item();
    hedgehog.setDesc("[Golf ball shaped hedgehogs]");
    hedgehog.setItemName("Hedgehog");
    hedgehog.setEdiable(1);
    r7.addItem(hedgehog);

    Item rock = new Item();
    rock.setDesc("[Rock]"); 
    rock.setEdiable(0);
    r7.addItem(rock);

    r7.setDesc(roomDesc.get(7));
    r7.setShortDesc(shortRoomDesc.get(7));
    r7.setRoomName("r7");

    // Room 8:
    Room r8 = new Room();
    r8.setDesc(roomDesc.get(8));
    r8.setShortDesc(shortRoomDesc.get(8));
    r8.setRoomName("r8");

    // Room 9:
    Room r9 = new Room();
    r9.setDesc(roomDesc.get(9));
    r9.setShortDesc(shortRoomDesc.get(9));
    r9.setRoomName("r9");

    Item paper = new Item();
    paper.setDesc("[Paper]");
    paper.setEdiable(0);
    r9.addItem(paper);

    Character tweedleDee = new Character();
    tweedleDee.setCharacterName("Tweedle Dee");
    tweedleDee.setCharacterBlurb("Hi! I am Tweedle Dee. Talk to my brother Tweedle Dum");
    r9.addCharacter(tweedleDee);
    Item finalKey = new Item();
    finalKey.setDesc("Final Key");
    finalKey.setItemName("Final Key");
    finalKey.setEdiable(0);
    tweedleDee.addItem(finalKey);

    Character tweedleDum = new Character();
    tweedleDum.setCharacterName("Tweedle Dum");
    tweedleDum.setCharacterBlurb("Hi! I am Tweedle Dum. Talk to my brother Tweedle Dee");
    r9.addCharacter(tweedleDum);
    finalKey.setDesc("Final Key");
    finalKey.setItemName("[Final Key]");
    finalKey.setEdiable(0);
    tweedleDum.addItem(finalKey);

    // Room 10:
    Room r10 = new Room();
    r10.setDesc(roomDesc.get(10));
    r10.setShortDesc(shortRoomDesc.get(10));
    r10.setRoomName("r10");

    Item mushroomStalk = new Item();
    mushroomStalk.setDesc("[The Stalk of the Mushroom(Possibly ediable)]");
    mushroomStalk.setItemName("Mushroom Stalk");
    mushroomStalk.setEdiable(1);
    r10.addItem(mushroomStalk);

    Item mushroomHead = new Item();
    mushroomHead.setDesc("[The Mushroom Head(Possibly ediable)]");
    mushroomHead.setItemName("Mushroom Head");
    mushroomHead.setEdiable(2);
    r10.addItem(mushroomHead);

    Character caterpiller = new Character();
    caterpiller.setCharacterName("Caterpiller");
    caterpiller.setCharacterBlurb("I am exactically three inches high, and it is a very good height indeed!");
    r10.addCharacter(caterpiller);

    // Room 11:
    Room r11 = new Room();
    r11.setDesc(roomDesc.get(11));
    r11.setShortDesc(shortRoomDesc.get(11));
    r11.setRoomName("r11");

    Room outside = new Room();
    outside.setDesc(roomDesc.get(12));
    outside.setShortDesc(shortRoomDesc.get(12));
    outside.setRoomName("r12");

    Character queen = new Character();
    queen.setCharacterName("Queen");
    queen.setCharacterBlurb("Where is your golf club and balls?");
    r11.addCharacter(queen);


    Character king = new Character();
    king.setCharacterName("King");
    king.setCharacterBlurb("I do not talk to peasants, talk to the Queen!");
    r11.addCharacter(king);
    
    // Connect rooms
    riverBank.setSide(5,r1);
    r1.setSide(2,r2);
    r2.setSide(3,r1);
    r3.setSide(5,r5);
    r3.setSide(2,r4);
    r4.setSide(3,r3);
    r4.setSide(1,r7);
    r4.setSide(0,r8);
    r5.setSide(4,r3);
    r5.setSide(3,r6);
    r6.setSide(2,r5);
    r7.setSide(0,r4);
    r8.setSide(1,r4);
    r8.setSide(3,r9);
    r8.setSide(2,r10);
    r9.setSide(2,r8);
    r10.setSide(3,r8);

    // We add a door between r2 and r3:
    Door theDoor = new Door(r2,r3,tinyKey,1);
    r2.setSide(2,theDoor);
    r3.setSide(3,theDoor);


    // We add a door between r2 and r3:
    Door trapDoor = new Door(r10,r11,letterKey,1);
    r10.setSide(1,trapDoor);
    r11.setSide(0,trapDoor);

    Door outsideDoor = new Door(r11, outside,finalKey,2);
    r11.setSide(5,outsideDoor);

    locDescReader.close();
    ShortLocDescReader.close();

    // Now return the entrance:
    entrance = riverBank;
    return entrance;
    }
 }

 