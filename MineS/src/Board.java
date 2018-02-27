//Beau Heffron
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Board extends ActorWorld 
{
	private boolean game = true;
	 private Grid<Actor> gr;
	 public Board()
	 {
		 setMessage("\t\tMINESWEEPER!\n"
		 		+ "\t                Click On A Bomb To Restart");	
		 gr = getGrid();
	}
	public boolean locationClicked(Location loc)
	    {
		if(gr.get(loc) instanceof Bomb)
		{
			reset();
			init();
			return true;
		}
		if(gr.get(loc) instanceof Cell)
		{
			if(!((Cell)gr.get(loc)).getIsBomb())
			{
				this.remove(loc);
				countBomb(loc);
				
			}else
			{
				javax.swing.JOptionPane.showMessageDialog(null, "GameOver", "alert", 0);
				game = false;
				 for (int x = 0;x<10;x++)
						for(int y = 0;y<10;y++)
						{
							Location p = new Location(x,y);
							if(gr.get(p) instanceof Cell)
							{
								Cell q = (Cell)gr.get(p);
								if(q.getIsBomb()==true)
								{
									this.add(p,new Bomb());
								}else
								{
									this.remove(p);
								}
							}else
							{
								this.remove(p);
							}
						}
				
				//reset();
				//init();
			}
		}
		return true;
	    }
	 public void countBomb(Location loc)
	 {
		 ArrayList<Actor> a  = gr.getNeighbors(loc);
		 Stack<Actor> b = new Stack<Actor>();
		 for(int r =0;r<a.size();r++)
		 {
			 b.push(a.get(r));
		 }
			int count = 0;
			for(Actor c:b)
			{
				if(c instanceof Cell)
				{
				if((((Cell) c).getIsBomb())==true)
				{
					count++;
				}
				}
			}
			if(count == 1)
			{
				One x = new One();
				x.putSelfInGrid(gr,loc);
			}else if(count==2){
				Two x  = new Two();
				x.putSelfInGrid(gr,loc);
			}else if(count==3){
				Three x = new Three();
				x.putSelfInGrid(gr,loc);
			}else if(count==4){
				Four x = new Four();
				x.putSelfInGrid(gr,loc);
			}else if(count==5){
				Five x = new Five();
				x.putSelfInGrid(gr,loc);
			}else if(count==0)
			{
				for(Actor t:gr.getNeighbors(loc))
				{
					if(gr.get(t.getLocation()) instanceof Cell)
					{
						countBombHelper(t.getLocation());
					}
				}
			}
	 }
	 public void countBombHelper(Location loc)
	 {
		 ArrayList<Actor> a  = gr.getNeighbors(loc);
			int count = 0;
			for(int x = 0;x<a.size();x++){
				if(a.get(x) instanceof Cell)
				{
				if((((Cell) a.get(x)).getIsBomb())==true)
				{
					count++;
				}
				}
			}
			if(count== 0)
			{
				gr.get(loc).removeSelfFromGrid();;
			}
	 }
	 public void init()
		{
			
			for (int x = 0;x<10;x++)
				for(int y = 0;y<10;y++)
				{	
					int random = (int )(Math.random() * 4);
					if(random==3)
					{
						this.add(new Location(x,y),new Cell(true));
					}else{
						this.add(new Location(x,y),new Cell(false));
					}
				}
			
		}
	 public boolean canPlay()
	 {
		 return game;
	 }
	 public void reset()
	 {
		 for (int x = 0;x<10;x++)
				for(int y = 0;y<10;y++)
				{
					Location loc = new Location(x,y);
					if(gr.get(loc) instanceof Actor)
					{
					((Actor)(gr.get(loc))).removeSelfFromGrid();
					}
				}
	 }
}

