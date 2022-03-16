package main.scene;

import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.SkaterGame;
import main.scene.sprites.AnimatedSprite;
import main.scene.sprites.MainCharacter;
import main.scene.sprites.Obstacle;

public class GameScene extends GeneralScene{
	
	//gli dico dove trovare l'immagine dello sfondo
	private static final String BACKGROUND_IMAGE = "assets/background.png";
	
	private Image background;
	private MainCharacter bear;
	//forse meglio usare un Optional
	private Obstacle obstacle = null;
	
	public int initialX = 380;
	public int initialY = 375;
	
	public GameScene() {
		super();
		//carico la foto nel campo background e bear
		try {
			background = new Image(Files.newInputStream(Paths.get(BACKGROUND_IMAGE)));
			bear = new MainCharacter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw() {
		//se c'era qualche bottono nella lista la pulisco perchè sono all'inizio
		activeKeys.clear();
		//scelgo la posizione iniziale dell'orso
		bear.moveTo(initialX, initialY);
		//uso un timer di java fx che ripete il mio codice ogni tot nano secondi automaticamente
		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
				
				//disegno lo sfondo e l'orso, l'ordine in cui li scrivo determina chi sta davanti
				gc.drawImage(background, 0, 0); //qui uso tutto il png e lo voglio a grandezza schermo
				bear.draw(gc); //disegno l'orso col metodo dentro MainCharacter
				
				//se c'è un ostacolo lo disegno
				if(obstacle != null) {
					obstacle.draw(gc);
				}
				
				//guardo se preme esc o invio
				if (activeKeys.contains(KeyCode.ESCAPE)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.WELCOME_SCENE);
				} else if (activeKeys.contains(KeyCode.ENTER)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.CREDITS_SCENE);
				}else if (activeKeys.contains(KeyCode.SPACE) && !bear.isJumping) {
					if (bear.y == initialY) {
						bear.isJumping = true;
						bear.jumpTime ++;
						bear.move(MainCharacter.UP);
					}
					
				} else if (bear.isJumping){
					bear.jumpTime ++;
					if (bear.y != initialY && bear.jumpTime >= bear.JUMP_TIME) {
						bear.y = initialY;
						bear.isJumping = false;
						bear.jumpTime = 0;
					}
				}
				
				//per ora tengo nelllo schermo un ostacolo alla volta, altezza terra
				if(obstacle  == null) {
					obstacle = new Obstacle();
					//il 2* è perchè se no è troppo in basso
					obstacle.moveTo(GeneralScene.GAME_WIDTH - Obstacle.OBSTACLE_WIDTH, GeneralScene.GAME_HEIGHT - Obstacle.OBSTACLE_HEIGHT*2);
					//obstacle.moveTo((int)(Math.random() * (GeneralScene.GAME_WIDTH - Obstacle.OBSTACLE_WIDTH)), 0);
				} else {
					obstacle.move();
					//controllo le collisioni, se lo tocco esco
					if (obstacle.collidesWith(bear)) {
						SkaterGame.setScene(SkaterGame.CREDITS_SCENE);
					}
					//se esce dallo schermo lo tolgo
					else if (obstacle.getX() < 0) {
						obstacle = null;
					}
				}
				
			}
			
		}.start();
	}

}
