package main.scene.sprites;

import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.shape.Path;
import main.scene.GeneralScene;

public class MainCharacter extends AnimatedSprite{

	//decido quanto è grande l'orso
	public static final int MAIN_CHARACTER_WIDTH = 96;
	public static final int MAIN_CHARACTER_HEIGHT = 96;
	//gli dico da dove prendere l'immagine con tutti gli orsi
	public static final String IMAGE_PATH = "assets/bear.png";
	//decido quanto è lungo un passo
	public static final int STEP = 4;
	//decido quanto è lungo un salto, quanto deve passare tra un salto e l'altro
	public static final int JUMP_TIME = 30;
	public static final int WAIT_JUMP_TIME = 10;
	//se sta saltando, da quanto e se deve aspettare
	public boolean isJumping = false;
	public int jumpTime = 0;
	public int waitTime = WAIT_JUMP_TIME;
	
	public MainCharacter() {
		super(MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);
		try {
			spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//scelgo le animazioni per andare a destra e a sinistra
		//spriteXCoordinates[RIGHT] = new int[] {480, 576, 672, 576};
		//spriteYCoordinates[RIGHT] = new int[] {0, 0, 0, 0};
		//spriteXCoordinates[LEFT] = new int[] {1248, 1344, 1440, 1344}; 
		//spriteYCoordinates[LEFT] = new int[] {0, 0, 0, 0};
		spriteXCoordinates[UP] = new int[] {480, 576, 672, 576};
		spriteYCoordinates[UP] = new int[] {0, 0, 0, 0};
		
		updateSpriteCoordinates();
	}
	
	@SuppressWarnings("unused")
	public void move(int movement) {
		int newY = y;
		
		/*if(movement == LEFT) {
			//se la mia x è già a zero non può andare a sinistra
			newX -= Math.min(STEP, x);
		}else if(movement == RIGHT) {
			//guardo se arrivo al bordo a destra
			newX += Math.min(STEP, GeneralScene.GAME_WIDTH - MAIN_CHARACTER_WIDTH - x);
		}*/
		if(movement == UP) {
			newY -= STEP*15;
		}
		moveTo(x, newY);
		animate(movement);
	}
}
