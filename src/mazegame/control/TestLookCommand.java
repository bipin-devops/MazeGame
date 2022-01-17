package mazegame.control;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import mazegame.HardCodedData;
import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.Player;
import mazegame.entity.Shop;
import mazegame.entity.Weapon;

public class TestLookCommand extends TestCase {
	

	 private ParsedInput playerInput;
    private Player thePlayer;
    private CommandHandler handler;
    private LookCommand look;
    private Exit northExit;
    private Location mainGate, sydOffice;
    private HardCodedData hd;
   
    
	@Before
	public void setup() throws Exception{
		 hd = new HardCodedData();         
         playerInput = new ParsedInput("get",null);      
         thePlayer = new Player("Bipin");
         mainGate = new Location("Main Gate", "Building main gate");
         sydOffice = new Shop("Programmers everywhere", "Sydney Office");
         mainGate.getExitCollection().addExit("south", new Exit("You see Coders on Action", sydOffice));
         sydOffice.getExitCollection().addExit("north", new Exit("you see a main gate of building", mainGate));
         sydOffice.getInventory().addItem(new Weapon("m16",10,10,"gun"));
         thePlayer.setCurrentLocation(mainGate);
         handler = new CommandHandler();
         look = new LookCommand();
	}
	
	@Test
    public void testlookifNoA() {

		Assert.assertSame(sydOffice.getDescription(), mainGate.getExitCollection().getExit(sydOffice.getDescription()));
        // test move command no arguments
        CommandResponse response = look.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("If you want to move you need to tell me where."));
        Assert.assertSame(sydOffice.getDescription(), mainGate.getExitCollection().getExit(sydOffice.getDescription()));

    }
	
	
	
	



}
