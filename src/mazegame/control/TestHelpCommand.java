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

public class TestHelpCommand {
	 private ParsedInput playerInput;
     private Player thePlayer;
     private CommandHandler handler;
     private HelpCommand help;
     private Location mainGate;
     private Item gun= new Weapon("gun", 5, 5, "gun");
     private HardCodedData hd;
	
     
     @Before
 	public void setup(){
 		 hd = new HardCodedData();         
          playerInput = new ParsedInput("help", new ArrayList());      
          thePlayer = new Player("Bipin");
          mainGate = new Location("Main Gate", "Building main gate");
          
          
          
          thePlayer.setCurrentLocation(mainGate);
          handler = new CommandHandler();
          help = new HelpCommand();		
 	}
     
     @Test
  	public void testGetNoArg() {
  		 Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
           // test help command no arguments
           CommandResponse response = help.execute(playerInput, thePlayer);
           Assert.assertFalse(response.isFinishedGame());
           Assert.assertTrue(response.getMessage().contains("****HELP FOR PLAYING GAME****"));
           Assert.assertSame(mainGate, thePlayer.getCurrentLocation());
  	}

}
