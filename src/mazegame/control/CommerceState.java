package mazegame.control;

import mazegame.entity.*;

public class CommerceState extends CommandState {

    public CommerceState()
    {
        this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("buy", new BuyCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("sell", new SellCommand());
        this.getAvailableCommands().put("list", new ListCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Shop)
            return this;
        return new MovementState();
    }
}
