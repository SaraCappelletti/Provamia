package main.scene;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.SkaterGame;

public class CreditsScene extends GeneralScene{
	
	public CreditsScene() {
		super();
	}
	
	private void showCreditsMessage() {
		Font myFont = Font.font("Arial", FontWeight.NORMAL, 32);
		gc.setFont(myFont);
		gc.setFill(Color.GREEN);
		gc.fillText("Skater Game", 325, 200);
		
		myFont = Font.font("Arial", FontWeight.NORMAL, 20);
		gc.setFont(myFont);
		gc.setFill(Color.WHITE);
		gc.fillText("Press spacebar to go back to Welcome Scene", 200, 275);
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
				
				showCreditsMessage();
				//guardo se preme spazio
				if (activeKeys.contains(KeyCode.SPACE)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.WELCOME_SCENE);
				}
			}
			
		}.start();
	}

}
