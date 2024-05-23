
// Names: Saniha Sreedhara, Mariam Abu Rahma, Aarya Patel
// Date: 05/22/2024
// Notes: This class extends ClassObjects. It creates the dino at different states and allows it to move, jump, and die.
import java.awt.*;
public class Dino extends ClassObjects {
	
	// FIELDS
	private double velX, velY;
	private boolean onSurface;
	
	private boolean not_dead = true;
	int y;
	
	
	
	
	// CONSTRUCTOR
	// Creates different dinos with different images.
	
	public Dino(String filename, int x, int y) {
		
		
		super(filename,x,y,40,43);
			
		
		
		
		
		velX = 0;
		velY = 0;
		onSurface = true;
		
		
	}
	
	
	public Dino(int x, int y) {
		
		
		super("main-character4.png",x,y,40,43);
			
		
		
		
		
		velX = 0;
		velY = 0;
		onSurface = true;
		
		
	}
	
	
	public Dino(int x, int y, int num) {
		
		
		super("main-character1.png",x,y,40,43);
			
		
		
		
		
		velX = 0;
		velY = 0;
		onSurface = true;
		
		
	}
	
	
	public Dino(int x, int y, String z) {
		
		
		super("main-character2.png",x,y,40,43);
			
		
		
		
		
		velX = 0;
		velY = 0;
		onSurface = true;
		
		
	}
	
	
	
	
	// METHODS
	
	public void walk(int dir) { // Makes the dino run across the screen
		if (Math.abs(velX) < 10)
			velX += dir;
	}
	
	public void jump() { // Makes the dino jump
		
		y = super.getY();
		
		
		if (y >= 540) {
			velY = -20;
			
			moveByAmount(0,(int)velY);
		}
	}
	
	public void fall(ClassObjects platform) { // Makes the dino fall back down after each jump.
		if (velY < 15) {
			velY += 1.75;
		
		}
		velX *= .25; // Friction
		
		onSurface = false;
		
		
		if ( platform.isPointInImage( getX()+getWidth()/2, getY() + getHeight() ) ) {
			
		
			velY = 0;
			onSurface = true;
		}
		
		moveByAmount((int)velX, (int)velY);
	}
	
	
	public boolean isDead() { // Allows the game to reset after the dino dies.
		return not_dead;
		
	}
	
	
	
}	
