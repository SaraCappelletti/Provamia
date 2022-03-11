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

public class GameScene extends GeneralScene{
	
	//gli dico dove trovare l'immagine dello sfondo
	private static final String BACKGROUND_IMAGE = "assets/background.png";
	
	private Image background;
	private MainCharacter bear;
	
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
		bear.moveTo(380, 375);
		//uso un timer di java fx che ripete il mio codice ogni tot nano secondi automaticamente
		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
				
				//disegno lo sfondo e l'orso, l'ordine in cui li scrivo determina chi sta davanti
				gc.drawImage(background, 0, 0); //qui uso tutto il png e lo voglio a grandezza schermo
				bear.draw(gc); //disegno l'orso col metodo dentro MainCharacter
				
				//guardo se preme esc o invio
				if (activeKeys.contains(KeyCode.ESCAPE)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.WELCOME_SCENE);
				} else if (activeKeys.contains(KeyCode.ENTER)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.CREDITS_SCENE);
				}else if (activeKeys.contains(KeyCode.LEFT)) {
					bear.move(AnimatedSprite.LEFT);
				}else if (activeKeys.contains(KeyCode.RIGHT)) {
					bear.move(AnimatedSprite.RIGHT);
				}
				
			}
			
		}.start();
	}

}
