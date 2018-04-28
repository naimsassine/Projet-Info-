package Model;

import View.Window;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.omg.CosNaming.IstringHelper;

public class Game implements DeletableObserver {
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public static Window window;
    private int size = 14;
    // private int bombTimer = 3000;
    private int numberOfBreakableBlocks = 27;
    MagicPotionLife mpl;
    int lifeplus = 1;
    Teleportation tele;
   

    public Game(Window window) {
        this.window = window;

        // Creating one Player at position (1,1)
        objects.add(new Player(10, 10, 3, 1));
   
        Enemy ennemy = new Enemy(1,1,1); 
        objects.add(ennemy);
        

        // Map building
        for (int i = 0; i < size; i++) {
            objects.add(new BlockUnbreakable(i, 0));
            objects.add(new BlockUnbreakable(0, i));
            objects.add(new BlockUnbreakable(i, size - 1));
            objects.add(new BlockUnbreakable(size - 1, i));
        }
        Random rand = new Random();
        for (int i = 0; i < numberOfBreakableBlocks; i++) {
            int x = rand.nextInt(11) + 2;
            int y = rand.nextInt(11) + 2;
            int lifepoints = rand.nextInt(5) + 1;
            BlockBreakable block = new BlockBreakable(x, y, lifepoints);
            block.attachDeletable(this);
            objects.add(block);
        }
        Random rand2 = new Random();
        int x1 = rand2.nextInt(11) + 2;
        int y1 = rand2.nextInt(11) + 2;
        int color1 = 4;
        MagicPotionLife mpl = new MagicPotionLife(x1, y1, color1);
        objects.add(mpl);
        
        int x3 = 12;
        int y3 = 1;
        int color3 = 4;
        Teleportation tele = new Teleportation(x3,y3,color3);
        objects.add(tele);
        
        

        window.setGameObjects(this.getGameObjects());
        notifyView();
    }


    public void movePlayer(int x, int y, int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        int nextX = player.getPosX() + x;
        int nextY = player.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : objects) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
                if (object instanceof MagicPotionLife == true ) {
                	player.addLife(lifeplus);
                	}
                if (object instanceof Teleportation == true ) {
                	player.teleporte(1, 12);
                }
            }
            if (obstacle == true) {
                break;
            }
            
        }
        
        player.rotate(x, y);
        if (obstacle == false) {
            player.move(x, y);
        }
        notifyView();
    }
    public void MoveEnemy(int x, int y, Enemy ennemy) {
    	int nextX = ennemy.getPosX() + x;
        int nextY = ennemy.getPosY() + y;
        boolean obstacle = false;
        for (GameObject object : objects) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
            }
            if (obstacle == true) {
            	break;
            }
            
        }
        
        
        if (obstacle == false) {
        	ennemy.posX = ennemy.posX + x;
    		ennemy.posY = ennemy.posY + y;
        }		
		notifyView();
	}   
    
    
    public void action(int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        Activable aimedObject = null;
		for(GameObject object : objects){
			if(object.isAtPosition(player.getFrontX(),player.getFrontY())){
			    if(object instanceof Activable){
			        aimedObject = (Activable) object;
			    }
			}
		}
		if(aimedObject != null){
		    aimedObject.activate();
            notifyView();
		}
        
    }

    private void notifyView() {
        window.update();
    }

    public ArrayList<GameObject> getGameObjects() {
        return this.objects;
    }

    @Override
    synchronized public void delete(Deletable ps, ArrayList<GameObject> loot) {
        objects.remove(ps);
        if (loot != null) {
            objects.addAll(loot);
        }
        notifyView();
    }


    public void playerPos(int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        System.out.println(player.getPosX() + ":" + player.getPosY());
        
    }
    public void playerLife(int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        System.out.println( player.getLife() );
        
    }
}