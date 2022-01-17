package mazegame.control;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Exit;
import mazegame.entity.Item;
import mazegame.entity.Location;
import mazegame.entity.Player;
import mazegame.entity.Shop;
import mazegame.entity.Weapon;

public class TestGetCommand {
	 private ParsedInput playerInput;
     private Player thePlayer;
     private CommandHandler handler;
     private GetCommand get;
     private Location mainGate;
     private Item gun= new Weapon("gun", 5, 5, "gun");
     private HardCodedData hd;
	
     
     @Before
 	public void setup(){
 		 hd = new HardCodedData();         
          playerInput = new ParsedInput("get", new ArrayList());      
          thePlayer = new Player("Bipin");
          mainGate = new Location("Main Gate", "Building main gate");
          mainGate.getInventory().addItem(gun);
          
          
          thePlayer.setCurrentLocation(mainGate);
          handler = new CommandHandler();
          get = new GetCommand();		
 	}
     
     @Test
 	public void testGetNoArg() {
 		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
          // test get command no arguments
          CommandResponse response = get.execute(playerInput, thePlayer);
          Assert.assertFalse(response.isFinishedGame());
          Assert.assertTrue(response.getMessage().contains("Tell me what item you want to get: "));
          Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 	}
     
     @Test
 	public void testGetNoItem() {
 		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 		 playerInput.getArguments().add("west");
          // test get command no item
          CommandResponse response = get.execute(playerInput, thePlayer);
          Assert.assertFalse(response.isFinishedGame());
          Assert.assertTrue(response.getMessage().contains("We dont have this item here"));         
          Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 	}
     
     @Test
 	public void testGetItem() {
 		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 		 playerInput.getArguments().add("gun");
          // test move command no exit
          CommandResponse response = get.execute(playerInput, thePlayer);
          Assert.assertFalse(response.isFinishedGame());
          Assert.assertTrue(response.getMessage().contains("You successfully got the item"));
          Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
          Assert.assertTrue(thePlayer.getCurrentLocation().getInventory().addItem(gun));
 	}
     
     

}
