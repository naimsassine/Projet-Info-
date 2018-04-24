package Model;

import java.util.ArrayList;

public class Enemy extends GameObject implements Directable,Runnable {
	int sleeptime = 200;
	int lifes = 0;
	int direction = EAST;
	Thread t;
	
	public Enemy(int x, int y, int lifes) {
		super(x,y,0);
	    this.lifes = lifes;
	    t = new Thread(this);
	    t.start();
	    }
	
	public void MoveEnemy(int x, int y) {
		while (true) {
			if(x<5 && y<5) {
				y=y;
				this.posX=x+1;
			}
			else {
				x=x;
				y=y+1;
			}
		}
	}
	
	
	
	public void run(){
		try {
			Thread.sleep(this.sleeptime);
			this.MoveEnemy(1, 1);
			}catch (InterruptedException e) {
			e.printStackTrace();
			}
			}
		
		
		
	
	
	
	
	
	
	
	

	
	
	 public int getDirection() {
		    return direction;
		    }

	 
	 public boolean isObstacle() {
	        return true;
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
