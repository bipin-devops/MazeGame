package mazegame.entity;

import mazegame.entity.utility.DiceRoller;

public class Player extends Character {
	
	private Location currentLocation;
	private Inventory items; 
	private Armor potion;

    public Armor getPotion() {
		return potion;
	}

	public void setPotion(Armor potion) {
		this.potion = potion;
	}

	public Player()
    {
    	items = new FiniteInventory(DiceRoller.GetInstance().generateAbilityScore());
    }

    public Player(String name)
	{
	    super (name);
	    
	    items = new FiniteInventory(DiceRoller.GetInstance().generateAbilityScore());
	}
    
    public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Inventory getItems() {
		return items;
	}
	
	

	public void setItems(Inventory items) {
		this.items = items;
	}


}
