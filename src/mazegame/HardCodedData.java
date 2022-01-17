package mazegame;

import java.util.HashMap;

import mazegame.boundary.IMazeData;
import mazegame.entity.*;
import mazegame.entity.Character;
import mazegame.entity.utility.*;


public class HardCodedData implements IMazeData {
	private Location mainGate, street,shoppingCenter,fightClub,weaponMarket, school, disco, policeStation, forest;
//	private NonPlayerCharacter hitler;
	private NonPlayerCharacter npc1;
	
	
	
	public HardCodedData()
	{
		createLocations();
		createItems();
		populateWeightLimitTable();
		populateStrengthTable();
		populateAgilityTable();
		createCharacters();
	}
	
	public Location getStartingLocation()
	{
		return mainGate;
	}
	
	private void createCharacters() {
		npc1 = new NonPlayerCharacter("Hitler", true);
		
		
	}
	
	public String getWelcomeMessage()
	{
		
		return "Author: \n"
				+ "WELCOME TO THE MAZE GAME \n";
	}
	
	private void createItems() {
		
		Item m16 = new Weapon("m16",25,5,"m16 gun fire");
		Item ak47 = new Weapon("ak47",10,20.5,"russian gun fire");
		Item hemlet = new Shield("helmet",10,10,"military cap");
		Item sword = new Weapon("sword",5,20.5,"long sword");
		Item rbj = new Weapon("rbj",50,20,"rbj machine");
		Item jacket = new Shield("jacket", 16, 22, "Bullet proof jacket");
		Item maverick = new Weapon("maverick",50,20,"Maverick gun");
		Item blueberries = new Armor("blueberry", 10, 2, "Blueberries");
		Item drink = new Armor("drink", 15, 3, "Energy drink for instant energy");
		//Item potion = new Armor("potion", 0, 2, "Potion");
		
		
		
		
		
		
		
		shoppingCenter.getInventory().addItem(m16);
		shoppingCenter.getInventory().addItem(maverick);
		shoppingCenter.getInventory().addItem(rbj);
		shoppingCenter.getInventory().addItem(jacket);
		
		mainGate.getInventory().addItem(blueberries);
		mainGate.getInventory().addItem(rbj);
		mainGate.getInventory().addItem(drink);
		
		
		//mainGate.getInventory().addItem(god);
		//mainGate.getInventory().addItem(hitler);
		
		street.getInventory().addItem(sword);
		street.getInventory().addItem(drink);
		street.getInventory().addItem(blueberries);
		
		fightClub.getInventory().addItem(hemlet);
		fightClub.getInventory().addItem(drink);
		fightClub.getInventory().addItem(blueberries);
		
		
		weaponMarket.getInventory().addItem(sword);
		weaponMarket.getInventory().addItem(ak47);
		
	}
	
	
	
