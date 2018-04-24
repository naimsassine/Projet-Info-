package Model;

import java.util.ArrayList;

public class Enemy extends GameObject implements Directable {
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	int lifes = 0;
	int direction = EAST;
	
	public Enemy(int x, int y, int maxBomb, int lifes) {
		super(x, y, 0);
	    this.lifes = lifes;
	    }
	
	
	 public int getDirection() {
		    return direction;
		    }
	
	 
	 public boolean isObstacle() {
	        return false;
	    }
	 
	 public int getLife() {
	        return lifes;
	        }
	    

	 public int getFrontX() {
	        int delta = 0;
	        if (direction % 2 == 0){
	            delta += 1 - direction;
	        }
	        return this.posX + delta;
	    }

	 public int getFrontY() {
	        int delta = 0;
	        if (direction % 2 != 0){
	            delta += direction - 2;
	        }
	        return this.posY + delta;
	    }
	    

	

}
