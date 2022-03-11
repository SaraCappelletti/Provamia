package main.scene.sprites;

public class AnimatedSprite extends Sprite{

	//decido che movimenti può fare
	private static final int TOTAL_MOVEMENTS = 2;
	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	//quando veloce deve cambiare immagine 
	public static final byte SPRITE_CHANGE = 5;
	
	//mi salvo direzione attuale, che sprite sto usando e quando manca per cambiare animazione
	protected int currentDirection;
	protected byte currentSprite;
	protected byte currentSpriteChange;
	//salvo le coordinate dello sprite
	protected int[][] spriteXCoordinates = new int[TOTAL_MOVEMENTS][];
	protected int[][] spriteYCoordinates = new int[TOTAL_MOVEMENTS][];
	
	public AnimatedSprite(int width, int height) {
		super(width, height);
		//parto a destra, con lo sprite frontale e 0 nel counter movimento
		currentDirection = RIGHT;
		currentSprite = 0;
		currentSpriteChange = 0;
	}

	public void animate(int movement) {
		if (currentDirection != movement) {
			//se cambio direzione la aggiorno e rimetto lo sprite frontale con counter 0
			currentDirection = movement;
			currentSprite = 0;
			currentSpriteChange = 0;
		} else {
			currentSpriteChange ++; //alzo il counter
			if(currentSpriteChange >= SPRITE_CHANGE) {
				//se è il momento cambio immagine
				currentSprite = (byte)((currentSprite +1) % spriteXCoordinates[currentDirection].length);
			}
			
		}
		updateSpriteCoordinates();
	}
	
	protected void updateSpriteCoordinates() {
		spriteX = spriteXCoordinates[currentDirection][currentSprite];
		spriteY = spriteYCoordinates[currentDirection][currentSprite];
	}
	
}
