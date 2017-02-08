import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
//  This class runs a world that contains a Heart, Bacteria1 and a WhiteBloodCellCritter 
//  all added at specified locations, as well as an alternative location near the boarder
public class SaveMyHeartRunner1
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(6,6), new Heart());
        world.add(new Location(5,4), new WhiteBloodCellCritter());
       // world.add(new Location(8,6), new Heart());  // try placing the heart near the boundry
       // world.add(new Location(7,4), new WhiteBloodCellCritter()); // place the wbc nearby
        world.add(new Location(8,1), new Bacteria1());  // note that this is BacteriaONE
        world.show();
    }
}