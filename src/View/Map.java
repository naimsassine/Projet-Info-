package View;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.BlockBreakable;
import Model.BlockUnbreakable;
import Model.Directable;
import Model.GameObject;
import Model.MagicPotionLife;
import Model.Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel {
    private ArrayList<GameObject> objects = null;
    ImageIcon icon ;
    Image image;
    public Map() {
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
        for (int i = 0; i < 14; i++) { // Virer la valeur 20 et parametrer ca
            for (int j = 0; j < 14; j++) {
                int x = i;
                int y = j;
                icon = new ImageIcon("slot_eq_cursed.png");
                image=icon.getImage();
                g.drawImage(image,x * 50, y * 50, 48, 48, null);
                /* g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x * 50, y * 50, 48, 48);
                g.setColor(Color.BLACK);
                /*
                 * 
                 */
            }
        }

        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();
            if (color == 0) {
            	g.setColor(Color.DARK_GRAY);
            } else if (color == 1) {
            	g.setColor(Color.GRAY);
            } else if (color == 2) {
                g.setColor(Color.BLACK);
            } else if (color == 3) {
                g.setColor(Color.GREEN);
            } else if (color == 4) {
                g.setColor(Color.RED);
            } else if (color == 5) {
                g.setColor(Color.ORANGE);
            }

            g.fillRect(x * 50, y * 50, 48, 48);
            g.setColor(Color.BLACK);
            g.drawRect(x * 50, y * 50, 48, 48);
            
            if (object instanceof BlockUnbreakable) {               //Question, prkoi sa marche pas avec color
            	icon = new ImageIcon("brick_gray1.png");
                image=icon.getImage();
                g.drawImage(image,x * 50, y * 50, 48, 48, null);
            }
            if (object instanceof Player) {               //Question, prkoi sa marche pas avec color
            	icon = new ImageIcon("deep_elf_m.png");
                image=icon.getImage();
                g.drawImage(image,x * 50, y * 50, 48, 48, null); //Sa veut dire quoi * 50?
            }
            if (object instanceof MagicPotionLife) {               //Question, prkoi sa marche pas avec color
            	icon = new ImageIcon("bolt01.png");
                image=icon.getImage();
                g.drawImage(image,x * 50, y * 50, 48, 48, null); 
            }
            if (object instanceof BlockBreakable) {              
            	icon = new ImageIcon("brick_brown-vines2.png");
                image=icon.getImage();
                g.drawImage(image,x * 50, y * 50, 48, 48, null); 
            }
            
            
            // Decouper en fontions
            if(object instanceof Directable) {
                int direction = ((Directable) object).getDirection();
                
                int deltaX = 0;
                int deltaY = 0;
                
                switch (direction) {
                case Directable.EAST:
                    deltaX = +24;
                    break;
                case Directable.NORTH:
                    deltaY = -24;
                    break;
                case Directable.WEST:
                    deltaX = -24;
                    break;
                case Directable.SOUTH:
                    deltaY = 24;
                    break;
                }

                int xCenter = x * 50 + 24;
                int yCenter = y * 50 + 24;
                g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
            }
        }
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }

    public void redraw() {
        this.repaint();
    }
}
