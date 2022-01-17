package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class getMazeStatusCommand implements Command {
	
	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			
			String loc = thePlayer.getCurrentLocation().getDescription();
			
			return new CommandResponse ("Current Maze Location:  "+ loc);
		}

		
   	 
		return null;
   	 	
   	 	
   	 	
   	 	
   	 	
	}
}
