package mazegame.control;

import mazegame.entity.Player;

public class PotionCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getPotion().getValue() == 0) {
			return new CommandResponse("You don't have any potion.");
		}
		else {
			thePlayer.setLifePoints(thePlayer.getLifePoints() + 10);
			
		}
		return null;
	}

}
