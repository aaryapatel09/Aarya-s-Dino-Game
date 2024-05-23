// Names: Saniha Sreedhara, Mariam Abu Rahma, Aarya Patel
// Date: 05/22/2024
// Notes: This class extends JPanel and implements KeyListener. It allows images to move across the screen.
//        It also allows the dino to use the power up sheild. 

//IMPORTS
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javax.swing.*;
public class Main extends JPanel implements KeyListener {
	
	//FIELDS:
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private static boolean check;
	private static boolean shield_check = false;
	private static int land_shift = 0;
	private int Cloud_shift1 = 800; //Helps move the clouds
	private int Cloud_shift2 = 1100;
	private	int Cloud_shift3 = 1400;
	private Dino dino; //Depends on the Dino class
	private ClassObjects platform, platform2, platform3, platform4, platform5, platform6, platform7, platform8, platform9, end;
	private ClassObjects palmtree1, palmtree2, palmtree3, palmtree4;
	private ClassObjects cloud1, cloud2, cloud3; // the platforms, plamtrees, and clouds are all class objects.
	private ClassObjects sand, shield;
	private Random random = new Random();
	private static int count1 = 0;
	private static int count2 = 0;
	private static double speed = 9.0;
	private int move = 0;
	private int shield_movement = 800;
	private int count3 = 0;
	private int first = 0;
	private int minDistance;
	private int maxDistance;
   
	private static int countz = 0;
	private boolean not_alive = false;
	private static int num = 0;
	private static int counter = 0;
	private boolean restKeyPressed, upKeyPressed;
	private static Boolean running = false, running1 = true, running2 = false;
	public Main() {
		super();
		
		// creating all objects
		
		dino = new Dino("main-character3.png",30,540);
		platform = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform2 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform3 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform4 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform5 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform6 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform7 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform8 = new ClassObjects("land5.png", 0, 555, 80, 40);
		platform9 = new ClassObjects("land5.png", 0, 555, 80, 40);
		
		sand = new ClassObjects("sandlayoutpng.png", 0, 590, 80, 10);
		palmtree1 = new ClassObjects("palmtree1.png", 800, 530, 23, 46,speed);
       palmtree2 = new ClassObjects("palmtree2.png", getRandomPosition(palmtree1.getX()), 545, 40, 30, speed);
       palmtree3 = new ClassObjects("palmtree1.png", getRandomPosition(palmtree2.getX()), 530, 23, 46, speed);
       palmtree4 = new ClassObjects("palmtree2.png", getRandomPosition(palmtree3.getX()), 545, 40, 30, speed);
      
       shield = new ClassObjects("shield.gif",getRandomPosition(palmtree1.getX(), palmtree2.getX()),420, 51,49);
		cloud1 = new ClassObjects("purplecloud_new2.png", 900, 555, 80, 40);
		cloud2 = new ClassObjects("purplecloud_new2.png", 900, 555, 80, 40);
		cloud3 = new ClassObjects("purplecloud_new2.png", 900, 555, 80, 40);
		Color backs = new Color(137, 196, 244);
		setBackground(backs);
	}
	
	public boolean isCollision(Dino dino, ClassObjects cactus) {
		
       int dinoX = dino.getX();
       int dinoY = dino.getY();
       int dinoWidth = dino.getWidth()/2 +20;
       int dinoHeight = dino.getHeight();
       int cactusX = cactus.getX();
       int cactusY = cactus.getY();
       int cactusWidth = cactus.getWidth();
       int cactusHeight = cactus.getHeight();
      
       return dinoX < cactusX + cactusWidth &&
              dinoX + dinoWidth > cactusX &&
              dinoY < cactusY + cactusHeight &&
              dinoY + dinoHeight > cactusY;
   }
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		double ratioX = (double) width / DRAWING_WIDTH;
		double ratioY = (double) height / DRAWING_HEIGHT;
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		g.drawString("Score: " + num + "", 50,300);
		
		//DRAWING ALL OBJECTS
		
		platform.draw(g, this);
		platform2.draw(g, this);
		platform3.draw(g, this);
		platform4.draw(g, this);
		platform5.draw(g, this);
		platform6.draw(g, this);
		platform7.draw(g, this);
		platform8.draw(g, this);
		platform9.draw(g, this);
		
		sand.draw(g, this);
		
		cloud1.draw(g, this);
		cloud2.draw(g, this);
		cloud3.draw(g, this);
		
