/*
 * Max Porter 1/31/2017
 * GridWorld Level 00
 */
import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;


public class Bacteria extends Actor{

	private Location loc = null;
	ArrayList<Location> locs;
	private boolean isDone = false;
	private boolean found = false;
	
	public Bacteria()
	{
		setColor(Color.BLUE);
	}
	
	public void act()
	{
			if(!found)
			{
				locs = getGrid().getOccupiedLocations();
				for(Location locate : locs)
				{
					Actor check = getGrid().get(locate);
					if(check instanceof Heart) 
					{
						loc = locate;
						found = true;
					}
				}
			}
			
			if(!isDone)
			{
				setDirection(getLocation().getDirectionToward(loc));
				Location next = getLocation().getAdjacentLocation(getDirection());
				if(getGrid().get(next) == null)
				{
					moveTo(next);
				}
			}
			
			for(Location endLoc : getGrid().getOccupiedAdjacentLocations(getLocation()))
			{
				Actor a = getGrid().get(endLoc);
				if(a instanceof Heart)
				{
					a.setColor(Color.BLACK);
					isDone = true;
				}
			}
	}
	
}
