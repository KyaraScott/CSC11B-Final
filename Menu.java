
package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState
{
	int ID;
	Image bgImage;
	Image bgImage2;
	String mouse = "";

public Menu(int state)
{
	ID = state;	
}

public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
{

}

public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
{
	
	bgImage = new Image("res/menu1.png");
	bgImage2 = new Image("res/menu2.png");
	g.drawString(mouse, 50, 50);
	g.drawString("Are you ready?!?!?!", 400, 40);
	g.drawImage(bgImage, 250, 100);
	g.drawImage(bgImage2,250,200 );

}
public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
{
	
	int xpos =Mouse.getX();
	int ypos = Mouse.getY();
	mouse = "x: " + xpos + " y: " + ypos; 
	if((xpos >277 && xpos <677) && (ypos>324 && ypos<357))  
	{  	
		if(Mouse.isButtonDown(0))
		{
			sbg.enterState(1);
		}
	}
	
	else if((xpos >345 && xpos <607) && (ypos>232 && ypos<267))  
	{  	
		if(Mouse.isButtonDown(0))
		{
			sbg.enterState(2);
		}
	}
	
	
	else if((xpos >410 && xpos <555) && (ypos>142 && ypos<177))
	{
		if(Mouse.isButtonDown(0))
		{
			System.exit(0);
		}
	}




}
public int getID()
{
	return ID;
}


}
