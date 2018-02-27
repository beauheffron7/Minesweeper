//Beau Heffron
import java.awt.event.MouseEvent;

import info.gridworld.actor.Actor;


//Frowny Face 2630
//Flag 2690

//Skull 2620
public class Cell extends Actor 
{
	private boolean isBomb;
	private int myValue;
	public Cell(boolean x)
	{
		isBomb = x;
	}
	public boolean getIsBomb()
	{
		return isBomb;
	}
	
	 public int disp()
	 {
		 return myValue;
	 }
	 public void mouseClicked(MouseEvent e) 
	 {

         if (e.getButton() == MouseEvent.BUTTON3) 
         {
             if(isBomb == false)
             {
            	 this.disp();
             }
         }
	 }

}
	