

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
public class ClassObjects {
	
	// FIELDS
	
	private int x, y;
	private int width, height;
	private Image image;
	private boolean isVisible;
	// CONSTRUCTORS
	
	
	 private double objspeed;
	
	
	public ClassObjects(String filename, int x, int y, int w, int h, double speed) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h, speed);
	}
	
	
	public ClassObjects(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public ClassObjects(Image img, int x, int y, int w, int h, double speed) {
		image = img;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		isVisible = true;
		
		this.objspeed = speed;
	}
	
	
	public ClassObjects(Image img, int x, int y, int w, int h) {
		image = img;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		isVisible = true;
	
	}
	
	
	// METHODS
	
	public void toggleVisibility() {
		isVisible = !isVisible;
	}
	
	public void moveToLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveByAmount(int x, int y) {
	
		
		
		this.y += y/2;
		this.y += y/2;
		if (this.y> 540) {
			this.y = 540;
		}
		
		
		
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-this.width);
		y = Math.min(y,windowHeight-this.height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	public boolean isPointInImage(int mouseX, int mouseY) {
		if (mouseX >= x +24 && mouseY >= y + 24 && mouseX <= x + width && mouseY <= y + height)
			return true;
		return false;
	}
	
	public void resize(int w, int h) {
		width = w;
		height = h;
	}
	
	public void draw(Graphics g, ImageObserver io) {
		if (isVisible)
			g.drawImage(image,x,y,width,height,io);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	
	
	public boolean changeisVisible(boolean input) {
		return this.isVisible = input;
	}
	
	
	 public void move(double speed) {
	        x -= speed;
	    }
	 public void resetPosition(int newX, double newSpeed) {
	        x = newX;
	        objspeed = newSpeed;
	    }
	
	
}
