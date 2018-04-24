package Model;

public class MagicPotionLife extends GameObject {

	public MagicPotionLife(int X, int Y, int color) {
		super(X, Y, 0);
	}

	@Override
	public boolean isObstacle() {
		
		return false;
	}
	
	public boolean isAtPosition(int x, int y) {
        return this.posX == x && this.posY == y;
    }


}
