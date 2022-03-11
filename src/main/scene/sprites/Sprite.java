package main.scene.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

	//misure dello sprite
	protected int width;
	protected int height;
	//coordinate nello schermo
	protected int x;
	protected int y;
	//coordinate dello sprite nel png per scegliere l'orso che mi serve
	protected int spriteX;
	protected int spriteY;
	//il png
	protected Image spriteImage;
	
	public Sprite(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(spriteImage, spriteX, spriteY, width, height, x, y, width, height);
	}
}