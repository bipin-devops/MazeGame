package mazegame.control;

import mazegame.entity.*;

public class MovementState extends CommandState {
    public MovementState()
    {
        //this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("quit", new QuitCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("unlock", new UnlockCommand());
        this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("get", new GetCommand());
        this.getAvailableCommands().put("list", new ListCommand());
        this.getAvailableCommands().put("drop", new DropCommand());
        this.getAvailableCommands().put("equip", new EquipCommand());
        this.getAvailableCommands().put("unequip", new UnequipCommand());
        this.getAvailableCommands().put("getmaze", new getMazeStatusCommand());
        this.getAvailableCommands().put("flee", new FleeCommand());
        this.getAvailableCommands().put("collect", new CollectCommand());
        this.getAvailableCommands().put("help", new HelpCommand());
        this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("potion", new PotionCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Shop)
            return new CommerceState();
        return this;
    }
}

