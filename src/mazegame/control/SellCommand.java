package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class SellCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse ("Tell me what item you want to sell: ");
		}

		String itemLabel = (String) userInput.getArguments().get(0);
		Item theItem = thePlayer.getItems().findItem(itemLabel);
		
		if (theItem == null) {
   	 		return new CommandResponse ("We dont have the item with name " + itemLabel);
   	 	}
		
		
		thePlayer.getCurrentLocation().getInventory().addItem(theItem);
		thePlayer.getItems().addMoney(theItem.getValue());
		thePlayer.getItems().removeItem(itemLabel);
		
		return new CommandResponse ("You successfully sold the item "+ itemLabel);
	}
	}

