package main.scene;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.SkaterGame;

public class GameScene extends GeneralScene{
	
	public GameScene() {
		super();
	}
	
	private void showGameMessage() {
		Font myFont = Font.font("Arial", FontWeight.NORMAL, 24);
		gc.setFont(myFont);
		gc.setFill(Color.YELLOW);
		gc.fillText("Game Scene", 325, 200);
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
				
				showGameMessage();
				//guardo se preme esc o invio
				if (activeKeys.contains(KeyCode.ESCAPE)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.WELCOME_SCENE);
				} else if (activeKeys.contains(KeyCode.ENTER)) {
					this.stop();
					SkaterGame.setScene(SkaterGame.CREDITS_SCENE);
				}
				
			}
			
		}.start();
	}

}