	private void createLocations () 
	{
		mainGate = new Location ("Main gate", "Main Gate of your building");
		street = new Location("Wallace Street","Wolves of wallace street");
		shoppingCenter = new Shop("Shopping Mall","Shopping Center");		
		fightClub = new Location("Fight club"," 22+ Fight Club");	
		weaponMarket = new Shop("Weapon Market", "Buy and Sell weapons here");
		school = new Location("High School", "ABC High School ground");
		disco = new Location("Disco and Bar", "Disco and Bar: Dance and drink");
		policeStation = new Location("Police Station", "Police Station Sydney");
		forest = new Location("Forest", "Animal life stays at forest");
		
		//connect locations
		mainGate.getExitCollection().addExit("south", new Exit("Shopping Mall ",shoppingCenter));
		mainGate.getExitCollection().addExit("east", new Exit("Wallace Street",street));
		
		
		street.getExitCollection().addExit("west", new Exit("lab2 exit ",mainGate));
		street.getExitCollection().addExit("north", new Exit("ring  exit",fightClub));
		street.getExitCollection().addExit("east", new Exit("Weapon Market", weaponMarket));
		street.getExitCollection().addExit("south",new Exit("Police Station", policeStation));
		
		weaponMarket.getExitCollection().addExit("west", new Exit("Wallace Street", street));
		weaponMarket.getExitCollection().addExit("south", new Exit("High School", school));
		weaponMarket.getExitCollection().addExit("east", new Exit("Disco and Bar", disco));
		
		school.getExitCollection().addExit("north", new Exit("Weapon Market", weaponMarket));
		school.getExitCollection().addExit("west", new Exit("Police Station", policeStation));
		
		disco.getExitCollection().addExit("west", new Exit("Weapon Market", weaponMarket));
		
		
		
		shoppingCenter.getExitCollection().addExit("north", new Exit("Main gate of building ",mainGate));
		shoppingCenter.getExitCollection().addExit("east", new Exit("Police Station",policeStation));
		
		
		fightClub.getExitCollection().addExit("south", new Exit("Wallace Street",street));
		
		policeStation.getExitCollection().addExit("east", new Exit("High School", school));
		policeStation.getExitCollection().addExit("west", new Exit("Shopping Mall", shoppingCenter));
		policeStation.getExitCollection().addExit("north", new Exit("Wallace Street", street));
		
		
	}
	 private void populateStrengthTable()
     {
         StrengthTable strengthModifiers = StrengthTable.getInstance();
         strengthModifiers.setModifier(1, -5);
         strengthModifiers.setModifier(2, -4);
         strengthModifiers.setModifier(3, -4);
         strengthModifiers.setModifier(4, -3);
         strengthModifiers.setModifier(5, -3);
         strengthModifiers.setModifier(6, -2);
         strengthModifiers.setModifier(7, -2);
         strengthModifiers.setModifier(8, -1);
         strengthModifiers.setModifier(9, -1);
         strengthModifiers.setModifier(10, 0);
         strengthModifiers.setModifier(11, 0);
         strengthModifiers.setModifier(12, 1);
         strengthModifiers.setModifier(13, 1);
         strengthModifiers.setModifier(14, 2);
         strengthModifiers.setModifier(15, 2);
         strengthModifiers.setModifier(16, 3);
         strengthModifiers.setModifier(17, 3);
         strengthModifiers.setModifier(18, 4);
         strengthModifiers.setModifier(19, 4);
         strengthModifiers.setModifier(20, 5);
         strengthModifiers.setModifier(21, 5);
         strengthModifiers.setModifier(22, 5);
         strengthModifiers.setModifier(23, 5);
         strengthModifiers.setModifier(24, 5);
         strengthModifiers.setModifier(25, 5);
         strengthModifiers.setModifier(26, 8);
         strengthModifiers.setModifier(27, 8);
         strengthModifiers.setModifier(28, 8);
         strengthModifiers.setModifier(29, 8);
         strengthModifiers.setModifier(30, 10);
         strengthModifiers.setModifier(31, 10);
         strengthModifiers.setModifier(32, 10);
         strengthModifiers.setModifier(33, 10);
         strengthModifiers.setModifier(34, 10);
         strengthModifiers.setModifier(35, 10);
         strengthModifiers.setModifier(36, 12);
         strengthModifiers.setModifier(37, 12);
         strengthModifiers.setModifier(38, 12);
         strengthModifiers.setModifier(39, 12);
         strengthModifiers.setModifier(40, 12);
         strengthModifiers.setModifier(41, 15);
         strengthModifiers.setModifier(42, 15);
         strengthModifiers.setModifier(43, 15);
         strengthModifiers.setModifier(44, 17);
         strengthModifiers.setModifier(45, 17);
         strengthModifiers.setModifier(46, 18);
     }

