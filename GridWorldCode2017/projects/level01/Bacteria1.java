import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class Bacteria1 extends Bacteria{

	private Location wbc = null;
	private Location h = null;
	private boolean foundH,isDone = false;
	
	
	public Bacteria1()
	{
		setColor(Color.GREEN);
	}
	
	public void act()
	{
		if(!foundH)
		{
			ArrayList<Location> loca = getGrid().getOccupiedLocations();
			for(Location loc : loca)
			{
				Actor a = getGrid().get(loc);
				if(a instanceof Heart) 
				{
					h = loc;
					foundH = true; //Find heart once
				}
			}
		}
		
		if(!isDone)
		{
			setDirection(getLocation().getDirectionToward(h));
			Location next = getLocation().getAdjacentLocation(getDirection());
			if(!closeToWhiteBloodCell())
			{
				if(getGrid().get(next) == null)
				{
					moveTo(next);
				}
			}
			else
			{
				setDirection(getDirection()+180);
				Location newNext = getLocation().getAdjacentLocation(getDirection());
				if(getGrid().get(newNext) == null)
				{
					moveTo(newNext);
				}
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
	
	public boolean closeToWhiteBloodCell()
	{
		locs = getGrid().getOccupiedLocations();
		for(Location loc : locs)
		{
			Actor a = getGrid().get(loc);
			if(a instanceof WhiteBloodCellCritter) 
			{
				wbc = loc;
			}
		}
		if(wbc != null)
		{
			if(Math.abs(wbc.getRow()-getLocation().getRow()) <= 2 && Math.abs(wbc.getCol()-getLocation().getCol()) <= 2)
			{
				return true;
			}
			else return false;
		}
		else return false;
	
	}
	
}
