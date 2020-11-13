package javagame;
import org.newdawn.slick.*;
import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
 



public class Credits extends BasicGameState {

	int ID;
	Image copy;
	Input input;
	String mouse = "";

	public Credits(int state)
	{
		ID = state;	
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		// load a default java font
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		Image copy = new Image("res/Copyright.png");
		g.drawImage(copy, 20, 40);
		g.drawString("Dimitry(Danny) Papish", 380, 150);
		g.drawString("Kyara Scott", 380, 200);
		g.drawString("Andrew Kresege", 380, 250);
		g.drawString("Otitodilinna (Tito) Amaefuna", 380, 300);
		g.drawString("Back to main menu", 380, 400);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xpos =Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "x: " + xpos + " y: " + ypos; 
		if((xpos >0 && xpos <1000) && (ypos>0 && ypos<500))  
		{  	
			if(Mouse.isButtonDown(0))
			{
				sbg.enterState(0);
			}
		}
	}
	
	public int getID()
	{
		return 2;
	}

	
}
