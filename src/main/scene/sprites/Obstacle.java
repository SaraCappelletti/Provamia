package main.scene.sprites;

import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.Image;

public class Obstacle extends Sprite {
	
	private static final String IMAGE_PATH = "assets/fruits.png";
	public static int MAX_OBSTACLES = 2;
	public static int OBSTACLE_WIDTH = 30;
	public static int OBSTACLE_HEIGHT = 30;
	
	//costruttore che mi genera un ostacolo a caso
	public Obstacle() {
		this((int)(Math.random() * MAX_OBSTACLES));
	}

	//creo uno specifico ostacolo
	public Obstacle(int type) {
		super(OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
		try {
			spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		//fa un po pena con uno switch ma adesso non ho voglia di pensare bene
		//a come scegliere le immagini dei vari ostacoli
		switch(type) {
			case 0:
				this.spriteX = 4;
				this.spriteY = 40;
				break;
			case 1:
				this.spriteX = 42;
				this.spriteY = 40;
				break;
		}
	}
	
	public void move() {
		this.y++;
	}

}
