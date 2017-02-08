// SaveMyHeartRunner.java
// This class runs a world that contains a Heart and Bacteria
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.util.Random;
public class level00Runner
{
    public static void main(String[] args)
    {
    	Random r = new Random();
        ActorWorld world = new ActorWorld();
        world.add(new Location(r.nextInt(10), r.nextInt(10)), new Heart());     // location can change   
        world.add(new Location(r.nextInt(10), r.nextInt(10)), new Bacteria());  // location can change   
        world.show();
    }
}