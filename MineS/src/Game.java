//Beau Heffron

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Game
{

	public static void main(String Args[])
	{ 
		Board b = new Board();
		b.init();
		//b.add(new Location(3,5),new Cell(false));
		b.show();
	}
	


}
