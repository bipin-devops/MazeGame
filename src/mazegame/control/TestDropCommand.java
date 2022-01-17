package mazegame.control;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Item;
import mazegame.entity.Location;
import mazegame.entity.Player;
import mazegame.entity.Weapon;

public class TestDropCommand {
	 private ParsedInput playerInput;
     private Player thePlayer;
     private CommandHandler handler;
     private DropCommand drop;
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
          drop = new DropCommand();		
 	}
     
     @Test
 	public void testDropNoArg() {
 		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
          // test drop command no arguments
          CommandResponse response = drop.execute(playerInput, thePlayer);
          Assert.assertFalse(response.isFinishedGame());
          Assert.assertTrue(response.getMessage().contains("Tell me what item you want to drop: "));
          Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 	}
     
     @Test
 	public void testDropNoItem() {
 		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 		 playerInput.getArguments().add("west");
          // test drop command no item
          CommandResponse response = drop.execute(playerInput, thePlayer);
          Assert.assertFalse(response.isFinishedGame());
          Assert.assertTrue(response.getMessage().contains("We dont have the item with name "));         
          Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 	}
     
     @Test
 	public void testDropItem() {
 		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
 		 playerInput.getArguments().add("gun");
          // test Drop command 
          CommandResponse response = drop.execute(playerInput, thePlayer);
          Assert.assertFalse(response.isFinishedGame());
          Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
          Assert.assertEquals(1, thePlayer.getCurrentLocation().getInventory().removeItem(gun.getLabel()));
          Assert.assertTrue(response.getMessage().contains("You successfully dropped the item "));
          
 	}
     
     

}
