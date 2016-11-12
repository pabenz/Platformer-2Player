package Entity.Collectable;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import TileMap.TileMap;
import Entity.*;

public class Orn2 extends Collectables{

	protected boolean collected;
	private BufferedImage[] sprites;
	
	
	public Orn2(TileMap tm){
		super(tm);
		
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		width = 20;
		height = 20;
		cwidth = 20;
		cheight = 16;
		
		collected = false;
	
		try{

			BufferedImage spritesheet = ImageIO.read(
					getClass().getResourceAsStream("/Sprites/Enemies/2.gif"));

			sprites = new BufferedImage[1];
			for(int i = 0; i < sprites.length; i++){
				sprites[i] = spritesheet.getSubimage(
						i * width, 0, width, height);
			}



		}catch(Exception e){
			e.printStackTrace();
		}

		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(300);

	}
	
	private void getNextPosition(){

		// movement
				if(falling) { 
					dy += fallSpeed;
					
				}
	}
	
	public boolean isCollected() {
		return collected;
	}
	
	
	public void hit(){
		if (collected) return;
		collected = true;
		
	}
	
	public void update() {
		//update position
				getNextPosition();
				checkTileMapCollision();
				setPosition(xtemp,ytemp);
				//update animation
				animation.update();
	}
	
	public void draw(Graphics2D g){

		setMapPosition();

		super.draw(g);

	}

}