     private void populateAgilityTable()
     {
         AgilityTable agilityModifiers = AgilityTable.getInstance();
         agilityModifiers.setModifier(1, -5);
         agilityModifiers.setModifier(2, -5);
         agilityModifiers.setModifier(3, -5);
         agilityModifiers.setModifier(4, -3);
         agilityModifiers.setModifier(5, -3);
         agilityModifiers.setModifier(6, -2);
         agilityModifiers.setModifier(7, -2);
         agilityModifiers.setModifier(8, -1);
         agilityModifiers.setModifier(9, -1);
         agilityModifiers.setModifier(10, 0);
         agilityModifiers.setModifier(11, 0);
         agilityModifiers.setModifier(12, 1);
         agilityModifiers.setModifier(13, 1);
         agilityModifiers.setModifier(14, 2);
         agilityModifiers.setModifier(15, 2);
         agilityModifiers.setModifier(16, 3);
         agilityModifiers.setModifier(17, 3);
         agilityModifiers.setModifier(18, 4);
         agilityModifiers.setModifier(19, 4);
         agilityModifiers.setModifier(20, 6);
         agilityModifiers.setModifier(21, 6);
         agilityModifiers.setModifier(22, 6);
         agilityModifiers.setModifier(23, 6);
         agilityModifiers.setModifier(24, 6);
         agilityModifiers.setModifier(25, 6);
         agilityModifiers.setModifier(26, 8);
         agilityModifiers.setModifier(27, 8);
         agilityModifiers.setModifier(28, 8);
         agilityModifiers.setModifier(29, 8);
         agilityModifiers.setModifier(30, 8);
         agilityModifiers.setModifier(31, 8);
         agilityModifiers.setModifier(32, 11);
         agilityModifiers.setModifier(33, 11);
         agilityModifiers.setModifier(34, 11);
         agilityModifiers.setModifier(35, 11);
         agilityModifiers.setModifier(36, 11);
         agilityModifiers.setModifier(37, 11);
         agilityModifiers.setModifier(38, 13);
         agilityModifiers.setModifier(39, 13);
         agilityModifiers.setModifier(40, 13);
         agilityModifiers.setModifier(41, 13);
         agilityModifiers.setModifier(42, 13);
         agilityModifiers.setModifier(43, 13);
         agilityModifiers.setModifier(44, 15);
         agilityModifiers.setModifier(45, 15);
         agilityModifiers.setModifier(46, 15);
     }

     private void populateWeightLimitTable()
     {
         WeightLimit weightModifier = WeightLimit.getInstance();
         weightModifier.setModifier(1, 6);
         weightModifier.setModifier(2, 13);
         weightModifier.setModifier(3, 20);
         weightModifier.setModifier(4, 26);
         weightModifier.setModifier(5, 33);
         weightModifier.setModifier(6, 40);
         weightModifier.setModifier(7, 46);
         weightModifier.setModifier(8, 53);
         weightModifier.setModifier(9, 60);
         weightModifier.setModifier(10, 66);
         weightModifier.setModifier(11, 76);
         weightModifier.setModifier(12, 86);
         weightModifier.setModifier(13, 100);
         weightModifier.setModifier(14, 116);
         weightModifier.setModifier(15, 133);
         weightModifier.setModifier(16, 153);
         weightModifier.setModifier(17, 173);
         weightModifier.setModifier(18, 200);
         weightModifier.setModifier(19, 233);
         weightModifier.setModifier(20, 266);
         weightModifier.setModifier(21, 306);
         weightModifier.setModifier(22, 346);
         weightModifier.setModifier(23, 400);
         weightModifier.setModifier(24, 466);
         weightModifier.setModifier(25, 533);
         weightModifier.setModifier(26, 613);
         weightModifier.setModifier(27, 693);
         weightModifier.setModifier(28, 800);
         weightModifier.setModifier(29, 933);
         weightModifier.setModifier(30, 1013);
         weightModifier.setModifier(31, 1093);
         weightModifier.setModifier(32, 1300);
         weightModifier.setModifier(33, 1433);
         weightModifier.setModifier(34, 1513);
         weightModifier.setModifier(35, 1593);
         weightModifier.setModifier(36, 1700);
         weightModifier.setModifier(37, 1833);
         weightModifier.setModifier(38, 1913);
         weightModifier.setModifier(39, 1993);
         weightModifier.setModifier(40, 2100);
         weightModifier.setModifier(41, 2233);
         weightModifier.setModifier(42, 2313);
         weightModifier.setModifier(43, 2393);
         weightModifier.setModifier(44, 2500);
         weightModifier.setModifier(45, 2633);
         weightModifier.setModifier(46, 2713);
     }
}