		palmtree1.draw(g, this);
		palmtree2.draw(g, this);
		palmtree3.draw(g, this);
		palmtree4.draw(g, this);
		
		dino.draw(g, this);
		
		shield.draw(g, this);
	
		g2.setTransform(at);
		
	}
	
	public void keyPressed(KeyEvent e) { //Helps the dino jump
		
		if ((e.getKeyCode() == KeyEvent.VK_SPACE) || (e.getKeyCode() == KeyEvent.VK_UP)) {
			
			if (countz == 0) {
			
				sand = new ClassObjects("sandlayoutpng.png", 0, 590, 900, 10);
				dino = new Dino("dino.gif",dino.getX(),dino.getY());
				upKeyPressed = false;
				running = true;
				countz =1;
				running2 = true;
			}
			
			else {
				
				count2 = 0;
				count1 ++;
				if (count1 == 1) {
					dino = new Dino("main-character3.png",dino.getX(),dino.getY());
				}
				
				upKeyPressed = true;
			}
			
			if (running == false) {
				running = true;
				run();
			}
			
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_R) {
			if (check == true) {
				
				counter = 0;
				restKeyPressed = true;
				check = false;
			}
			
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			if (speed >1) {
				speed -=1;
			}
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_F) {
			speed +=0.5;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_SPACE)|| (e.getKeyCode() == KeyEvent.VK_UP) && (!check)) {
			count2 ++;
			
			count1 = 0;
			countz = 1;
			upKeyPressed = false;
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_R) {
			if (check == true) {
				restKeyPressed = false;
				check = false;
			}
			
		}
			
	}
	
	public void keyTyped(KeyEvent e) {
	}
	public void run() {
		while (running1) {
			
			check = checkDino();
			
			shield_check = checkDinoShield();
			
			if (shield_check) {
				first++;
				if (first == 1) {
				
					count3 = num;
				}
				
				if ((count3 + 30  <= num) && (count3 + 40 != num)) {
					
						shield = new ClassObjects("shield1.gif",dino.getX(), dino.getY(),51,49);	
				}
				
				else if (count3 + 40 != num){
					
					shield = new ClassObjects("shield.gif",dino.getX(), dino.getY(),51,49);
				}
				
				
				else {
			        shield = new ClassObjects("shield.gif",getRandomPosition(palmtree1.getX(), palmtree2.getX())+ 5000,420,51,49);
				}
				
				
			}
			else {
				first = 0;
			}
			
			if (upKeyPressed) {
			
				
				if ((countz ==1) && (check == false)){
					
					
					dino.jump();
				}
				
			}
			if ((dino.getY()== 540) &&(check == false) && (running == true)) {
				dino = new Dino("dino.gif",dino.getX(),dino.getY());
			}
			
			
			
			if (restKeyPressed) {
			
				dino = new Dino("dino.gif",30,540);
				speed = 9.0;
				palmtree1.resetPosition(getRandomPosition(palmtree4.getX()), speed);
			    palmtree2.resetPosition(getRandomPosition(palmtree1.getX()),speed);
			    palmtree3.resetPosition(getRandomPosition(palmtree2.getX()),speed);
			    palmtree4.resetPosition(getRandomPosition(palmtree3.getX()), speed);
			    shield.resetPosition(getRandomPosition(palmtree4.getX()), speed);
			    
			    
			    Cloud_shift1 = 800;
			    Cloud_shift2 = 1100;
			    Cloud_shift3 = 1400;
			
			    
			    restKeyPressed = false;
			
			   
			    num = 0;
			   
			    check = false;
				
			}
	
			
			
			dino.fall(platform);
		
			
			if (!check) {			
				counter++;
				
			}
		
		
			if (counter > 5) {
		
				counter = 0;
				if (countz == 1) {
			
					num ++;
				
			
				}
			
			}
			
			
			
			if (countz == 1) {
				if (!check) {
					move = landMove();
					palmtreeMove();
					cloudMove();
				}
			}
		
			repaint();
		
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
	
	
	public boolean checkDino() {
		int x = dino.getX() + dino.getWidth() / 2;
		int y = dino.getY() + dino.getHeight() / 2;
		
		if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT) {
			
				dino = new Dino("dino.gif",30,540);
		
		}
		
		
		boolean collide1 = isCollision(dino, palmtree1);
		boolean collide2 = isCollision(dino, palmtree2);
		boolean collide3 = isCollision(dino, palmtree3);
		boolean collide4 = isCollision(dino, palmtree4);
		
		
		if (!shield_check) {
			if ((collide1) || (collide2) || (collide3)||(collide4)) {
				dino = new Dino(dino.getX(), dino.getY());
				return true;
			
			
			}
			else {
				return false;
			}
		}
	
		
		else {
			return false;
		}
	}
		
		public boolean checkDinoShield() {
				boolean collide5 = isCollision(dino, shield);
				
				if(collide5) {
					
					return true;
					
				}
				else {
					return false;
				}
	}
	
	public int landMove() { //makes the platforms move
		
		platform = new ClassObjects("land5.png", 0-land_shift, 555, 100, 40);
		platform2 = new ClassObjects("land5.png", 100-land_shift, 555, 100, 40);
		platform3 = new ClassObjects("land5.png", 200-land_shift, 555, 100, 40);
		platform4 = new ClassObjects("land5.png", 300-land_shift, 555, 100, 40);
		platform5 = new ClassObjects("land5.png", 400-land_shift, 555, 100, 40);
		platform6 = new ClassObjects("land5.png", 500-land_shift, 555, 100, 40);
		platform7 = new ClassObjects("land5.png", 600-land_shift, 555, 100, 40);
		platform8 = new ClassObjects("land5.png", 700-land_shift, 555, 100, 40);
		platform9 = new ClassObjects("land5.png", 800-land_shift, 555, 100, 40);
		
		land_shift += speed;
		
		if (num > 0) {
			if (num % 25 == 0) {
				speed += .05;
				
			}
			
		}
		
		if (land_shift>100) {
			land_shift = 0;
		}
		
		return land_shift;
	}
	
	  private int getRandomPosition(int previousX) {
	         minDistance = 200;
	         maxDistance = 350;
	       
	       
	        if (speed > 9) {
	        	 minDistance = (int)(200 + (2*(speed)));
	 	         maxDistance = (int)(350 + (2*(speed)));
	 	       
	        }
	   
	        return previousX + minDistance + random.nextInt(maxDistance - minDistance);
	    }
	 
	  private int getRandomPosition(int previousX, int nextX) {
	        int average = (previousX + nextX)/2;
	       
	        return average + random.nextInt(30);
	    }
	
	public void palmtreeMove() { //makes the palmtrees move
		palmtree1.move(speed);
		palmtree2.move(speed);
		palmtree3.move(speed);
		palmtree4.move(speed);
		shield.move(speed);
		
		
		 if (palmtree1.getX() < -25) {
	            palmtree1.resetPosition(getRandomPosition(palmtree4.getX()), speed);
	        }
	        if (palmtree2.getX() < -25) {
	            palmtree2.resetPosition(getRandomPosition(palmtree1.getX()),speed);
	        }
	        if (palmtree3.getX() < -25) {
	            palmtree3.resetPosition(getRandomPosition(palmtree2.getX()),speed);
	        }
	        if (palmtree4.getX() < -25) {
	            palmtree4.resetPosition(getRandomPosition(palmtree3.getX()), speed);
	        }
	       
	        if (shield.getX() < -25) {
	            shield.resetPosition(getRandomPosition(palmtree4.getX()+ 5000), speed);
	        }
	
	        if (num > 0) {
				if (num % 25 == 0) {
					speed += .05;
					
					
				}
				
			}   
	}
	
	public void cloudMove() { //makes the clouds move
		
		cloud1 = new ClassObjects("purplecloud_new2.png", Cloud_shift1, 375, 75, 75);
		cloud2 = new ClassObjects("purplecloud_new2.png", Cloud_shift2, 425, 75, 75);
		cloud3 = new ClassObjects("purplecloud_new2.png", Cloud_shift3, 400, 75, 75);
		Cloud_shift1 -= 1;
		Cloud_shift2 -= 1;
		Cloud_shift3 -= 1;
		if (Cloud_shift1 < -75) {
			Cloud_shift1 = 800;
		}
		if (Cloud_shift2 < -75) {
			Cloud_shift2 = 800;
		}
		if (Cloud_shift3 < -75) {
			Cloud_shift3 = 800;
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
	
			}
		});
		JFrame w = new JFrame("Dino Game");
		w.setBounds(100, 100, 600, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main panel = new Main();
		w.addKeyListener(panel);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		panel.run();
	}
}
