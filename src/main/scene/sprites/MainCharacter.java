package main.scene.sprites;

import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.shape.Path;

public class MainCharacter extends AnimatedSprite{

	//decido quanto è grande l'orso
	public static final int MAIN_CHARACTER_WIDTH = 96;
	public static final int MAIN_CHARACTER_HEIGHT = 96;
	//gli dico da dove prendere l'immagine con tutti gli orsi
	public static final String IMAGE_PATH = "assets/bear.png";
	//decido quanto è lungo un passo
	public static final int STEP = 4;
	
	public MainCharacter() {
		super(MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);
		try {
			spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//scelgo le animazioni per andare a destra e a sinistra
		spriteXCoordinates[RIGHT] = new int[] {480, 576, 672, 576};
		spriteYCoordinates[RIGHT] = new int[] {0, 0, 0, 0};
		spriteXCoordinates[LEFT] = new int[] {1248, 1344, 1440, 1344}; 
		spriteYCoordinates[LEFT] = new int[] {0, 0, 0, 0};
		
		updateSpriteCoordinates();
	}
	
	public void move(int movement) {
		int newX = x;
		
		if(movement == LEFT) {
			newX -= STEP;
		}else if(movement == RIGHT) {
			newX += STEP;
		}
		moveTo(newX, y);
		animate(movement);
	}
}
