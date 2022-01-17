package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.*;

public class TestMoveCommand {

	 private ParsedInput playerInput;
     private Player thePlayer;
     private CommandHandler handler;
     private MoveCommand move;
     private Location mainGate, sydOffice;
     private HardCodedData hd;
     
	@Before
	public void setup(){
		 hd = new HardCodedData();         
         playerInput = new ParsedInput("get", new ArrayList());      
         thePlayer = new Player("Bipin");
         mainGate = new Location("Main Gate", "Building main gate");
         sydOffice = new Shop("Programmers everywhere", "Sydney Office");
         mainGate.getExitCollection().addExit("south", new Exit("You see Coders on Action", sydOffice));
         sydOffice.getExitCollection().addExit("north", new Exit("you see a main gate of building", mainGate));
         sydOffice.getInventory().addItem(new Weapon("m16",10,10,"gun"));
         thePlayer.setCurrentLocation(mainGate);
         handler = new CommandHandler();
         move = new MoveCommand();		
	}
	
	@Test
	public void testMoveNoWhere() {
		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
         // test move command no arguments
         CommandResponse response = move.execute(playerInput, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("If you want to move you need to tell me where."));
         Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
	}

	@Test
	public void testMoveNoExit() {
		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
		 playerInput.getArguments().add("west");
         // test move command no exit
         CommandResponse response = move.execute(playerInput, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("There is no exit there . . . try moving somewhere else!"));         
         Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
	}
	
	@Test
	public void testTakeExit() {
		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
		 playerInput.getArguments().add("south");
         // test move command no exit
         CommandResponse response = move.execute(playerInput, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("You successfully move"));
         Assert.assertSame(sydOffice, thePlayer.getCurrentLocation());
	}
}
