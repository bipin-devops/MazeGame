package mazegame.control;

import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class TalkCommand implements Command{

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse ("Which NPC? ");
		}
		
		
		
		
		
		
		
		
		return null;
	}

}
