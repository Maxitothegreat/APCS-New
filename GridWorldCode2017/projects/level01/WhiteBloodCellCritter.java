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
		ArrayList<Location> loca = getGrid().getOccupiedLocations();
		for(Location loc : loca)
		{
			Actor a = getGrid().get(loc);
			if(a instanceof Heart) 
			{
				heart = loc;
			}
		}
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
		ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(getLocation());
		for(int i = 0; i < locs.size(); i++)
		{
			if(locs.get(i).getCol() < heart.getCol()-2 || locs.get(i).getCol() > heart.getCol()+2 || locs.get(i).getRow() < heart.getRow()-2 || locs.get(i).getRow() > heart.getRow()+2)
			{
				locs.remove(i);
				i--;
			}
		}
		return locs;
	}

}
