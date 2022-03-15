package main.scene;

import main.SkaterGame;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.animation.AnimationTimer;

public class WelcomeScene extends GeneralScene{
	
	public WelcomeScene() {
		super();
		showWelcomeMessage();
	}

	public void showWelcomeMessage() {
		Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
		gc.setFont(myFont);
		gc.setFill(Color.RED);
		gc.fillText("Skater Game", 275, 200);
		
		myFont = Font.font("Arial", FontWeight.NORMAL, 20);
		gc.setFont(myFont);
		gc.setFill(Color.WHITE);
		gc.fillText("Press SpaceBar to play", 325, 275);
		gc.fillText("Press S to go to the shop", 325, 305);
	}
	
	@Override
	public void draw() {
		//se c'era qualche bottono nella lista la pulisco perchè sono all'inizio
		activeKeys.clear();
		//uso un timer di java fx che ripete il mio codice ogni tot nano secondi automaticamente
		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
				
				showWelcomeMessage();
				//guardo se preme spazio o esc
				if (activeKeys.contains(KeyCode.SPACE)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.GAME_SCENE);
				} else if (activeKeys.contains(KeyCode.ESCAPE)) {
					this.stop();
					SkaterGame.exit();
				} else if(activeKeys.contains(KeyCode.S)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.SHOP_SCENE);
				}
				
			}
			
		}.start();
		
	}

}
