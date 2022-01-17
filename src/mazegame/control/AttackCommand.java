package mazegame.control;

import mazegame.entity.Player;

public class AttackCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		// TODO Auto-generated method stub
		
		if (userInput.getArguments().size() == 0){
            return new CommandResponse("Who do you want to attack?");
        }

        //check if there is an NPC
//        if (thePlayer.getCurrentLocation().getCharacters() == null) {
//        	return new CommandResponse("Nobody is here!");
//          }
        
       
        
        
        
		return new CommandResponse("Going good");
	}

}
