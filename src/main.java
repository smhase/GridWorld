import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class main {
    public static void main(String[] args) {

        // Create 50x1 grid
        BoundedGrid boundedGrid = new BoundedGrid(1,50);

        // Creating world for the above grid
        ActorWorld actorWorld = new ActorWorld(boundedGrid);

        // Creating car actor object with speed 2
        Car myCar = new Car(2);

        // Creating rock 1
        Rock rock1 = new Rock();
        // Adding rock to the world
        actorWorld.add(rock1);
        // Setting the position of rock
        rock1.moveTo(new Location(0,3));
        Rock rock2 = new Rock();

        // Creating rock 2
        actorWorld.add(rock2);
        rock2.moveTo(new Location(0,4));
        actorWorld.add(myCar);
        myCar.moveTo(new Location(0,0));
        actorWorld.show();
    }
}

class Car extends Actor {
    int speed;

    Car(){}

    Car(int speed){
        this.speed = speed;
    }

    @Override
    public void act()
    {
        if (canMove())
            move();
    }

    void move(){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = new Location(loc.getRow(),loc.getCol()+speed);
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();

    }

    boolean canMove(){
       return true;
    }

}

