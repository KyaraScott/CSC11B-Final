package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class Main extends StateBasedGame //state based game, each part of the game is a diff state
{
public static final String gameName = "DragonQuest!";
public static final int MENU_ID = 0;//menu state
public static final int PLAY_ID = 1;//play state
public static final int CREDITS_ID = 2;//credits state




public Main(String gameName)
{
	super(gameName);
	this.addState(new Menu(MENU_ID));
	this.addState(new Play(PLAY_ID));
	this.addState(new Credits(CREDITS_ID));

}
public void initStatesList(GameContainer gc) throws SlickException {
	this.getState(Main.MENU_ID).init(gc, this);
	this.getState(Main.PLAY_ID).init(gc, this);
	this.getState(Main.CREDITS_ID).init(gc, this);
	
	this.enterState(Main.MENU_ID);//menu screen is to be showed first 
}


public void render(GameContainer gc) throws SlickException {
	
}

public static void main(String[] args)
{
	AppGameContainer appgc;
try
{
	appgc = new AppGameContainer(new Main(gameName));//set screen size
	appgc.setDisplayMode(950,500,false);//set to a larger number later//if full screen make a number
	appgc.start();
}
catch(SlickException e)
{
	e.printStackTrace();
}
// TODO Auto-generated method stub

}

}