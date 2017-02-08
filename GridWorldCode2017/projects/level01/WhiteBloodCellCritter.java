import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class WhiteBloodCellCritter extends Critter{
	
	private Location heart = null;
	
	public WhiteBloodCellCritter()
	{
		setColor(Color.YELLOW);
	}
	
	public void act()
	{
		if (getGrid() == null) return;
		ArrayList<Actor> actors = getActors(); 
		processActors(actors);
		ArrayList<Location> moveLocs = getMoveLocations(); 
		Location loc = selectMoveLocation(moveLocs); 
		makeMove(loc);
	}
	public void processActors(ArrayList<Actor> actors){/*Do nothing*/}
	
	public ArrayList<Actor> getActors(){return null;}
	
	public ArrayList<Location> getMoveLocations()
	{
		return getGrid().getEmptyAdjacentLocations(heart);
	}

}
