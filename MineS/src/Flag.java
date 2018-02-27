import info.gridworld.actor.Actor;
//Beau Heffron

public class Flag extends Actor
{
	private Cell cell;
	public Flag(Cell c)
	{
		cell = c;
	}
	public boolean getFlag()
	{
		return cell.getIsBomb();
	}
}
