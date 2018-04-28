package Model;

public class Player extends GameObject implements Directable {

    int lifes = 0;
    int direction = EAST;  

    public Player(int x, int y, int maxBomb, int lifes) {
        super(x, y, 0);
        this.lifes = lifes;
    }

    public void move(int X, int Y) {
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }
    
    public void teleporte(int x3, int y3) {
    	this.posX = x3;
        this.posY = y3;
    }

    public void rotate(int x, int y) {
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0)
            direction = WEST;
    }

   // //////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean isObstacle() {
        return false;
    }

    @Override
    public int getDirection() {
    return direction;
    }
    
    public int getLife() {
        return lifes;
        }
    
    
    public void addLife(int lifeplus) {
        lifes = lifes + lifeplus;
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
