package Model;
import View.Window;
import java.util.ArrayList;

import Controller.Keyboard;
import View.Window;

public class Enemy extends GameObject implements Directable,Runnable {
	int sleeptime = 1000;
	int lifes = 0;
	int direction = EAST;
	Thread t;
	
	public Enemy(int x, int y, int lifes) {
		super(x,y,0);
	    this.lifes = lifes;
	    t = new Thread(this);
	    t.start();
	    }
	
	
	private void notifyView() {
        Game.window.update();
    }

	
	public void run(){
		try {
			for (int i = 0; i < 14; i++) {
				Thread.sleep(sleeptime);
				Keyboard.game.MoveEnemy(1, 0,this);
				Thread.sleep(sleeptime);
				Keyboard.game.MoveEnemy(0, 1,this);
				
			}
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
