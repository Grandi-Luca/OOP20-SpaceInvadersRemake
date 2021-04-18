package graphics;

import java.awt.Graphics;

import model.entitiesutil.Entity;

/**
 * Interface for {@link Entity} update
 */
public interface EntityGraphics {

	/**
	 * Update the entity's graphics 
	 * 
	 * @param g is the type of graphics used for draw the {@link Entity}'s image
	 * @param e is the {@link Entity} that need to be updated
	 */
	public void updateGraphics(Graphics g, Entity e);

	/**
	 * if the entity has more than one image this methods change entity's image
	 * 
	 * @param e 		is the {@link Entity} that need to change his image
	 * @param strImg	is the path of the new image
	 */
	public void switchImage(Entity e, String strImg);
	
}