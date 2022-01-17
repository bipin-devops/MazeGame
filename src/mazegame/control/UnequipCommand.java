package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;

public class UnequipCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse ("Tell me the item name to unequip.");
		}
		
		String itemLabel = (String) userInput.getArguments().get(0);
		Item theItem = thePlayer.getItems().findItem(itemLabel);
		
		
		if (theItem == null) {
			return new CommandResponse("There is not this item with you");
		}
		//
		
		
		if (theItem instanceof Weapon || theItem instanceof Shield) {
			
			thePlayer.setM_Weapon((Weapon) theItem);
			thePlayer.setM_Shield((Shield) theItem);
		}else {
			return new CommandResponse("Cannot do this action.");
		}
		
		
		// TODO Auto-generated method stub
		return new CommandResponse("successfully unequipped "+ itemLabel );
	}
	

}
