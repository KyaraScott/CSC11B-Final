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



public class Play extends BasicGameState //BasicGame implements the game loop/ input handling
{
    private Music music;
    private Sound pickCoin;
    private Sound win;
	ArrayList<Animation> coins = new ArrayList<Animation>();
	Image bgImage;
	int ID;
    private Animation sprite;
    private Animation coin1,coin2,coin3,coin4,coin5;
    private Animation left;
    private Animation right;
    private Animation up;
    private Animation down;
    boolean quit = false;
    boolean collectCoin1,collectCoin2,collectCoin3,collectCoin4,collectCoin5,winner = false;
    float x = 500;
    float y = 450;
    boolean soundHasPlayed = false;
    
    
    
    

    
	
	
	



public Play(int play)
{
	super();
	ID = play;


}



public static void main(String[] args) throws SlickException
{
}

public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException //update first, then render //determines FPS
{
	//renders the game into a frame
	//method to render the map

	Image bgImage = new Image("res/map1.png");
	Image sprite = new Image("res/character.png");
	g.drawImage(bgImage,  0, 0);
	sprite.draw(x,y);
	g.drawString("Char X: " + x + "\nChar Y: " + y, 800,50);
	Image coin1 = new Image("res/coin1.png");
	Image coin2 = new Image("res/coin2.png");
	Image coin3 = new Image("res/coin3.png");
	Image coin4 = new Image("res/coin4.png");
	Image coin5 = new Image("res/coin5.png");
	if (collectCoin1 == false) {
	coin1.draw(750,430);
	}
	if (collectCoin2 == false) {
	coin2.draw(700,200);
	}
	if (collectCoin3 == false) {
	coin3.draw(400,130);
	}
	if (collectCoin4 == false) {
	coin4.draw(220,233);
	}
	if (collectCoin5 == false) {
	coin5.draw(678,29);
	}

	
	if (quit==true) {
		g.drawString("Resume (R)", 400, 200);
		g.drawString("Main Menu (M)", 400, 250);
		g.drawString("Quit Game (Q)", 400, 300);
	}
	
	if (winner == true) {
		g.drawString("Cogratulations!! You won the game!", 300,200);
		
	}
  
	


	

}
@Override
public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
{
//loads in maps, images, sprites,and music


    	
    	

   music = new Music("sound/arcade.ogg");
   pickCoin = new Sound("sound/pickCoin.ogg");
   win = new Sound("sound/win.ogg");
   music.loop();
   coins.add(coin1);
   coins.add(coin2);
   coins.add(coin3);
   coins.add(coin4);
   coins.add(coin5);
   Image [] walkLeft = {new Image("res/character.png"), new Image("res/character.png")};
   Image [] walkRight = {new Image("res/character.png"), new Image("res/character.png")};
   Image [] walkUp = {new Image("res/character.png"), new Image("res/character.png")};
   Image [] walkDown = {new Image("res/character.png"), new Image("res/character.png")};
   
	int [] duration = {300,300};
	left = new Animation (walkLeft, duration, false);
	right = new Animation(walkRight, duration, false);
	up = new Animation(walkUp, duration, false);
	down = new Animation(walkDown, duration, false);
    sprite = right;


}   






@Override
public int getID() {
// TODO Auto-generated method stub
return ID;
}

public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	// TODO Auto-generated method stub
	Input input;
	input= gc.getInput();
	if (input.isKeyDown(Input.KEY_UP))
	{
	    sprite = up;
	    sprite.update(delta);
	    // The lower the delta the slowest the sprite will animate.
	    y -= delta * 0.1f;
	    if (y<1.1) {
	    	y += delta * 0.1f;
	    	
	    }
	}
	else if (input.isKeyDown(Input.KEY_DOWN))
	{
	    sprite = down;
	    sprite.update(delta);
	    y += delta * 0.1f;
	    if (y>450) {
	    	y -= delta * 0.1f;
	    }
	}
	else if (input.isKeyDown(Input.KEY_LEFT))
	{
	    sprite = left;
	    sprite.update(delta);
	    x -= delta * 0.1f;
	    if (x<93) {
	    	x += delta * 0.1f;
	    }
	}
	else if (input.isKeyDown(Input.KEY_RIGHT))
	{
	    sprite = right;
	    sprite.update(delta);
	    x += delta * 0.1f;
	    if (x>832) {
	    	x -= delta * 0.1f;
	    }
	}
	
	if ((x>722) && (x<790) && (y>403)) {
		collectCoin1 = true;
		pickCoin.play();
	
		}
	
	if ((x>668) && (x<748) && (y>169) && (y<246)) {
		collectCoin2 = true;
		pickCoin.play();
	}
	if ((x>369) && (x<445) && (y>98) && (y<175)) {
		collectCoin3 = true;
		pickCoin.play();
	}
	if ((x>187) && (x<265) && (y>229) && (y<279)) {
		collectCoin4 = true;
		pickCoin.play();
	}
    if ((x>649) && (x<725) && (y<72)) {
		collectCoin5 = true;
		pickCoin.play();
	}
    if ((collectCoin1 == true) && (collectCoin2 == true) && (collectCoin3 == true) && 
    		(collectCoin4 == true) && (collectCoin5 == true)) {
    	winner = true;
    	win.play();
    	music.stop();
    }
	
	
	
	//escape
	if (input.isKeyDown(Input.KEY_ESCAPE)) {
		quit = true;

	}
	if (quit==true) {
		if (input.isKeyDown(Input.KEY_R))  {
			quit = false;
		}
		if (input.isKeyDown(Input.KEY_M)) {	
			sbg.enterState(0);

		}
		if (input.isKeyDown(Input.KEY_Q)) {	
			System.exit(0);
		}
	}
}

	
}

