package mazegame.control;

import mazegame.entity.Exit;
import mazegame.entity.Item;
import mazegame.entity.Location;
import mazegame.entity.Player;

public class FleeCommand implements Command {
	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			
			String[] anywhere = {"east", "west", "north", "south"};
			boolean exitfound = true;
			
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			Exit theExit1 = thePlayer.getCurrentLocation().getExitCollection().getExit(anywhere[0]);
			Exit theExit2 = thePlayer.getCurrentLocation().getExitCollection().getExit(anywhere[1]);
			Exit theExit3 = thePlayer.getCurrentLocation().getExitCollection().getExit(anywhere[2]);
			Exit theExit4 = thePlayer.getCurrentLocation().getExitCollection().getExit(anywhere[3]);
			
			
			while (true){
				if (theExit1 != null) {
					thePlayer.setCurrentLocation(theExit1.getDestination());
					break;
				}
				else if (theExit2 != null) {
					thePlayer.setCurrentLocation(theExit2.getDestination());
					break;
				}
				else if (theExit3 != null) {
					thePlayer.setCurrentLocation(theExit3.getDestination());
					break;
				}
				else if (theExit4 != null) {
					thePlayer.setCurrentLocation(theExit4.getDestination());
					break;
				}else {
					return new CommandResponse("You are trapped, no exit found.");
				}
			}
			
			
			
			
		
			
			
			
			
			return new CommandResponse ("You successfully run away from danger!! You are now on another location.");
		}
		
		
   	 	
		return new CommandResponse ("You successfully run away");
	}

}
